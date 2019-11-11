

class Imp {
	public static String toLower(String s) {
		String str = "" ;
//		System.out.println(s);
		for(int i = 0 ; i < s.length() ; i++) {
			if ((int)s.charAt(i) > 64 && (int)s.charAt(i) < 90 ) {
				int code = (int) s.charAt(i);
//				System.out.println(code);
				char lowChar = (char) (code + 32);
//				System.out.println(lowChar);
				str = str + lowChar;
//				System.out.println(str);
			}
			else {
				str = str + s.charAt(i);
			}
		}
		return str;
	}
}


public class ToLowerCase {

	public static void main(String[] args) {
		System.out.println(Imp.toLower("ahMed GHANEM"));

	}

}
