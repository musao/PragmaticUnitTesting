/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package scratch;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static scratch.ConstrainsSidesTo.constrainsSidesTo;
import org.junit.*;

public class RectangleTest {
   private Rectangle rectangle;

   // 制約を満たしている
   @After
   public void ensureInvariant() {
      assertThat(rectangle, constrainsSidesTo(100));
   }

   // 面積を返す
   @Test
   public void answersArea() {
      rectangle = new Rectangle(new Point(5, 5), new Point (15, 10));
      assertThat(rectangle.area(), equalTo(50));
   }

   // 動的に座標を変更できる
   @Ignore
   @ExpectToFail
   @Test
   public void allowsDynamicallyChangingSize() {
      rectangle = new Rectangle(new Point(5, 5));
      rectangle.setOppositeCorner(new Point(130, 130));
      assertThat(rectangle.area(), equalTo(15625));
   }
}
