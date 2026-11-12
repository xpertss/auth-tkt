package xpertss.auth.tkt;

/**
 * Thrown to indicate that the ticket did not authenticate properly.
 */
public class InvalidTicketException extends RuntimeException {

   private static final long serialVersionUID = 1L;
   /**
    * Constructs an exception with no detail message.
    */
   public InvalidTicketException() {
   }

   /**
    * Constructs an exception with the given detail message.
    *
    * @param message the detail message
    */
   public InvalidTicketException(String message) {
      super(message);
   }

   /**
    * Constructs an exception with the given detail message and cause.
    *
    * @param message the detail message
    * @param cause the cause
    */
   public InvalidTicketException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs an exception with the given cause.
    *
    * @param cause the cause
    */
   public InvalidTicketException(Throwable cause) {
      super(cause);
   }
}
