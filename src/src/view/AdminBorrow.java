package src.view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import src.database.FindBorrow;

/**
 * Administrator Borrowing Record Page
 *
 * @author CK & R
 */
public class AdminBorrow extends JFrame {
    /*
     *Background Picture Table
     *
     *Drop down box text box button
     */
    // panel
    private JPanel jPanel = new JPanel();
    // layer
    private JLayeredPane jLayeredPane = new JLayeredPane();
    // label
    private JLabel jLabel = new JLabel("Borrow record");
    private JLabel jLabel2 = new JLabel("Choose search method");
    // text box
    private JTextField field = new JTextField(20);
    // drop down box
    private JComboBox<String> box = new JComboBox<String>();
    // button
    private JButton button = new JButton("Search");
    // font
    private Font font = new Font("Dialog", Font.BOLD, 40);
    private Font font2 = new Font("Dialog", Font.BOLD, 20);
    private Font font3 = new Font("Dialog", Font.BOLD, 18);
    private Font font4 = new Font("Dialog", Font.BOLD, 17);
    // table
    public DefaultTableModel model = new DefaultTableModel();
    // save drop down options
    private String s;
    private int num;

    public AdminBorrow() {
        // change background picture
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 850, 100);
        setLayout(null);
        setSize(850, 650);
        setLocationRelativeTo(null);

        jLabel.setFont(font);
        jLabel.setBounds(345, 80, 400, 100);

        jLabel2.setFont(font4);
        jLabel2.setBounds(95, 140, 250, 30);

        // drop down box
        box.addItem("Search by User name");
        box.addItem("Search by book id");
        box.setFont(font3);
        box.setBounds(95, 175, 160, 30);
        // box.setBackground(Color.cyan);
        box.setOpaque(false);

        // text box
        field.setFont(font2);
        field.setBackground(Color.cyan);
        field.setBounds(325, 175, 200, 30);
        field.setOpaque(false);

        // button
        button.setFont(font2);
        button.setBounds(590, 173, 80, 35);
        button.setBackground(Color.cyan);
        button.setOpaque(false);

        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(box);
        jPanel.add(field);
        jPanel.add(button);
        // table
        model.addColumn("User name", new Vector<Integer>());
        model.addColumn("Book id", new Vector<Integer>());
        model.addColumn("Book name", new Vector<Integer>());
        model.addColumn("Borrow date", new Vector<Integer>());
        model.addColumn("Return date", new Vector<Integer>());
        model.addColumn("Statement", new Vector<Integer>());
        JTable jTable = new JTable(model);
        JScrollPane pane = new JScrollPane(jTable);
        pane.setBounds(80, 220, 690, 340);
        jLayeredPane.add(pane);

        // all borrow record
        FindBorrow.allborrow(model);

        setTitle("borrow record");
        // cannot change the size of the frame
        setResizable(false);
        // add event
        addEvent();
        JTableHeader head = jTable.getTableHeader();
        // set header size
        head.setPreferredSize(new Dimension(head.getWidth(), 30));
        // font
        head.setFont(new Font("Dialog", Font.BOLD, 20));
        // head.setForeground(Color.cyan);
        head.setBackground(Color.cyan);
        // size of row width
        jTable.setRowHeight(30);
        // font
        jTable.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 17));
        /* ���ñ����е����ݾ��� */
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable.setDefaultRenderer(Object.class, renderer);

        // jPanel.setBackground(Color.blue);
        jPanel.setBounds(0, 0, 850, 250);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        setContentPane(jLayeredPane);
        add(jPanel);
        add(Label);
        setVisible(true);
    }

    private void addEvent() {

        // Get drop-down list value
        s = "search by User name";
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    s = (String) e.getItem();
                }
            }
        });

        // add search button event
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                model.setRowCount(0);
                if (s.equals("search by User name")) {
                    try {
                        String user = field.getText().trim();
                        FindBorrow.userborrow(model, user);
                    } catch (Exception e1) {
                    }
                } else if (s.equals("search by book id")) {
                    try {
                        num = Integer.parseInt(field.getText().trim());
                        FindBorrow.bookidborrow(model, num);
                    } catch (Exception e1) {
                    }
                }
                field.setText("");
            }
        });
    }
}