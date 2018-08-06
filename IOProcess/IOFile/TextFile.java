package IOProcess.IOFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TextFile implements AutoCloseable{
	private FileStream m_fs;
	
	public TextFile(File file) throws IOException{
		m_fs = new FileStream(file);
	}
	
	public TextFile(String file) throws IOException{
		m_fs = new FileStream(file);
	}
	
	public int findAndReplaceLines(String oldText, String newText) throws IOException {
		int result = 0;
		String temp;
		
		while((temp = m_fs.readLine()) != null) {
			if(temp.contains(oldText)) {
				result++;
				m_fs.seek(m_fs.getFilePointer()-1);
				m_fs.writeLine(temp.replace(oldText, newText));
			}
		}
		
		m_fs.seek(0);
		return result;
	}
	
	public String readLine() throws IOException {
		return m_fs.readLine();
	}
	
	public TextFile writeLine(String s) throws IOException{
		m_fs.writeLine(s);
		return this;
	}
	
	public ArrayList<String> readLines() throws IOException {
		ArrayList<String> result= new ArrayList<>();
		
		String temp;
		while((temp = m_fs.readLine()) != null)
			result.add(temp.trim());

		m_fs.seek(0);
		return result;
	}

	@Override
	public void close() throws Exception {
		m_fs.close();
	}

}
