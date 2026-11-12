package xpertss.auth.tkt;

/**
 * Thrown to indicate that the auth ticket cookie was not found
 */
public class TicketNotFoundException extends RuntimeException {

   private static final long serialVersionUID = 1L;

   /**
    * Constructs an exception with no detail message.
    */
   public TicketNotFoundException() {
   }

   /**
    * Constructs an exception with the given detail message.
    *
    * @param message the detail message
    */
   public TicketNotFoundException(String message) {
      super(message);
   }

   /**
    * Constructs an exception with the given detail message and cause.
    *
    * @param message the detail message
    * @param cause the cause
    */
   public TicketNotFoundException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs an exception with the given cause.
    *
    * @param cause the cause
    */
   public TicketNotFoundException(Throwable cause) {
      super(cause);
   }

}
