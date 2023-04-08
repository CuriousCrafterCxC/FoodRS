package com.example.foodrs;

public class HarrisBenedict {
    private String gender;
    private double weight;
    private double height;
    private int age;

    public HarrisBenedict(String gender, double weight, double height, int age) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public double bmr() {
        double bmr;
        if (gender.equals("Men")) {
            bmr = 66.5 + (13.75*weight) + (5.003*height) - (6.75*age);
        } else {
            bmr = 655.1 + (9.563*weight) + (1.85*height) - (4.676*age);
        }
        return bmr;
    }
}
