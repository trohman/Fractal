package expressionevaluator;


@SuppressWarnings("serial")
class StackEmptyException extends Exception {

  public StackEmptyException() {
  }

  public StackEmptyException( String message ) {
    super( message );
  }

}

