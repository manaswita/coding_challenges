package main.wiki.operation;

import java.util.List;
import java.util.Set;

import main.wiki.constants.WikiConstants;
import main.wiki.vo.RequestVO;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

public class WikiAnswers {

	/**
	 * Find questions to the answers	
	 * @param request
	 */
		public void findAnswers(RequestVO request){
			List<String> answers=request.getAnswers();
				for(String answer: answers){
					matchAnswertoQues(request,answer);
				}
			
		}

	/**
	 * Get question for answer
	 * 
	 * @param questions
	 * @param ans
	 * @param lines
	 */
	private void matchAnswertoQues(RequestVO request, String ans) {
		boolean ansIntersection = false;
		String maxMatchedQues = null;

		for (String line : request.getTextLines()) {
			ansIntersection = false;
			/* For every line, check if you have a direct substring that matches the answer */
			ansIntersection = line.contains(ans);

			/*If the exact answer is found for the question, check the string of the question */
			if (ansIntersection) {

				/* The question that matches the maximum strings with the line is the question for this answer*/
				maxMatchedQues = maxMatchedString(line, request.getQuestions());

				System.out.println("Question :" + maxMatchedQues + "\nAnswer :"+ ans);
				request.getAnswerMap().put(maxMatchedQues, ans);
				break;
			}
		}
	}

	/**
	 * Check the question that has the maximum words matching to the line
	 * 
	 * @param line
	 * @param matchStringList
	 * @return
	 */
	public String maxMatchedString(String line, List<String> matchStringList) {

		int maxMatch = 0;
		String maxMatchedString = null;
		Set<String> quesIntersection = null;
		Splitter splitter = Splitter.onPattern(WikiConstants.SPACE_SPLITTER).trimResults().omitEmptyStrings();

		for (String ques : matchStringList) {
			quesIntersection = Sets.intersection(
					Sets.newHashSet(splitter.split(ques)),
					Sets.newHashSet(splitter.split(line)));
			if (quesIntersection != null && !quesIntersection.isEmpty()) {
				if (maxMatch < quesIntersection.size()) {
					maxMatch = quesIntersection.size();
					maxMatchedString = ques;
				}
			}
		}

		return maxMatchedString;
	}
}
