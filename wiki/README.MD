This the solution to the Wikipedia Problem.
The solution can be imported and run by the JUnit Test case - WikiTest.java.

The RequestVO.java is the input to the solution. This Value Object contains the input text snippet, the questions, the answers and a HashMap with key value pair that contains the computed solution.

The WikiAnswers.java, is where the business logic resides. Here is the detailed logic explained :

1. For each of the answers provided, we find the line in the text snippet where the exact answer string is found  - line.contains(ans); 
2. This line is compared with all the input questions, the question which has maximum number of strings matching with the line is derived to be the answer to the above question.

The limitation to this logic lies in the second part. While finding the question that is the most match for a line, often the articles and connectors (and, to, with, a, an etc.) create a wrong result.