package irrigationSystem;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Autocomplete extends JComboBox{

	static final long serialVersionUID = 4321421L;
	
	private final Search<String, String> match;
	
	public Autocomplete(Search<String, String> S) 
	{
		super();
		this.match = S;
		setEditable(true);
		putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		Component C = getEditor().getEditorComponent();
		if(C instanceof JTextComponent)
		{
			final JTextComponent TC = (JTextComponent)C;
			TC.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					update_choices();
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					update_choices();
					
				}
				
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void update_choices()
				{
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							if(TC.getText().length() != 0)
							{
								List<String> matches = new ArrayList<String>(match.search_string(TC.getText()));
								Set<String> foundSet = new HashSet<String>();
								for(String S : matches)
								{
									foundSet.add(S.toLowerCase());
								}
								Collections.sort(matches);
								
								setEditable(false);
								removeAllItems();
								if(!foundSet.contains(TC.getText().toLowerCase()))
								{
									addItem(TC.getText());
								}
								
								for(String S : matches)
								{
									addItem(S);
								}
								setEditable(true);
								setPopupVisible(true);
							}
							else
							{
								setPopupVisible(false);
							}
						}
					});
				}
			});
			
			TC.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(TC.getText().length() == 0)
					{
						setPopupVisible(false);
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					if(TC.getText().length() > 0)
					{
						setPopupVisible(true);
					}
					if(TC.getText().length() == 0)
					{
						setPopupVisible(false);
					}
				}
			});
		}
		else
		{
			throw new IllegalStateException("Editing component is not a JTextComponent!");
		}
	}
}
