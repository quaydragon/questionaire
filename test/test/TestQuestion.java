package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import questions.AbstractQuestion;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.TrueFalse;




/**
 * The testing class for the questionaire.
 * 
 * @author quaydragon
 *
 */
public class TestQuestion {
  public TrueFalse trueFalse;
  public TrueFalse falseTrue;
  public MultipleChoice multiChoice;
  public Likert likert;
  public MultipleSelect multiSelect;

  
  /**
   * Sets up the questionaire testing.
   * 
   */
  @Before
  public void setUp() {
    trueFalse = new TrueFalse("I ate half a pizza last night", "True");
    falseTrue = new TrueFalse("Salad is usually my go to", "False");
    

    String option1 = "I hate Java";
    String option2 = "My cat is cooler than me";
    String option3 = "Dogs are the best things on earth";
    String option4 = "My cell phone is purple";
    String option5 = "I wear noise cancelling headphones without music";

    
    
    multiChoice = new MultipleChoice("Which of the following questions are true?",
        "2",
        option1,
        option2,
        option3,
        option4);
    
    likert = new Likert("The covid safe party will be fun tonight: ");
    
    multiSelect = new MultipleSelect("Select all that are true",
        "4 2 5",
        option1,
        option2,
        option3,
        option4,
        option5);
    
  }

  @Test
  public void testTrueFalseAnswer() {
    assertEquals("Correct", trueFalse.answer("True"));
    assertEquals("Incorrect", falseTrue.answer("True"));
  }
  
  @Test
  public void testTrueFalseGetText() {
    assertEquals("I ate half a pizza last night", trueFalse.getText());
    assertEquals("Salad is usually my go to", falseTrue.getText());
  }
  
  @Test
  public void testMultiChoiceGetText() {
    String answer = "Which of the following questions are true?"
        + "\n1: I hate Java"
        + "\n2: My cat is cooler than me"
        + "\n3: Dogs are the best things on earth"
        + "\n4: My cell phone is purple";
   
    assertEquals(answer, multiChoice.getText());
  
  }
  
  @Test
  public void testMultiChoiceAnswer() {
    assertEquals("Correct", multiChoice.answer("2"));
    assertEquals("Incorrect", multiChoice.answer("3"));
  }
  
  @Test
  public void testLikertGetText() {
    String answer = "The covid safe party will be fun tonight: "
        + "\n1: Strongly Agree"
        + "\n2: Agree"
        + "\n3: Neither Agree nor Disagree"
        + "\n4: Disagree"
        + "\n5: Strongly Disagree";
    assertEquals(answer, likert.getText());
  
  }
  
  @Test
  public void testLikertAnswer() {
    assertEquals("Correct", likert.answer("2"));
    assertEquals("Incorrect", multiChoice.answer("blue fish"));
    assertEquals("Correct", likert.answer("1"));
    assertEquals("Correct", likert.answer("3"));
    assertEquals("Correct", likert.answer("4"));
    assertEquals("Correct", likert.answer("5"));
    
  }
  
  @Test
  public void testMultiSelectGetText() {
    String answer = "Select all that are true"
        + "\n1: I hate Java"
        + "\n2: My cat is cooler than me"
        + "\n3: Dogs are the best things on earth"
        + "\n4: My cell phone is purple"
        + "\n5: I wear noise cancelling headphones without music";

    assertEquals(answer, multiSelect.getText());
  
  }
  
  @Test
  public void testMultiSelectAnswer() {
    assertEquals("Correct", multiSelect.answer("2 4 5"));
    assertEquals("Incorrect", multiSelect.answer("1 5"));
  }
  
  @Test
  public void testQuestionOrdering() {
    
    int comparing = falseTrue.getText().compareTo(trueFalse.getText());
    int comparing2 = trueFalse.getText().compareTo(falseTrue.getText());

    assertEquals(10, comparing);
    assertEquals(-10, comparing2);
  }
  
  
  @Test
  public void testCompareTrueFalse() {
    //compare to likert
    assertEquals(-3, trueFalse.compareTo(likert));
    //compare to TrueFalse
    assertEquals(0, trueFalse.compareTo(trueFalse));
    assertEquals(-10, trueFalse.compareTo(falseTrue));
    //compare to multiplechoice
    assertEquals(-1, trueFalse.compareTo(multiChoice));
    //compare to multiSelect
    assertEquals(-2, trueFalse.compareTo(multiSelect));
  }
  
  @Test
  public void testCompareMultiSelect() {
    //compare to likert
    assertEquals(-1, multiSelect.compareTo(likert));
    //compare to TrueFalse
    assertEquals(2, multiSelect.compareTo(trueFalse));
    //compare to multiplechoice
    assertEquals(1, multiSelect.compareTo(multiChoice));
    //compare to multiSelect
    assertEquals(0, multiSelect.compareTo(multiSelect));
  }
  
  @Test
  public void testCompareMultiChoice() {
    //compare to likert
    assertEquals(-2, multiChoice.compareTo(likert));
    //compare to TrueFalse
    assertEquals(1, multiChoice.compareTo(trueFalse));
    //compare to multiplechoice
    assertEquals(0, multiChoice.compareTo(multiChoice));
    //compare to multiSelect
    assertEquals(-1, multiChoice.compareTo(multiSelect));
  }
  
  @Test
  public void testCompareLikert() {
    //compare to likert
    assertEquals(0, likert.compareTo(likert));
    //compare to TrueFalse
    assertEquals(3, likert.compareTo(trueFalse));
    //compare to multiplechoice
    assertEquals(2, likert.compareTo(multiChoice));
    //compare to multiSelect
    assertEquals(1, likert.compareTo(multiSelect));
  }
  
  @Test
  public void testOrder() {
    List<AbstractQuestion> a = new ArrayList<AbstractQuestion>();
    AbstractQuestion[] q = new AbstractQuestion[] {likert, trueFalse, multiChoice, multiSelect};
    Arrays.sort(q);
    a.add(likert);
    a.add(trueFalse);
    a.add(multiChoice);
    a.add(multiSelect);
    Collections.sort(a);
    
    System.out.println(a);

    
//    Collections.sort(a);
    
//    AbstractQuestion[] questions = new AbstractQuestion[] {falseTrue, trueFalse};
    List<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
    
    questions.add(falseTrue);
    questions.add(trueFalse);
    System.out.println(falseTrue.getText());
    System.out.println(trueFalse.getText());
    System.out.println(questions);
    
    
    Collections.sort(questions);
    
    System.out.println(questions);
    
   
//    assertEquals("sdljn", questions);

    
    
  }
  
  
  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectConstructor() {
    new MultipleSelect("Question",
        "1 2",
        "Hello",
        "wrongo");
    
    new MultipleSelect("Question",
        "1 2",
        "Hello",
        "wrongo",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9");
    
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceConstructor() {
    new MultipleChoice("Question",
        "1 2",
        "Hello",
        "wrongo");
    
    new MultipleChoice("Question",
        "1 2",
        "Hello",
        "wrongo",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9");
    
  }


}
