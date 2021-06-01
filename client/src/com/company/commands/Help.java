package com.company.commands;

import com.company.Otvet;

public class Help implements Command {

    @Override
    public Otvet run(String s, String login, String password) {
        Otvet otvet = new Otvet();
        otvet.text = "";

        if (s.contains("help")){

            otvet.text =   "help : вывести справку по доступным командам\n" +
                    "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
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
                    "count_less_than_minimal_point minimalPoint : вывести количество элементов, значение поля minimalPoint которых меньше заданного\n";
        }

        return otvet;
    }

}
