package com.company.threads;

import com.company.Otvet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Sender extends RecursiveTask<String> {

    ObjectOutputStream objectOutputStream;

    Otvet otvetNow;

    @Override
    protected String compute() {
        try {
            objectOutputStream.writeObject(otvetNow);
            System.out.println(otvetNow.tickets);
            System.out.println("Отправил\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Поток запущен\n";

    }

    public Sender(ObjectOutputStream objectOutputStream){
        this.objectOutputStream = objectOutputStream;
    }


    public void send(Otvet otvet) throws IOException {
        this.otvetNow = otvet;
        compute();






    }
}
