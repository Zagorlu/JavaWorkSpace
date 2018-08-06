package App;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final public class HackerRankUtil {
    private HackerRankUtil() {}
    
	// Complete the absolutePermutation function below.
    public static int[] absolutePermutation(int n, int k) {
        int[] result = new int[n];
        
        if (k == 0) {
            for(int i = 0 ; i < n ; ++i)
                result[i] = i + 1;
            return result;
        }
        
        if (n % 2 == 1) 
        	return new int[]{-1};

        if (n % k == 0 && (n / k) % 2 == 0) {
            int signSwitch = 1;
            int counter = 0;
            for(int i = 0 ; i < n ; ++i) {
                result[i+k*signSwitch] = i+1;
                counter++;
                if ((counter / k) % 2 == 1)
                    signSwitch = -1;
                else
                    signSwitch = 1;
            }
        }
        else {
            return new int[]{-1};
        }
        return result;
    }
	
    // Complete the acmTeam function below.
    public static int[] acmTeam(String[] topic) {
    	int[] resutlArray = new int[2];
    	for (int i=0;i<topic.length-1;i++){
            for (int k=i+1;k<topic.length;k++){
                int tempMaxSubjects = 0;
                for (int j=0;j<topic[0].length();j++){
                    if (topic[i].charAt(j) == '1' || topic[k].charAt(j) == '1')
                        tempMaxSubjects++;
                }
                if ( tempMaxSubjects > resutlArray[0]){
                    resutlArray[0] = tempMaxSubjects;
                    resutlArray[1] = 1;
                } else if ( tempMaxSubjects == resutlArray[0] )
                    resutlArray[1]++;
            }
        }
        return resutlArray;
    }
	
	// Complete the almostSorted function below.
    public static void almostSorted(int[] arr) {
    	int[] temp=new int[arr.length];
        temp=Arrays.copyOf(arr,arr.length);
        int i,j,count,flag;
        int[] lr=new int[2];
        Arrays.sort(temp);
        
        if(Arrays.equals(temp,arr))
            System.out.println("yes");
        else{
            count=0;
            for(i=0;i<arr.length;i++){
                if(arr[i]!=temp[i]){
                    count++;
                    if(count>2)
                        break;
                    lr[count-1]=i+1;
                }
            }
            if(count==2){
                System.out.println("yes");
                System.out.println("swap "+lr[0]+" "+lr[1]);
            }
            else{
                for(i=0;i<arr.length;i++){
                    flag=0;
                    for(j=arr.length-1;j>i;j--){
                        if(arr[i]>arr[j]){
                            lr[0]=i;
                            lr[1]=j;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
                flag=0;
                for(i=lr[0];i<lr[1];i++){
                    if(arr[i]<arr[i+1]){
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    System.out.println("no");
                else
                    System.out.println("yes\n"+"reverse "+(lr[0]+1)+" "+(lr[1]+1));
            }
        }
    }
	
    // Complete the alternatingCharacters function below.
    public static int alternatingCharacters(String s) {
    	int result = 0;
    	for(int i=0; i<s.length(); i++)
    		if(i != 0 && s.charAt(i) == s.charAt(i-1))
    			result++;
    	return result;
    }
	
    // Complete the anagram function below.
    public static int anagram(String s) {
        if(s.length()%2 != 0)
            return -1;
        int result = 0;
        int[] charArray = new int[26];
        for(int i=0; i<s.length()/2; i++)
            charArray[s.charAt(i) - 97]++;
        
        for(int i=s.length()/2; i<s.length(); i++)
            charArray[s.charAt(i) - 97]--;
        
        for(int val : charArray)
            result += Math.abs(val);
        
        return result/2 ;
    }
    
    // Complete the angryProfessor function below.
    public static String angryProfessor(int k, int[] a) {
    	for (int i=0; i<a.length && k>0; i++) 
    	    if (a[i]<=0) 
    	        k--;
    	return k == 0 ? "NO" : "YES";
    }
    
    // Complete the appendAndDelete function below.
    public static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;
        
        for (int i=0; i<Math.min(s.length(),t.length());i++){
            if (s.charAt(i)==t.charAt(i))
                commonLength++;
            else
                break;
        }
        
        if((s.length()+t.length()-2*commonLength)>k)
        	return "No";
   
        else if((s.length()+t.length()-2*commonLength)%2==k%2)
        	return "Yes";

        else if((s.length()+t.length()-k)<0)
            return "Yes";
 
        return "No";        
    }
	
    // Complete the beautifulBinaryString function below.
    public static int beautifulBinaryString(String b) {
    	return (b.length() - b.replaceAll("010", "").length())/3;
    }
    
    // Complete the beautifulDays function below.
    public static int beautifulDays(int i, int j, int k) {
    		int n = Math.abs(i-j) + 1, result = 0;
    		while(n-- != 0) {
    			int rev = Integer.parseInt(new StringBuilder(i+"").reverse().toString());
    			if(Math.abs(rev - i++) % k == 0)
    				result++;
    		}
    		return result;
    }

    // Complete the beautifulTriplets function below.
    public static int beautifulTriplets(int d, int[] arr) {
    	int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (Arrays.stream(arr).anyMatch(no -> no == n + d) && Arrays.stream(arr).anyMatch(no -> no == (n + d + d)))
                count += 1;
        }
        return count;
    }
	
    // Complete the biggerIsGreater function below.
    public static String biggerIsGreater(String w) {
        String ans = "";
        char[] arr = w.toCharArray();
        int i = w.length()-1;
        
        while(i>0 && ((int)arr[i]<=(int)arr[i-1]))
            i--;
        
        if(i==0)
          ans = "no answer";
        
        else{
            int j = w.length()-1;
            int ab = (int)arr[i-1];
            while((int)arr[j] <= ab)
                j--;
            
            char tmp = arr[j];
            arr[j] = arr[i-1];
            arr[i-1]=tmp;
            j = w.length()-1;
            
            while(i<j){
                char tp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = tp2;
                i++;
                j--;
            }
            ans = "";
            for(int p=0;p<w.length();p++)
                ans = ans.concat(String.valueOf(arr[p]));
        }
        return(ans);
    }
	
    // Complete the bigSorting function below.
    public static String[] bigSorting(String[] unsorted) {
        List<String> list = new ArrayList<String>(Arrays.asList(unsorted));
        Collections.sort(list, new Comparator<String>(){
            
            public int compare(String one, String two){
                if(one.length() != two.length())
                    return one.length() - two.length();
                
                for(int i = 0; i < one.length(); i++)
                    if(one.charAt(i) != two.charAt(i))
                        return one.charAt(i) - two.charAt(i);
                
                return 0;
            }
            
        });
        return list.toArray(new String[list.size()]);
    }
	
    //Birthday Chocolate
    public static int birthdayChocolate(int[] s, int d, int m) {
    		int result = 0;
    		for(int i=0; i<s.length; i++){
    			int tmpSum = 0;
    			

    			for(int j=i; j<m+i; j++)
    				tmpSum += s[j];
    				

    			if(tmpSum == d)
    				result++;
    				

    			if(s.length -i - m == 0)
    				break;
    		}
    		return result;
    }
	
    // Complete the solve function below.
    public static int[] bobAliceProblem(int[] a, int[] b) {
    	int bob = 0;
    	int alice = 0;
    	int[] result = new int[2];
    	
    	for(int i=0; i<a.length; i++) {
    		if(a[i] > b[i])
    			bob++;
    		if(a[i] < b[i])
    			alice++;
    	}
    	
    	result[0] = bob;
    	result[1] = alice;
    	return result;
    }
	
    // Complete the breakingRecords function below.
    public static int[] breakingRecords(int[] scores) {
        int highest, lowest;
        highest = lowest = scores[0];
        
        int[] result = new int[2];
        
        for (int i = 1; i < scores.length; i++)
        {
            if (scores[i] > highest)
            {
                highest = scores[i];
                ++result[0];
            }
            else if (scores[i] < lowest)
            {
                lowest = scores[i];
                ++result[1];
            }
        }
        
        return result;
    }
	
    // Complete the caesarCipher function below.
    public static String caesarCipher(String s, int k) {
    	StringBuilder result = new StringBuilder(s);
    	for(int i=0; i<result.length(); i++)
    		if(Character.isAlphabetic(result.charAt(i)))
    			result.setCharAt(i, (char)(
    					Character.isUpperCase(result.charAt(i)) ? 
    						(((result.charAt(i)+k%26) > 90)  ? ((result.charAt(i) + k%26) % 90 ) + 64 : result.charAt(i)+ k%26) :
    						(((result.charAt(i)+k%26) > 122) ? ((result.charAt(i) + k%26) % 122) + 96 : result.charAt(i)+ k%26)));
    	return result.toString();
    }
	
    // Complete the camelcase function below.
    public static int camelcase(String s) {
    	int result = 1;
    	for(int i=0; i<s.length(); i++)
    		if(Character.isUpperCase(s.charAt(i)))
    			result++;
    	return result;
    }
	
    // Complete the catAndMouse function below.
    public static String catAndMouse(int x, int y, int z) {
    	int distanceCatA = z - x;
    	int distanceCatB = z - y;
    	
    	if(((distanceCatB + distanceCatA) != 0) && x != y)
    		return Math.abs(distanceCatA) > Math.abs(distanceCatB) ? "Cat B" : "Cat A";
    	
    	return "Mouse C";
    }
	
    // Complete the cavityMap function below.
    public static String[] cavityMap(String[] grid) {
        for (int i = 1; i < grid.length-1; i++)
        {
            for (int j = 1; j < grid.length-1; j++)
            {
                if (grid[i-1].charAt(j) < grid[i].charAt(j)
                    && grid[i].charAt(j-1) < grid[i].charAt(j)
                    && grid[i+1].charAt(j) < grid[i].charAt(j)
                    && grid[i].charAt(j+1) < grid[i].charAt(j))
                    grid[i] = grid[i].substring(0, j) + "X" + grid[i].substring(j+1, grid.length);
                
            }
        }
        return grid;
    }
	
    // Complete the chocolateFeast function below.
    public static int chocolateFeast(int n, int c, int m) {
    	int tmp = n / c; 
        int result = tmp;
        while(tmp>=m) {  
            tmp=tmp-m;
            tmp++;
            result++;
        }
        return result;
    }
	
    // Complete the circularArrayRotation function below.
    public static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int length = a.length;
        for(int i=0;i<queries.length;i++)
            queries[i] = a[(queries[i] - k%length + length) % length];
        
        return queries;
    }
	
    // Complete the climbingLeaderboard function below.
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	int results[] = new int[alice.length];
    	int rank = 1, rankScore = scores[0];

    	for (int a = alice.length - 1, s = 0; a >= 0; a--) {
    		if (alice[a] < rankScore) {
    			for (; s < scores.length; s++) {
    				if (scores[s] < rankScore) {
    					rank++;
    					rankScore = scores[s];
    				}				
    				if(alice[a] >= scores[s]) 
    					break;
    			}
    		}

    		results[a] = s == scores.length ? rank + 1 : rank;
    	}
    	return results;
    }
	
    // Complete the closestNumbers function below.
    public static int[] closestNumbers(int[] arr) {
    	Arrays.sort(arr);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] < min) {
				result.clear();
				result.add(arr[i]);
				result.add(arr[i - 1]);
				min = arr[i] - arr[i - 1];
			} else if (arr[i] - arr[i - 1] == min) {
				result.add(arr[i]);
				result.add(arr[i - 1]);
			}
		}
		Collections.sort(result);
		return result.stream().mapToInt(i -> i).toArray();
    }
	
    // Complete the commonChild function below
    public static int commonChild(String s1, String s2) {
        int[][] array = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    array[i+1][j+1] = array[i][j] + 1;
                else
                    array[i+1][j+1] = Math.max(array[i+1][j], array[i][j+1]);
            }
        }
        return array[s1.length()][s2.length()];
    }
	
    // Complete the countApplesAndOranges function below.
    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    	ArrayList<Integer> appleList  = new ArrayList<>();
    	ArrayList<Integer> orangeList = new ArrayList<>();
    	
    	for(int i: apples)
    		if ((a+i)>=s && (a+i)<=t)
    			appleList.add(i);
    	
    	for(int i: oranges)
    		if((b+i)<=t && (b+i)>=s)
    			orangeList.add(i);
    	
    	System.out.println(appleList.size());
    	System.out.println(orangeList.size());
    }
	
    // Complete the countingSort function below.
	// WARNING : This Name Should remove char of the last one "1"
    public static int[] countingSort1(int[] arr) {
        int maxNumber = 0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]>maxNumber)maxNumber=arr[i];
        
        int[] result = new int[maxNumber+1];
        for(int i=0;i<arr.length;i++)
            result[arr[i]]++;
        
        return result;
    }
	
    // Complete the countingSort function below.
    // WARNING : This Name Should remove char of the last one "2"
    public static int[] countingSort2(int[] arr) {
        int max = 0, temp = 0;
        Arrays.sort(arr);
        List <Integer> al = new ArrayList<Integer>();
        max = arr[arr.length-1];
        int count[] = new int[max+1];
        
        for(int i = 0;i<count.length;i++)
            count[i]=0;
        
       for(int i = 0;i<arr.length;i++)
           count[arr[i]]++;

       for(int i = 0;i<count.length;i++){
          temp = count[i];
          for(int j=0;j<temp;j++)
              al.add(i);
       }
       
       int result[] = new int[al.size()];
       for(int i=0;i < result.length;i++)
          result[i]=al.get(i);
      
       return result;
    }
	
    // Complete the countingValleys function below.
    public static int countingValleys(int n, String s) {
    	int result = 0, state = 0;
    	
        for(char c : s.toCharArray()){
            if(c == 'U') 
            	++state;
            
            if(c == 'D') 
            	--state;

            if(state == 0 && c == 'U')
                ++result;
        }
        return result;
    }
	
    // Complete the cutTheSticks function below.
    public static int[] cutTheSticks(int[] arr) {    
        int arrSum = 0;
        String str = "";
        
        for(int i=0; i<arr.length; i++)
            arrSum += arr[i];
        
        while(arrSum > 0){
            Arrays.sort(arr);
            int tempCount = 0;
            int currSmall = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] == 0)
                    continue;
                else{
                    currSmall = (tempCount == 0) ? arr[i] : currSmall;
                    arr[i] = arr[i] - currSmall;
                    arrSum = arrSum - currSmall;
                    tempCount++;
                }
            }
            str += String.valueOf(tempCount) + "-";
        }
        String strArr[] = str.split("-");
        int[] retArr = new int[strArr.length];
        
        for(int i=0; i<strArr.length; i++)
            retArr[i] = Integer.parseInt(strArr[i]);
        
        return retArr;
    }
	
    // Complete the designerPdfViewer function below.
    public static int designerPdfViewer(int[] h, String word) {
        int temp = 0;
       
        for(int i = 0;i<word.length();i++){
            int ascii =(int)word.charAt(i);
            int height = h[ascii- 97];
            if(height>temp)
                temp = height;
        }
        return temp*word.length();
    }
    
    // Complete the divisibleSumPairs function below.
    public static int divisibleSumPairs(int n, int k, int[] ar) {
    	int result = 0;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
        		if(i < j && (ar[i] + ar[j]) % k == 0)
        			result++;
        	}
    	}
    	return result;
    }
	
    // Complete the encryption function below.
    public static String encryption(String s) {
		String str = "";
		int n=s.length();
		int c = (int) Math.ceil(Math.pow(n,0.5));
		
		for(int i=0;i<c;i++){
			for(int j=0+i;j<s.length();j+=c)
				str+= s.charAt(j);
			str+=" "; 
		}
		return str;
    }

    // Complete the equalizeArray function below.
    public static int equalizeArray(int[] arr) {
        int max = 1;
	    Map<Integer, Integer> nums = new HashMap<>();
	    for (int i : arr)
	        if (!nums.containsKey(i))
	            nums.put(i, 1);
	        else {
	            nums.put(i, nums.get(i) + 1);
	            if (max < nums.get(i))
	                max = nums.get(i);
	        }
	    return arr.length - max;
    } 
        
    // Complete the extraLongFactorials function below.
    public static void extraLongFactorials(int n) {
        BigInteger bi = BigInteger.ONE;
        for(int i=1; i<=n; i++)
            bi = bi.multiply(BigInteger.valueOf(i));
        System.out.printf("%s%n",bi.toString());
    }

	// Complete the fairRations function below.
    public static int fairRations(int[] B) {
    	int sum = 0, n = 0;
        
        for(int i =0; i<B.length-1;i++){
            if(B[i]%2!=0){
                B[i]+=1;
                B[i+1]+=1;
                n+=2;
            }
            sum+=B[i];
        }
        sum+=B[B.length-1];
        if(sum % 2 != 0)
        	return -1;
        return n;
        /*
        ---- THIS CODE BLOCK HAS TO BE ADD MAIN CODE BLOCK ----
        int result = fairRations(B);
        if(result == -1)
            bufferedWriter.write(String.valueOf("NO"));
        else
            bufferedWriter.write(String.valueOf(result));
        */
    }

	// Complete the findDigits function below.
    public static int findDigits(int n) {
        int r = n;
        int count = 0;
        while(r > 0){
            if(r % 10 != 0 && n % (r % 10) == 0) count++;
            r = r / 10;
        }
        return count;
    }
    
    // Complete the findMedian function below.
    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
	
    // Complete the flatlandSpaceStations function below.
    public static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = c[0];
        for(int i = 1; i < c.length; i++){
            int distance = (c[i] - c[i-1]) / 2;
            if(maxDistance < distance) 
            	maxDistance = distance;
        }
        int lastGap = (n-1) - c[c.length - 1];
        return (lastGap < maxDistance) ? maxDistance : lastGap;
    }

    // Complete the formingMagicSquare function below.
    public static int formingMagicSquare(int[][] s) {
        int cost = Integer.MAX_VALUE;
        int t[][] = 
                    {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                    };
        int temp = 0;
        
        for(int i=0;i<8;i++){
            temp = Math.abs(s[0][0]-t[i][0]) 
            		+ Math.abs(s[0][1]-t[i][1]) 
            		+ Math.abs(s[0][2]-t[i][2]) 
            		+ Math.abs(s[1][0]-t[i][3]) 
            		+ Math.abs(s[1][1]-t[i][4]) 
            		+ Math.abs(s[1][2]-t[i][5])
            		+ Math.abs(s[2][0]-t[i][6]) 
            		+ Math.abs(s[2][1]-t[i][7]) 
            		+ Math.abs(s[2][2]-t[i][8]);
            
            cost = temp<cost?temp:cost;
        }
        
        return cost;
    }
    
    // Complete the funnyString function below.
    public static String funnyString(String s) {
    	String reversedString = new StringBuilder(s).reverse().toString();
        int index = 1;
        while(Math.abs(s.charAt(index)-s.charAt(index-1)) == Math.abs(reversedString.charAt(index)-reversedString.charAt(index-1)) && index<s.length())
            if(++index==s.length())
                return "Funny";
        return "Not Funny";
    }
	
    // Complete the gameOfThrones function below.
    public static String gameOfThrones(String s) {
    	HashMap<Character, Integer> container = new HashMap<>();
    	for(char c: s.toCharArray())
    		if(container.containsKey(c))
    			container.put(c, container.get(c).intValue()+1);
    		else
    			container.put(c, 1);
    	int oddCount = 0;
    	for(int i: container.values())
    		if(i%2 != 0)
    			oddCount++;
    	return oddCount == 1 || oddCount == 0 ? "YES" : "NO";
    }

    // Complete the gemstones function below.
    public static int gemstones(String[] arr) {
    	int[] a = new int[26];
        int count =0;
		for(int i =0; i< arr.length; i++){
			String s = arr[i];
			for(int j=0; j<s.length(); j++)
				if(a[s.charAt(j) % 97] == i)
					a[s.charAt(j) % 97]++;
		}
		for(int i =0; i<26 ; i++)
			if(a[i] == arr.length) 
				count++;
		return count;
    }
	
	//Complete the getMoneySpent function below.
    public static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
		int max = -1;
		
		for (int i = 0; i < keyboards.length; i++)
			for (int j = 0; j < drives.length; j++)
				if (keyboards[i] + drives[j] <= budget && keyboards[i] + drives[j] > max)
					max = keyboards[i] + drives[j];
	
		return max;
	}
	
    //Complete the getTotalX function below.
    public static int getTotalX(int[] a, int[] b) {
        int x=1,r=0,j=0,count=0;
        int[] d = new int[101];
        for(x=1;x<101;x++){
        	int c=0;
        		for(int i=0;i<a.length;i++) {
        			if(x%a[i]==0&&x>=a[i]){
        				c++;
        			}
        			}
        		if(c==a.length){
        			d[j]=x;
    				r++;
    				j++;
        		}
        		}
        for(j=0;j<r;j++){
        	int c=0;
            for(int i=0;i<b.length;i++){
         	   if(b[i]%d[j]==0){
         		   c++;
         	   }
            }
            if(c==b.length){
         	   count++;
            }
        }
        return count;
    }
	
    //Complete the gradingStudents function below.
    public static int[] gradingStudents(int[] grades) {
    	for(int i=0; i<grades.length; i++) {
    		int tmp = grades[i], diff = 5 -(tmp % 5);
    		int newValue = tmp + diff;
    		
    		if(((newValue - tmp) == 3) || tmp < 38)
    			continue;
    		
    		if((newValue - tmp) < 3)
    			tmp += diff;
    		
    		grades[i] = tmp;
    	}
    	return grades;
    }
	
    // Complete the gridSearch function below.
    public static String gridSearch(String[] G, String[] P) {
        char[][] gridArr = new char[G.length][G[0].length()];
        char[][] patternArr = new char[P.length][P[0].length()];
        for (int i = 0; i < G.length; i++)
            gridArr[i] = G[i].toCharArray();
        for (int i = 0; i < P.length; i++)
            patternArr[i] = P[i].toCharArray();
        boolean matchFlag = true;

        for (int i = 0; i < gridArr.length - patternArr.length+1; i++) {
            for (int j = 0; j < gridArr[0].length - patternArr[0].length+1; j++) {
                matchFlag = true;
                if (gridArr[i][j] == patternArr[0][0]) {
                    for (int k = 0; k < patternArr.length; k++) {
                        if (matchFlag) {
                            for (int l = 0; l < patternArr[0].length; l++) {
                                if (gridArr[i + k][j + l] != patternArr[k][l]) {
                                    matchFlag = false;
                                    break;
                                }

                            }
                        }
                    }
                    if (matchFlag == true)
                        return "YES";

                } else
                    continue;
            }
        }
        return "NO";
    }
	
    // Complete the hackerlandRadioTransmitters function below.
    public static int hackerlandRadioTransmitters(int[] x, int k) {
    	Arrays.sort(x);
    	int numOfTransmitters = 0;
    	int index = 0;
    	while (index < x.length) {
    	    numOfTransmitters++;
    	    int loc = x[index] + k;
    	    while (index < x.length && x[index] <= loc) index++;
    	    loc = x[--index] + k;
    	    while (index < x.length && x[index] <= loc) index++;
    	}
    	return numOfTransmitters;
    }
	
    // Complete the hackerrankInString function below.
    public static String hackerrankInString(String s) {
    	int index = 0;
    	for(char c: s.toCharArray()) {
    		if(c == "hackerrank".charAt(index))
    			index++;
    		if(index == 10)
    			return "YES";
    	}
    	return "NO"; 
    }
	
    // Complete the happyLadybugs function below.
    public static String happyLadybugs(String b) {
        int[] tmpArray = new int['Z' - 'A' + 1];
        boolean flag = false;

        for (char c : b.toCharArray()) {
            if(c!='_')
                tmpArray[c-'A']++;
            else
                flag = true;
        }
        
        if (!flag)
            for (int i = 1; i < b.length()-1; i++)
                if(b.charAt(i)!=b.charAt(i-1) && b.charAt(i)!=b.charAt(i+1))
                    return "NO";

        for (int i : tmpArray)
            if(i==1) 
            	return "NO";
        
        return "YES";
    }
	
    // Complete the highestValuePalindrome function below.
    public static String highestValuePalindrome(String s, int n, int k) {
        char[] tmpArray = s.toCharArray();

        int firstIndex = 0, secondIndex = 0, thirdIndex = n-1;

        while(thirdIndex>secondIndex){
            int num1 = (int)s.charAt(secondIndex) - (int)'0';
            int num2 = (int)s.charAt(thirdIndex) - (int)'0';

            if(num1 == num2){
                secondIndex++;
                thirdIndex--;
            }
            else if(num1 > num2){
                tmpArray[thirdIndex] = (char)(num1 + (int)'0');
                firstIndex++;
                secondIndex++;
                thirdIndex--;
            }
            else{
                tmpArray[secondIndex] = (char)(num2 + (int)'0');
                firstIndex++;
                secondIndex++;
                thirdIndex--;
            }
        }

        if(firstIndex > k)
            return "-1";
        
        else if(firstIndex == k)
            return new String(tmpArray);
        
        else{
            secondIndex = 0;
            thirdIndex = n-1;
            while(thirdIndex>secondIndex && firstIndex<k){
                if(s.charAt(secondIndex) == s.charAt(thirdIndex)){
                    if(firstIndex<k-1 && s.charAt(secondIndex) != '9'){
                        tmpArray[secondIndex] = (char)(9+(int)'0');
                        tmpArray[thirdIndex] = (char)(9+(int)'0');
                        firstIndex = firstIndex+2;
                        secondIndex++;
                        thirdIndex--;
                    }
                    else{
                        secondIndex++;
                        thirdIndex--;
                    }
                }
                else{
                    if(tmpArray[secondIndex] != '9'){
                    tmpArray[secondIndex] = (char)(9+(int)'0');
                    tmpArray[thirdIndex] = (char)(9+(int)'0');
                    firstIndex++;
                    secondIndex++;
                    thirdIndex--;
                    }else{
                        secondIndex++;
                        thirdIndex--;
                    }
                }
            }

            if(firstIndex < k && n%2 != 0)
                    tmpArray[n/2] = (char)(9+(int)'0');
            
            return new String(tmpArray);
        }
    }
	
    // Complete the howManyGames function below.
    public static int howManyGames(int p, int d, int m, int s) {
    	int games = 0;
    	while(s >= 0) {
    		s -= p;
    		p = Math.max(p - d, m);
    		games++;
    	}
    	return games - 1;
    }
	
    // Complete the hurdleRace function below.
    public static int hurdleRace(int k, int[] height) {
        int max = 0;
        for(int i: height)
            if(i>max)
                max = i;
        
        return max > k ? max - k : 0;
    }
	
    // Complete the icecreamParlor function below.
    public static int[] icecreamParlor(int m, int[] arr) {
        HashMap<Integer, Integer> tmpContainer = new HashMap<Integer, Integer>();
        
        for(int i=0;i<arr.length;i++) {
            int rem = m-arr[i];
            if(tmpContainer.containsKey(rem)) {
                if(tmpContainer.get(rem)> i) 
                    return new int[]{i+1,tmpContainer.get(rem)+1};
                else
                    return new int[]{tmpContainer.get(rem)+1,i+1};
            }
            else
                tmpContainer.put(arr[i],i);
        }
        
        return new int[]{-1,-1};
    }

    // Complete the insertionSort function below.
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i;
            while(j > 0 && A[j-1] > value){
                A[j] = A[j-1];
                j--;
            }
            A[j] = value;
        }

        printArray(A);//This method already exist in main code file
        /*
        for(int n: A){
            System.out.print(n+" ");
        }
        */
    }

    // Complete the insertionSort1 function below.
    public static void insertionSort1(int n, int[] arr) {
        boolean isInserted=false;
        int unsortedval=-1;
        int unsortedindex=-1;
        for(int i=arr.length-1;i>0;i--){
        
            if(arr[i]<arr[i-1]){ 
                unsortedval=arr[i];
                unsortedindex=i;
                break;
            }
        }
        
        for(int i=unsortedindex;i>=0;i--){
         
            if(i>0 && arr[i-1]>=unsortedval){ 
             arr[i]=arr[i-1];
            }
            else{
             arr[i]=unsortedval;
             isInserted=true;
            }
            
            for(int j=0;j<arr.length;j++)
                System.out.print(arr[j]+" ");
            
            System.out.print("\n");
            
            if(isInserted)
                break;
        }
    }
	
    // Complete the insertionSort2 function below.
    public static void insertionSort2(int n, int[] arr) {
	     for(int k=0;k<arr.length-1;k++){
	         for(int i=0;i<arr.length-1;i++){
	          int key = arr[k+1];
	             if(i==k+1)
	                 break;           
	             if(arr[i]>key){
	                 arr[k+1]=arr[i];
	                 arr[i]=key;
	             }
	         }
	         
	         for(int i=0;i<arr.length;i++)
	        	 System.out.print(arr[i]+" ");
	         System.out.println();
	     }
    }
	
    // Complete the introTutorial function below.
    public static int introTutorial(int V, int[] arr) {
    	int result = 0;
    	for(int i: arr) {
    		if(i == V)
    			return result;
    		else
    			result +=1;
    	}
    	return result;
    }
    
 // Complete the isKaprekar function below.
    public static boolean isKaprekar(int num) {
        long squared = (long) num * num;
        String str   = String.valueOf(squared);
        String left  = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        int numL = (left.isEmpty())  ? 0 : Integer.parseInt(left);
        int numR = (right.isEmpty()) ? 0 : Integer.parseInt(right);
        
        return (numL + numR) == num;
    }
	
    // Complete the isValid function below.
    public static String isValid(String s) {
    		HashMap<Character, Integer> container = new HashMap<>();
    		for(char c: s.toCharArray()) 
    			if(container.containsKey(c))
    				container.put(c, container.get(c)+1);
    			else
    				container.put(c, 1);
    		

    		int count = container.get(s.charAt(0));
    		int checkCount = 0;
    		for(int i : container.values())
    			if(i != count)
    				checkCount++;

    		return checkCount == 0 || checkCount == 1 ? "YES" : "NO";
    }
	
    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c) {
        int count=0,i=2;
        for(i=2;i<c.length;i=i+2){
            if(c[i]==0)
                count++;
            else{
                i--;
                count++;
            }
        }
        if(i==c.length)
            count++;
        return count;
    }
    
    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c, int k) {
    	 int len=c.length;
         int power=100;
         int index=0;
         while(true){
             if((index+k)<len){
            	 power = c[index+k]==0 ? power-1 : power-3 ;
                 index=index+k;
             }
             else{
               index =(index+k)%len;
                 if(c[index]==0)
                     return power-1;
                 else
                    return power-3;
             }
         }
    }
    
    //Kangrooo
	public static String kangaroo(int x1, int v1, int x2, int v2) {
		if(v1<=v2)
			return "NO";
		if(Math.abs(x1-x2) % Math.abs(v1-v2) != 0)
			return "NO";
        return "YES";
    }
	
    // Complete the kaprekarNumbers function below.
    public static void kaprekarNumbers(int p, int q) {
    	boolean flag = false;
    	for(int i=p; i<=q; i++) {
    		if(isKaprekar(i)) {
    			System.out.printf("%d ",i);
    			flag = true;
    		}
    	}
    	if(!flag)
    		System.out.printf("%s ","INVALID RANGE");
    	System.out.println();
    }

    // Complete the larrysArray function below.
    public static String larrysArray(int[] A) {
        int iCnt=0;
        for (int i=0; i<A.length-1; i++)
            for (int j=i+1;j<A.length; j++)  
                if (A[i]>A[j]) iCnt++;

        return (iCnt % 2 == 0) ? "YES" : "NO";
    }
	
    // Complete the solve function below.
    public static String leapYearProblem(int year) {
    	if(year == 1918)
    		return "26.09."+ year;
    	if(year > 1918 && year <= 2700)
    		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? "12.09."+ year : "13.09."+ year;
    	return year % 4 == 0 ? "12.09."+ year : "13.09."+ year;
    }
	
    // Complete the libraryFine function below.
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if(y1>y2)
		    return 10000;
		
		if(y1==y2 && m1>m2)
		    return (m1-m2)*500;
		
		if(y1==y2 && m1==m2 && d1>d2)
		    return (d1-d2)*15;
		
		return 0;  
    }
	
    // Complete the makingAnagrams function below.
    public static int makingAnagrams(String s1, String s2) {
    	int[] chars = new int[26];
    	int count = 0;
    	
        for (char c1 : s1.toCharArray())
        	chars[c1-97]++;
        
        for (char c2 : s2.toCharArray())
        	chars[c2-97]--;
        
        for(int i: chars) 
        	count += Math.abs(i);

        return count;
    }
	
    // Complete the marsExploration function below.
    public static int marsExploration(String s) {
    	String messageString = "SOS";
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != messageString.charAt(i % 3)) 
            	count++;
        
        return count;
    }
	
    // Complete the maximumSum function below.
    public static long maximumSum(long[] a, long m) {
    	long current = a[0] % m;
		long result = current;
		TreeSet<Long> sortedModValues = new TreeSet<>();
		sortedModValues.add(current);
		for (int i = 1; i < a.length; i++) {
			long next = (current + (a[i] % m)) % m;

			sortedModValues.add(next);
			SortedSet<Long> biggerPrevious = sortedModValues.tailSet(next + 1);
			if (!biggerPrevious.isEmpty()) {
				long largestPrevious = biggerPrevious.first();
				long pos = (next - largestPrevious + m) % m;
				result = Math.max(pos, result);
			}
			
			result = Math.max(next, result);
			current = next;
		}
		return result;
    }

    // Complete the migratoryBirds function below.
    public static int migratoryBirds(int[] ar) {
    	int result = 0;
    	int tmp[] =  new int[6];
    	
    	for(int i = 0; i< ar.length; i++)
    		tmp[ar[i]]++;
    	
    	int max = 0;
    	for(int i=1; i<6; i++)
    		if(tmp[i]>max)
    			max = tmp[i];
    	
    	for(int i=1; i<6; i++) {
    		if(tmp[i] == max) {
    			result = i;
    			break;
    		}
    	}
    	return result;
    }
	
    // Complete the minimumDistances function below.
    public static int minimumDistances(int[] a) {
		int minimum = Integer.MAX_VALUE;

		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + " " + i);
			else
				map.put(a[i], i + "");
		}

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if (entry.getValue().contains(" ")) {
				String[] arr = entry.getValue().split(" ");
				int temp1 = Integer.parseInt(arr[arr.length - 2]);
				int temp2 = Integer.parseInt(arr[arr.length - 1]);
				if (temp2 - temp1 < minimum)
					minimum = temp2 - temp1;
			}
		}
		if (minimum == Integer.MAX_VALUE)
			minimum = -1;

		return minimum;
    }
	
    // Complete the minimumNumber function below.
    public static int minimumNumber(int n, String password) {
		int result = 0;
		
		Pattern patternDigit = Pattern.compile("(\\d)");
		Pattern patternUpper = Pattern.compile("([A-Z])");
		Pattern patternLower = Pattern.compile("([a-z])");
		Pattern patternSpecial = Pattern.compile("(\\W)");
        
		Matcher matcherDigit = patternDigit.matcher(password);
		Matcher matcherUpper = patternUpper.matcher(password);
		Matcher matcherLower = patternLower.matcher(password);
		Matcher matcherSpecial = patternSpecial.matcher(password);
		
		if (!matcherDigit.find())
			result++;
			
		if (!matcherUpper.find())
			result++;
		
		if (!matcherLower.find())
			result++;
		
		if (!matcherSpecial.find())
			result++;
			
		if ((result+password.length())<6)
			result = result + 6-(result+password.length());
		
		return result;
    }
	
    // Complete the nonDivisibleSubset function below.
    public static int nonDivisibleSubset(int k, int[] S) {
        int[] remainders = new int[k];
        int count = 0;

        for (int  i = 0; i < S.length; i++)
            remainders[S[i] % k]++;
        
        for (int j = 1; j <= (k / 2); j++) {            
            if (j == k - j) {
                count++;
                continue;
            }
            count += Math.max(remainders[j], remainders[k - j]);    
        }

        if (remainders[0] > 0)
            count++;

        return count;
    }
	
    // Complete the organizingContainers function below.
    public static String organizingContainers(int[][] container) {
        int[] hsArr = new int[container.length];
        int[] vsArr = new int[container.length];
        for(int i=0; i<container.length; i++){
            for(int j=0; j<container[i].length; j++){
                hsArr[i] += container[i][j];
                vsArr[i] += container[j][i];
            }
        }
        Arrays.sort(hsArr);
        Arrays.sort(vsArr);
        return (Arrays.equals(hsArr, vsArr)) ?"Possible":"Impossible";
    }
	
    //Complete the pageCount function below.
    public static int pageCount(int n, int p) {
    	int left  = 0, right = 1;
    	int firstPath = 0, secondPath = 0;
    	
    	for(;;) {	
    		if(left == p || right == p)
    			break;
    		
    		left += 2;
    		right += 2;
    		firstPath++;
    	}
    	
    	if(n % 2 ==0) {
    		left = n;
    		right = n+1;
    	}
    	else {
    		right = n;
    		left = n -1;
    	}
    	
    	for(;;) {	
    		if(left == p || right == p)
    			break;
    		
    		left -= 2;
    		right -= 2;
    		secondPath++;
    	}
    	
    	return firstPath > secondPath ? secondPath : firstPath;
    }
	
    // Complete the pairs function below.
    public static int pairs(int k, int[] arr) {
        int matches = 0;
        Arrays.sort(arr);
        
        int firstIndex = 0;
        int secondIndex = 1;
        while (secondIndex < arr.length) {
            int diff = arr[secondIndex] - arr[firstIndex];
            if (diff == k) {
                matches++;
                secondIndex++;
            } 
            else if (diff > k) {
                firstIndex++;
                if (firstIndex == secondIndex)
                    secondIndex++;
                
            } 
            else if (diff < k) {
                secondIndex++;
            }
        }
        return matches;
    }
	
    // Complete the palindromeIndex function below.
    public static int palindromeIndex(String s) {
    	int stringLen =  s.length();
        int startIndex = 0, endIndex = stringLen-1;      
        while(startIndex<endIndex){
            if(s.charAt(startIndex)!=s.charAt(endIndex)){
                if((s.charAt(startIndex+1)==s.charAt(endIndex)) && (s.charAt(startIndex+2) == s.charAt(endIndex-1)))
                    return startIndex;
                else
                    return endIndex;
            }
            startIndex++;
            endIndex--;
        }
        return -1;
    }
	
	// Complete the pangrams function below.
    public static String pangrams(String s) {
    	s = s.toLowerCase();
    	for(int i=97; i<=122; i++)
    		if(s.indexOf((char)i) == -1)
        		return "not pangram";
        return "pangram";
    }
	
    private static int partition(int[] input, int position, int start, int end) { 
    	int l = start; 
        int h = end - 2; 
        int piv = input[position]; 
        swap(input, position, end - 1); 
        while (l < h) { 
        	if (input[l] < piv) 
        		l++; 
        	else if (input[h] >= piv)
        		h--; 
        	else 
        		swap(input, l, h);
        } 
        
        int idx = h; 
        if (input[h] < piv) 
        	idx++;
        
        swap(input, end - 1, idx); 
        return idx; 
    }
	
	// Complete the permutationEquation function below.
    public static int[] permutationEquation(int[] p) {
	    int[] result = new int[p.length];
	    Map<Integer, Integer> xaMap = new HashMap<>();
	
	    for(int i=0; i<p.length; i++)
	        xaMap.put(p[i], i+1);
	    
	    int x = 1;
	    for(int i=0; i<p.length; i++) 
	        result[i] = xaMap.get(xaMap.get(x++));
	    
	    return result;
    }
	
    // Complete the pickingNumbers function below.
	public static int pickingNumbers(int[] a) {
	    int actualCount = 0, temp = 0;
	    for(int i =0;i<a.length;i++){
	        int A = a[i]+1, B = a[i]-1, C = a[i];
	        int count1 =0, count2 =0, count3 = 0;
	        for(int j =0;j<a.length;j++){
		         if(a[j] == A)
		             count1++;
		         
		         if(a[j] == B)
		             count2++;
		         
		         if(a[j] == C)
		             count3++;
		         
		         if((count1+count3) > (count2 + count3))
		            actualCount = count1+count3;
		         else
		            actualCount = count2+count3;
	            
	        }
	        if(actualCount > temp)
	            temp = actualCount;
	    }
	    return temp;
	}
	
    public static void printArray(int[] ar) {
        for(int n: ar)
            System.out.print(n+" ");
    }
	
    // Complete the queensAttack(2) function below.
    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
         Map<String, Integer> obstacleMap = new HashMap<String, Integer>();
         
		 for(int[] o : obstacles){
		  String key = Integer.toString(o[0])+"-"+Integer.toString(o[1]);
		  obstacleMap.put(key, 1);
		 }
		
		 int[][] queenDirections = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
		
		 int attackedSquares = 0;
		
		 for (int[] direction : queenDirections){	
		  int rQueen = r_q;
		  int cQueen = c_q;
		  
			  while(true){
			   rQueen -= direction[0];
			   cQueen -= direction[1];
			
			   String newSquare = Integer.toString(rQueen) + "-" + Integer.toString(cQueen);
			
			   if(rQueen < 1 || rQueen > n || cQueen < 1 || cQueen > n || obstacleMap.containsKey(newSquare))
			    break;
			
			   attackedSquares++;
			  }
		 }
	
	 return attackedSquares;
    }

    // Complete the quickSort function below.
	// This Quicksort Algorithm is Iterative Quicksort
    public static int[] quickSort(int[] arr) {
    	Stack<Integer> stack = new Stack<>(); 
    	stack.push(0); 
    	stack.push(arr.length);
    	
    	while (!stack.isEmpty()) { 
    		int end = stack.pop(); 
    		int start = stack.pop(); 
    		if (end - start < 2)
    			continue;
    		
    		int p = start + ((end - start) / 2); 
    		p = partition(arr, p, start, end); 
    		
    		stack.push(p + 1); 
    		stack.push(end); 
    		stack.push(start); 
    		stack.push(p); }
    	return arr;
    }
	
    // Complete the repeatedString function below.
    public static long repeatedString(String s, long n) {
        String sh = s.replaceAll ("[^a]", "");
        long ost = n%s.length();
        long result = ((n - ost)/ s.length())*sh.length(); 
        for (int i = 0; i < ost; i++)
            if (s.charAt(i) == 'a')
                result++;
        return result;
    }
	
    // Complete the runningTime function below.
    public static int runningTime(int[] arr) {
    	int result = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i, value = arr[i];
            while (j >= 1 && arr[j-1] > value) {
                arr[j] = arr[j-1];
                j--;
                result++;
            }
            arr[j] = value;
        }
        return result;
    }
	
    // Complete the saveThePrisoner function below.
    public static int saveThePrisoner(int n, int m, int s) {
      int a = s+m-1;   
        if(a>n){
            if(a%n==0)
                return n;
            return a%n;
        }
        return a;
    }
	
    // Complete the separateNumbers function below.
	public static void separateNumbers(String s) { 
        long count=0; 
        if(s.length()==1)
                System.out.println("NO");
                
        for(int i=1;i<=(s.length()/2);i++){
           if(s.charAt(0)==0){
                 System.out.println("NO");
                 break;
           }           
           long countOfIndex = Long.parseLong(s.substring(0,i));
           String fullString ="";
           fullString+=countOfIndex;
           count = countOfIndex;
           long len = String.valueOf(count).length();
           for(int j=0;j<s.length();j++){
               countOfIndex++;
               fullString+=countOfIndex;      
           }
           String tmpString = fullString.substring(0,s.length());
           if(tmpString.equals(s.substring(0,s.length())) && (tmpString.length()%len==0 || tmpString.length()%len==1)){
	              System.out.println("YES" +" "+count);
	              break;
            }
           if(i==s.length()/2)
              System.out.println("NO");  
        }
    }
	
	/*
    // Complete the squares function below.
	public static int squares(int a, int b) {
    	int result = 0;
        for(int i=a; i<=b; i++) {
        	BigInteger sqrt = bigIntegerSqrt(new BigInteger(i+""));
        	if((sqrt.multiply(sqrt)).compareTo(new BigInteger(i+"")) == 0)
        		result++;
        }
        return result;
    }
    
    public static BigInteger bigIntegerSqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
    */
	
    // Complete the serviceLane function below.
    public static int[] serviceLane(int n, int[][] cases,int[] width) {
        int[] result = new int[cases.length];
        int min = 4;
        for(int i=0;i<cases.length;i++)
        {
                for(int j=cases[i][0];j<=cases[i][1];j++)
                {
                    if(width[j]<min)
                        min = width[j];
                }
                result[i] = min;
                min = 4;
        }
        return(result);
    }

    // Complete the Sherlock Array function below.
    public static String sherlockArray(int[] a){
        int index = 0, j = a.length - 1, result = 0;
        while (index != j) {
            if(result >= 0) {
                result -= a[j];
                j--;
            } else {
                result +=a[index];
                index++;
            }
        }
        return result == 0 ? "YES" : "NO";
    }
    
    // Complete the sockMerchant function below.
    public static int sockMerchant(int n, int[] ar) {
    	int coupleCount = 0;
    	ArrayList<Integer> values = new ArrayList<>();
    	for(int i: ar)
    		if(!values.contains(i))
    			values.add(i);
    	
    	for(Integer i: values) {
    		int tmp = 0;
    		for(int k: ar)
    			if(i.intValue() == k)
    				tmp++;
    		coupleCount += (tmp/2);
    	}
    	return coupleCount;
    }
	
    // Complete the squares function below.
	public static int squares(int a, int b) {
        return (int)Math.floor(Math.sqrt(b)) - (int)Math.ceil(Math.sqrt(a)) + 1;
    }
	
    // Starwairs
	public static void starwairs(int n) {
		for(int i = 1; i<=n; i++) {
			String tmp = "";
			String dies = "";
			for(int j=0; j<n-i; j++)
				tmp += " ";
			for(int j=0; j<i; j++)
				dies += "#";
			System.out.printf("%s%s%n",tmp,dies);
		}
	}
	
    // Complete the stones function below.
    public static int[] stones(int n, int a, int b) {
        int j=0, i=n-1;
        
        if(a==b){
            int [] a1=new int[1];
            a1[0]=a*(n-1); //
            return a1;
        }
        
        int ans[]=new int[n];
        
        for(int k=0;k<n;k++){
        	ans[k]=i*a+j*b;
            i--;
            j++;
        }
        Arrays.sort(ans);
        return ans;
    }
	
    // Complete the strangeCounter function below.
    public static long strangeCounter(long t) {
    	long n = 2;
    	while (3 * (n - 1) < t) 
    		n = 2 * n;
        return 3 * (n - 1) - t + 1;
    }
	
    // Complete the stringConstruction function below.
    public static int stringConstruction(String s) {
    	HashSet<Character> result = new HashSet<Character>();
        for (char c : s.toCharArray())
            result.add(new Character(c));
        return result.size();
    }
	
    // Complete the super_reduced_string function below.
    public static String super_reduced_string(String s) {
    	Stack<Character> stack = new Stack<>();
        int h = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();    //throw away
                h--;
            } else {
                stack.push(s.charAt(i));
                h++;
            }
        }
        
        if (h == 0)
            return "Empty String";

        char[] reduced = new char[h];
        
        for (int i=h-1; i>=0; i--)
            reduced[i] = stack.pop();

        return new String(reduced);
    }
    
    // Complete the surfaceArea function below.
    public static int surfaceArea(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        int upDown = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(A[i][j] != 0)
                    upDown++;
            }
        }  
        
        upDown *= 2;
        int frontBack = 0; 
        for(int i = 0; i < row; i++){
            frontBack += A[i][0];
            for(int j = 1; j < col; j++)
                frontBack += Math.min(A[i][j], A[i][j]-A[i][j-1] >= 0 ? A[i][j]-A[i][j-1] : 0);           
        }
        
        frontBack *= 2;
        int rightLeft = 0;
        for(int i = 0; i < col; i++){
            rightLeft += A[0][i];
            for(int j = 1; j < row; j++)
                rightLeft += Math.min(A[j][i], A[j][i] - A[j-1][i] >= 0 ? A[j][i]-A[j-1][i] : 0);
        }
        
        rightLeft *= 2;
        return upDown+frontBack+rightLeft;
    }
    
    private static void swap(int[] arr, int i, int j) { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    }
	
	/*
	// Complete the bigSorting function below.
	public static String[] bigSorting(String[] arr) {
        return Arrays.stream(arr).sorted(
        	(s1, s2) -> { return (s1.length() != s2.length()) ? s1.length() - s2.length() : s1.compareTo(s2);}
        ).toArray(String[]::new);
    } 
	 
	 
	// Complete the bigSorting function below.
    public static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        }});
        return unsorted;
    }
    
    // Complete the bigSorting function below.
    public static String[] bigSorting(String[] unsorted) {
        iterativeQsort(unsorted);
        return unsorted;
    }
    
    private static void iterativeQsort(String[] numbers) { 
    	Stack<Integer> stack = new Stack<>(); 
    	stack.push(0); 
    	stack.push(numbers.length);
    	
    	while (!stack.isEmpty()) { 
    		int end = stack.pop(); 
    		int start = stack.pop(); 
    		if (end - start < 2)
    			continue;
    		
    		int p = start + ((end - start) / 2); 
    		p = partition(numbers, p, start, end); 
    		
    		stack.push(p + 1); 
    		stack.push(end); 
    		stack.push(start); 
    		stack.push(p); 
    	}
    }
    
    private static int partition(String[] input, int position, int start, int end) { 
    	int l = start; 
    	int h = end - 2; 
    	String piv = input[position]; 
    	swap(input, position, end - 1); 
    	while (l < h) { 
    		//input[l] < piv
    		if ((new BigInteger(piv)).compareTo(new BigInteger(input[l]))>0) 
    			l++; 
    		//input[h] >= piv
    		else if ((new BigInteger(piv)).compareTo(new BigInteger(input[h])) <= 0)
    			h--; 
    		else 
    			swap(input, l, h);
    	} 
    	
    	int idx = h; 
    	if ((new BigInteger(input[h])).compareTo(new BigInteger(piv)) < 0) 
    		idx++;
    	
    	swap(input, end - 1, idx); 
    	
    	return idx; 
    } 
    
    private static void swap(String[] arr, int i, int j) { 
    	String temp = arr[i]; 
    	arr[i] = arr[j]; 
    	arr[j] = temp; 
    }
    */
	
    // Complete the taumBday function below. NOT SOLVED
    public static String taumBday(int b, int w, int bc, int wc, int z) {
    	BigInteger b_i = new BigInteger(b+"");
    	BigInteger w_i = new BigInteger(w+"");
    	BigInteger bc_i = new BigInteger(bc+"");
    	BigInteger wc_i = new BigInteger(wc+"");
    	BigInteger z_i = new BigInteger(z+"");
    	
    	if(bc_i.compareTo(wc_i) > 0 && (bc_i.compareTo(wc_i.add(z_i)))>0)
    		return (b_i.multiply(wc_i)).add(w_i.multiply(wc_i)).add(b_i.multiply(z_i)).toString();
    	
    	else if(wc_i.compareTo(wc_i) > 0 && (wc_i.compareTo(bc_i.add(z_i)))>0)
    		return (b_i.multiply(bc_i)).add(w_i.multiply(bc_i)).add(w_i.multiply(z_i)).toString();
    	
    	return b_i.multiply(bc_i).add(w_i.multiply(wc_i)).toString();
    }	
	
	/*
    // Complete the maxMin function below.
    public static int maxMin(int k, int[] arr) {
    	iterativeQsort(arr);
    	int partition[] = new int[k];
    	for(int i = 0; i<k; i++)
    		partition[i] = arr[i];
    	
    	int max = 0;
    	for(int i : partition)
    		if(i > max)
    			max = i;
    	
    	int min = arr[0];
    	for(int i : partition)
    		if(i < min)
    			min = i;
    	
    	return max - min;
    }
    
    public static void iterativeQsort(int[] numbers) { 
    	Stack<Integer> stack = new Stack<>(); 
    	stack.push(0); 
    	stack.push(numbers.length);
    	
    	while (!stack.isEmpty()) { 
    		int end = stack.pop(); 
    		int start = stack.pop(); 
    		if (end - start < 2)
    			continue;
    		
    		int p = start + ((end - start) / 2); 
    		p = partition(numbers, p, start, end); 
    		
    		stack.push(p + 1); 
    		stack.push(end); 
    		stack.push(start); 
    		stack.push(p); }
    }
    
    private static int partition(int[] input, int position, int start, int end) { 
    	int l = start; 
    	int h = end - 2; 
    	int piv = input[position]; 
    	swap(input, position, end - 1); 
    	while (l < h) { 
    		if (input[l] < piv) 
    			l++; 
    		else if (input[h] >= piv)
    			h--; 
    		else 
    			swap(input, l, h);
    	} 
    	
    	int idx = h; 
    	if (input[h] < piv) 
    		idx++;
    	
    	swap(input, end - 1, idx); 
    	return idx; 
    } 
    
    private static void swap(int[] arr, int i, int j) { 
    	int temp = arr[i]; 
    	arr[i] = arr[j]; 
    	arr[j] = temp; 
    }
    */

    // Complete the theLoveLetterMystery function below.
    public static int theLoveLetterMystery(String s) {
    	int result = 0;
    	for(int i=0; i<s.length()/2; i++)
    		result += Math.abs(s.charAt(i)-s.charAt(s.length() - i - 1));
    	return result;
    }
	
	//TimeConversion
	public static String timeConversion(String s) {
        if(s.contains("AM")){
            s = s.replace("AM","");
            String hourString = s.split("[:]+")[0];
            if(!hourString.equalsIgnoreCase("12"))
            	return s;
            s = s.replace(hourString, "0"+(Integer.parseInt(hourString) - 12));
            return s;
        }
        else{
            s = s.replace("PM","");
            String hourString = s.split("[:]+")[0];
            int hour = Integer.parseInt(hourString);
            s = s.replace(hourString, ( hour == 12 ? hour : hour + 12) + "");
            return s;
        }
    }
	
	// Complete the timeInWords function below.
    public static String timeInWords(int h, int m) {
    	String[] hours = {"zero", "one", "two", "three", "four", "five", "six", "seven",
    					  "eight", "nine", "ten", "eleven", "twelve", "thirteen",
    					  "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
    					  "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
    					  "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};
    	if(m==0)
    		return hours[h] + " " + "o' clock";
    	
    	if(m==15)
    		return "quarter past " + hours[h];
    	
    	if(m==30)
    		return "half past " + hours[h];
    	
    	if(m==45)
    		return "quarter to " + hours[h+1];
    	
    	String preString 		= m > 30 ? hours[60-m] + " " : hours[m] + " ";
    	String singularOrPlural = m == 1 || m == 59 ? "minute " : "minutes ";
    	String between 			= m > 30 ? "to " + hours[h+1] : "past " + hours[h];
    	
    	return preString + singularOrPlural + between;
    }	
	
    // Complete the solve function below.(NOTE: it was changed with twoCharaters")
    public static int twoCharaters(String s) {
    	char[] sa = s.toCharArray();
        int[] unique = s.chars().distinct().toArray();
        int maxLength = 0;
        for (int i = 0; i < unique.length - 1; i++) {
        	char c1 = (char) unique[i];
    	    for (int j = i + 1; j < unique.length; j++) {
            	char c2 = (char) unique[j];
    	        int count = 0;
        	    boolean valid = true;
            	int toogle = 0;
    	        for (int k = 0; k < sa.length; k++) {
        		    if (sa[k] == c1) {
    			        toogle++;
            			count++;
        		    } else if (sa[k] == c2) {
    			        toogle--;
    			        count++;
            		}
    		        if (toogle > 1 || toogle < 0) {
            			valid = false;
    			        break;
            		}
            	}
    	        if (valid && count > maxLength)
    			        maxLength = count;
            }
        }
        return maxLength;
    }
	
	// Complete the twoPluses function below.
    public static int twoPluses(String[] grid) {
        int g=grid.length, l=grid[0].length(), min=0, count=-1, max=0, k=0, r1=0, r2=0, c1=0, c2=0, s1=0, s2=0;
        int[][] size=new int[g][l];
        
        for(int i=0;i<g;i++){
            for(int j=0;j<l;j++){
                min=Math.min(Math.min(i,g-1-i),Math.min(j,l-1-j));
                for(int t=0;t<=min;t++){
                    if(grid[i+t].charAt(j)!='B'&&grid[i-t].charAt(j)!='B'&&grid[i].charAt(j+t)!='B'&&grid[i].charAt(j-t)!='B')
                        count=t;
                    else
                        break;
                }
                size[i][j]=count;
                count=-1;
            }
        }
        
        count=0;
        for(int i=0;i<g;i++)
            for(int j=0;j<l;j++)
                if(size[i][j]>=0)
                    count+=1;

        int[][] plus=new int[count][3];
        int[] area=new int[count*(count-1)];
        for(int i=0;i<g;i++){
            for(int j=0;j<l;j++){
                if(size[i][j]>=0){
                    plus[k][0]=i;
                    plus[k][1]=j;
                    plus[k][2]=size[i][j];
                    k++;
                }
            }
        }
        
        k=0;
        for(int i=0;i<plus.length;i++){
            for(int j=0;j<plus.length;j++){
                if(i!=j){
                    r1=plus[i][0];
                    r2=plus[j][0];
                    c1=plus[i][1];
                    c2=plus[j][1];
                    for(s1=0;s1<=plus[i][2];s1++){
                        for(s2=0;s2<=plus[j][2];s2++){
                            if(Math.abs(r1-r2)>s1+s2||Math.abs(c1-c2)>s1+s2
                              ||Math.abs(r1-r2)>Math.max(s1,s2)&&c1!=c2
                              ||Math.abs(c1-c2)>Math.max(s1,s2)&&r1!=r2
                              ||Math.abs(r1-r2)>Math.min(s1,s2)&&Math.abs(c1-c2)>Math.min(s1,s2)){
                                if(area[k]<(4*s1+1)*(4*s2+1))
                                    area[k]=(4*s1+1)*(4*s2+1);
                            }
                        }
                    }
                    k++;
                }
            }
        }
        
        max=area[0];
        for(int i=0;i<area.length;i++)
            if(area[i]>max)
                max=area[i];
        
        return max;
    }
	
	// Complete the twoStrings function below.
    public static String twoStrings(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.split("")));
        Set<String> set3 = new HashSet<>(set1);
        set3.addAll(set2);
        return set3.size() == set1.size() + set2.size() ? "NO" : "YES";
    }
	
	// Complete the utopianTree function below.
    public static int utopianTree(int n) {
        return ~(~1<<(n>>1)) << n % 2;
    }
	
	// Complete the viralAdvertising function below.
    public static int viralAdvertising(int n) {
    	int sum = 0, p = 5;
        while(n-- != 0){
            sum += (p/2);
            p = (p/2)*3;
        }
        
    	return sum;
    }
	
    // Complete the weightedUniformStrings function below.
	public static String[] weightedUniformStrings(String s, int[] queries) {
        s = s+"\0";
        int[] charNumbers = new int[27];
        int index = 1;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                charNumbers[s.charAt(i-1)-'a'+1] = Math.max(charNumbers[s.charAt(i-1)-'a'+1], index);
                index = 1;
            }
            else 
            	index++;
        }
        
        String[] resultArray = new String[queries.length];
        
        for(int i = 0; i<queries.length; i++){
            boolean flag = false;
            int j = 1;
            while(j<charNumbers.length){
                if(charNumbers[j] > 0 && queries[i]%j == 0 && queries[i]/j <= charNumbers[j]){
                    resultArray[i] = "Yes";
                    flag = true;
                    break;
                }
                j++;            
            }
            if(!flag) 
            	resultArray[i] = "No";
        }
        return resultArray;
    }
	
	// Complete the workbook function below.
    public static int workbook(int n, int k, int[] arr) {
        int page = 1;
        int count = 0;
        for(int a : arr){
            for(int i=1; i<=a; i++){
                if(i == page)
                	count++;
                if(i % k == 0)
                	page++;
            }
            if(a % k != 0)  page++;
        }
        return count;
    }
}
