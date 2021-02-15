package questions;


/**
 * Creates a Likert Question.
 * 
 * @author quaydragon
 *
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructs a likert question from the text of a question.
   * 
   * @param text the text of the question
   */
  public Likert(String text) {
    super(text);

  }
  
  /**
   * Returns the text and answer options for Likert.
   * 
   * @return the text and answer options
   */
  @Override
  public String getText() {
    text = this.text;
    String option1 = "\n1: Strongly Agree";
    String option2 = "\n2: Agree";
    String option3 = "\n3: Neither Agree nor Disagree";
    String option4 = "\n4: Disagree";
    String option5 = "\n5: Strongly Disagree";
    
    String returnString = text 
        + option1
        + option2
        + option3
        + option4
        + option5;
    
    return returnString;
  }
  
  /**
   * Returns correct if a number 1 through 5 is given.
   * 
   * @return whether or not question is answered correctly
   */
  @Override
  public String answer(String answer) {
    
    if (answer.equals("1")
        || answer.equals("2") 
        || answer.equals("3") 
        || answer.equals("4") 
        || answer.equals("5")) {
      return Question.CORRECT;
    }
    
    return Question.INCORRECT;
    
  }

  /**
   * Compares the different comparable questions with Likert.
   * 
   * @return a number designating the position within the questionaire
   */
  @Override
  public int compareTo(Question o) {
    
    if (o instanceof TrueFalse) {
      return 3;
    }
    
    if (o instanceof MultipleChoice) {
      return 2;
    }
    if (o instanceof MultipleSelect) {
      return 1;
    }
    
    if (o instanceof Likert) {
      
      return this.getText().compareTo(o.getText());
    }
    
    return 0;
    
  }
  
}

