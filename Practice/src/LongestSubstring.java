import java.util.ArrayList;

/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: " pwwkewy"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution4 {
	public static int lengthOfLongestSubstring(String s) {
		ArrayList<Character> chars = new ArrayList<Character>();
		if (s.isEmpty() || s.length() == 0)
			return 0;
		else {
			int length = 1;
			for (int j = 0; j < s.length() - 1; j++) {

				chars.add(s.charAt(j));

				for (int i = j + 1; i < s.length(); i++) {
					if(length >= s.length()-j)
						break;
					if (!chars.contains(s.charAt(i))) {

						chars.add(s.charAt(i));
						

						if (i == s.length()-1 && chars.size() > length) {
							length = chars.size();
						}

					} else if (chars.contains(s.charAt(i))) { 
						if (chars.size() > length) {
							length = chars.size();
						}
						chars.clear();
						break;
					}
				}
			}
			return length;
		}
	}
}

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println("resutl:" + Solution4.lengthOfLongestSubstring(""));

	}

}
