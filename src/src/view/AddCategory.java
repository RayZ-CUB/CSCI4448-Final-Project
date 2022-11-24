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
import javax.swing.JTextField;

import src.database.Category;

public class AddCategory extends JFrame{
    // panel
    private JPanel jPanel = new JPanel();
    // label
    private JLabel jLabel = new JLabel("category name: ");
    // text box
    private JTextField field = new JTextField(22);
    // font
    private Font font2 = new Font("Dialog", Font.BOLD, 22);
    private Font font3 = new Font("Dialog", Font.BOLD, 18);
    // button
    private JButton button = new JButton("Confirm");


    public AddCategory() {
        setSize(400, 450);
        setTitle("add category");
        // change background picture
        Icon i = new ImageIcon(/*"img\\background.jpg"*/"");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 400, 100);

        jLabel.setFont(font2);
        field.setFont(font2);
        button.setFont(font3);

        jLabel.setBounds(50, 180, 100, 30);
        field.setBounds(150, 180, 185, 28);

        button.setBounds(47, 270, 288, 35);


        // add event
        addEvent();

        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        add(Label);
        // cannot change the size of the frame
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
                String s = field.getText().trim();
                if(Category.addcategory(s)) {
                    JOptionPane.showMessageDialog(null, "Operation successfully");
                }
            }
        });
    }

}