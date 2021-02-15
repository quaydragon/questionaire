package questions;


import java.util.ArrayList;
import java.util.List;



/**
 * Creates a multiple choice question.
 * 
 * @author quaydragon
 *
 */
public class MultipleChoice extends AbstractQuestion {
  private List<String> options = new ArrayList<String>();
  
  
  /**
   * Constructs a multiple choice question from the text,
   * the correct answer,
   * and the answer options.
   * 
   * @param text the question
   * @param correctAnswer the correct answer
   * @param args the choices to choose from
   */
  public MultipleChoice(String text, 
      String correctAnswer, 
      String... args)  throws IllegalArgumentException {
    super(text);
    if (args.length < 3 
        || args.length > 8
        ) {
      throw new IllegalArgumentException("Must have between 3 and 8 arguments");
    }

    // TODO Make Illegal Argument Exception for Options

    this.correctAnswer = correctAnswer;
    
    for (String arg : args) {
      this.options.add(arg);
    }
    
    
    
  }
  

 /**
  * Returns a string with both the question text and options.
  * 
  *  @return a string with question text and options
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
   * Compares the different comparable questions with Multiple Choice.
   * 
   * @return a number designating the position within the questionaire
   */
  @Override
  public int compareTo(Question o) {
    
    if (o instanceof MultipleChoice) {
      
      return this.getText().compareTo(o.getText());
    }

    
    if (o instanceof TrueFalse) {
      return 1;
    }
    if (o instanceof MultipleSelect) {
      return -1;
    }
    
    if (o instanceof Likert) {
      return -2;
    }
    
    
    
    return 0;
  }

}
