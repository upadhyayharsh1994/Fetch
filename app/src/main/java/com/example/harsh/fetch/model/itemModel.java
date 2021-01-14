package com.example.harsh.fetch.model;

import java.util.Comparator;

public class itemModel {
    private int listId;
    private int id;
    private String name;

    public itemModel(int listId, int id, String name) {
        this.listId = listId;
        this.id = id;
        this.name = name;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
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

    public static Comparator<itemModel> COMPARE_BY_LISTID = new Comparator<itemModel>() {
        public int compare(itemModel obj1, itemModel obj2) {
            return obj1.listId - obj2.listId;
        }
    };

    public static Comparator<itemModel> COMPARE_BY_ID = new Comparator<itemModel>() {
        public int compare(itemModel obj1, itemModel obj2) {
            return obj1.id - obj2.id;
        }
    };

    public static Comparator<itemModel> COMPARE_BY_NAME = new Comparator<itemModel>() {
        public int compare(itemModel obj1, itemModel obj2) {
            return obj1.name.compareTo(obj2.name);
        }
    };
}
