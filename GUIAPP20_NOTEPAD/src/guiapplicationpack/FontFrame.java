
package guiapplicationpack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

class FontPanel extends JPanel implements ActionListener,MouseListener
{
    private JLabel sample;
    private JList lstFontName,lstFontStyle,lstFontSize;
    private JScrollPane spnFontName,spnFontStyle,spnFontSize;
    private JButton btnOk,btnCancel;
    private String fname[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private String fstyle[] = {"Plain","Bold","Italic","Bold Italic"};
    private String fsize[] = {"11","12","14","16","18","20","22","24","26","28","36","48","72"};
    private Font fnt = new Font("Courier New", 1, 14);
    private Font sampleFont = MainFrame.txtFont;
    private String fntName = sampleFont.getFamily();
    private int fntStyle = sampleFont.getStyle();
    private int fntSize = sampleFont.getSize();
    private FontFrame father = null;
    
    private JLabel makeLabel(String cap,int x,int y,int w,int h)
    {
        JLabel temp = new JLabel(cap);
        temp.setFont(new Font("Courier New", 1, 16));
        temp.setBounds(x,y,w,h);
        super.add(temp);
        return temp;
    }
    private JList makeList(String[] s,JScrollPane sp,int x,int w)
    {
        JList temp = new JList(s);
        temp.setFont(fnt);
        temp.addMouseListener(this);
        sp = new JScrollPane(temp);
        sp.setBounds(x,40,w,150);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(sp);
        return temp;
    }
    private JButton makeButton(String caption,int x,int y,int w,int h)
    {
        JButton temp = new JButton(caption);
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Verdana", 1, 12));
        temp.setMargin(new Insets(0,0,0,0));
        temp.addActionListener(this);
        super.add(temp);
        return temp;
    }
    public FontPanel(FontFrame fFrame)
    {
        father = fFrame;
        
        makeLabel("Name",10,10,180,30);
        lstFontName = makeList(fname,spnFontName,10,250);
        
        makeLabel("Style",270,10,110,30);
        lstFontStyle = makeList(fstyle,spnFontStyle,270,110);
        
        makeLabel("Size",390,10,50,30);
        lstFontSize = makeList(fsize,spnFontSize,390,50);
        
        sample = makeLabel("AaBbCcDd",10,200,320,100);
        sample.setFont(sampleFont);
        sample.setOpaque(true);
        sample.setBackground(Color.LIGHT_GRAY);
        sample.setForeground(Color.BLUE);
        sample.setHorizontalAlignment(JLabel.CENTER);
        sample.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2),"Sample",TitledBorder.LEFT,TitledBorder.CENTER,fnt));
        
        btnOk = makeButton("OK",340,217,100,30);
        btnCancel = makeButton("Cancel",340,265,100,30);
        
        lstFontName.setSelectedValue(fntName, true);
        lstFontStyle.setSelectedIndex(fntStyle);
        lstFontSize.setSelectedValue(String.valueOf(fntSize), true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object ob = e.getSource();
        if(ob== btnOk)
        {
            MainFrame.txtFont = sampleFont;
            MainFrame.txtEditor.setFont(sampleFont);
            father.dispose();
        }
        
        if( ob == btnCancel)
        {
            father.dispose();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        fntName = (String)lstFontName.getSelectedValue();
        fntStyle = lstFontStyle.getSelectedIndex();
        fntSize = Integer.parseInt((String)lstFontSize.getSelectedValue());
        sampleFont = new Font(fntName,fntStyle,fntSize);
        sample.setFont(sampleFont);
        
    }
    @Override
    public void mousePressed(MouseEvent e) 
    {
    }
    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }
    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }
    @Override
    public void mouseExited(MouseEvent e) 
    {
    }
    
    
}
public class FontFrame extends JDialog
{
    private FontPanel panel;
    public FontFrame()
    {
        panel = new FontPanel(this);
        panel.setLayout(new BorderLayout());
        add(panel);
    }
}