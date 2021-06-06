package com.company.graph;

import com.company.*;
import com.company.commands.*;
import com.company.serv.Connect;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener, KeyListener, MouseListener {

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
    UpdateFrame updateFrame;

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

        //System.out.println(table.getValueAt(0, 12));

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
        this.addMouseListener(this);

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

                    System.out.println(RemoveById.run((long) coolTable.getValueAt(index, 0), this.login, this.password).text);
                    coolTable.delete(index);
                    updateTableWithServer();
                    tableOptions();

                }
            }
            if (commandsBox.getSelectedItem().equals("Help")){
                JOptionPane.showMessageDialog(this, "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add {element} : добавить новый элемент в коллекцию\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id id : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_head : вывести первый элемент коллекции и удалить его\n" +
                        "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                        "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "remove_all_by_minimal_point minimalPoint : удалить из коллекции все элементы, значение поля minimalPoint которого эквивалентно заданному\n" +
                        "min_by_author : вывести любой объект из коллекции, значение поля author которого является минимальным\n" +
                        "count_less_than_minimal_point minimalPoint : вывести количество элементов, значение поля minimalPoint которых меньше заданного\n");

            }
            if (commandsBox.getSelectedItem().equals("Info")){
                JOptionPane.showMessageDialog(this, Info.run(this.login, this.password).text);

            }

            if (commandsBox.getSelectedItem().equals("Clear")){
                if (JOptionPane.showConfirmDialog(this, "Вы уверены? Эта команда удалит все ваши билеты") == 0){
                    System.out.println(Clear.run(this.login, this.password).text);
                    updateTableWithServer();
                    tableOptions();

                }

            }

            if (commandsBox.getSelectedItem().equals("Update")){
                int index = table.getSelectedRow();
                if (index != -1){
                    if (table.getValueAt(index, 12).equals(this.login)) {
                        this.updateFrame = new UpdateFrame(this, (long) coolTable.getValueAt(index, 0), index);
                    }else{
                        JOptionPane.showMessageDialog(this, "Вы не можете редактировать чужой билет");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Выберете билет");
                }
            }


        }
        if (addFrame != null) {
            if (e.getSource() == addFrame.getButton()) {
                //Нажата 'ok', можно получить список строк addFrame.getText()
                //Name, X, Y,  Price, Discount, Comment, TicketType, VenueName, VenueCapacity, VenueType

                Ticket ticket;
                try {
                    ticket = GetTicketFromFrame.getTicket(this, addFrame);
                }catch (ValueException exception){
                    return;
                }

                System.out.println(Add.run(ticket, this.login, this.password).text);

                updateTableWithServer();
                tableOptions();
                addFrame.dispose();

            }
        }
        if (updateFrame != null){
            if (e.getSource() == updateFrame.getButton()){

                Ticket ticket;
                try {
                    ticket = GetTicketFromFrame.getTicket(this, updateFrame);
                }catch (ValueException exception){
                    return;
                }


                System.out.println(UpdateId.run(updateFrame.ticketId, ticket, this.login, this.password).text);

                updateTableWithServer();
                tableOptions();
                updateFrame.dispose();

                table.isCellEditable( updateFrame.ticketRow, 0);

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

    @Override
    public void mouseClicked(MouseEvent e) {


        int x = e.getX();
        int y = e.getY();

        if ((e.getClickCount() == 2) && ( ((8  + panel.PANEL_X + panel.x <= x)&&(x <= 8  + panel.PANEL_X + panel.x + panel.IMAGE_WIDTH)) &&
                                          ((31 + panel.PANEL_Y + panel.y <= y)&&(y <= 31 + panel.PANEL_Y + panel.y + panel.IMAGE_HEIGHT)) ) ){


            int index = table.getSelectedRow();

            if (index != -1) {
                if (table.getValueAt(index, 12).equals(this.login)){
                    this.updateFrame = new UpdateFrame(this, (long) coolTable.getValueAt(index, 0), index);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Вы не можете редактировать чужой билет");
                }

            }


        }

    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
