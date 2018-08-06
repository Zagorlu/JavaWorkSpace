package Converters;

import java.nio.ByteBuffer;

public final class BitConverter {
	private BitConverter() {}
    
    public static byte[] getBytes(boolean value)
    {
        return new byte[] {(byte)(value ? 1 : 0)};
    }
     
    public static byte [] getBytes(byte value)
    {
        return new byte [] {value};
    }
     
    public static byte[] getBytes(char value)
    {
        return ByteBuffer.allocate(2).putChar(value).array();
    }
     
    public static byte[] getBytes(double value)
    {
        return ByteBuffer.allocate(8).putDouble(value).array();
    }
     
    public static byte[] getBytes(float value)
    {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }   
     
    public static byte[] getBytes(int value)
    {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
     
    public static byte[] getBytes(long value)
    {
        return ByteBuffer.allocate(8).putLong(value).array();
    }
     
    public static byte[] getBytes(short value)
    {
        return ByteBuffer.allocate(2).putShort(value).array();
    }
     
    public static byte [] getBytes(String str)
    {
        return str.getBytes();
    }   
     
    public static boolean toBoolean(byte [] data)
    {
        return toBoolean(data, 0);      
    }
     
    public static boolean toBoolean(byte [] data, int startIndex)
    {
        return data[startIndex] == 1;
    }
     
    public static char toChar(byte [] data)
    {
        return toChar(data, 0);     
    }
     
    public static char toChar(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 2).getChar();      
    }
     
    public static double toDouble(byte [] data)
    {
        return toDouble(data, 0);       
    }
     
    public static double toDouble(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 8).getDouble();        
    }
     
    public static float toFloat(byte [] data)
    {
        return toFloat(data, 0);        
    }
     
    public static float toFloat(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 4).getFloat();     
    }
     
    public static int toInt(byte [] data)
    {
        return toInt(data, 0);      
    }
    
    public static int toInt(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 4).getInt();       
    }
     
    public static long toLong(byte [] data)
    {
        return toLong(data, 0);     
    }   
     
    public static long toLong(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 8).getLong();      
    }
     
    public static short toShort(byte [] data)
    {
        return toShort(data, 0);        
    }   
     
    public static short toShort(byte [] data, int startIndex)
    {
        return ByteBuffer.wrap(data, startIndex, 2).getShort();     
    }
     
    public static String toString(byte [] data)
    {
        return new String(data);
    }
}