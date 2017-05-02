package com.ompampassas.model;

import java.time.LocalDate;
public class PoJoMpampas {
    private String name;
    private LocalDate dateUploaded;
    private String username;

    public PoJoMpampas(String name, LocalDate dateUploaded, String username, boolean flag) {
        this.name = name;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

}
