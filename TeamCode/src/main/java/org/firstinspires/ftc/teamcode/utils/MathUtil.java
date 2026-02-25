package org.firstinspires.ftc.teamcode.utils;

public class MathUtil {

    public static double clamp(double val, double min, double max) {
        double res = Math.max(val, min);
        return Math.min(res, max);
    }

}
