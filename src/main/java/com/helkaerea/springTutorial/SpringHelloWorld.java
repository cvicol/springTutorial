package com.helkaerea.springTutorial;

/**
 * Hello world Example
 * this class has a property called message
 * we going to inject a value for this using spring
 *
 */
public class SpringHelloWorld {
	public static final String DEFAULT_GREETING_MESSAGE = "This is teh default Message that NORMAL PEOPLE get!!";
	private String message;
	
	/**
	 * Displays the value of the message 
	 */
    public void displayMessage(){
        System.out.println( this.getMessage() );
    }

    /**
     * Set's a String value for a message
     * @param String message
     */
	public void setMessage(String message) {
		   this.message = message;
    }


	/**
	 * returns the value of the message
	 * @return String
	 */
	public String getMessage() {
		return message;
	}
}
