package questions;

/** 
 * Creates an abstract question class. 
 */
public abstract class AbstractQuestion implements Question {
  protected String text;
  protected String[] options;
  protected String correctAnswer;

  
  /** 
   * Constructs a question based on the question's text.
   * 
   * @param text the question
   */
  protected AbstractQuestion(String text) {
    this.text = text;


    
  }
  
  /** 
   * Returns whether the input is the correct answer.
   * 
   * @return whether the input is the correct answer
   */
  @Override
  public String answer(String answer) {
    if (answer == this.correctAnswer) { 
      return Question.CORRECT;
    }
    
    return Question.INCORRECT;
    
  }
  
  
  /**
   * Returns the text of the question.
   * 
   * 
   * @return the text of the question
   */
  @Override
  public String getText() {
    return this.text;
  }

}
