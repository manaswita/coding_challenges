package main.wiki.vo;

import java.util.HashMap;
import java.util.List;

import main.wiki.operation.WikiAnswers;

public class RequestVO {
	
	private List<String> questions;
	private List<String> answers;
	private List<String> textLines;
	private HashMap<String, String> answerMap=new HashMap<String, String>();
	
	public RequestVO(List<String> questions, List<String> answers,
			List<String> textLines) {
		super();
		this.questions = questions;
		this.answers = answers;
		this.textLines = textLines;
	}
	public List<String> getQuestions() {
		return questions;
	}
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public List<String> getTextLines() {
		return textLines;
	}
	public void setTextLines(List<String> textLines) {
		this.textLines = textLines;
	}
	public HashMap<String, String> getAnswerMap() {
		return answerMap;
	}
	public void setAnswerMap(HashMap<String, String> answerMap) {
		this.answerMap = answerMap;
	}
	public void findAnswers(RequestVO request) {
		WikiAnswers command=new WikiAnswers();
		command.findAnswers(this);
    }
	
}
