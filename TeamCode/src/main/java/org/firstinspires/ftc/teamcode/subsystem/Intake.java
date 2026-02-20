package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {

    public final CRServo leftServo;
    public  final CRServo rightServo;

    public Intake(HardwareMap hardwareMap) {
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
    }

    public void setPower(double power) {
        rightServo.setPower(power);
        leftServo.setPower(power);
    }

}

