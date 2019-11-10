import java.util.Arrays;

class Fun{
	public static int[] findOddOcurrence(int[] a) {
		Arrays.sort(a);
		return a;
	}
}
public class OddOccurrencesInArray {

	public static void main(String[] args) {
		
		int count = 1;
		int[] ar = new int[] {2,7,2,7,3,8,1,8,1,6,4,6,4};
//		int[] b = ar.clone();
		Fun.findOddOcurrence(ar);
//		for (int i = 0 ; i < b.length ; i ++) {
//			System.out.print(b[i] + ",");
//		}
		System.out.println();
		for (int i = 0 ; i < ar.length-1 ; i++) {
//			System.out.println(ar[i]+" and "+ ar[i+1]);
			if (ar[i] == ar[i+1]) {
				count++;
			}else {
				if(count%2 == 0) {
					count =1 ;
				}else {
					System.out.println(ar[i]);
					break;
				}
			}
				
		}
//		System.out.println(Integer.toBinaryString(9));
	}

}


