package Util;

import java.util.ArrayList;
import java.util.Random;
 
public final class StringUtil {
	private StringUtil() {}
	
    public static String changeCase(String s){
        return changeCase(new StringBuilder(s)).toString();
    }
     
    public static StringBuilder changeCase(StringBuilder sb){
        int len = sb.length();
         
        for (int i = 0; i < len; ++i) {
            char ch = sb.charAt(i);
             
            if (Character.isLetter(ch))
                sb.setCharAt(i, Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
        }
         
        return sb;              
    }
     
    public static String generateRandomPassword(int n){
        if (n <= 0)
            throw new IllegalArgumentException("n should be positive");
         
        String trStr = "çÇğĞıIiİşŞöÖüÜ";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(n);
         
        for (int i = 0; i < n; ++i) {
            int type = r.nextInt(3);
            char ch = trStr.charAt(r.nextInt(trStr.length()));
             
            switch (type) {         
            case 1: 
                int val = r.nextInt(26);
                ch = r.nextBoolean() ? (char)('A' + val) : (char)('a' + val);
                break;
            case 2:System.out.println(StringUtil.changeCase("aNkAra:"));
                ch = (char)('0' + r.nextInt(10));
                break;          
            }
             
            sb.append(ch);
        }       
         
        return sb.toString();
    }
     
    public static int getCount(String first, String second){
        int count = 0;      
         
        for (int index = 0; (index = first.indexOf(second, index)) != -1; ++index, ++count)
            ;
         
        return count;
    }
     
    public static String getRandomStr(int n){
        return getRandomStr(new java.util.Random(), n);     
    }
     
    public static String getRandomStr(java.util.Random r, int n){
        if (n <= 0)
            return "";
         
        char [] str = new char[n];
        String chars = "-_?:.[]";
         
        for (int i = 0; i < n; ++i) {
            int option = r.nextInt(3);          
             
            switch (option) {
                case 0: 
                    str[i] = (char)(r.nextInt(26) + (r.nextBoolean() ?  'A' : 'a'));
                    break;
                case 1: 
                    str[i] = (char)(r.nextInt(10) + '0');
                    break;
                case 2:
                    str[i] = chars.charAt(r.nextInt(chars.length()));                   
                    break;
            }
        }
         
        return String.valueOf(str);
    }   
     
    public static String getRandomStrWithTR(int n){
        return getRandomStrWithTR(new java.util.Random(), n);       
    }
     
    public static String getRandomStrWithTR(java.util.Random r, int n){
        if (n <= 0)
            return "";
         
        char [] str = new char[n];
        String chars = "-_?:.";
        String trLetters = "üÜiİıIçÇöÖğĞşŞ";
         
        for (int i = 0; i < n; ++i) {
            int option = r.nextInt(3);          
             
            switch (option) {
                case 0: 
                    if (r.nextBoolean())
                        str[i] = (char)(r.nextInt(26) + (r.nextBoolean() ?  'A' : 'a'));
                    else
                        str[i] = trLetters.charAt(r.nextInt(trLetters.length()));
                    break;
                case 1: 
                    str[i] = (char)(r.nextInt(10) + '0');
                    break;
                case 2:
                    str[i] = chars.charAt(r.nextInt(chars.length()));                   
                    break;
            }
        }
         
        return String.valueOf(str);
    }
     
    public static String getReverse(String s) {
    	return (new StringBuilder(s)).reverse().toString();
    }
     
    public static String getString(int count, char ch){
        String str = "";
         
        for (int i = 0; i < count; ++i)
            str += ch;
         
        return str;
    }
     
    public static boolean isPalindromeWithoutWS(String s){   
        return isPalindromeWithWS(removeWS(s));
    }
     
    public static boolean isPalindromeWithWS(String s){
        return reverse(s).equals(s);
    }
     
    public static String join(ArrayList<String> list){
        return join(list, "");
    }
     
    public static String join(ArrayList<String> list, char delim){
        return join(list, delim + "");      
    }
     
    public static String join(ArrayList<String> list, String delim){
        String [] strs = new String[list.size()];
         
        return join(list.toArray(strs), delim);
    }
     
    public static String join(String[] strs, char delim){           
        return join(strs, delim + "");              
    }   
     
    public static String join(String[] strs, String delim){   
        StringBuilder sb = new StringBuilder();
         
        for (String s : strs) {
            if (sb.length() != 0)
                sb.append(delim);
             
            sb.append(s);           
        }
         
        return sb.toString();               
    }
     
    public static String makeFirstCapital(String s){
        s = s.trim();
         
        return !s.isEmpty() ? Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase() : s;
    }
     
    public static String mergeIfNotEnds(String str, String endStr){
        return str.endsWith(endStr) ? str : str + endStr;       
    }
     
    public static String mergeIfNotStarts(String str, String startStr){
        return str.startsWith(startStr) ? str : startStr + str;     
    }
     
    public static String padLeft(String str, int count){
        return padLeft(str, count, ' ');
    }
     
    public static String padLeft(String str, int count, char ch){
        if (count < 0)
            return ""; //...
         
        if (count <= str.length())
            return str;
         
        String result = "";
         
        int len = count - str.length();
         
        for (int i = 0; i < len; ++i)
            result += ch;       
         
        return result + str;
    }
     
 
    public static String padRight(String str, int count){
        return padRight(str, count, ' ');
    }
     
    public static String padRight(String str, int count, char ch){
        if (count < 0)
            return ""; //...
         
        if (count <= str.length())
            return str;
         
        String result = str;        
         
        int len = count - str.length();
         
        for (int i = 0; i < len; ++i)
            result += ch;       
         
        return result;
    }
     
    public static String removeWS(String s){
        int len = s.length();       
        String str = "";        
         
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
             
            if (!Character.isWhitespace(ch))
                str += ch;
        }
         
        return str;     
    }
     
    public static String reverse(String s){       
        return new StringBuilder(s).reverse().toString();
    }
     
    public static String trimLeft(String s){
        int index = 0;      
         
        for (int len = s.length(); index < len && Character.isWhitespace(s.charAt(index)); ++index)
            ;               
         
        return s.substring(index);
    }
    
    public static String trimRight(String s){
        int index = s.length() - 1;
         
        for (; index >= 0 && Character.isWhitespace(s.charAt(index)); --index)
            ;
         
        return s.substring(0, index + 1);
    }
}