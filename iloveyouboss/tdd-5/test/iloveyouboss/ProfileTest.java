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
   // プロフィールが空の場合にはマッチングは失敗する
   @Test
   public void matchesNothingWhenProfileEmpty() {
      Profile profile = new Profile();
      Question question = new BooleanQuestion(1, "転居時のサポートはありますか?");
      Criterion criterion = 
         new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare);
      
      boolean result = profile.matches(criterion);
      
      assertFalse(result);
   }

   // 該当する回答がプロフィールに含まれる場合にはマッチングは成功する
   @Test
   public void matchesWhenProfileContainsMatchingAnswer() {
      Profile profile = new Profile();
      Question question = new BooleanQuestion(1, "転居時のサポートはありますか?");
      Answer answer = new Answer(question, Bool.TRUE);
      profile.add(answer);
      Criterion criterion = new Criterion(answer, Weight.Important);

      boolean result = profile.matches(criterion);

      assertTrue(result);
   }
}
