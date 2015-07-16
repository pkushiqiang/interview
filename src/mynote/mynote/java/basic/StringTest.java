package mynote.java.basic;

public class StringTest {
	public static void main(String[] args) {
		
		String a = "ab";// 创建了一个对象，并加入字符串池中
		System.out.println("String a = \"ab\";");
		String b = "cd";// 创建了一个对象，并加入字符串池中
		System.out.println("String b = \"cd\";");
		String c = "abcd";// 创建了一个对象，并加入字符串池中
		String d = "ab" + "cd";
		// 如果d和c指向了同一个对象，则说明d也被加入了字符串池
		if (d == c) {
			System.out.println("\"ab\"+\"cd\" 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果d和c没有指向了同一个对象，则说明d没有被加入字符串池
		else {
			System.out.println("\"ab\"+\"cd\" 创建的对象 \"没加入\" 字符串池中");
		}
		String e = a + "cd";
		// 如果e和c指向了同一个对象，则说明e也被加入了字符串池
		if (e == c) {
			System.out.println(" a +\"cd\" 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果e和c没有指向了同一个对象，则说明e没有被加入字符串池
		else {
			System.out.println(" a +\"cd\" 创建的对象 \"没加入\" 字符串池中");
		}
		String f = "ab" + b;
		// 如果f和c指向了同一个对象，则说明f也被加入了字符串池
		if (f == c) {
			System.out.println("\"ab\"+ b 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果f和c没有指向了同一个对象，则说明f没有被加入字符串池
		else {
			System.out.println("\"ab\"+ b 创建的对象 \"没加入\" 字符串池中");
		}
		String g = a + b;
		// 如果g和c指向了同一个对象，则说明g也被加入了字符串池
		if (g == c) {
			System.out.println(" a + b 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果g和c没有指向了同一个对象，则说明g没有被加入字符串池
		else {
			System.out.println(" a + b 创建的对象 \"没加入\" 字符串池中");
		}
	}

}
