package com.example.foodrs;

public class TotalDailyEnergyExpenditure extends HarrisBenedict {
    private String lifestyle;

    public TotalDailyEnergyExpenditure(String gender, double weight, double height, int age, String lifestyle) {
        super(gender, weight, height, age);
        this.lifestyle = lifestyle;
    }

    public double tdee() {
        double bmr = super.bmr();
        double tdee;
        if (lifestyle.equals("Sedentary")) {
            tdee = bmr * 1.2;
        } else if (lifestyle.equals("Slight Active")) {
            tdee = bmr * 1.375;
        } else if (lifestyle.equals("Moderately Active")) {
            tdee = bmr * 1.55;
        } else if (lifestyle.equals("Very Active")) {
            tdee = bmr * 1.725;
        } else {
            tdee = bmr * 1.9;
        }
        return tdee;
    }
}

