package xpertss.auth.tkt;

/**
 * Thrown to indicate the auth ticket is not of the correct form and
 * should be treated in a similar way as if the ticket was not found.
 */
public class MalformedTicketException extends TicketNotFoundException {

   private static final long serialVersionUID = 1L;
   /**
    * Constructs an exception with no detail message.
    */
   public MalformedTicketException() {
   }

   /**
    * Constructs an exception with the given detail message.
    *
    * @param message the detail message
    */
   public MalformedTicketException(String message) {
      super(message);
   }

   /**
    * Constructs an exception with the given detail message and cause.
    *
    * @param message the detail message
    * @param cause the cause
    */
   public MalformedTicketException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs an exception with the given cause.
    *
    * @param cause the cause
    */
   public MalformedTicketException(Throwable cause) {
      super(cause);
   }
}
