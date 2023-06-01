
public class array {
	public static void main(String[] args) {
		int ary[] = new int[2];
		System.out.println(ary[0]);
		System.out.println(ary[1]);

		ary[0] = 10;
		ary[1] = 20;
		System.out.println(ary[0]);
		System.out.println(ary[1]);

		String str1[] = new String[2];
		System.out.println(str1[0]);
		System.out.println(str1[1]);
		
		str1[0] = "array 0";
		str1[1] = "array 1";
		System.out.println(str1[0]);
		System.out.println(str1[1]);
		
		int num[] = new int[] {1, 2};
		System.out.println(num[0]);
		System.out.println(num[1]);
		
		String str2[] = new String[] {"str2 - 1", "str2 - 2"};
		System.out.println(str2[0]);
		System.out.println(str2[1]);
	}
}
