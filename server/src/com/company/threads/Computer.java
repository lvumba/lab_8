package com.company.threads;

import com.company.*;
import com.company.commands.*;
import com.company.serv.Pak;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Computer implements Runnable{
    Sender sender;
    MyCollection collection;

    Security security;

    Pak lastPak;

    private Command[] commands;



    public Computer(Sender sender, MyCollection collection){
        this.sender = sender;
        this.collection = collection;

        this.security = new Security(new PostgreSQL("logins"));

        this.commands = new Command[7];
        commands[0] = new Show();
        commands[1] = new Add();
        commands[2] = new Info(new Date());
        commands[3] = new RemoveById();
        commands[4] = new Update();
        commands[5] = new Clear();
        commands[6] = new AverageOfDiscount();

    }

    @Override

    public void run() {

        Otvet otvet = new Otvet();
        otvet.text = "";

        Pak pak = this.lastPak;



        if (! security.check(pak.login, pak.password)){
            otvet.text = "Неправильные логин или пароль\n";
            otvet.incorrect = true;

        } else {

            for (Command command : commands) {
                if (command.getType() == pak.type) {
                    otvet = command.run(collection, pak);
                    break;

                }
            }
        }


        System.out.println("Обработал");





        try {
            sender.send(otvet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void compute(Pak pak) {
        this.lastPak = pak;
        /*ExecutorService fixedPool = Executors.newFixedThreadPool(1);
        fixedPool.submit(this);*/
        run();




    }

    public boolean register(String login, String password){
        return security.register(login, password);
    }
}
