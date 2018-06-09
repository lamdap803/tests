package grop.artficat;

import java.math.BigInteger;

public class testString {

	
	public static void main(String[] args) {
	
	String n = "54770818280596248290568769658843343326164235069808867955830816240794310956454354452369872055679769392";
	//String n = "16";
//	System.out.println (test.substring(0, 2));
//	long sum = 0;
//		for (int lenx = 1 ; lenx < test.length() ; lenx ++) {
//			for (int i = 0 ; i < test.length() ; i ++) {
//				
//				int end  = i+lenx;
//				if (end > test.length()) {
//					continue;
//				}
//			    System.out.println("-->" +test.substring (i,end));
//			    System.out.println(Long.valueOf(test.substring (i,end)));
//			    Long det = Long.valueOf(test.substring (i,end));
//			     sum = sum + det;
//			    
//		    }
//		}
//		System.out.println(sum + Long.valueOf(test));

	
	//System.out.println (Long.valueOf("9624829056876965884"));
	System.out.println (new BigInteger("9624829056876965884"));
	
	
	BigInteger sum = BigInteger.ZERO;
    boolean adding = true;
    long ns = n.length();
    int mystart = 0;
    int myend = 0;
    int lenx = 0;
    while (adding) {
    
     if (myend > ns) {
    	 mystart = 0;
    	 lenx ++;
    	 
    	 if (lenx > ns) {
    		 adding = false;
    		 continue;
    	 }
    	 myend = lenx;
     }
     
      System.out.println (mystart +" -- " + myend);
      System.out.println (n.substring(mystart, myend));
      String addpart = n.substring(mystart, myend);
      if (addpart.length() > 0 ) {
    	  sum = sum.add((new BigInteger(addpart)));
      }
      
      mystart ++;
      myend ++;
    }
	
    BigInteger result = sum.mod(new BigInteger ("1000000007"));
	
    System.out.println (" result -- " + result);
	}
	
	
	
}
