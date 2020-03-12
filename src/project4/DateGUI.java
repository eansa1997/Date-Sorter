package project4;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
/***************************************************************
 * 
 * A GUI that shows two TextAreas in a GridLayout, scrollbars are added once needed.
 *
 */
public class DateGUI extends JFrame{
    private final int WINDOW_HEIGHT = 450;
    private final int WINDOW_WIDTH = 550;
    private JPanel panel1, panel2;
    private JTextArea left, right;
    private JMenu menu, edit;
    private JMenuItem open, quit, insert;
    private JMenuBar bar;
    private JSeparator sep;
    private JFileChooser ch;
    private FileMenuHandler handler;
    private EditMenuHandler edithandler;
    private File file;
    private int status;
    private UnsortedDate212List unsorted;
    private TreeMap<Date212, Integer> sorted;
    public DateGUI() throws FileNotFoundException{
        //insantiates data structures 
        this.unsorted = new UnsortedDate212List();
        this.sorted = new TreeMap<>(new Date212Comparator());
        // builds base content pane
        setTitle("Date GUI");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        createMenuBar();
        // builds panels with textarea's, textareas have scrollbars when needed. 
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        left = new JTextArea();
        JScrollPane leftpane = new JScrollPane(left);
        left.setEditable(false); 
        right = new JTextArea();
        JScrollPane rightpane = new JScrollPane(right);
        right.setEditable(false); 
        panel1.add(leftpane);
        panel2.add(rightpane);
        // adds panels to content pane and sets to visible.
        add(panel1);
        add(panel2);
        setVisible(true);     
    }
    /**
     * This method empties text area, reads a file and adds its contents to the lists 
     * and adds the new (empty/larger) lists to the textarea and revalidates the content pane.
     * textArea: Instance of JTextArea
     * t: A temporary list node to traverse linked lists.
     * @throws FileNotFoundException an exception if file is not found.
     */
    public void createStuff() throws FileNotFoundException{
        left.setText(null);
        right.setText(null);
        readFile(unsorted, sorted);
        Date212Node t = unsorted.first.next;
        while(t != null){ // makes sure value is not null for run time errors.
            left.append(t.date.toString() + "\n");
            t = t.next;
        }
        // iterate through treemap
        for(Date212 entry : sorted.keySet()){
            right.append(entry.toString() + "\n");
        }
        validate();
    }
    /**
     * This method creates a JFIleChooser instance and allows the user to select
     * a file. If selected, the class variable file will point to it.
     * @return Returns int that either Open or Cancel generates in JFileChooser.
     */
    public int createFileChooser(){
        ch = new JFileChooser();
        status = ch.showOpenDialog(null);
        if( status == JFileChooser.APPROVE_OPTION){
            file = ch.getSelectedFile();
        }
        return status;
    }
    /**
     * This method builds the menubar and its items with ActionListeners to 
     * respond to a certain action.
     */
    private void createMenuBar(){
        bar = new JMenuBar();
        menu = new JMenu("File");
        open = new JMenuItem("Open");
        handler = new FileMenuHandler(this);
        open.addActionListener(handler);
        quit = new JMenuItem("Quit");
        quit.addActionListener(handler);
        sep = new JSeparator();
        edit = new JMenu("Edit");
        insert = new JMenuItem("Insert");
        edithandler = new EditMenuHandler(this);
        insert.addActionListener(edithandler);
        
        menu.add(open);
        menu.add(sep);
        menu.add(quit);
        edit.add(insert);
        bar.add(menu); 
        bar.add(edit);
        setJMenuBar(bar);
    }
    /**
     * This method takes the class filename, and Date212List's then reads the
     * file into them.
     * inputFile: Scanner class instance to read file lines.
     * tokens: Stores the string split by commas.
     * @param unsorted A LinkedList of unsorted dates to be written to.
     * @param sorted A TreeMap of sorted dates.
     * @throws FileNotFoundException an exception if file is not found.
     */
    public void readFile(UnsortedDate212List unsorted, TreeMap sorted) throws FileNotFoundException{
        Scanner inputFile = new Scanner(file);
        String line;
        while(inputFile.hasNext()){
            line = inputFile.nextLine();
            String[] tokens = line.split(",");
            for(int i = 0; i < tokens.length; i++){
                try{
                Date212 a = new Date212(tokens[i]);
                unsorted.add(a);
                sorted.put(a, a.getDate());
                }catch(Date212Exception ex){
                    System.out.println(ex);
                }
            }
        }  
    }
    /**
     * This method takes a Date212 object and adds them to both the UnsortedLinkedList and Treemap.
     * Then it clears the JTextArea's and reiterates through the list to get an updates JTextArea.
     * @param in A Date212 object to be added to the Text Areas.
     */
    public void addDate212(Date212 in){
            sorted.put(in, in.getDate());
            unsorted.add(in);
            left.setText(null);
            right.setText(null);
            Date212Node t = unsorted.first.next;
            while(t != null){ // makes sure value is not null for run time errors.
                left.append(t.date.toString() + "\n");
                t = t.next;
            }
            // iterate through treemap
            for(Date212 entry : sorted.keySet()){
                right.append(entry.toString() + "\n");
            }
            
            validate(); //refreshes content pane.
    }
}
