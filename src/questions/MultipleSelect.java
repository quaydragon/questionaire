package questions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates a multiselect question.
 * 
 * @author quaydragon
 *
 */
public class MultipleSelect extends AbstractQuestion {
  private List<String> options = new ArrayList<String>();
  
  /**
   * Constructs the multiselect question with the question text,
   * correct answer, 
   * and different selection options. 
   * 
   * @param text the question
   * @param correctAnswer the correct answer
   * @param args the selection choices
   */
  public MultipleSelect(String text, 
      String correctAnswer, 
      String... args)  throws IllegalArgumentException {
    super(text);
    if (args.length < 3 
        || args.length > 8
        ) {
      throw new IllegalArgumentException("Must have between 3 and 8 arguments");
    }


    this.correctAnswer = correctAnswer;
    
    for (String arg : args) {
      this.options.add(arg);
    }
  
    
    
    
  }
  
  /**
   * Returns a string with the text and the selection options.
   * 
   * @return the question and options
   */
  @Override 
  public String getText() {
    text = this.text;
    options = this.options;
    
    String returnString = text;
    
    for (int i = 1; i <= options.size(); i++) {
      returnString += "\n";
      returnString += i + ": ";
      String option = (String) options.get(i - 1);
      returnString += option;
      
    }
    
    
    
    return returnString;
  }
  
  /**
   * Returns whether or not the answer is correct.
   * 
   * @return whether the answer is correct
   */
  @Override
  public String answer(String answer) {  
    String[] splitedAnswer = answer.split("\\s+");
    String[] correctAnswer = this.correctAnswer.split("\\s+");
    Arrays.sort(correctAnswer);
    Arrays.sort(splitedAnswer);
    
    if (Arrays.equals(splitedAnswer, correctAnswer)) {
      return Question.CORRECT;
    }
    
    
    return Question.INCORRECT;
    
  }

  /**
   * Compares the different comparable questions with Multiple Select.
   * 
   * @return a number designating the position within the questionaire
   */
  @Override
  public int compareTo(Question o) {
    
    if (o instanceof MultipleSelect) {
      return this.getText().compareTo(o.getText());
    }
    
    if (o instanceof TrueFalse) {
      return 2;
    }
    if (o instanceof MultipleChoice) {
      return 1;
    }
    
    if (o instanceof Likert) {
      return -1;
    }
    
    return 0;
    
  }

}
