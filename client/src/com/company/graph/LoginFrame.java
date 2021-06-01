package com.company.graph;
import com.company.Otvet;
import com.company.commands.Show;
import com.company.serv.Connect;
import com.company.serv.Pak;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends JFrame implements ActionListener {



    JPanel panelLogo = new JPanel();
    JLabel logoL = new JLabel("");


    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton registerButton = new JButton("Register");
    JCheckBox showPassword = new JCheckBox("Show Password");




    Color fon = new Color(0, 71, 210, 255);
    Color textColor = new Color(213, 213, 215, 255);
    Color color3 = new Color(255,255,255, 255);

    Font font = new Font("", Font.BOLD, 15);

    public static void main(String[] args) {
        new Connect();
        new LoginFrame();
    }


    LoginFrame() {
        this.setTitle("Login Form");
        this.setVisible(true);
        this.setBounds(10, 10, 370, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        logoL.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/company/itmoL.png")));

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        options();
        colorize();


    }

    public void setLayoutManager() {
        this.setLayout(null);
    }

    public void options(){
        loginButton.setFocusable(false);
        resetButton.setFocusable(false);
        showPassword.setFocusable(false);
        registerButton.setFocusable(false);


        userTextField.setFont(this.font);
        passwordField.setFont(this.font);

        userLabel.setFont(this.font);
        passwordLabel.setFont(this.font);

        registerButton.setBorder(BorderFactory.createEtchedBorder());
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);

        panelLogo.setBorder(new EmptyBorder(0, 0, 0, 0));



    }


    public void colorize(){
        this.getContentPane().setBackground(this.fon);


        userLabel.setForeground(this.textColor);
        passwordLabel.setForeground(this.textColor);
        showPassword.setForeground(this.textColor);
        registerButton.setForeground(this.textColor);

        loginButton.setBackground(color3);
        resetButton.setBackground(color3);
        showPassword.setBackground(fon);
        registerButton.setBackground(fon);
        panelLogo.setBackground(fon);


    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        registerButton.setBounds(150, 350, 55, 19);
        panelLogo.setBounds(24, 55, 310, 53);




    }

    public void addComponentsToContainer() {
        this.add(userLabel);
        this.add(passwordLabel);
        this.add(userTextField);
        this.add(passwordField);
        this.add(showPassword);
        this.add(loginButton);
        this.add(resetButton);
        this.add(registerButton);
        getContentPane().add(panelLogo);
        panelLogo.add(logoL);



    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        registerButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText() + "";

            Otvet otvet = new Show().run( userText, pwdText);
            if (otvet.incorrect){
                JOptionPane.showMessageDialog(this, "Неверные логин или пароль");
            }else{
                new MainFrame(userText, pwdText);
                this.dispose();

            }


        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        }
        if(e.getSource() == registerButton){
            String userText = userTextField.getText();
            String pwdText = passwordField.getText() + "";
            Pak pak = new Pak();
            pak.login = userText;
            pak.password = pwdText;
            pak.register = true;
            Connect.send(pak);

            Otvet otvet = Connect.read(); // new Show().run("show", userText, pwdText);
            System.out.println(otvet.text);
            System.out.println(otvet.incorrect);

            if (otvet.incorrect){
                JOptionPane.showMessageDialog(this, "Такой логин уже существует");
            }else{
                JOptionPane.showMessageDialog(this, "Вы успешно зарегистрировались");
                new MainFrame(userText, pwdText);
                this.dispose();
            }


        }
    }

}

