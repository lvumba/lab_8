package com.company.threads;

import com.company.Otvet;
import com.company.serv.Pak;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.RecursiveTask;

public class Reader extends RecursiveTask<String>{

    Computer computer;
    Sender sender;
    ObjectInputStream objectInputStream;

    public Reader(Computer computer, Sender sender, ObjectInputStream objectInputStream){
        this.computer = computer;
        this.sender = sender;
        this.objectInputStream = objectInputStream;
    }

    @Override
    protected String compute()  {
        Object obj;
        try {
            while (true){
                obj = objectInputStream.readObject();
                Pak pak = (Pak) obj;

                if (pak.register){
                    Otvet otvet = new Otvet();
                    if (computer.register(pak.login, pak.password)){
                        otvet.text = "Вы успешно зарегестрировались\n";
                    }else{
                        otvet.text = "Такой логин уже существует\n";
                        otvet.incorrect = true;
                    }
                    sender.send(otvet);
                    continue;
                }



                System.out.println("Прочитал");

                computer.compute(pak);

            }




        } catch (ClassNotFoundException e) {
            System.out.println("Не тот класс pak");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Ошибка");
        }

        return "Поток работает\n";
    }



}
