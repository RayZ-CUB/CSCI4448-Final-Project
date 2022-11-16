package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.FindBook;
/**
 * Book query interface
 *
 * @author CK & R
 *
 */
public class BookSearch {
    /*
     * large label
     *
     * One drop-down box, one text box and one button
     *
     * A table
     */
    // layer
    public JLayeredPane jLayeredPane = new JLayeredPane();
    // lable
    private JLabel jLabel = new JLabel("search book");
    private JLabel jLabel2 = new JLabel("choose method to search: ");
    // text box
    private JTextField field = new JTextField(25);
    // size
    private Dimension dimension = new Dimension(220, 30);
    // drop down box
    private JComboBox<String> box = new JComboBox<String>();
    // button
    private JButton button = new JButton("Search");
    // table
    public DefaultTableModel model = new DefaultTableModel();
    // font
    private Font font = new Font("Dialog", Font.BOLD, 60);
    private Font font1 = new Font("Dialog", Font.BOLD, 25);
    private Font font2 = new Font("Dialog", Font.BOLD, 20);
    // save drop down options
    private String s;
    private String book;
    private int id;

    public BookSearch() {
        // change background picture
        Icon i = new ImageIcon("img\\booksearch.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 1200, 800);
        // label
        jLabel.setFont(font);
        jLabel.setBounds(485, 35, 800, 100);
        jLabel.setForeground(Color.cyan);

        jLabel2.setFont(font1);
        jLabel2.setBounds(180, 130, 250, 30);
        jLabel2.setForeground(Color.cyan);

        // drop down box
        box.setSize(dimension);
        box.addItem("����������");
        box.addItem("������������");
        box.addItem("�������߲���");
        box.addItem("������Ų���");
        box.setFont(font2);
        box.setBounds(180, 170, 200, 40);
        // box.setBackground(Color.cyan);
        box.setOpaque(false);

        // text box
        field.setFont(font2);
        field.setSize(dimension);
        field.setBackground(Color.cyan);
        field.setBounds(480, 173, 250, 35);
        field.setForeground(Color.cyan);
        field.setOpaque(false);

        // button
        button.setFont(font1);
        button.setBounds(850, 170, 100, 40);
        button.setForeground(Color.cyan);
        button.setBackground(Color.cyan);
        button.setOpaque(false);

        // table
        model.addColumn("Book id", new Vector<Integer>());
        model.addColumn("Category", new Vector<Integer>());
        model.addColumn("Book name", new Vector<Integer>());
        model.addColumn("Author", new Vector<Integer>());
        model.addColumn("Publisher", new Vector<Integer>());
        model.addColumn("Statement", new Vector<Integer>());
        JTable jTable = new JTable(model);

        JScrollPane pane = new JScrollPane(jTable);
        pane.setBounds(180, 250, 800, 400);

//		for(int k = 0; k < 30; k++) {
//			model.addRow(new Vector<Integer>());
//		}
        FindBook.allbook(model);

        JTableHeader head = jTable.getTableHeader();
        // header size
        head.setPreferredSize(new Dimension(head.getWidth(), 30));
        // font
        head.setFont(new Font("Dialog", Font.BOLD, 20));
        // head.setForeground(Color.cyan);
        head.setBackground(Color.cyan);
        // size of row width
        jTable.setRowHeight(30);
        // font
        jTable.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 17));
        // middle
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable.setDefaultRenderer(Object.class, renderer);

        //add event
        addEvent();

        // add layer windows
        jLayeredPane.add(Label, new Integer(0), 0);
        jLayeredPane.add(jLabel, new Integer(100), 1);
        jLayeredPane.add(jLabel2, new Integer(100), 2);
        jLayeredPane.add(box, new Integer(100), 3);
        jLayeredPane.add(field, new Integer(100), 4);
        jLayeredPane.add(button, new Integer(100), 5);
        jLayeredPane.add(pane, new Integer(100), 6);
    }

    private void addEvent() {

        //Get drop-down list value
        s = "Search by category";
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    s=(String)e.getItem();
                }
            }
        });

        //add search button event
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                model.setRowCount(0);
                if(s.equals("Search by category")) {
                    book=field.getText().trim();
                    FindBook.findcategory(model, book);
                }else if(s.equals("Search by book name")) {
                    book=field.getText().trim();
                    FindBook.findbookname(model, book);
                }else if(s.equals("Search by author")) {
                    book=field.getText().trim();
                    FindBook.findauthor(model, book);
                }else if(s.equals("Search by book id")) {
                    try {
                        id= Integer.parseInt(field.getText().trim());
                        FindBook.findbookid(model, id);
                    }catch(Exception e1) {
                    }
                }
                field.setText("");
            }
        });
    }
}