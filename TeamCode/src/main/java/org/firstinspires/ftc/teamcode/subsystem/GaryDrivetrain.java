package org.firstinspires.ftc.teamcode.subsystem;

import androidx.loader.content.Loader;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.bosch.BNO055IMUNew;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class GaryDrivetrain extends SubsystemBase {

    private final BNO055IMUNew imu;
    private final DcMotorEx frontLeft;
    private final DcMotorEx frontRight;
    private final DcMotorEx backRight;
    private final DcMotorEx backLeft;

    //pedro
    private final Follower follower;

    public GaryDrivetrain(HardwareMap hardwareMap) {

        imu = hardwareMap.get(BNO055IMUNew.class, "imu");
        imu.initialize(
                new BNO055IMUNew.Parameters(
                        new RevHubOrientationOnRobot(
                                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                                RevHubOrientationOnRobot.UsbFacingDirection.DOWN
                        )
                )
        );
        imu.resetYaw();

        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //pedro
        follower = Constants.createFollower(hardwareMap);

    }

    public void resetIMU(){
        imu.resetYaw();
    }

    public void arcadeDrive(Gamepad gamepad1) {
        double x = -gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double zSpin = gamepad1.right_stick_x;

        arcadeDrive(x, y, zSpin);
    }

    public void fieldOrientedDrive(Gamepad gamepad1) {
        double x = -gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double zSpin = gamepad1.right_stick_x;

        Vector2d joystickVec = new Vector2d(x,y);
        Vector2d fieldOrientedVec = joystickVec.rotateBy(getAngleYaw());

        arcadeDrive(fieldOrientedVec.getX(), fieldOrientedVec.getY(), zSpin);
    }

    public void arcadeDrive(double x, double y, double zSpin) {

        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(zSpin), 1);

        frontLeft.setPower((y - x + zSpin) / denominator);
        frontRight.setPower((y + x - zSpin) / denominator);
        backRight.setPower((y - x - zSpin) / denominator);
        backLeft.setPower((y + x + zSpin) / denominator);

    }

    public double getAngleYaw() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public Follower getFollower() {
        return follower;
    }
}