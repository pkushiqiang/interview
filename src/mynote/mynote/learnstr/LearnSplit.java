package mynote.learnstr;

public class LearnSplit {
	
	public static void test1(){
		String str = ":a:b";
		String[] strs = str.split(":");
		printStrs(strs);
		
		str = ":::a:b";
		strs = str.split(":");
		printStrs(strs);
		
		str = ":::a:b:::";
		strs = str.split(":");
		printStrs(strs);
		
		str = ":::a:::b:::";
		strs = str.split(":");
		printStrs(strs);
	}
	
	public static void printStrs(String[] strs){
		for (int i=0 ;i<strs.length; i++){
			System.out.println(i +"  :  [" + strs[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

}
