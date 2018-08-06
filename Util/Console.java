package Util;

import java.math.BigInteger;
import java.util.Scanner;
 
public final class Console {
    private Console() {}
    private static Scanner ms_kb = new Scanner(System.in);  
	
    public static BigInteger readBigInteger()
    {
        return readBigInteger("");  
    }
     
    public static BigInteger readBigInteger(String msg)
    {
        return readBigInteger(msg, "");
    }
     
    public static BigInteger readBigInteger(String msg, String errMsg)
    {
        BigInteger val = BigInteger.ZERO;
        boolean repeat;
         
        do {
            try {
                repeat = false;
                write(msg);
                val = new BigInteger(ms_kb.nextLine());
            }
            catch (Throwable ex) {
                write(errMsg);
                repeat = true;
            }
             
        } while (repeat);
         
         
        return val;     
    }
     
    public static BigInteger readBigIntegerLine()
    {
        return readBigIntegerLine("");
    }   
     
    public static BigInteger readBigIntegerLine(String msg)
    {
        return readBigIntegerLine(msg, "");
    }   
     
    public static BigInteger readBigIntegerLine(String msg, String errMsg)
    {
        return readBigInteger(String.format("%s%s", msg, msg.isEmpty() ? "" : "\n"), String.format("%s%s", errMsg, errMsg.isEmpty() ? "" : "\n"));      
    }   
     
    public static double readDouble()
    {
        return readDouble("");  
    }
     
    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }
     
    public static double readDouble(String msg, String errMsg)
    {
        double val = 0;
        boolean repeat;
         
        do {
            try {
                repeat = false;
                write(msg);
                val = Double.parseDouble(ms_kb.nextLine());
            }
            catch (Throwable ex) {
                write(errMsg);
                repeat = true;
            }
             
        } while (repeat);       
         
         
        return val;
    }   
     
    public static double readDoubleLine()
    {
        return readDoubleLine("");
    }   
     
    public static double readDoubleLine(String msg)
    {
        return readDoubleLine(msg, "");
    }   
     
    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(String.format("%s%s", msg, msg.isEmpty() ? "" : "\n"), String.format("%s%s", errMsg, errMsg.isEmpty() ? "" : "\n"));      
    }   
     
    public static int readInt()
    {
        return readInt(""); 
    }
     
    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }
     
    public static int readInt(String msg, String errMsg)
    {
        int val = 0;
        boolean repeat;
         
        do {
            try {
                repeat = false;
                System.out.print(msg);
                val = Integer.parseInt(ms_kb.nextLine());
            }
            catch (Throwable ex) {
                System.out.print(errMsg);
                repeat = true;
            }
             
        } while (repeat);
         
         
        return val;
    }
     
    public static int readIntLine()
    {
        return readIntLine("");
    }   
     
    public static int readIntLine(String msg)
    {
        return readIntLine(msg, "");
    }   
     
    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(String.format("%s%s", msg, msg.isEmpty() ? "" : "\n"), String.format("%s%s", errMsg, errMsg.isEmpty() ? "" : "\n"));     
    }
 
     
    //...
     
    public static String readLine()
    {
        return ms_kb.nextLine();        
    }   
     
    public static String readLine(String msg)
    {
        writeLine(msg);
        return readLine();      
    }
     
     
    public static void write(Object obj)
    {
        write("%s", obj);
    }
     
    public static void write(String fmt, Object...objs)
    {
        System.out.printf(String.format("%s", fmt), objs);
    }
     
     
    public static void writeLine()
    {
        System.out.println();
    }
     
    public static void writeLine(Object obj)
    {
        writeLine("%s", obj);
    }
     
    public static void writeLine(String fmt, Object...objs)
    {
        System.out.printf(String.format("%s%n", fmt), objs);
    }   
}