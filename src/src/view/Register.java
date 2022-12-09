package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.database.Adduser;

/**
 * register interface
 *
 * @author CK & R
 *
 */
public class Register{

    /*
     * 7labels, 5 text box, a button and 7 pages
     */
    // labels
    private JLabel jLabel = new JLabel("Register: ");
    private JLabel jLabel2 = new JLabel("User Name: ");
    private JLabel jLabel3 = new JLabel("Student id: ");
    private JLabel jLabel4 = new JLabel("Name: ");
    private JLabel jLabel5 = new JLabel("Password: ");
    private JLabel jLabel6 = new JLabel("Confirm Password: ");
    private JLabel jLabel7 = new JLabel("length of password: 6~16 units, should not input space ");

    private String user;
    private String studentid;
    private String name;
    private String password;
    private String password2;
    // Font
    private Font font = new Font("Dialog", Font.BOLD, 40);
    private Font font2 = new Font("Dialog", Font.BOLD, 25);
    private Font font3 = new Font("Dialog", Font.BOLD, 20);
    private Font font4 = new Font("Dialog", Font.ITALIC, 13);
    private Font font5 = new Font("Dialog", Font.BOLD, 17);
    // Text box
    private JTextField field = new JTextField(18);
    private JTextField field2 = new JTextField(18);
    private JTextField field3 = new JTextField(18);
    private JPasswordField field4 = new JPasswordField(18);
    private JPasswordField field5 = new JPasswordField(18);

    // button
    private JButton button = new JButton("register");
    private JButton button2 = new JButton("return");
    // size
    private Dimension dimension = new Dimension(1000, 40);
    // panel
    private JPanel jPanel = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel jPanel4 = new JPanel();
    private JPanel jPanel5 = new JPanel();
    private JPanel jPanel6 = new JPanel();
    private JPanel jPanel7 = new JPanel();

    // frame
    private JFrame frame = new JFrame("register");

    public Register() {
        // window size
        frame.setSize(450, 1000);
        // empty
        frame.setLayout(null);
        // in middle
        frame.setLocationRelativeTo(null);
        // change the picture of the window
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(/*"img\\background.jpg"*/"");
        frame.setIconImage(image);

        addassembly();

        transparent();

        addEvent();
        // background picture
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 600, 1000);
        frame.add(Label);
        // cannot change the size
        frame.setResizable(false);
        // window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window visible
        frame.setVisible(true);
    }

    private void addassembly() {
        // add font
        jLabel.setFont(font);
        jLabel2.setFont(font2);
        jLabel3.setFont(font2);
        jLabel4.setFont(font2);
        jLabel5.setFont(font2);
        jLabel6.setFont(font2);
        jLabel7.setFont(font4);
        jLabel7.setForeground(Color.red);

        jLabel.setBounds(170, 30, 150, 60);
        button.setFont(font2);
        field.setFont(font3);
        field2.setFont(font3);
        field3.setFont(font3);
        field4.setFont(font3);
        field5.setFont(font3);
        field.setForeground(Color.blue);
        field2.setForeground(Color.blue);
        field3.setForeground(Color.blue);
        field4.setForeground(Color.blue);
        field5.setForeground(Color.blue);
        // button size
        button.setPreferredSize(dimension);
        button2.setFont(font5);
        button2.setBounds(2, 2, 100, 30);
        button2.setBackground(Color.cyan);
        button2.setOpaque(false);
        // add board
        jPanel.add(button2);
        jPanel.add(jLabel);
        jPanel2.add(jLabel2);
        jPanel2.add(field);
        jPanel3.add(jLabel3);
        jPanel3.add(field2);
        jPanel4.add(jLabel4);
        jPanel4.add(field3);
        jPanel5.add(jLabel5);
        jPanel5.add(field4);
        jPanel5.add(jLabel7);
        jPanel6.add(jLabel6);
        jPanel6.add(field5);
        jPanel7.add(button);
        jPanel.setLayout(null);
        // location of the board
        jPanel.setBounds(0, 0, 450, 110);
        jPanel2.setBounds(0, 150, 450, 80);
        jPanel3.setBounds(0, 250, 450, 80);
        jPanel4.setBounds(0, 350, 450, 80);
        jPanel5.setBounds(0, 450, 450, 80);
        jPanel6.setBounds(0, 550, 450, 80);
        jPanel7.setBounds(0, 650, 450, 80);
        // add into the window
        frame.add(jPanel);
        frame.add(jPanel2);
        frame.add(jPanel3);
        frame.add(jPanel4);
        frame.add(jPanel5);
        frame.add(jPanel6);
        frame.add(jPanel7);

    }

    private void transparent() {
        // transparent label
        jLabel.setOpaque(false);
        jLabel2.setOpaque(false);
        jLabel3.setOpaque(false);
        jLabel4.setOpaque(false);
        jLabel5.setOpaque(false);
        jLabel6.setOpaque(false);
        // transparent text box
        field.setOpaque(false);
        field2.setOpaque(false);
        field3.setOpaque(false);
        field4.setOpaque(false);
        field5.setOpaque(false);
        // transparent board
        jPanel.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel5.setOpaque(false);
        jPanel6.setOpaque(false);
        jPanel6.setOpaque(false);
        jPanel7.setOpaque(false);
    }

    private void addEvent() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                user = field.getText().trim();
                studentid = field2.getText().trim();
                name = field3.getText().trim();
                password = field4.getText().trim();
                password2 = field5.getText().trim();
                if (user.length() == 0) {
                    JOptionPane.showMessageDialog(null, "User Name cannot be empty", "Warning!", JOptionPane.WARNING_MESSAGE);
                    empty();
                } else if (studentid.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Student id cannot be empty", "Warning!", JOptionPane.WARNING_MESSAGE);
                    empty();
                } else if (name.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty", "Warning!", JOptionPane.WARNING_MESSAGE);
                    empty();
                } else if (password.length() < 6 || password.length() > 12) {
                    JOptionPane.showMessageDialog(null, "Password is invalid", "Warning!", JOptionPane.WARNING_MESSAGE);
                    empty();
                } else if (!(password.equals(password2))) {
                    JOptionPane.showMessageDialog(null, "Different with the first password", "Warning!", JOptionPane.WARNING_MESSAGE);
                    empty();
                } else {
                    if (Adduser.adduser(user, studentid, name, password)) {
                        JOptionPane.showMessageDialog(null, "Successful");
                        //frame.setVisible(false);
                        frame.dispose();
                        new Land();
                    } else {
                        empty();
                    }

                }
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                new Land();
            }
        });
    }

    private void empty() {
        field.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
    }
}