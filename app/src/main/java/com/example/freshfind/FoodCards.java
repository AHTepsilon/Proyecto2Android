package com.example.freshfind;

public class FoodCards
{
    private String name;
    private int quantity, weight, bought, expires;

    public FoodCards()
    {

    }

    public FoodCards(String name, int quantity, int weight, int bought, int expires) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.bought = bought;
        this.expires = expires;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
