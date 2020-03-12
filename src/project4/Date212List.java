package project4;
/***************************************************************
 * 
 * An abstract linked list class that stores the first/last node and the length.
 *
 */
public class Date212List {
    protected Date212Node first;
    protected Date212Node last;
    protected int length;
    public Date212List(){
        Date212Node dummy = new Date212Node(null);
        first = dummy;
        last = first;
        length = 0;
    }
    /**
     * This method adds the date to the linked list.
     * n: Takes the date object and creates a node.
     * @param date A Date212 object.
     */
    public void append(Date212 date){
        Date212Node n = new Date212Node(date);
        last.next = n;
        last = n;
        length++;
    }
    
}
