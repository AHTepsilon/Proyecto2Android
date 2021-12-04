package com.example.freshfind;

public class FoodCards
{
    private String NAME;
    private int QUANTITY, WEIGHT, BOUGHT, EXPIRES;

    public FoodCards()
    {

    }

    public FoodCards(String NAME, int QUANTITY, int WEIGHT, int BOUGHT, int EXPIRES) {
        this.NAME = NAME;
        this.QUANTITY = QUANTITY;
        this.WEIGHT = WEIGHT;
        this.BOUGHT = BOUGHT;
        this.EXPIRES = EXPIRES;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(int WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public int getBOUGHT() {
        return BOUGHT;
    }

    public void setBOUGHT(int BOUGHT) {
        this.BOUGHT = BOUGHT;
    }

    public int getEXPIRES() {
        return EXPIRES;
    }

    public void setEXPIRES(int EXPIRES) {
        this.EXPIRES = EXPIRES;
    }
}
