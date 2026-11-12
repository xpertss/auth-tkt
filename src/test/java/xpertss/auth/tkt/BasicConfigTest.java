/**
 * Copyright 2015 XpertSoftware
 * <p/>
 * Created By: cfloersch
 * Date: 8/15/2015
 */
package xpertss.auth.tkt;

import org.junit.jupiter.api.Test;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicConfigTest {


   @Test
   public void testMissingSecret() throws ServletException
   {
      FilterConfig config = mock(FilterConfig.class);
      AuthTicketFilter objectUnderTest = new AuthTicketFilter();
      assertThrows(IllegalArgumentException.class, () -> objectUnderTest.init(config));
   }

   @Test
   public void testMissingAuthUrl() throws ServletException
   {
      FilterConfig config = mock(FilterConfig.class);
      when(config.getInitParameter(eq("TKTAuthSecret"))).thenReturn("some_random_secret_key");
      AuthTicketFilter objectUnderTest = new AuthTicketFilter();
      assertThrows(IllegalArgumentException.class, () -> objectUnderTest.init(config));
   }

   @Test
   public void testInvalidAuthUrl() throws ServletException
   {
      FilterConfig config = mock(FilterConfig.class);
      when(config.getInitParameter(eq("TKTAuthSecret"))).thenReturn("some_random_secret_key");
      when(config.getInitParameter(eq("TKTAuthLoginURL"))).thenReturn("hello kitty");
      AuthTicketFilter objectUnderTest = new AuthTicketFilter();
      assertThrows(IllegalArgumentException.class, () -> objectUnderTest.init(config));
   }

   @Test
   public void testFtpAuthUrl() throws ServletException
   {
      FilterConfig config = mock(FilterConfig.class);
      when(config.getInitParameter(eq("TKTAuthSecret"))).thenReturn("some_random_secret_key");
      when(config.getInitParameter(eq("TKTAuthLoginURL"))).thenReturn("ftp://ftp.manheim.com/");
      AuthTicketFilter objectUnderTest = new AuthTicketFilter();
      assertThrows(IllegalArgumentException.class, () -> objectUnderTest.init(config));
   }

   @Test
   public void testInvalidDuration() throws ServletException
   {
      FilterConfig config = mock(FilterConfig.class);
      when(config.getInitParameter(eq("TKTAuthSecret"))).thenReturn("some_random_secret_key");
      when(config.getInitParameter(eq("TKTAuthLoginURL"))).thenReturn("https://www.manheim.com/login");
      when(config.getInitParameter(eq("TKTAuthTimeout"))).thenReturn("hello");
      AuthTicketFilter objectUnderTest = new AuthTicketFilter();
      assertThrows(IllegalArgumentException.class, () -> objectUnderTest.init(config));
   }

}
