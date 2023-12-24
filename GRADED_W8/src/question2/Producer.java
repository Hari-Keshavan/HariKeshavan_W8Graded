package question2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Producer extends Thread {

	final Thread1 obj;

	public Producer (Thread1 obj) {
		this.obj = obj;
	}

	public void run() {
		
		synchronized(obj) {
			
			try {
				String fileName = "myProject2.txt";
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(obj.hmap);
				oos.close();
				fos.close();
				System.out.println("Serialize called by Producer\nSerialized Data:");
				for (Entry<Project, ArrayList<Employee>> temp : obj.hmap.entrySet()) {
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
			
			obj.notifyAll();
			
		}
		
	}

}
