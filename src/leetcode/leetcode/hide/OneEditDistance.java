package leetcode.hide;

/*
 * 
 * Given two strings S and T, 
 * determine if they are both one edit distance apart.
 * 
 * Hint:
 1. If | n ¨C m | is greater than 1, we know immediately both are not one-edit distance apart.
 2. It might help if you consider these cases separately, m == n and m ¡Ù n.
 3. Assume that m is always ¡Ü n, which greatly simplifies the conditional statements. If m > n, we could just simply swap S and T.
 4. If m == n, it becomes finding if there is exactly one modified operation. If m ¡Ù n, you do not have to consider the delete operation. Just consider the insert operation in T.
 */

public class OneEditDistance {

	public static boolean isOneEditDistance2(String s, String t) {
		int m = s.length(), n = t.length();
		if (m > n)
			return isOneEditDistance2(t, s);
		if (n - m > 1)
			return false;
		int i = 0, shift = n - m;
		while (i < m && s.charAt(i) == t.charAt(i))
			++i;
		if (i == m)
			return shift > 0; // if two string are the same (shift==0), return
								// false
		if (shift == 0)
			i++; // if n==m skip current char in s (modify operation in s)
		while (i < m && s.charAt(i) == t.charAt(i + shift))
			i++; // use shift to skip one char in t
		return i == m;
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;

		if (s.length() == t.length()) {
			boolean find = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					if (find)
						return false;
					else
						find = true;
				}
			}
			return find;
		} else {
			if (s.length() > t.length()) {
				String tmp = s;
				s = t;
				t = tmp;
			}
			int i = 0, j = 0;
			boolean find = false;
			while (i < s.length() ) {
				if (s.charAt(i) != t.charAt(j)) {
					if (find)
						return false;
					else {
						find = true;
						i--;
					}
				}
				i++;
				j++;
			}
			return i==s.length();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEditDistance("aa", "aa") + " "
				+ isOneEditDistance2("aa", "aa"));
		System.out.println(isOneEditDistance("aa", "ab") + " "
				+ isOneEditDistance2("aa", "ab"));
		System.out.println(isOneEditDistance("aaa", "aba") + " "
				+ isOneEditDistance2("aaa", "aba"));
		System.out.println(isOneEditDistance("aaa", "abb") + " "
				+ isOneEditDistance2("aaa", "abb"));
		System.out.println(isOneEditDistance("aaa", "ab") + " "
				+ isOneEditDistance2("aaa", "ab"));
		System.out.println(isOneEditDistance("aaa", "aa") + " "
				+ isOneEditDistance2("aaa", "aa"));
		System.out.println(isOneEditDistance("aba", "aa") + " "
				+ isOneEditDistance2("aba", "aa"));
		System.out.println(isOneEditDistance("abaa", "aa") + " "
				+ isOneEditDistance2("abaa", "aa"));
	}

}
