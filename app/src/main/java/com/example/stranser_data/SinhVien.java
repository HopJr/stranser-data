package com.example.stranser_data;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String name;
    private String add;

    public SinhVien(String name, String add) {
        this.name = name;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public SinhVien setName(String name) {
        this.name = name;
        return this;
    }

    public String getAdd() {
        return add;
    }

    public SinhVien setAdd(String add) {
        this.add = add;
        return this;
    }
}
