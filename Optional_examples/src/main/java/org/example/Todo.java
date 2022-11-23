package org.example;

public class Todo {
    private int id;
    private String Summary;

    public Todo(int id) {
        this.id = id;
    }

    public Todo(int id, String summary) {
        this.id = id;
        Summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", Summary='" + Summary + '\'' +
                '}';
    }
}
