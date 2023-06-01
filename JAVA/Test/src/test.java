
public class test {
	public static void main(String[] args) {
		p193();
		p199();
	}

	public static void p193() {
		// 책.193 참고
		String cat = "고양이";
		String cat2 = "고양이";
		String cat3 = new String("고양이");
		String cat4 = new String("고양이");
		// System.identityHashCode(cat) << 주소 값 출력함.
		System.out.println(System.identityHashCode(cat));
		System.out.println(System.identityHashCode(cat2));
		System.out.println(System.identityHashCode(cat3));
		System.out.println(System.identityHashCode(cat4));
	}

	public static void p199() {

		char c = 'c';

		System.out.println((int) c);

		String cat = "고양이";
		System.out.println(String.format("%10s", cat));
	}
}
