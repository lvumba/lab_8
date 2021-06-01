package com.company.commands;

import com.company.*;

import java.util.Scanner;

/**
 * Реализация ввода данных от пользователя. В случае, если пользователь ничего не ввёл, возвращается null
 * Пользователь не сможет ввести что-то неправильно
 * Все функции принимают String s -  приглашение к вводу, которое будет показанно пользователю
 */
public class Input {

    private static Scanner in = new Scanner(System.in);


    /**
     * Получает от пользователя число
     * @param s
     * @return число
     */
    public static Integer Integer(String s){
        while (true){
            try {
                System.out.print(s);
                String inn = in.nextLine();
                if (inn.isEmpty()){
                    return new Integer(0);
                }
                return new Integer(inn);
            } catch (NumberFormatException e){
                System.out.println("Вы ввели некорректное значение");
            }

        }


    }

    /**
     * Возвращает строку, введённую пользователем
     * @param s
     * @return
     */

    public static String String(String s){
        System.out.print(s);
        String inn = in.nextLine();


        return inn;
    }

    /**
     * Получает от пользователя число Long
     * @param s
     * @return
     */

    public static Long Long(String s){
        while (true){
            try {
                System.out.print(s);
                String inn = in.nextLine();
                if (inn.isEmpty()){
                    return new Long(0);
                }
                return new Long(inn);
            } catch (NumberFormatException e){
                System.out.println("Вы ввели некорректное значение");
            }

        }
    }

    /**
     * Получает от пользователя тип билета
     * @param s
     * @return object enum TicketType
     * @see TicketType
     */

    public static TicketType TicketType(String s){



        while (true){
            System.out.println("Варианты:");
            for (TicketType value: TicketType.values()){
                System.out.println(value);
            }

            try {
                System.out.print(s);
                String inn = in.nextLine();

                return TicketType.valueOf(inn.toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Вы ввели некорректное значение");
            }

        }


    }

    /**
     * Получает от пользователя VenueType
     * @see VenueType
     * @param s
     * @return
     */
    public static VenueType VenueType(String s){
        System.out.println("Варианты:");
        for (VenueType value: VenueType.values()){
            System.out.println(value);
        }

        while (true){
            try {
                System.out.print(s);
                String inn = in.nextLine();

                return VenueType.valueOf(inn.toUpperCase());

            } catch (IllegalArgumentException e){
                System.out.println("Вы ввели некорректное значение");
            }

        }
    }

    /**
     * Получает от пользователя Venue
     * @see Venue
     * @param s
     * @return
     */
    public static Venue Venue(String s){
        System.out.print(s);

        String Vname = Input.String("Введите venue name: ");
        Integer Vcapacity = Input.Integer("Введите venue capacity: ");
        VenueType Vtype = Input.VenueType("Введите venue type: ");

        return new Venue(Vname, Vcapacity, Vtype);

    }

    /**
     * Получает от пользователя Ticket
     * @see Ticket
     * @param s
     * @return
     */
    public static Ticket Ticket(String s){
        System.out.print(s);

        String name = Input.String("Введите name: ");
        Integer price = Input.Integer("Введите price: ");
        Long discount = Input.Long("Введите discount: ");
        String comment = Input.String("Введите comment: ");
        TicketType type = Input.TicketType("Введите type: ");

        Venue venue = Input.Venue("");

        return new Ticket(name,new Coordinates(), price, discount, comment, type, venue);

    }


}
