package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.database.UpdateAdmin;

/**
 *Edit Permission Interface
 *
 * @author CK & R
 */
public class Permissions extends JFrame {

    //Panel
    private JPanel jPanel = new JPanel();
    //Label
    private JLabel jLabel = new JLabel("User Name: ");
    private JLabel jLabel2 = new JLabel("Options: ");
    //Text box
    private JTextField field = new JTextField(22);
    //Drop down box
    private JComboBox<String> box = new JComboBox<String>();
    //Font
    private Font font2 = new Font("Dialog", Font.BOLD, 22);
    private Font font3 = new Font("Dialog", Font.BOLD, 18);
    // button edit
    private JButton button = new JButton("Confirm");

    private String s;

    public Permissions() {
        setSize(400, 450);
        setTitle("Edit Permission");
        // change the background
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 400, 100);

        jLabel.setFont(font2);
        jLabel2.setFont(font2);
        field.setFont(font2);
        button.setFont(font3);

        jLabel.setBounds(50, 150, 100, 30);
        field.setBounds(150, 150, 185, 28);

        jLabel2.setBounds(50, 225, 100, 30);

        button.setBounds(47, 300, 288, 35);
        // Drop down box
        box.addItem("Delete User");
        box.addItem("Change to User");
        box.addItem("Add to be Manager");
        box.setFont(font3);
        box.setBounds(150, 225, 185, 28);
        // box.setBackground(Color.cyan);
        box.setOpaque(false);

        //Add event
        addEvent();

        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(jLabel2);
        jPanel.add(box);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        add(Label);
        // Cannot change the size of the window
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void addEvent() {

        // Get drop-down list value
        s = "Delete User";
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    s = (String) e.getItem();
                }
            }
        });

        // add confirm button event
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String user = field.getText().trim();
                if(UpdateAdmin.sureuser(user)) {
                    if (s.equals("Delete User")) {
                        UpdateAdmin.deleteuser(user);
                        JOptionPane.showMessageDialog(null, "Operation successfully");
                    } else if (s.equals("Change to be User")) {
                        UpdateAdmin.updateuser(user);
                        JOptionPane.showMessageDialog(null, "Operation successfully");
                    }else if(s.equals("Add to be Manager")) {
                        UpdateAdmin.updateadmin(user);
                        JOptionPane.showMessageDialog(null, "Operation successfully");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "User name does not exist", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

}