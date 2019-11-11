import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/*You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
321+321 = 642
*/

class Solution2{
public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int r1 =0;
        int r2 = 0;
        int d = 1;
//        Iterator<Integer> itr1 = l1.iterator();
//        Iterator<Integer> itr2 = l2.iterator();
//        while (itr1.hasNext()) {
//        	r1 += itr1.next() * d;
//        	d *= 10 ;
//        }
//        d=1;
//        while (itr2.hasNext()) {
//        	r2 += itr2.next() * d;
//        	d *= 10 ;
//        }
        
        for(int i = 0 ; i < l1.size() ; i ++) {
        	r1 += l1.get(i) * d ;
        	r2 += l2.get(i) * d ;
        	d *= 10 ;
        }
        
        int result = r1+r2;
        int digit = 0 ;
        LinkedList<Integer> sol = new LinkedList<Integer>();
        while ( result > 10) {
        	digit = result % 10 ;
        	sol.add(digit);
        	result = result / 10 ;
        }
        sol.add(result);
        return sol;
    }
}


public class AddTwoNumbers {
	public static void main (String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(2);
		l1.add(4);
		l1.add(3);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(5);
		l2.add(6);
		l2.add(4);
		LinkedList<Integer> sol = Solution2.addTwoNumbers(l1, l2);
		Iterator<Integer> itr = sol.iterator();
        while (itr.hasNext()) {
        	System.out.println(itr.next() + "");
        }
        
//        Integer[] arr = {1,3,2};
//        Set<Integer> s = new TreeSet<Integer>(Arrays.asList(arr));
//        Iterator<Integer> itr2 = s.iterator();
//        while (itr2.hasNext()) {
//        	System.out.println(itr2.next());
//        }
        
	}
}
