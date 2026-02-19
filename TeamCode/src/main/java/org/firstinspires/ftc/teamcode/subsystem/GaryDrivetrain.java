package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.Drawing;

public class GaryDrivetrain extends SubsystemBase {

    private final Follower follower;

    public GaryDrivetrain(HardwareMap hardwareMap) {
        super(); //registers this subsystem (for the periodic block below to be called).
        follower = Constants.createFollower(hardwareMap);
    }

    public Follower getFollower() {
        return follower;
    }

    @Override
    public void periodic() {
        follower.update();
        Drawing.drawDebug(follower);
        Drawing.sendPacket();
    }
}