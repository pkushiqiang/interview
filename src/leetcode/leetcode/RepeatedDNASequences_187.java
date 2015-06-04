package leetcode;
import java.util.*;
public class RepeatedDNASequences_187 {
	
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if ( s == null || s.length() < 11)
            return list;
            
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> added = new HashSet<Integer>();
        
        int code = 0;
        int mask =  ((1<<20)-1);
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( i < 9 ) {
                code =  (code << 2) | getCode(c);
            }  else {
                code =  (code << 2) | getCode(c);
                code &=mask; 
                if ( !set.contains(code) ) {
                    set.add(code) ;
                } else if ( !added.contains(code) ) {
                    list.add(s.substring(  i-9, i+1 ));
                    added.add(code);
                }
            }
            
        }
        return list;
    }
    
    private int getCode(char c){
       switch (c) {
            case 'A': 
                return 0;
            case 'C': 
                return 1; 
            case 'G': 
                return 2;
            case 'T': 
                return 3;
        }
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences_187 solution = new RepeatedDNASequences_187();
		solution.findRepeatedDnaSequences("CAAAAAAAAAC");
	}

}
