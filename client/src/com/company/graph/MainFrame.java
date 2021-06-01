package com.company.graph;

import com.company.*;
import com.company.commands.Add;
import com.company.commands.RemoveById;
import com.company.commands.Show;
import com.company.serv.Connect;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener, KeyListener {

    String language[] = {"EN", "RU", "UKR", "GER", "ES"};
    String[] commandsName = new String[] {"Add", "Delete", "Update", "Clear", "Help", "Info"};
    String[] shapka = new String[] {"id", "Name", "X", "Y", "CreationDate", "Price", "Discount", "Comment",
                                    "TicketType", "VenueName", "Capacity", "VenueType", "CrName"};



    CoolTable coolTable;

    JComboBox comboBox = new JComboBox(language);
    JComboBox commandsBox = new JComboBox(commandsName);

    MyPanel panel = new MyPanel(comboBox);

    JButton activate = new JButton("");
    AddFrame addFrame;

    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable(coolTable);

    JLabel nik;
    JLabel text = new JLabel("Команды");

    String login;
    String password;

    public static void main(String[] args) {
        new Connect();

        new MainFrame("puppa", "123");

    }
    public void setLocation(){
        comboBox.setBounds(912, 530, 51, 28);
        commandsBox.setBounds(10, 530, 152, 28);

        nik.setBounds(10, 11, 67, 20);
        text.setBounds(10, 509, 80, 20);

        activate.setBounds(172, 530, 28, 28);
        scrollPane.setBounds(10, 380, 963, 118);



    }

    public void tableOptions(){

        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(123);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(69);
        table.getColumnModel().getColumn(7).setPreferredWidth(94);
        table.getColumnModel().getColumn(8).setPreferredWidth(80);
        table.getColumnModel().getColumn(9).setPreferredWidth(80);
        table.getColumnModel().getColumn(10).setPreferredWidth(70);
        table.getColumnModel().getColumn(11).setPreferredWidth(75);
        table.getColumnModel().getColumn(12).setPreferredWidth(94);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(8).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(9).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(10).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(11).setCellRenderer(new CellRenderer(this.login));
        table.getColumnModel().getColumn(12).setCellRenderer(new CellRenderer(this.login));

        //table.setGridColor(Color.BLACK);

    }

    public void updateTableWithServer(){

        Otvet otvet = Show.run(this.login, this.password);

        ArrayList<Ticket> tickets = otvet.tickets;

        this.coolTable = new CoolTable(tickets, this.shapka, this.login, this.password, panel);
        table.setModel(this.coolTable);

        scrollPane.setViewportView(table);

        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return null;
            }
        });

    }

    public void updateTable(){
        table.setModel(this.coolTable);
        scrollPane.setViewportView(table);

    }

    public void options(){
        commandsBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }

    public void colorize(){
        this.setBackground(new Color(255, 255, 255));
        table.setBackground(new Color(255, 255, 255));
        panel.setBackground(new Color(255, 255, 255));
    }
    public void addAction(){
        activate.addActionListener(this);
        commandsBox.addActionListener(this);
        this.addKeyListener(this);
    }

    public void addComponent(){

        this.add(comboBox);
        this.add(nik);
        this.add(commandsBox);
        this.add(text);
        this.add(activate);
        this.add(scrollPane);
        this.getContentPane().add(panel);


    }

    public MainFrame(String login, String password) {
        this.login = login;
        this.password = password;

        this.setFocusable(true);




        this.setBounds(100, 100, 989, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.nik = new JLabel(login);

        this.coolTable = new CoolTable(new ArrayList<Ticket>(), shapka, this.login, this.password, panel);


        setLocation();
        options();

        updateTableWithServer();
        tableOptions();

        colorize();
        addAction();
        addComponent();







        this.setVisible(true);




    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == activate) {
            if (commandsBox.getSelectedItem().equals("Add")) {
                addFrame = new AddFrame(this);
            }
            if (commandsBox.getSelectedItem().equals("Delete")){
                int index = table.getSelectedRow();
                if ((index != -1) && (coolTable.getValueAt(index, 12).equals(login))){

                    RemoveById.run((long) coolTable.getValueAt(index, 0), this.login, this.password);
                    coolTable.delete(index);
                    updateTableWithServer();
                    tableOptions();
                    //updateTable();
                }

            }
            if (commandsBox.getSelectedItem().equals("Update")){
                new MainFrame("puppa", "123");


            }


        }
        if (addFrame != null) {
            if (e.getSource() == addFrame.getButton()) {
                //Нажата 'ok', можно получить список строк addFrame.getText()
                //Name, X, Y,  Price, Discount, Comment, TicketType, VenueName, VenueCapacity, VenueType
                String[] str = addFrame.getTexts();

                String name;
                Long x;
                float y;
                Integer price;
                Long discount;
                String comment;
                TicketType ticketType;
                String venueName;
                Integer venueCapacity;
                VenueType venueType;

                name = str[0];

                try {
                    x = Long.parseLong(str[1]);
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(this, "Введите корректное значение x");
                    return;
                }

                try{
                    y = Float.parseFloat(str[2]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение y");
                    return;
                }
                try{
                    price = Integer.parseInt(str[3]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение Price");
                    return;
                }

                try{
                    discount = Long.parseLong(str[4]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение Discount");
                    return;
                }

                comment = str[5];

                try{
                    ticketType = TicketType.valueOf(str[6]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение TicketType");
                    return;
                }

                venueName = str[7];

                try{
                    venueCapacity = Integer.parseInt(str[8]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение VenueCapacity");
                    return;
                }

                try{
                    venueType = com.company.VenueType.valueOf(str[9]);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(this, "Введите корректное значение VenueType");
                    return;
                }

                Ticket ticket = new Ticket(name, new Coordinates(x, y), price, discount, comment, ticketType,
                                           new Venue(venueName, venueCapacity,venueType));

                System.out.println(Add.run(ticket, this.login, this.password).text);

                updateTableWithServer();
                tableOptions();
                addFrame.dispose();


            }

        }
    }



    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            new LoginFrame();
            this.dispose();

        }
    }
}
