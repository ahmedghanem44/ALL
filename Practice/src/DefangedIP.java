//Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//A defanged IP address replaces every period "." with "[.]".

class Solution5 {
    public static String defangIPaddr(String address) {
    	String[] arr = address.split("[.]");
    	System.out.println(arr.length);
    	if (arr.length != 4)
    		return "Invalid IP number";
    	else {
	    	for (int i = 0 ; i < arr.length ; i++) {
	    		int a = Integer.parseInt(arr[i]);
	    		if(a < 0 || a > 255)
	    			return "Invalid IP number";
	    	}
    	}
    	
        return address.replace(".", "[.]");
    }
}


public class DefangedIP {

	public static void main(String[] args) {
		
		String ip = "254.100.50.0";
		System.out.println(Solution5.defangIPaddr(ip));
//		String[] arr = ip.split("[.]",0);
//		System.out.println(arr.length);
//		for (int i = 0 ; i < arr.length ; i++) {
//			System.out.println(arr[i]);
//		}

	}

}
