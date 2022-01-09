﻿/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import java.io.*;
import org.json.simple.parser.*;
import org.junit.*;
import util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AddressRetrieverTest {
   // 正当な座標に対して適切な住所を返す
   @Test
   public void answersAppropriateAddressForValidCoordinates() 
         throws IOException, ParseException {
      Http http = (String url) -> 
         "{\"address\":{"
         + "\"house_number\":\"324\","
         + "\"road\":\"ノーステジョンストリート\","
         + "\"city\":\"コロラドスプリングス\","
         + "\"state\":\"コロラド\","
         + "\"postcode\":\"80903\","
         + "\"country_code\":\"us\"}"
         + "}";
      AddressRetriever retriever = new AddressRetriever(http);

      Address address = retriever.retrieve(38.0,-104.0);
      
      assertThat(address.houseNumber, equalTo("324"));
      assertThat(address.road, equalTo("ノーステジョンストリート"));
      assertThat(address.city, equalTo("コロラドスプリングス"));
      assertThat(address.state, equalTo("コロラド"));
      assertThat(address.zip, equalTo("80903"));
   }

   @Test
   public void returnsAppropriateAddressForValidCoordinates() 
         throws IOException, ParseException {
      Http http = new Http() {
         @Override
         public String get(String url) throws IOException {
            return "{\"address\":{"
               + "\"house_number\":\"324\","
               + "\"road\":\"ノーステジョンストリート\","
               // ...
               + "\"city\":\"コロラドスプリングス\","
               + "\"state\":\"コロラド\","
               + "\"postcode\":\"80903\","
               + "\"country_code\":\"us\"}"
               + "}";
            }};
      AddressRetriever retriever = new AddressRetriever(http);

      Address address = retriever.retrieve(38.0,-104.0);
      
      assertThat(address.houseNumber, equalTo("324"));
      assertThat(address.road, equalTo("ノーステジョンストリート"));
      assertThat(address.city, equalTo("コロラドスプリングス"));
      assertThat(address.state, equalTo("コロラド"));
      assertThat(address.zip, equalTo("80903"));
   }
}
