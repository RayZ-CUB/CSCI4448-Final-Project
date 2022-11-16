package view;

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
import javax.swing.table.DefaultTableModel;

import database.Book;
import database.FindBook;

public class DeleteBook extends JFrame {
    // panel
    private JPanel jPanel = new JPanel();
    // label
    private JLabel jLabel = new JLabel("Book id: ");
    private JLabel jLabel2 = new JLabel("Delete book: ");
    // text box
    private JTextField field = new JTextField(22);
    // font
    private Font font2 = new Font("Dialog", Font.BOLD, 24);
    private Font font3 = new Font("Dialog", Font.BOLD, 18);
    private Font font4 = new Font("Dialog", Font.BOLD, 40);
    // button
    private JButton button = new JButton("Confirm");

    // Table for updating the book search interface
    public DefaultTableModel model = new DefaultTableModel();

    public DeleteBook() {
        setSize(400, 450);
        setTitle("Delete book");
        // change background picture
        Icon i = new ImageIcon("img\\ah.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 400, 100);

        jLabel.setFont(font2);
        field.setFont(font3);
        button.setFont(font3);
        jLabel2.setFont(font4);

        jLabel2.setBounds(100, 110, 200, 60);

        jLabel.setBounds(55, 210, 100, 30);
        field.setBounds(140, 210, 185, 28);

        button.setBounds(47, 300, 288, 35);

        // add event
        addEvent();

        jPanel.add(jLabel2);
        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        add(Label);
        // cannot chang the size of frame
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    private void addEvent() {

        // Add confirm Button Event
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    int bookid = Integer.parseInt(field.getText().trim());
                    Book.deletebook(bookid);
                    model.setRowCount(0);
                    FindBook.allbook(model);
                    JOptionPane.showMessageDialog(null, "Operation successfully");
                } catch (Exception e1) {

                }

            }
        });
    }

}