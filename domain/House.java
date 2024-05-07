package com.hll.recent.domain;

public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int recent;
    private String state;

    public House(int id, String name, String phone, String address, int recent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.recent = recent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRecent() {
        return recent;
    }

    public void setRecent(int recent) {
        this.recent = recent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t\t" + phone +
                "\t\t" + address +
                "\t\t" + recent +
                "\t\t" + state;
    }
}
