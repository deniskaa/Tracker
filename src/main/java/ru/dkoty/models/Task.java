package ru.dkoty.models;

public class Task extends Item {
    public Task(String name, String desc) {
        setName(name);
        setDesc(desc);
    }
    public String calculatePrice() {
        return "100%";
    }
}

