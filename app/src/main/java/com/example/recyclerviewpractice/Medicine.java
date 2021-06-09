package com.example.recyclerviewpractice;

public class Medicine {

    public String name;
    public Integer price;
    public Integer piecesPerBox;

    public Medicine(String name, Integer price, Integer piecesPerBox) {
        this.name = name;
        this.price = price;
        this.piecesPerBox = piecesPerBox;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPiecesPerBox() {
        return piecesPerBox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPiecesPerBox(Integer piecesPerBox) {
        this.piecesPerBox = piecesPerBox;
    }
}
