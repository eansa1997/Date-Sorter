package project4;
/***************************************************************
 * 
 * A custom exception that extends the Exception class.
 *
 */
public class Date212Exception extends Exception{
    /**
     * Calls the Exception class super method while passing a string.
     * @param msg A string passed when exception is generated.
     */
    public Date212Exception(String msg){
        super(msg);
    }
}
