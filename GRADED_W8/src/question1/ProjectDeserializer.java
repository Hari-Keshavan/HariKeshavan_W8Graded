package question1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class ProjectDeserializer {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Map<Project, ArrayList<Employee>> projectMap1 = null;
		String fileName = "myProject.txt";
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			projectMap1 = (Map<Project, ArrayList<Employee>>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch (Exception e) {
			System.out.println("Exception happened");
		}
		
		for (Entry<Project, ArrayList<Employee>> temp : projectMap1.entrySet()) {
			System.out.println(temp.getKey());
			System.out.println("Employees .............");
			for (Employee temp2 : temp.getValue()) {
				System.out.println(temp2);
			}
		}
		
	}

}
