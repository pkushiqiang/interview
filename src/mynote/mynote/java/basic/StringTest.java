package mynote.java.basic;

public class StringTest {
	public static void main(String[] args) {
		
		String a = "ab";// ������һ�����󣬲������ַ�������
		System.out.println("String a = \"ab\";");
		String b = "cd";// ������һ�����󣬲������ַ�������
		System.out.println("String b = \"cd\";");
		String c = "abcd";// ������һ�����󣬲������ַ�������
		String d = "ab" + "cd";
		// ���d��cָ����ͬһ��������˵��dҲ���������ַ�����
		if (d == c) {
			System.out.println("\"ab\"+\"cd\" �����Ķ��� \"������\" �ַ�������");
		}
		// ���d��cû��ָ����ͬһ��������˵��dû�б������ַ�����
		else {
			System.out.println("\"ab\"+\"cd\" �����Ķ��� \"û����\" �ַ�������");
		}
		String e = a + "cd";
		// ���e��cָ����ͬһ��������˵��eҲ���������ַ�����
		if (e == c) {
			System.out.println(" a +\"cd\" �����Ķ��� \"������\" �ַ�������");
		}
		// ���e��cû��ָ����ͬһ��������˵��eû�б������ַ�����
		else {
			System.out.println(" a +\"cd\" �����Ķ��� \"û����\" �ַ�������");
		}
		String f = "ab" + b;
		// ���f��cָ����ͬһ��������˵��fҲ���������ַ�����
		if (f == c) {
			System.out.println("\"ab\"+ b �����Ķ��� \"������\" �ַ�������");
		}
		// ���f��cû��ָ����ͬһ��������˵��fû�б������ַ�����
		else {
			System.out.println("\"ab\"+ b �����Ķ��� \"û����\" �ַ�������");
		}
		String g = a + b;
		// ���g��cָ����ͬһ��������˵��gҲ���������ַ�����
		if (g == c) {
			System.out.println(" a + b �����Ķ��� \"������\" �ַ�������");
		}
		// ���g��cû��ָ����ͬһ��������˵��gû�б������ַ�����
		else {
			System.out.println(" a + b �����Ķ��� \"û����\" �ַ�������");
		}
	}

}
