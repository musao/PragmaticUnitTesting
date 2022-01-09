/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;

public class ProfileTest {
   // 転居時のサポートがないという回答
   private Answer answerThereIsNotRelocation;
   // ... 
   private Profile profile;
   private BooleanQuestion questionIsThereRelocation;
   private Answer answerThereIsRelocation;

   @Before
   public void createProfile() {
      profile = new Profile();
   }
   
   @Before
   public void createQuestionAndAnswer() {
      questionIsThereRelocation = 
            new BooleanQuestion(1, "転居時のサポートはありますか?");
      answerThereIsRelocation = 
            new Answer(questionIsThereRelocation, Bool.TRUE);
      answerThereIsNotRelocation = 
            new Answer(questionIsThereRelocation, Bool.FALSE);
   }
   // ...

   @Test
   public void matchesNothingWhenProfileEmpty() {
      Criterion criterion = 
            new Criterion(answerThereIsRelocation, Weight.DontCare);
      
      boolean result = profile.matches(criterion);
      
      assertFalse(result);
   }
  
   @Test
   public void matchesWhenProfileContainsMatchingAnswer() {
      profile.add(answerThereIsRelocation);
      Criterion criterion = 
            new Criterion(answerThereIsRelocation, Weight.Important);

      boolean result = profile.matches(criterion);

      assertTrue(result);
   }

   // 該当する回答がない場合にマッチングは失敗する
   @Test
   public void doesNotMatchWhenNoMatchingAnswer() {
      profile.add(answerThereIsNotRelocation);
      Criterion criterion = 
            new Criterion(answerThereIsRelocation, Weight.Important);
      
      boolean result = profile.matches(criterion);
      
      assertFalse(result);
   }
}
