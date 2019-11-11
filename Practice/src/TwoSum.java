/*Given an array of integers, return indices of the two numbers such that they add up to a 
 * specific target.

You may assume that each input would have exactly one solution, and you may not use the same 
element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

class Sum {
	public static int[] twoSum(int[] nums, int target) {
		int indexZero = -1;
		int indexOne = -1;
        for(int i = 0 ; i < nums.length ; i++) {
        	for (int j = i+1 ; j < nums.length ; j++ ) {
        		if (nums [i] + nums [j] == target) {
        			indexZero = i;
        			indexOne = j;
        		}
        	}
        }

        return new int[] {indexZero,indexOne};

    }
}
public class TwoSum {

	public static void main(String[] args) {
		int[] a = new int[] {2, 7, 11, 15};
		int[] b = Sum.twoSum(a,29);
		for (int i = 0 ; i < b.length ; i ++) {
			System.out.print(b[i] + ",");
		}
	}
}
