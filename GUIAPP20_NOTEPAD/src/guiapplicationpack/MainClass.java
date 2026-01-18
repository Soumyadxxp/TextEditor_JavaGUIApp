
package guiapplicationpack;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

class MainFrame extends JFrame
{
    protected static Font txtFont = new  Font("Courier New",1,18);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile,menuEdit,menuFormat,menuWindow;
    private JMenuItem[] fileMenu = new JMenuItem[9];
    private JMenuItem[] editMenu = new JMenuItem[12];
    private JMenuItem[] formatMenu = new JMenuItem[3];
    private JMenuItem[] windowMenu = new JMenuItem[3];
    private String[] fileStr = {"New", "Open", "Save", "Save As", "Page Setup", "Print Preview", "Print", "Close", "Exit"};
    private String[] editStr = {"Undo", "Redo", "Cut", "Copy", "Paste", "Delete", "Find", "Find Next", "Replace", "Go To", "Select All", "Date/Time"};
    private String[] formatStr = {"Font", "Color", "Wrap Text"};
    private String[] WindowStr = {"Window1", "Window2", "Window3"};
    protected static JTextArea txtEditor;
    private JScrollPane spnEditor;
    private JColorChooser colChooser;
    private JDialog colChooserDlg;
    
    private JMenu makeMenu(String cap)
    {
        JMenu temp = new JMenu(cap);
        temp.setFont(new Font("Verdana",1,12));
        menuBar.add(temp);
        return temp;
    }
    
    private JMenuItem makeMenuItem(String cap,JMenu menu)
    {
        JMenuItem temp = new JMenuItem(cap,new ImageIcon("p1.gif"));
        temp.setFont(new Font("Verdana", 1, 12));
        temp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object ob = e.getSource();
                if(ob == fileMenu[0]) //New
                {
                    txtEditor.setText("");
                    spnEditor.setVisible(true);
                }
                else if(ob == fileMenu[1]) // Code for File Menu
                {}
                else if(ob == fileMenu[2]) //
                {}
                else if(ob == fileMenu[3]) //
                {}
                else if(ob == fileMenu[4]) //
                {}
                else if(ob == fileMenu[5]) //
                {}
                else if(ob == fileMenu[6]) //
                {}
                else if(ob == fileMenu[7]) //
                {
                    spnEditor.setVisible(false);
                }
                else if(ob == fileMenu[8]) //
                {
                    System.exit(0);
                }
                else if(ob == editMenu[0]) // Code for Edit Menu
                {
                }
                else if(ob == editMenu[1]) //
                {
                }
                else if(ob == editMenu[2]) //
                {
                }
                else if(ob == editMenu[3]) //
                {
                }
                else if(ob == editMenu[4]) //
                {
                }
                else if(ob == editMenu[5]) //
                {
                }
                else if(ob == editMenu[6]) //
                {
                }
                else if(ob == editMenu[7]) //
                {
                }
                else if(ob == editMenu[8]) //
                {
                }
                else if(ob == editMenu[9]) //
                {
                }
                else if(ob == editMenu[10]) //
                {
                }
                else if(ob == editMenu[11]) //
                {
                }
                else if(ob == formatMenu[0]) // Font
                {
                    FontFrame frame = new FontFrame();
                    frame.setTitle("Font");
                    frame.setAlwaysOnTop(true);
                    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    frame.setSize(470, 350);
                    frame.setLocationRelativeTo(null);
                    
                    frame.setVisible(true);
                }
                else if(ob == formatMenu[1]) // Color
                {
                    colChooserDlg.setVisible(true);
                }
                else if(ob == formatMenu[2]) // Wrap Text
                {
                }
                
            }
        });
        menu.add(temp);
        return temp;
    }
    public MainFrame()
    {
        super.setJMenuBar(menuBar);
        menuFile = makeMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F); //VK means virtual key, Shortcut Key for alt key, Direct Interfacing(Open app, then open menu then new file, etc.)
        menuEdit = makeMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E); //Shortcut Key
        menuFormat = makeMenu("Format");
        menuFormat.setMnemonic(KeyEvent.VK_R); //Shortcut Key
        menuWindow = makeMenu("Window");
        menuWindow.setMnemonic(KeyEvent.VK_W); //Shortcut Key
        
        for(int i=0; i<fileMenu.length; i++)
        {
            fileMenu[i] = makeMenuItem(fileStr[i], menuFile);
            if(i==1||i==3||i==6) menuFile.addSeparator();
        }
        fileMenu[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)); // Hot Key  i.e CTRL, Indirect Interfacing
        fileMenu[7].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        fileMenu[8].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        
        for(int i=0; i<editMenu.length; i++) // Array for using For loops , 0,1,2,3,4,etc.
        {
            editMenu[i] = makeMenuItem(editStr[i], menuEdit);
            if(i==1||i==4||i==9) menuEdit.addSeparator();
        }
        for(int i=0; i<formatMenu.length; i++)
        {
            formatMenu[i] = makeMenuItem(formatStr[i], menuFormat);
            if(i==1) menuFormat.addSeparator();
        }
        for(int i=0; i<windowMenu.length; i++)
        {
            windowMenu[i] = makeMenuItem(WindowStr[i], menuWindow);
        }
        colChooser = new JColorChooser();
        ActionListener act = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                txtEditor.setForeground(colChooser.getColor());
            }
        };
        colChooserDlg = JColorChooser.createDialog(null, "Color Palette", false, colChooser, act, null);
        
        txtEditor = new JTextArea();
        txtEditor.setFont(txtFont);
        spnEditor = new JScrollPane(txtEditor);
        spnEditor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spnEditor.setBounds(10,10,670,480);
        spnEditor.setVisible(false);
        add(spnEditor);
    }
}
public class MainClass
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Notepad");
    }
}
