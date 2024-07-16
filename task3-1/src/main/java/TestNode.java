package main.java;

import java.util.List;

public class TestNode {
    private int id;
    private String title;
    private String value;
    private List<TestNode> values;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TestNode> getValues() {
        return values;
    }

    public void setValues(List<TestNode> values) {
        this.values = values;
    }
}