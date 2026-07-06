package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {

    public final DcMotorEx intakeMotor;


    public static final double ACTIVE_POWER = 1; // hi dude how are you; im good wbu? not good the robot broken
    public static final double REVERSED_POWER = -1;
    public Intake(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");


    }

    public void setPower(double power) {
        intakeMotor.setPower(power);

    }

}

