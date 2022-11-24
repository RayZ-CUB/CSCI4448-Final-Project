package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import src.database.ConnectDatabase;
/**
 *Account information interface
 *
 */
public class AdminAccount extends JFrame {
    // panel
    private JPanel jPanel = new JPanel();
    // layer
    private JLayeredPane jLayeredPane = new JLayeredPane();
    // label
    private JLabel jLabel = new JLabel("Account information");
    // font
    private Font font = new Font("Dialog", Font.BOLD, 40);
    // table
    public DefaultTableModel model = new DefaultTableModel();

    public AdminAccount() {
        // change background picture
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 800, 100);
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);

        jLabel.setFont(font);
        jLabel.setBounds(315, 80, 400, 100);

        jPanel.add(jLabel);
        // table
        model.addColumn("User name", new Vector<Integer>());
        model.addColumn("Student id", new Vector<Integer>());
        model.addColumn("Name", new Vector<Integer>());
        model.addColumn("if administer or not", new Vector<Integer>());
        JTable jTable = new JTable(model);
        JScrollPane pane = new JScrollPane(jTable);
        pane.setBounds(80, 160, 640, 350);
        jLayeredPane.add(pane);

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
        // middle
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable.setDefaultRenderer(Object.class, renderer);

        borrow(model);

        jPanel.setBounds(0, 0, 800, 200);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        setContentPane(jLayeredPane);
        setTitle("Account information");
        // cannot change the size of frame
        setResizable(false);
        add(jPanel);
        add(Label);
        setVisible(true);
    }

    private void borrow(DefaultTableModel model) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from usertable";
        try {
            preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
            while (rs.next()) {
                String user = rs.getString(1);
                String studentid = rs.getString(2);
                String name = rs.getString(3);
                int flag = rs.getInt(5);
                String admin;
                if (flag == 1) {
                    admin = "yes";
                } else {
                    admin = "no";
                }
                model.addRow(new Vector<>(Arrays.asList(user, studentid, name, admin)));
            }
            con.close();
        } catch (SQLException e) {
        }
    }
}