package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GaryDrivetrain extends SubsystemBase {

    private final DcMotorEx frontLeft;
    private final DcMotorEx frontRight;
    private final DcMotorEx backRight;
    private final DcMotorEx backLeft;

    public GaryDrivetrain(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    public void drive(Gamepad gamepad1) {
        double x = gamepad1.right_stick_x;
        double y = -gamepad1.right_stick_y;
        double zSpin = gamepad1.left_stick_x;
        frontLeft.setPower(y-x+zSpin);
        frontRight.setPower(y+x-zSpin);
        backRight.setPower(y-x-zSpin);
        backLeft.setPower(y+x+zSpin);
    }

    public void drive(double x, double y, double zSpin) {
        frontLeft.setPower(y-x+zSpin);
        frontRight.setPower(y+x-zSpin);
        backRight.setPower(y-x-zSpin);
        backLeft.setPower(y+x+zSpin);
    }

}