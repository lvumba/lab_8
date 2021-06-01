package com.company;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class PostgreSQL {

    private Connection connection;

    private String tableName;



    public PostgreSQL(String tableName) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        this.tableName = tableName;

        try {
            connection = DriverManager.getConnection(jdbcURL, "postgres", "123");
            System.out.println("Connection to database is done");
        } catch (SQLException e) {
            System.out.println("Something was wrong with connection to database. Exiting...");
            e.printStackTrace();
            System.exit(-1);

        }
    }

    public void add(Ticket ticket) throws SQLException{

        String request = "insert into " + this.tableName + " VALUES (nextval('id'),?,?,?,?,?,?,?,?,?,?,?,?)";


        PreparedStatement statement = connection.prepareStatement(request);

        statement.setString(1, ticket.getName());
        statement.setLong(2, ticket.getCoordinates().getX());
        statement.setFloat(3,ticket.getCoordinates().getY()) ;
        statement.setDate(4,new java.sql.Date(ticket.getCreationDate().getTime()));
        statement.setInt(5,ticket.getPrice() );
        statement.setFloat(6, ticket.getDiscount() );
        statement.setString(7,ticket.getComment());
        statement.setString(8, ticket.getType() + "");

        statement.setString(9, ticket.getVenue().getName());
        statement.setInt(10, ticket.getVenue().getCapacity());
        statement.setString(11, ticket.getVenue().getType() + "");
        statement.setString(12, ticket.getCreatorName());
        statement.executeUpdate();
        statement.close();

        ticket.setId(this.lastId());





    }




    public ArrayList<Ticket> show(){
        ArrayList<Ticket> array = new ArrayList<Ticket>();

        try {

            String query = "SELECT * FROM " + this.tableName + " ORDER BY id";

            ResultSet res = connection.createStatement().executeQuery(query);


            while (res.next()) {
                Long id  = res.getLong(1);
                String name = res.getString(2);
                Coordinates coordinates = new Coordinates();
                coordinates.setX(res.getLong(3));
                coordinates.setY(res.getFloat(4));

                java.sql.Date date = res.getDate(5);

                Integer price = res.getInt(6);
                Long discount = res.getLong(7);
                String comment = res.getString(8);
                TicketType type = TicketType.valueOf(res.getString(9));


                String Vname = res.getString(10);
                Integer capacity = res.getInt(11);
                VenueType Vtype = VenueType.valueOf(res.getString(12));

                String creatorName = res.getString(13);


                Ticket ticket = new Ticket(name, coordinates, price, discount, comment, type, new Venue(Vname, capacity,Vtype));
                ticket.setCreatorName(creatorName);
                ticket.setId(id);

                ticket.setCreationDate(date);

                array.add(ticket);


            }

        }catch (SQLException e) {
            System.out.println("Ошибка от базы данных");
            e.printStackTrace();
        }

        return array;

    }

    public Long lastId() throws SQLException {
        String query = "SELECT * FROM " + this.tableName + " ORDER BY 1 DESC, id DESC LIMIT 1;";
        ResultSet res = connection.createStatement().executeQuery(query);
        res.next();
        return res.getLong(1);


    }

    public HashMap<String, String> showLog_pas(){

        HashMap<String, String> map = new HashMap<>();
        try {

            String query = "SELECT * FROM " + this.tableName;
            ResultSet res = connection.createStatement().executeQuery(query);

            while (res.next()) {
                map.put(res.getString(1), res.getString(2));

            }


        }catch (SQLException e) {
            System.out.println("Ошибка от базы данных");
            e.printStackTrace();

        }

        return map;

    }


    public void addLog_pass(String login, String password)  {
        String request = "insert into " + this.tableName + " VALUES (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(request);

            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }




    }

    public boolean remove(long id){
        //String request = "DELETE FROM " + this.tableName + " WHERE 1 = " + id;
        String request  = "DELETE from " +this.tableName + " WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (PSQLException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public void clear(){
        String request  = "TRUNCATE TABLE tti";
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean update(long id, Ticket ticket){
        String request  = "update tti SET  name=?, coordinateX=?, coordinateY=?, creationDate=?, price=?, discount=?, comment=?," +
                "ticketType=?, VenueN=?, Vcapacity=?, Vtype=?, creatorName=? WHERE id=?";

        //String request  = "update tti  VALUES(?,?,?,?,?,?,?,?,?,?,?,?) WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, ticket.getName());
            statement.setLong(2, ticket.getCoordinates().getX());
            statement.setFloat(3, ticket.getCoordinates().getY());
            statement.setDate(4, new java.sql.Date(ticket.getCreationDate().getTime()));
            statement.setInt(5, ticket.getPrice());
            statement.setLong(6, ticket.getDiscount());
            statement.setString(7, ticket.getComment());
            statement.setString(8, ticket.getType().toString());
            statement.setString(9, ticket.getVenue().getName());
            statement.setInt(10, ticket.getVenue().getCapacity());
            statement.setString(11, ticket.getVenue().getType().toString());
            statement.setString(12, ticket.getCreatorName());
            statement.setLong(13, id);

            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }






}
