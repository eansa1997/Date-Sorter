package project4;
import java.util.Comparator;
/***************************************************************
 * 
 * A Comparator that takes two Date212 objects.
 *
 */
public class Date212Comparator implements Comparator<Date212> {
    @Override
    /**
     * This method compares two objects of the same class.
     * @return Returns the int produced by the compareTo method in class Date212.
     * @param a Date212 object.
     * @param b Date212 object.
     */
    public int compare(Date212 a, Date212 b) {
        return a.compareTo(b); //calls the compareTo method of the left parameter.
    }
    
}
