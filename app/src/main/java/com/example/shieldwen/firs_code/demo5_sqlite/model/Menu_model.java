package com.example.shieldwen.firs_code.demo5_sqlite.model;

public class Menu_model {
        private int id;
        private String peiliao;
        private String menu_name;

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPeiliao(String peiliao) {
        this.peiliao = peiliao;
    }

    public String getPeiliao() {
        return peiliao;
    }
}
