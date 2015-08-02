package wiki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.wiki.operation.WikiAnswers;
import main.wiki.util.WikiSolutionUtil;
import main.wiki.vo.RequestVO;

import org.junit.Assert;
import org.junit.Test;

public class WikiTest {

	@Test
	public void testWikiAnswers() {
		String testString = "Zebras are several species of African equids (horse family) united by their distinctive black "
				+ "and white stripes. Their stripes come in different patterns, unique to each individual. They "
				+ "are generally social animals that live in small harems to large herds. Unlike their closest "
				+ "relatives, horses and donkeys, zebras have never been truly domesticated. There are "
				+ "three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The "
				+ "plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's "
				+ "zebra is the sole species of subgenus Dolichohippus. The latter resembles an ass, to "
				+ "which it is closely related, while the former two are more horse-like. All three belong to the "
				+ "genus Equus, along with other living equids. The unique stripes of zebras make them one "
				+ "of the animals most familiar to people. They occur in a variety of habitats, such as "
				+ "grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hills. "
				+ "However, various anthropogenic factors have had a severe impact on zebra populations, "
				+ "in particular hunting for skins and habitat destruction. Grévy's zebra and the mountain "
				+ "zebra are endangered. While plains zebras are much more plentiful, one subspecies, the "
				+ "quagga, became extinct in the late 19th century – though there is currently a plan, called "
				+ "the Quagga Project, that aims to breed zebras that are phenotypically similar to the "
				+ "quagga in a process called breeding back.";
		
		
		/*Set the questions to an arraylist*/
		List<String> questions=new ArrayList<String>();
		questions.add("Which Zebras are endangered?");
		questions.add("What is the aim of the Quagga Project?");
		questions.add("Which animals are some of their closest relatives?");
		questions.add("Which are the three species of zebras?");
		questions.add("Which subgenus do the plains zebra and the mountain zebra belong to?");
		
		/*Set the answers to an arraylist*/
		String answer = "subgenus Hippotigris;the plains zebra, the Grévy's zebra and the mountain zebra;horses "
				+ "and donkeys;aims to breed zebras that are phenotypically similar to the quagga;Grévy's "
				+ "zebra and the mountain zebra";
		
		RequestVO request=new RequestVO(questions,WikiSolutionUtil.tokenize(answer,";"),WikiSolutionUtil.tokenize(testString,"."));
		
		/*Find the correct answers*/
		request.findAnswers(request);
		
		HashMap<String, String> answerMap= new HashMap<String, String>();
		answerMap.put("Which Zebras are endangered?", "Grévy's zebra and the mountain zebra");
		answerMap.put("What is the aim of the Quagga Project?", "aims to breed zebras that are phenotypically similar to the quagga");
		answerMap.put("Which animals are some of their closest relatives?", "horses and donkeys");
		answerMap.put("Which are the three species of zebras?", "the plains zebra, the Grévy's zebra and the mountain zebra");
		answerMap.put("Which subgenus do the plains zebra and the mountain zebra belong to?", "subgenus Hippotigris");
		
		Assert.assertEquals(true, answerMap.equals(request.getAnswerMap()));
	}

/**
 * Test the tokenizer 
 */
	@Test
	public void testTokenizer() {
		
		String testString1 = "one,two,three";
		List<String> resultString1=WikiSolutionUtil.tokenize(testString1, ",");
		Assert.assertEquals(3, resultString1.size());
				
		String testString2 = "one:two:three";
		List<String> resultString2=WikiSolutionUtil.tokenize(testString2, ":");
		Assert.assertEquals(3, resultString2.size());
		
	}
	
	/**
	 * Find the maximum matching line
	 */
	@Test
	public void testMaxMatch() {
		WikiAnswers ans=new WikiAnswers();
		List<String> lines = new ArrayList<String>();
		lines.add("Zebras are several species of African equids (horse family) united by their distinctive black");
		lines.add("However, various anthropogenic factors have had a severe impact on zebra populations");
		lines.add("All three belong to the genus Equus, along with other living equids.");
		
		Assert.assertEquals("Zebras are several species of African equids (horse family) united by their distinctive black", ans.maxMatchedString("several African united black", lines));
		Assert.assertEquals("All three belong to the genus Equus, along with other living equids.", ans.maxMatchedString("along other living", lines));
		Assert.assertEquals("However, various anthropogenic factors have had a severe impact on zebra populations", ans.maxMatchedString("various severe impact", lines));
		

	}
}
