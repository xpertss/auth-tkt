package xpertss.auth.tkt;

/**
 * Thrown to indicate that this valid ticket does not contain the required
 * token. This exception should treated as an authorization failure.
 */
public class TokenMissingException extends InvalidTicketException {

   private static final long serialVersionUID = 1L;
   /**
    * Constructs an exception with no detail message.
    */
   public TokenMissingException() {
   }

   /**
    * Constructs an exception with the given detail message.
    *
    * @param message the detail message
    */
   public TokenMissingException(String message) {
      super(message);
   }

   /**
    * Constructs an exception with the given detail message and cause.
    *
    * @param message the detail message
    * @param cause the cause
    */
   public TokenMissingException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs an exception with the given cause.
    *
    * @param cause the cause
    */
   public TokenMissingException(Throwable cause) {
      super(cause);
   }
}
