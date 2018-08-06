package Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
 
public class IOUtil {
    private IOUtil() {}
    
    public static void copy(final InputStream src, final OutputStream dest, int blockSize, boolean flush) throws IOException {
        int read;       
        byte [] buf = new byte[blockSize];
         
        while ((read = src.read(buf)) > 0)
            dest.write(buf, 0, read);
         
        if (flush)
            dest.flush();                   
    }
     
    public static void copy(final InputStream src, final OutputStream dest, int blockSize) throws IOException 
    {
        copy(src, dest, blockSize, true);
    }
    
    public static void fastCopy(final InputStream src, final OutputStream dest) throws IOException 
    {
        fastCopy(src, dest, (16 * 1024));
    }
    
    public static void fastCopy(final InputStream src, final OutputStream dest, int blockSize) throws IOException 
    {
        final ReadableByteChannel inputChannel = Channels.newChannel(src);
        final WritableByteChannel outputChannel = Channels.newChannel(dest);
        fastCopy(inputChannel, outputChannel, blockSize);
    }
    
    public static void fastCopy(final ReadableByteChannel src, final WritableByteChannel dest, int blockSize) throws IOException 
    {
        final ByteBuffer buffer = ByteBuffer.allocateDirect(blockSize);
        
        while(src.read(buffer) != -1) {
            buffer.flip();
            dest.write(buffer);
            buffer.compact();
        }
        
        buffer.flip();
        while(buffer.hasRemaining()) {
            dest.write(buffer);
        }
    }
}