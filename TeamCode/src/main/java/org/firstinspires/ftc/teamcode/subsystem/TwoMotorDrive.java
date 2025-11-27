package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TwoMotorDrive extends SubsystemBase {

    private final DcMotorEx backRight;
    private final DcMotorEx backLeft;

    public TwoMotorDrive(HardwareMap hardwareMap) {
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void drive(Gamepad gamepad1) {
        double y = -gamepad1.right_stick_y;
        double zSpin = gamepad1.left_stick_x;
        backRight.setPower(y-zSpin);
        backLeft.setPower(y+zSpin);
    }

}
