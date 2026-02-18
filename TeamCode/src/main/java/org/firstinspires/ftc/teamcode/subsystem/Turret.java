package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret extends SubsystemBase {

    //Hardware
    private final DcMotorEx motor;
    //Control
    private final PIDFController pidfController;
    public static double kP = 0.;
    public static double kI = 0;
    public static double kD = 0.;
    private double kF = 0.;

    //Constants
    private final double REV_TO_ANGLE = 360;
    private final double TICKS_PER_REV = 167; //todo
    private final double RATIO = 1./2.; //todo
    public Turret(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "turret");
        pidfController = new PIDFController(kP, kI, kD, kF);
    }

    public PIDFController getPidfController() {
        return pidfController;
    }

    public double getPosition() {
        return (motor.getCurrentPosition() / TICKS_PER_REV) * RATIO * REV_TO_ANGLE;
    }
    public void setPower(double power) {
        motor.setPower(power);
    }

}