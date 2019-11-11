import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Streams {

	public static void main(String[] args) {

		List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		// To convert an array of Interger into array of int
		int[] arrOfint = list.stream()
							 .mapToInt(i->(int) i)
							 .toArray();
		
//		IntStream.of(arrOfint).forEach(x->System.out.println(x));
		System.out.println(IntStream.of(arrOfint).sum());
							 

//		list.stream().forEach(i -> System.out.print(i));
//		System.out.println();
//		list.stream().forEach(System.out::print);
//		System.out.println();
//		long count = list.stream().count();
//		System.out.println(count);
//		list.stream()
//			.filter(x->x%2==0)
//			.map(i->i*i)
//			.forEach(System.out::println);
		
		
//
//
//		IntStream.range(3, 8).skip(2).forEach(System.out::print);
//		int sum =IntStream.range(1,4).sum();
//		System.out.println("sum is: "+ sum);

	}

}
