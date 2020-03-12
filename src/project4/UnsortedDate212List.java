package project4;
/***************************************************************
 * 
 * A linked list that inherits from Date212List, adds nodes by calling
 * inherited method append().
 *
 */
public class UnsortedDate212List extends Date212List {
    public UnsortedDate212List(){
        super();
    }
    /**
     * This method adds the date to the linked list in the order its read in.
     * Calls the Date212List method append.
     * @param date A Date212 object.
     */
    public void add(Date212 date){
        append(date);
    }
}