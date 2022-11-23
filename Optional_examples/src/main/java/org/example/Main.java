package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Todo todo = new Todo(1, "Resumen Ejecutivo");
//        Todo todo = null;

        Optional<Todo> optTodo = Optional.of(todo);

        //get the id of the todo or a default value
//        optTodo.ifPresent(t -> System.out.println(t.getId()));

        //get the summary (trimmed) of todo if the id is higher than 0
        Optional<String> map = optTodo.filter(o -> o.getId() > 0).map(o -> o.getSummary().trim());
        System.out.println(map.get());

        //Same as above but print i out
        optTodo.filter(o -> o.getId() > 0).map(o -> o.getSummary().trim()).ifPresent(System.out::println);

        //to avoid NoSuchElementException
        String s = "Hello";
        Optional<String> maybeS = Optional.of(s);

        int len = maybeS.map(String::length).orElse(-1);
        System.out.println(len);

        int calStringlen = maybeS.map(String::length).orElseGet(() -> "Hello".length());
        System.out.println(calStringlen);

    }
}