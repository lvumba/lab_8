package com.company;

import java.util.HashMap;

public class Security {

    private HashMap<String, String> log_pas;
    private PostgreSQL postgreSQL;

    public Security(PostgreSQL postgreSQL){
        this.postgreSQL = postgreSQL;
        this.log_pas = postgreSQL.showLog_pas();

    }

    public boolean check(String login, String password){

        String pass = this.log_pas.get(login);

        if (pass != null){
            return pass.equals(password);
        } else {
            return false;
        }

    }

    public boolean register(String login, String password){
        if (this.log_pas.get(login) == null){
            //такого логина нет
            this.log_pas.put(login, password);
            this.postgreSQL.addLog_pass(login, password);
            return true;

        }else{
            return false;
        }
    }
}
