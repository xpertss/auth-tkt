package xpertss.auth.tkt;

/**
 * Thrown to indicate that the timestamp associated with the auth ticket
 * has expired.
 */
public class ExpiredTicketException extends TicketNotFoundException {

   private static final long serialVersionUID = 1L;

   /**
    * Constructs an exception with no detail message.
    */
   public ExpiredTicketException() {
   }

   /**
    * Constructs an exception with the given detail message.
    *
    * @param message the detail message
    */
   public ExpiredTicketException(String message) {
      super(message);
   }

   /**
    * Constructs an exception with the given detail message and cause.
    *
    * @param message the detail message
    * @param cause the cause
    */
   public ExpiredTicketException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs an exception with the given cause.
    *
    * @param cause the cause
    */
   public ExpiredTicketException(Throwable cause) {
      super(cause);
   }
}
