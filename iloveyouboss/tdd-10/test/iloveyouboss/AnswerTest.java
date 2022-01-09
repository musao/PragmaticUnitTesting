﻿/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerTest {
   // 空の回答に対するマッチングではfalseを返す
   @Test
   public void matchAgainstNullAnswerReturnsFalse() {
      assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE)
        .match(null));
   }
}
