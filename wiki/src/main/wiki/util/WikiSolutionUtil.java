package main.wiki.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import main.wiki.vo.RequestVO;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

public class WikiSolutionUtil {
	
	/**
	 * Tokenize the strings
	 * @param inputString
	 * @param tokenParam
	 * @return
	 */
	public static List<String> tokenize(String inputString, String tokenParam) {
		List<String> lines = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(inputString, tokenParam);
		while (st.hasMoreTokens()) {
			lines.add(st.nextToken());
		}
		/*Collections.sort(lines, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Integer L1 = o1.length();
				return L1.compareTo(o2.length()) ;
			}
		});
		 */
		return lines;
	}

}
