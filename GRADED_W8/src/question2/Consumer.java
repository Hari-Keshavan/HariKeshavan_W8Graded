package question2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Consumer extends Thread{

	final Thread1 obj;

	public Consumer (Thread1 obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public void run() {
		
		synchronized (obj) {
			
			try {
				obj.wait();
				String fileName = "myProject2.txt";
				HashMap<Project,ArrayList <Employee>> obj1;
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				obj1 = (HashMap<Project,ArrayList <Employee>>) ois.readObject();
				ois.close();
				fis.close();

				System.out.println("Deserialize called by Consumer\nDeserialized Data:");
				for (Entry<Project, ArrayList<Employee>> temp : obj1.entrySet()) {
					System.out.println(temp.getKey());
					for (Employee temp2 : temp.getValue()) {
						System.out.println(temp2);
					}
					System.out.println();
				}

			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
		
	}

}


