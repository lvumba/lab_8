package com.company.graph;
import com.company.languages.Languages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyPanel extends JPanel implements ActionListener {


    final int PANEL_X = 0;
    final int PANEL_Y = 50;
    final int PANEL_WIDTH = 989;
    final int PANEL_HEIGHT = 295;

    final int IMAGE_WIDTH = 789;
    final int IMAGE_HEIGHT = 295;

    String language[] = {"EN", "RU", "UKR", "GER", "ES"};


    JComboBox comboLanguage;



    String[] dann = new String[] {"---","--------","------","--------","----------","----","-------","---------------","-----","------"};
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

        this.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
        //this.setBackground(new Color(0xFF0000FF, true));
        enemy = new ImageIcon("D:/ИТМО/Programming/programs_2_sem/lab_8/client/src/com/company/graph/ItmoTicket.png").getImage();
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
        g1d.drawString(Obrezanie.obr(dann[0]), x + 48, y + 140);
        g1d.drawString(Obrezanie.obr(dann[1]), x + 185, y + 140);
        g1d.drawString(Obrezanie.obr(dann[2]), x + 310, y + 140);
        g1d.drawString(Obrezanie.obr(dann[3]), x + 430, y + 140);
        g1d.drawString(Obrezanie.obr(dann[4], 15), x + 570, y + 140);
        g1d.drawString(Obrezanie.obr(dann[5]), x + 55, y + 205);
        g1d.drawString(Obrezanie.obr(dann[6]), x + 185, y + 205);
        g1d.drawString(dann[7], x + 286, y + 205);
        g1d.drawString(Obrezanie.obr(dann[8]), x + 440, y + 205);
        g1d.drawString(Obrezanie.obr(dann[9]), x + 570, y + 205);
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
