package project4;
/***************************************************************
 * 
 * A class that creates a linked list node storing a Date212 object and 
 * a pointer to the next node.
 *
 */
public class Date212Node {
    protected Date212 date;
    protected Date212Node next;
    public Date212Node(Date212 d){
        this.date = d;
        this.next = null;
    }
    
}
