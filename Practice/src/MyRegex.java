import java.util.regex.Pattern;

public class MyRegex {

	public static void main(String[] args) {
//		String regex = "\\b\\d{1,3}\\.\\d\\.\\d\\.\\d\\b";
		String regex = "((([0-9]{1,2})|([0-2]{1}[0-5]{1,2}))\\.){3}(([0-9]{1,2})|([0-2]{1}[0-5]{1,2}))";
		System.out.println(Pattern.matches(regex, "00.12.123.123123.123"));

	}

}
