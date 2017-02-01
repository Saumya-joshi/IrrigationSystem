package irrigationSystem;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.font.TextAttribute;
import java.text.AttributedString;


class Surface7 extends JPanel
        implements ActionListener {

    private final Color colors[] = {
        Color.blue, Color.cyan, Color.green,
        Color.magenta, Color.orange, Color.pink,
        Color.red, Color.yellow, Color.lightGray, Color.white
    };

    private Ellipse2D.Float[] ellipses;
    private double esize[];
    private float estroke[];
    private double maxSize = 0;
    private final int NUMBER_OF_ELLIPSES = 100;
    private final int DELAY = 30;
    private final int INITIAL_DELAY = 150;    
    private Timer timer;

    public Surface7() {

        initSurface();
        initEllipses();
        initTimer();
    }

    private void initSurface() {

        setBackground(Color.black);
        ellipses = new Ellipse2D.Float[NUMBER_OF_ELLIPSES];
        esize = new double[ellipses.length];
        estroke = new float[ellipses.length];
    }

    private void initEllipses() {

        int w = 350;
        int h = 250;

        maxSize = w / 10;

        for (int i = 0; i < ellipses.length; i++) {

            ellipses[i] = new Ellipse2D.Float();
            posRandEllipses(i, maxSize * Math.random(), w, h);
        }
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void posRandEllipses(int i, double size, int w, int h) {

        esize[i] = size;
        estroke[i] = 1.0f;
        double x = Math.random() * (w - (maxSize / 2));
        double y = Math.random() * (h - (maxSize / 2));
        ellipses[i].setFrame(x, y, size, size);
    }

    private void doStep(int w, int h) {

        for (int i = 0; i < ellipses.length; i++) {

            estroke[i] += 0.025f;
            esize[i]++;

            if (esize[i] > maxSize) {

                posRandEllipses(i, 1, w, h);
            } else {

                ellipses[i].setFrame(ellipses[i].getX(), ellipses[i].getY(),
                        esize[i], esize[i]);
            }
        }
    }

    private void drawEllipses(Graphics2D g2d) {

        for (int i = 0; i < ellipses.length; i++) {

            g2d.setColor(colors[i % colors.length]);
            g2d.setStroke(new BasicStroke(estroke[i]));
            g2d.draw(ellipses[i]);
        }
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        doStep(size.width, size.height);
        drawEllipses(g2d);
        
        String words = "THANK YOU! VISIT AGAIN!";
        
        Font font = new Font("Serif", Font.PLAIN, 50);

        AttributedString as1 = new AttributedString(words);
        as1.addAttribute(TextAttribute.FONT, font);

        as1.addAttribute(TextAttribute.FOREGROUND, Color.yellow, 0, words.length());

        g2d.drawString(as1.getIterator(), 200, 200); 
        
        Font font1 = new Font("Serif", Font.ITALIC, 40);

        words="Project By:-  Chandni Garg";
        AttributedString as2 = new AttributedString(words);
        as2.addAttribute(TextAttribute.FONT, font1);

        as2.addAttribute(TextAttribute.FOREGROUND, Color.yellow, 0, words.length());

        g2d.drawString(as2.getIterator(), 200, 400); 
        
        words="Priyank Jain";
        AttributedString as3 = new AttributedString(words);
        as3.addAttribute(TextAttribute.FONT, font1);

        as3.addAttribute(TextAttribute.FOREGROUND, Color.yellow, 0, words.length());

        g2d.drawString(as3.getIterator(), 410, 450); 
        
        words="Priyanshu Sinha";
        AttributedString as4 = new AttributedString(words);
        as4.addAttribute(TextAttribute.FONT, font1);

        as4.addAttribute(TextAttribute.FOREGROUND, Color.yellow, 0, words.length());

        g2d.drawString(as4.getIterator(), 410, 500); 
        
        words="Saumya Joshi";
        AttributedString as5 = new AttributedString(words);
        as5.addAttribute(TextAttribute.FONT, font1);

        as5.addAttribute(TextAttribute.FOREGROUND, Color.yellow, 0, words.length());

        g2d.drawString(as5.getIterator(), 410, 550); 
        
        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
}

public class EndPage extends JFrame {

    public EndPage() {

        initUI();
    }

    private void initUI() {

        add(new Surface7());
        
        setTitle("Bubbles");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                EndPage ex = new EndPage();
                ex.setVisible(true);
            }
        });
    }
}