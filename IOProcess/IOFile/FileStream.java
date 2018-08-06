package IOProcess.IOFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
 
public class FileStream implements Closeable {
    private RandomAccessFile m_raf;
    private BufferedReader m_br;
    private BufferedWriter m_bw;
     
    public FileStream(String filePath) throws IOException
    {
        this(filePath, FileAccess.READWRITE);
    }
     
    public FileStream(File file) throws IOException
    {
        this(file.getAbsolutePath());
    }
     
    public FileStream(String filePath, boolean append) throws IOException
    {
        this(filePath, FileAccess.READWRITE);
         
        if (append)
            m_raf.seek(m_raf.length());
    }
     
    public FileStream(File file, boolean append) throws IOException
    {
        this(file.getAbsolutePath(), append);
    }
     
    public FileStream(String filePath, FileAccess fileAccess) throws IOException
    {
        if (filePath == null || fileAccess == null)
            throw new IllegalArgumentException("null value is not accepted");
         
        m_raf = new RandomAccessFile(filePath, fileAccess == FileAccess.READ ? "r" : "rw");
        m_br = new BufferedReader(new FileReader(m_raf.getFD()));
        m_bw = new BufferedWriter(new FileWriter(m_raf.getFD()));
    }
     
    public FileStream(File file, FileAccess fileAccess) throws IOException
    {
        this(file.getAbsolutePath(), fileAccess);
    }   
 
    public boolean equals(Object arg0)
    {
        return m_raf.equals(arg0);
    }
 
    public final FileChannel getChannel()
    {
        return m_raf.getChannel();
    }
 
    public final FileDescriptor getFD() throws IOException
    {
        return m_raf.getFD();
    }
 
    public long getFilePointer() throws IOException
    {
        return m_raf.getFilePointer();
    }
 
    public int hashCode()
    {
        return m_raf.hashCode();
    }
 
    public long length() throws IOException
    {
        return m_raf.length();
    }
 
    public int read() throws IOException
    {
        return m_raf.read();
    }
 
    public int read(byte[] b, int off, int len) throws IOException
    {
        return m_raf.read(b, off, len);
    }
 
    public int read(byte[] b) throws IOException
    {
        return m_raf.read(b);
    }
 
    public final boolean readBoolean() throws IOException
    {
        return m_raf.readBoolean();
    }
 
    public final byte readByte() throws IOException
    {
        return m_raf.readByte();
    }
 
    public final char readChar() throws IOException
    {
        return m_raf.readChar();
    }
 
    public final double readDouble() throws IOException
    {
        return m_raf.readDouble();
    }
 
    public final float readFloat() throws IOException
    {
        return m_raf.readFloat();
    }
 
    public final void readFully(byte[] b, int off, int len) throws IOException
    {
        m_raf.readFully(b, off, len);
    }
 
    public final void readFully(byte[] b) throws IOException
    {
        m_raf.readFully(b);
    }
 
    public final int readInt() throws IOException
    {
        return m_raf.readInt();
    }
 
    public final String readLine() throws IOException
    {
        return m_br.readLine();
    }
 
    public final long readLong() throws IOException
    {
        return m_raf.readLong();
    }
     
    @SuppressWarnings("resource")
    public Object readObject() throws IOException, ClassNotFoundException
    {       
        return new ObjectInputStream(new FileInputStream(m_raf.getFD())).readObject();
    }
 
    public final short readShort() throws IOException
    {
        return m_raf.readShort();
    }
 
    public final String readUTF() throws IOException
    {
        return m_raf.readUTF();
    }
 
    public final int readUnsignedByte() throws IOException
    {
        return m_raf.readUnsignedByte();
    }
 
    public final int readUnsignedShort() throws IOException
    {
        return m_raf.readUnsignedShort();
    }
 
    public void seek(long pos) throws IOException
    {
        m_raf.seek(pos);
    }
 
    public void setLength(long newLength) throws IOException
    {
        m_raf.setLength(newLength);
    }
 
    public int skipBytes(int n) throws IOException
    {
        return m_raf.skipBytes(n);
    }
 
    public String toString()
    {
        return m_raf.toString();
    }
 
    public void write(byte[] b, int off, int len) throws IOException
    {
        m_raf.write(b, off, len);
    }
 
    public void write(byte[] b) throws IOException
    {
        m_raf.write(b);
    }
 
    public void write(int b) throws IOException
    {
        m_raf.write(b);
    }
     
    public void write(String s) throws IOException
    {       
        m_bw.write(s);
        m_bw.flush();       
    }
 
    public final void writeBoolean(boolean v) throws IOException
    {
        m_raf.writeBoolean(v);
    }
 
    public final void writeByte(int v) throws IOException
    {
        m_raf.writeByte(v);
    }
 
    public final void writeBytes(String s) throws IOException
    {
        m_raf.writeBytes(s);
    }
 
    public final void writeChar(int v) throws IOException
    {
        m_raf.writeChar(v);
    }
 
    public final void writeChars(String s) throws IOException
    {
        m_raf.writeChars(s);
    }
 
    public final void writeDouble(double v) throws IOException
    {
        m_raf.writeDouble(v);
    }
 
    public final void writeFloat(float v) throws IOException
    {
        m_raf.writeFloat(v);
    }
 
    public final void writeInt(int v) throws IOException
    {
        m_raf.writeInt(v);
    }
     
    public void writeLine(String s) throws IOException  
    {       
        m_bw.write(s);
        m_bw.newLine();
        m_bw.flush();
    }
 
    public final void writeLong(long v) throws IOException
    {
        m_raf.writeLong(v);
    }
     
    @SuppressWarnings("resource")
    public void writeObject(Object o) throws IOException
    {       
        new ObjectOutputStream(new FileOutputStream(m_raf.getFD())).writeObject(o);
    }
 
    public final void writeShort(int v) throws IOException
    {
        m_raf.writeShort(v);
    }
 
    public final void writeUTF(String str) throws IOException
    {
        m_raf.writeUTF(str);
    }
 
    @Override
    public void close() throws IOException
    {
        m_raf.close();      
    }   
}