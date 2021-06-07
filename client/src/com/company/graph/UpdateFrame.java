package com.company.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateFrame extends JFrame{

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_7;
    private JTextField textField_8;


    JButton btnNewButton;

    ActionListener actionListener;
    long ticketId;
    int ticketRow;

    Color fon = new Color(0, 71, 210, 255);
    Color textColor = new Color(255, 255, 255, 255);


    public UpdateFrame(ActionListener actionListener, long ticketId, int ticketRow) {
        this.actionListener = actionListener;
        this.ticketId = ticketId;
        this.ticketRow = ticketRow;
        this.setTitle("Update ticket " + ticketId);

        initialize();
        this.getContentPane().setBackground(fon);
        this.setVisible(true);

    }
    String[] tickettype = {
            "VIP",
            "USUAL",
            "BUDGETARY"
    };

    String[] ventype = {
            "BAR",
            "LOFT",
            "OPEN_AREA"
    };

    JComboBox comboBox = new JComboBox(tickettype);
    JComboBox comboBox1 = new JComboBox(ventype);

    public void addComponent() {
        this.add(comboBox);
        this.add(comboBox1);
    }

    private void setLocation() {
        comboBox.setBounds(160, 212, 86, 20);
        comboBox1.setBounds(160, 305, 86, 20);
    }
    private void initialize(){
        this.setBounds(100, 100, 364, 468);





        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(84, 26, 60, 14);
        lblNewLabel.setForeground(textColor);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("X");
        lblNewLabel_1.setBounds(84, 57, 60, 14);
        lblNewLabel_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Y");
        lblNewLabel_2.setBounds(84, 88, 60, 14);
        lblNewLabel_2.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("Price");
        lblNewLabel_1_1.setBounds(84, 119, 60, 14);
        lblNewLabel_1_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_3 = new JLabel("Discount");
        lblNewLabel_3.setBounds(84, 150, 60, 14);
        lblNewLabel_3.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_1_2 = new JLabel("Comment");
        lblNewLabel_1_2.setBounds(84, 181, 60, 14);
        lblNewLabel_1_2.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_2_1 = new JLabel("TicketType");
        lblNewLabel_2_1.setBounds(84, 212, 68, 14);
        lblNewLabel_2_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_2_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("VenueName");
        lblNewLabel_1_1_1.setBounds(84, 243, 72, 14);
        lblNewLabel_1_1_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_3_1 = new JLabel("Capacity");
        lblNewLabel_3_1.setBounds(84, 274, 60, 14);
        lblNewLabel_3_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_3_1);

        JLabel lblNewLabel_1_2_1 = new JLabel("VenueType");
        lblNewLabel_1_2_1.setBounds(84, 305, 68, 14);
        lblNewLabel_1_2_1.setForeground(textColor);
        this.getContentPane().add(lblNewLabel_1_2_1);

        //Расположение и размер кнопок

        textField = new JTextField();
        textField.setBounds(160, 26, 86, 20);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(160, 57, 86, 20);
        this.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(160, 88, 86, 20);
        this.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(160, 119, 86, 20);
        this.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(160, 150, 86, 20);
        this.getContentPane().add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(160, 181, 86, 20);
        this.getContentPane().add(textField_5);

        setLocation();
        addComponent();

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(160, 243, 86, 20);
        this.getContentPane().add(textField_7);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(160, 274, 86, 20);
        this.getContentPane().add(textField_8);

        btnNewButton = new JButton("ok");
        btnNewButton.setBounds(114, 356, 89, 23);
        btnNewButton.addActionListener(actionListener);
        this.getContentPane().add(btnNewButton);
    }

    public JButton getButton(){
        return btnNewButton;
    }

    public String[] getTexts(){
        String[] s = new String[10];
        s[0]= textField.getText();
        s[1]= textField_1.getText();
        s[2]= textField_2.getText();
        s[3]= textField_3.getText();
        s[4]= textField_4.getText();
        s[5]= textField_5.getText();
        s[6]= comboBox.getSelectedItem().toString();
        s[7]= textField_7.getText();
        s[8]= textField_8.getText();
        s[9]= comboBox1.getSelectedItem().toString();
        return s;


    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton){
            System.out.println(111);
        }
    }*/
}


