package com.company.graph;

import com.company.Ticket;
import com.company.TicketType;
import com.company.VenueType;
import com.company.commands.RemoveById;
import com.company.commands.UpdateId;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CoolTable extends AbstractTableModel {


    ArrayList<Ticket> data;
    String[] shapka;

    int width = 13;

    String userNik;
    String userPsw;

    MyPanel panel;
    int lastRowIndex;

    public CoolTable(ArrayList<Ticket> data, String[] shapka, String userNik, String userPsw, MyPanel panel){
        if (shapka.length != width){
            throw new ValueException("Неправильная шапка");
        }

        this.shapka = shapka;
        this.data = data;
        this.userNik = userNik;
        this.userPsw = userPsw;
        this.panel = panel;
        this.lastRowIndex = -1;

    }


    public void add(Ticket ticket){
        data.add(ticket);
    }
    public void delete(int index){
        if (index < data.size() ) {
            data.remove(index);
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {


        if (this.lastRowIndex != rowIndex) {
            panel.naDan[0] = data.get(rowIndex).getId() + "";
            panel.naDan[1] = data.get(rowIndex).getName() + "";
            panel.naDan[2] = data.get(rowIndex).getPrice() + "";
            panel.naDan[3] = data.get(rowIndex).getDiscount() + "";
            panel.naDan[4] = data.get(rowIndex).getComment() + "";
            panel.naDan[5] = data.get(rowIndex).getType() + "";
            panel.naDan[6] = data.get(rowIndex).getVenue().getName() + "";
            panel.naDan[7] = data.get(rowIndex).getCreationDate() + "";
            panel.naDan[8] = data.get(rowIndex).getVenue().getType() + "";
            panel.naDan[9] = data.get(rowIndex).getVenue().getCapacity() + "";

            panel.Stchetchik = false;
            panel.Xvector = 5;
            panel.ax = panel.ax_0;

        }

        this.lastRowIndex = rowIndex;
        return (columnIndex != 12) && (columnIndex != 0) && (columnIndex != 4) && (data.get(rowIndex).getCreatorName().equals(this.userNik));
    }

    @Override
    public String getColumnName(int column) {
        return shapka[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return width;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).toObjects()[columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

        if (! data.get(rowIndex).getCreatorName().equals(userNik) ){
            super.setValueAt(value, rowIndex, columnIndex);
            return;
        }

        try {
            boolean anim = false;
            switch (columnIndex) {
                case 0:
                    break;
                case 1:
                    data.get(rowIndex).setName(value.toString());
                    panel.naDan[1] = value.toString();
                    anim = true;
                    break;
                case 2:
                    data.get(rowIndex).getCoordinates().setX(Long.parseLong(value.toString()));
                    break;
                case 3:
                    data.get(rowIndex).getCoordinates().setY(Long.parseLong(value.toString()));
                    break;
                case 4:
                    break;
                case 5:
                    data.get(rowIndex).setPrice(Integer.parseInt(value.toString()));
                    panel.naDan[2] = value.toString();
                    anim = true;
                    break;
                case 6:
                    data.get(rowIndex).setDiscount(Long.parseLong(value.toString()));
                    panel.naDan[3] = value.toString();
                    anim = true;
                    break;
                case 7:
                    data.get(rowIndex).setComment(value.toString());
                    panel.naDan[4] = value.toString();
                    anim = true;
                    break;
                case 8:
                    data.get(rowIndex).setType(TicketType.valueOf(value.toString()));
                    panel.naDan[5] = value.toString();
                    anim = true;
                    break;
                case 9:
                    data.get(rowIndex).getVenue().setName(value.toString());
                    panel.naDan[6] = value.toString();
                    anim = true;
                    break;
                case 10:
                    data.get(rowIndex).getVenue().setCapacity(Integer.parseInt(value.toString()));
                    panel.naDan[9] = value.toString();
                    anim = true;
                    break;
                case 11:
                    data.get(rowIndex).getVenue().setType(VenueType.valueOf(value.toString()));
                    panel.naDan[8] = value.toString();
                    anim = true;
                    break;
                case 12:
                    break;
            }

            if (anim) {
                panel.Stchetchik = false;
                panel.Xvector = 5;
                panel.ax = panel.ax_0;
            }


        } catch (IllegalArgumentException e){

        }

        UpdateId.run(data.get(rowIndex).getId(), data.get(rowIndex), this.userNik, this.userPsw);

        super.setValueAt(value, rowIndex, columnIndex);
    }

}
