package com.company.graph;
import com.company.languages.Languages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 989;
    final int PANEL_HEIGHT = 310;

    String language[] = {"EN", "RU", "UKR", "GER", "ES"};


    JComboBox comboLanguage;



    String[] dann = new String[] {"---","---","---","---","---","---","---","---","---","---"};
    String[] naDan = new String[] {"---","---","---","---","---","---","---","---","---","---"};




    public void addComponent() {
        this.add(comboLanguage);

    }

    Image enemy;
    Timer timer;

    int X0 = 0;
    boolean Stchetchik = false;
    float Xvector = 0;
    float Yvector = 5;// нам не нужен, но можно оставить

    float ax;
    float ax_0 = 1;

    float x = 100;
    float y = 0;

    MyPanel(JComboBox comboLanguage) {

        this.comboLanguage = comboLanguage;

        this.setBounds(0, 40, PANEL_WIDTH, PANEL_HEIGHT);
        //this.setBackground(new Color(0xFF0000FF, true));
        enemy = new ImageIcon("D:/ИТМО/Programming/programs_2_sem/lab_7/client/src/com/company/graph/3.png").getImage();
        timer = new Timer(1, this);
        timer.start();


        this.comboLanguage.addActionListener(this);

        addComponent();

    }

    public void paint(Graphics g) {

        super.paint(g);//Печатает задний экран

        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g1d = (Graphics2D) g;

        g2d.drawImage(enemy, Math.round(x), Math.round(y), null);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(Languages.getId(), x + 55, y + 120);
        g2d.drawString(Languages.getNAME(), x + 185, y + 120);
        g2d.drawString(Languages.getPRICE(), x + 310, y + 120);
        g2d.drawString(Languages.getDISCOUNT(), x + 430, y + 120);
        g2d.drawString(Languages.getCOMMENTS(), x + 560, y + 120);
        g2d.drawString(Languages.getTicketType(), x + 28, y + 185);
        g2d.drawString(Languages.getVENUE(), x + 185, y + 185);
        g2d.drawString(Languages.getDATE(), x + 310, y + 185);
        g2d.drawString(Languages.getTYPE(), x + 422, y + 185);
        g2d.drawString(Languages.getCAPASITY(), x + 560, y + 185);


        g1d.setFont(new Font("Arial", Font.BOLD, 17));
        g1d.setColor(Color.white);
        g1d.drawString(dann[0], x + 40, y + 140);
        g1d.drawString(dann[1], x + 185, y + 140);
        g1d.drawString(dann[2], x + 310, y + 140);
        g1d.drawString(dann[3], x + 430, y + 140);
        g1d.drawString(dann[4], x + 570, y + 140);
        g1d.drawString(dann[5], x + 55, y + 205);
        g1d.drawString(dann[6], x + 185, y + 205);
        g1d.drawString(dann[7], x + 286, y + 205);
        g1d.drawString(dann[8], x + 440, y + 205);
        g1d.drawString(dann[9], x + 570, y + 205);
        g1d.drawString(Languages.getCOMMANDS() + ":", X0 = 20, y + 490);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Languages.language = comboLanguage.getSelectedItem().toString();



        if ((x > 1000) ) {
            x = -789;
            ax = -ax_0;
            Stchetchik = true;
            dann = naDan.clone();
        }

        if (x < -800){
            ax = ax_0;
        }


        if ((x + ax > 99)  & (Stchetchik == true)) {
            x = 100;
            Xvector = 0;
            ax = 0;
            Stchetchik = false;
        }

        x = x + Xvector;
        Xvector += ax;
        repaint();

    }
}
