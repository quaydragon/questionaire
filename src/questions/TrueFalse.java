package questions;

/**
 * Constructs a true false question.
 * 
 * @author quaydragon
 *
 */
public class TrueFalse extends AbstractQuestion {
  
  /**
   * Constructs a true/false question using the question text 
   * and correct answer.
   * 
   * @param text the question text
   * @param correctAnswer the correct answer to true/false
   */
  public TrueFalse(String text, 
      String correctAnswer) {
    super(text);
    this.correctAnswer = correctAnswer;

    
    //TODO: Throw Illegal argument exception 
  }

  /**
   * Compares the different comparable questions with True/False.
   * 
   * @return a number designating the position within the questionaire
   */
  @Override
  public int compareTo(Question o) {
    
    if (this == o) {
      return 0;
    } 
    
    if (o instanceof TrueFalse) {
      return this.getText().compareTo(o.getText());
    }
    
    if (o instanceof MultipleChoice) {
      return -1;
    }
    if (o instanceof MultipleSelect) {
      return -2;
    }
    
    if (o instanceof Likert) {
      return -3;
    }
    
    return 0;
    
  }
  

}
