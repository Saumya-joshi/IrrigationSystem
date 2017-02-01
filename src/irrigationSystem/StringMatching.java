package irrigationSystem;

import java.util.*;

public class StringMatching implements Search<String, String>{

	private List<String> items = new ArrayList<String>(); 
	private static int Prefix_array_pattern[];
	
	public StringMatching(List<String> items) 
	{
		this.items.addAll(items);
		Prefix_array_pattern = new int[items.size()];
	}

	@Override
	public Collection<String> search_string(String value) {
		HashSet<String> results = new HashSet<String>();
		build_prefix_array_pattern(value);
		int j = 0; //index for text
		int k = 0; //index for pattern
		for(int i = 0; i<items.size(); i++)
		{
			System.out.println("Running loop : " + (i));
			while(j < items.get(i).toString().length())
			{
				if(value.charAt(k) == items.get(i).toString().charAt(j))
				{
					k++;
					j++;
				}
				
				if(k == value.length())
				{
					System.out.println("Found at : " + (j-k));
					results.add(items.get(i));
					k = Prefix_array_pattern[k-1];
				}
				
				else if(j < items.get(i).toString().length() && value.charAt(k) != items.get(i).toString().charAt(j))
				{
					if(k != 0)
						k = Prefix_array_pattern[k-1];
					else
						j+=1;
				}
			}
			j = 0;
			k = 0;
		}
		return results;
	}

	public static void build_prefix_array_pattern(String user_input_pattern)
	{
		int length = 0;
		int i;
		Prefix_array_pattern[0] =  0;
		i = 1;
		while(i < user_input_pattern.length())
		{
			if(user_input_pattern.charAt(i) == user_input_pattern.charAt(length))
			{
				length++;
				Prefix_array_pattern[i] = length;
				i++;
			}
			else
			{
				if(length != 0)
				{
					length = Prefix_array_pattern[length-1];
				}
				else
				{
					Prefix_array_pattern[i] = 0;
					i++;
				}
			}
		}
	}
}
