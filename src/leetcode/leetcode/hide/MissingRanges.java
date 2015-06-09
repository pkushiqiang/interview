package leetcode.hide;

/*
 * Given a sorted integer array where the range of elements 
 * are [0, 99] inclusive, return its missing ranges.
 For example, given [0, 1, 3, 50, 75], 
 return [¡°2¡±, ¡°4->49¡±, ¡°51->74¡±, ¡°76->99¡±]
 * 
 */

import java.util.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import org.junit.Test;

public class MissingRanges {

	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> list = new ArrayList<>();
		if (vals == null || vals.length == 0 || vals[0] > end
				|| vals[vals.length - 1] < start) {
			list.add(start + "->" + end);
			return list;
		}

		int i = 0;
		while (vals[i] < start)
			i++;
		int last;
		if (vals[i] == start) {
			last = start;
		} else {
			last = start - 1;
		}

		for (; i < vals.length && vals[i] <= end; i++) {
			if (vals[i] - last > 1) {
				if (vals[i] - last == 2) {
					list.add("" + (last + 1));
				} else {
					list.add((last + 1) + "->" + (vals[i] - 1));
				}
			}
			last = vals[i];
		}

		if (last < end) {
			if (last == (end - 1))
				list.add("" + end);
			else
				list.add((last + 1) + "->" + end);
		}

		return list;
	}

	public static String toString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
			sb.append(",");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	public static String missingRanges(int[] vals, int start, int end) {
		List<String> list = findMissingRanges(vals, start, end);
		return toString(list);
	}

	@Test
	public  void test1() {
		int[] A = { 0, 1, 3, 50, 98, 100 };		
		String res = missingRanges(A, 0, 99);
		assertEquals(res, "2,4->49,51->97,99");
	}

	@Test
	public  void test2() {		
		int[] A = { 99, 100 };
		String res = missingRanges(A, 0, 99);
		assertEquals(res, "0->98");
		res = missingRanges(A, 0, 100);
		assertEquals(res, "0->98");
		res = missingRanges(A, 0, 101);
		assertEquals(res, "0->98,101");
	}

	@Test
	public void test3() {
		int[] A = { 99, 100 };
		String res = missingRanges(A, 98, 100);
		assertEquals(res, "98");
		res = missingRanges(A, 97, 100);
		assertEquals(res, "97->98");
	}
	
	@Test
	public void test4() {
		int[] A = {50, 98, 100};
		String res = missingRanges(A, 0, 99);
		assertEquals(res, "0->49,51->97,99");
		res = missingRanges(A, 97, 100);
		assertEquals(res, "97,99");
	}
	
	@Test
	public void test5() {
		int[] A = {50 };
		String res = missingRanges(A, 0, 99);
		assertEquals(res, "0->49,51->99");
		res = missingRanges(A, 97, 100);
		assertEquals(res, "97->100");
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MissingRanges.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
