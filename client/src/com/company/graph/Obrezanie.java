package com.company.graph;

public class Obrezanie {
    static int len = 8;

    public static String obr(String arg){
        if (arg.length() <= len){
            return arg;
        }else{
            return arg.substring(0, len) + "...";
        }
    }

    public static String obr(String arg, int len){
        if (arg.length() <= len){
            return arg;
        }else{
            return arg.substring(0, len) + "...";
        }
    }
}
