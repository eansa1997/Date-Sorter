package project4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
/***************************************************************
 * 
 * A action listener implementation. Receives a DateGUI object so it can
 * perform actions when certain items are selected.
 *
 */
public class FileMenuHandler implements ActionListener {
    protected DateGUI gui;
    /**
     * This constructor instantiates the class and takes a DateGUI object.
     * @param goey A Date212 instance for access to its methods.
     */
    public FileMenuHandler(DateGUI goey){
        this.gui = goey;
    }
    /**
     * This class responds to an item being selected in the DateGUI.
     * @param event A event generated from the GUI.
     */
    public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("Open")){ //if open is selected, a JFileChooser is created in DateGUI instance.
            int status = gui.createFileChooser();
            if(status == JFileChooser.APPROVE_OPTION){
                try { // attempts to grab the file selected and read it, throws exception if file isnt found.
                    gui.createStuff();
                } catch (FileNotFoundException ex) {
                    System.out.print("Error, file not found. Try again.");
                }
            }
        }
        else if(event.getActionCommand().equals("Quit")){ //exits program if quit is selected from menubar.
            System.exit(0);    
        }
    }
    
}
