package classroom;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

	public static void main(String[] args) {
		
		//Declare set
		Set<String> names1 = new HashSet<String>();
		names1.add("Padma");
		names1.add("Sumathi");
		names1.add("Ashmita");
		names1.add("Ashmita");
		
		System.out.println(names1);
		
		//Declare Treeset
		
		Set<String> names2 = new TreeSet<String>();
		names2.add("Riya");
		names2.add("Miya");
		names2.add("Shirley");
		
		System.out.println(names2);
		
		for (String name : names2) {
			System.out.println(name);
		}

	}

}
