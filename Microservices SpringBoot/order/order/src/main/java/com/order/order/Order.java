package com.order.order;

public class Order {
    int id;
    String product;
    int price;
    User user;

    public Order( int id, String product,int price, User user) {
        this.user = user;
        this.price = price;
        this.product = product;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

