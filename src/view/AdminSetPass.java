package src.view;

import java.awt.Font;
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

import src.database.UpdateAdmin;

public class AdminSetPass extends JFrame{
    // panel
    private JPanel jPanel = new JPanel();
    // label
    private JLabel jLabel = new JLabel("User name: ");
    private JLabel jLabel2 = new JLabel("Password: ");
    // text box
    private JTextField field = new JTextField(22);
    private JPasswordField field2 = new JPasswordField(22);
    // font
    private Font font2 = new Font("Dialog", Font.BOLD, 22);
    private Font font3 = new Font("Dialog", Font.BOLD, 18);
    // button
    private JButton button = new JButton("Confirm");


    public AdminSetPass() {
        setSize(400, 450);
        setTitle("set password");
        // change background picture
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 400, 100);

        jLabel.setFont(font2);
        jLabel2.setFont(font2);
        field.setFont(font2);
        field2.setFont(font2);
        button.setFont(font3);

        jLabel.setBounds(50, 150, 100, 30);
        field.setBounds(150, 150, 185, 28);

        jLabel2.setBounds(50, 225, 100, 30);
        field2.setBounds(150, 225, 185, 28);
        button.setBounds(47, 300, 288, 35);


        //add event
        addEvent();

        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(jLabel2);
        jPanel.add(field2);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        add(Label);
        // cannot change the size of frame
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void addEvent() {

        // add confirm button event
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String user = field.getText().trim();
                String password = field2.getText().trim();
                if(UpdateAdmin.sureuser(user)) {
                    UpdateAdmin.updatepass(user, password);
                    JOptionPane.showMessageDialog(null, "Operation successfully");
                }else {
                    JOptionPane.showMessageDialog(null, "User name does not exist", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

}