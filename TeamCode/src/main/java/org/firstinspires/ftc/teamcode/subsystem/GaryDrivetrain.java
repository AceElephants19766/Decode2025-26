package org.firstinspires.ftc.teamcode.subsystem;

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

    private final Follower follower;


    public GaryDrivetrain(HardwareMap hardwareMap) {
        follower = Constants.createFollower(hardwareMap);
    }

    public Follower getFollower() {
        return follower;
    }
}