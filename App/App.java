package App;

import java.io.File;

public class App {
	public static void main(String[] args) {
		try {

			//RandomAccessFile text = new RandomAccessFile("C:\\Users\\z003x7jw\\Desktop\\BASE_DEVICE_INFO.txt","rw");
			
			File file  = new File("C:\\Users\\z003x7jw\\Desktop\\BASE_DEVICE_INFO.txt");
			
			
			
			
			
	
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
