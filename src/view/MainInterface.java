package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * Main interface
 * @author CK & R
 *
 * */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import database.Landing;


public class MainInterface extends JFrame{
    /*
     * Tab Main Interface Book Query Book Borrowing and Returning Account Management
     *
     * */
    //Tab
    public  JTabbedPane jTabbedPane = new JTabbedPane();
    // Main Interface
    private JPanel jPanel = new JPanel();
    // Label
    private JLabel jLabel = new JLabel("��ӭ��½ͼ�����ϵͳ");
    // font
    private Font font = new Font("����", Font.BOLD, 70);
    private Font font2 = new Font("����", Font.BOLD, 20);

    private Container con = getContentPane();
    public MainInterface(String user) {

        // Change window icon
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("img\\top.jpg");
        setIconImage(image);

        // Change background picture
        Icon i = new ImageIcon("img\\Main.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 1200, 800);
        jPanel.setLayout(null);
        jLabel.setFont(font);

        jLabel.setBounds(230, 50, 1000,200);
        jLabel.setForeground(Color.yellow);
        jPanel.add(jLabel);
        jPanel.add(Label);



        jTabbedPane.setFont(font2);
        jTabbedPane.add("Main Interface", jPanel);
        BookSearch search = new BookSearch();
        jTabbedPane.add("Search book",search.jLayeredPane);

        BorrowingReturning returning = new BorrowingReturning();
        returning.setUser(user);
        returning.setModel(search.model);
        jTabbedPane.add("Book borrowing and returning", returning.jLayeredPane);


        if(Landing.sureadmin(user)) {
            Admin admin = new Admin();
            admin.setUser(user);
            admin.setFrame(this);
            jTabbedPane.add("Account management", admin.jPanel2);

            BookAdmin bookAdmin = new BookAdmin();
            bookAdmin.setModel(search.model);
            jTabbedPane.add("Books management",bookAdmin.jPanel2);

        }else {
            AccountManagement management = new AccountManagement();
            management.setUser(user);
            management.setFrame(this);
            jTabbedPane.add("Account management", management.jPanel2);
        }



        con.add(jTabbedPane);
        // Cannot change the size of the frame
        setResizable(false);
        setTitle("Books management system");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}