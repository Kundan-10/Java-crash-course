import java.util.*;

class Main{
    public static void usingStringBuffer(String str){
        
         long startTime = System.currentTimeMillis();
        StringBuffer sb=new StringBuffer();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        System.out.println("using stringbuffer  --> "+ sb.toString() );
         long endTime = System.currentTimeMillis();
         long elapsedTime = endTime - startTime;
         System.out.println("time taken by stringBuffer --> "+ elapsedTime);
        
        
        // using while loop we can use this method for all 
      long s = System.currentTimeMillis();  
        int start=0;
        int end=str.length()-1;
        char [] ch=str.toCharArray();
        while(start < end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            
            start++;
            end--;
        }
        String str2=new String(ch);
        System.out.println("using while loop --> "+str2);
        long e = System.currentTimeMillis();
        long elapsed = e - s;
        System.out.println("time taken by stringBuffer while loop --> "+ elapsed);


        
    }
    public static void usingStringBuilder(String str){
        
         long startTime = System.currentTimeMillis();
         StringBuilder sb=new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        System.out.print("using StringBuilder  --> "+ sb.toString() );
        System.out.println();
       long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
         System.out.println("time taken by stringBuilder --> "+ elapsedTime);

        
    }
    public static void usingString(String str){
        String sb="";
        for(int i=str.length()-1; i>=0; i--){
            sb +=str.charAt(i);
        }
        System.out.println("using String  --> "+ sb.toString() );
        System.out.println();
    }
    public static void main(String [] args){
        String str="kundan";
        usingStringBuffer( str);
        usingStringBuilder( str);
        usingString( str);
    }
}