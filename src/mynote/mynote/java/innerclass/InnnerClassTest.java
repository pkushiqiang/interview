package mynote.java.innerclass;

public class InnnerClassTest {
	static int a;  	  
    int b;  
    
    private class InnerClass {  
        // ֻ���ھ�̬�ڲ����в��ܹ��������徲̬��Ա  
        // private static String tt = "0";  
        private int flag = 0;  
  
        public InnerClass() {  
            // ��.�Ǿ�̬�ڲ���ķǾ�̬��Ա���Է����ⲿ��ķǾ�̬�����;�̬����  
            System.out.println("InnerClass create a:" + a);  
            System.out.println("InnerClass create b:" + b);  
            System.out.println("InnerClass create flag:" + flag);  
            //  
            System.out.println("InnerClass call outer static function");  
            // �����ⲿ��ľ�̬����  
            test();  
        }  
  
        public  String getKey() {  
            return "no-static-inner";  
        }  
    }  
  
    private static class InnerStaticClass {  
        // ��̬�ڲ�������о�̬��Ա�����Ǿ�̬�ڲ��������о�̬��Ա��  
        private static String static_value = "0";  
  
        private int flag = 0;  
  
        public InnerStaticClass() {  
            System.out.println("InnerClass create a:" + a);  
            // ��̬�ڲ��಻�ܹ������ⲿ��ķǾ�̬��Ա  
            // System.out.println("InnerClass create b:" + b);  
            System.out.println("InnerStaticClass flag is " + flag);  
            System.out.println("InnerStaticClass tt is " + static_value);  
        }  
  
        public int getValue() {  
            // ��̬�ڲ�������ⲿ��ľ�̬����  
            test();  
            return 1;  
        }  
  
        public static String getMessage() {  
            return "static-inner";  
        }  
    }  
    public InnnerClassTest() {  
        // newһ���Ǿ�̬���ڲ���  
        InnerClass ic = new InnerClass();  
        System.out.println("OuterClass create");  
    }  
  
    public static void test() {  
        System.out.println("outer class static function");  
    }  
  
    public static void main(String[] args) {  
    	InnnerClassTest oc = new InnnerClassTest();  
        // newһ���ⲿ��  
    	InnnerClassTest oc1 = new InnnerClassTest();  
        // ͨ���ⲿ��Ķ���newһ���Ǿ�̬���ڲ���  
    	InnnerClassTest.InnerClass no_static_inner = oc1.new InnerClass();  
        // ���÷Ǿ�̬�ڲ���ķ���  
        System.out.println(no_static_inner.getKey());  
  
        // ���þ�̬�ڲ���ľ�̬����  
        System.out.println(InnnerClassTest.InnerStaticClass.static_value);  
        // ���������ⲿ��ʵ��,ֱ��ʵ�����ڲ���̬��  
        InnnerClassTest.InnerStaticClass inner = new InnnerClassTest.InnerStaticClass();  
        // ���þ�̬�ڲ���ķǾ�̬����  
        System.out.println(inner.getValue());  
        // �����ڲ���̬��ľ�̬����  
        System.out.println(InnnerClassTest.InnerStaticClass.getMessage());  
    }    
 
}
