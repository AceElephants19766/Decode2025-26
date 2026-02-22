package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {

    public final CRServo leftServo;
    public final CRServo rightServo;

    public static final double ACTIVE_POWER = 0.8; // hi dude how are you; im good hbu?

    public Intake(HardwareMap hardwareMap) {
        rightServo = hardwareMap.get(CRServo.class, "rightIntakeServo");
        leftServo = hardwareMap.get(CRServo.class, "leftIntakeServo");

    }

    public void setPower(double power) {
        rightServo.setPower(-power);
        leftServo.setPower(power);
    }

}

