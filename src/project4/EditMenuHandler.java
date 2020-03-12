package project4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
/***************************************************************
 * 
 * A action listener implementation. Receives a DateGUI object so it can
 * perform actions when certain items are selected.
 *
 */
public class EditMenuHandler implements ActionListener {
    private DateGUI gui;
    private String s;
    /**
     * This constructor instantiates the class and takes a DateGUI object.
     * @param goey A Date212 instance for access to its methods.
     */
    public EditMenuHandler(DateGUI goey){
        this.gui = goey;
    }
    /**
     * This class responds to an item being selected in the DateGUI.
     * @param event A event generated from the GUI.
     */
    public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("Insert")){ //if Insert is selected a JOptionPane object is instantiated, for user input.
            try{ //attempts to create Date212 object with string, throws exception if a character is a non-digit.
            s = JOptionPane.showInputDialog(null,"Enter a string in the the format YYYYMMDD, all digits.");
            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i)) == false)
                    throw new Date212Exception("Characters entered invalid. Try again.");
            }
            Date212 in = new Date212(s);
            gui.addDate212(in);
            } catch(Date212Exception ex){ //thrown when string is all digit but it is an invalid date.
                System.out.println(ex);
            }
        }
    }
    
}
