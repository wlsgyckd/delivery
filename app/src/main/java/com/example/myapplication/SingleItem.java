package com.example.myapplication;

public class SingleItem {
    public String name;
    public String minOrderAmount;
    public String deliveryFee;
    public int imageId;

    public SingleItem(String name, String minOrderAmount, String deliveryFee, int imageId){
        this.name = name;
        this.minOrderAmount = minOrderAmount;
        this.deliveryFee = deliveryFee;
        this.imageId = imageId;
    }
}