package org.firstinspires.ftc.teamcode.commands.learning;

import android.graphics.Color;

public class LearningParameters {

    private int numOfLegs;
    private String color;

    public LearningParameters(int numOfLegs, String color) {
        this.numOfLegs = numOfLegs;
        this.color = color;
    }

    public static void main(String[] args) {
        LearningParameters table = new LearningParameters(6, "turquoise");
        LearningParameters table2 = new LearningParameters(0, "red");
    }
}
