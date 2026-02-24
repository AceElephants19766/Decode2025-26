package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.bylazar.telemetry.PanelsTelemetry;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class GaryDrivetrain extends SubsystemBase {

    private final Follower follower;


    public GaryDrivetrain(HardwareMap hardwareMap) {
        follower = Constants.createFollower(hardwareMap);
    }

    public Follower getFollower() {
        return follower;
    }

    public double getRadius(boolean isGoalBlue) {

        Vector2d goalPose = isGoalBlue ? org.firstinspires.ftc.teamcode.utils.Constants.BLUE_GOAL_POS : org.firstinspires.ftc.teamcode.utils.Constants.RED_GOAL_POS;

        double yDiff = goalPose.getY() - follower.getPose().getY();
        double xDiff = goalPose.getX() - follower.getPose().getX();

        double yDiffSquared = Math.pow(yDiff, 2);
        double xDiffSquared = Math.pow(xDiff, 2);

        double distanceSquared = yDiffSquared + xDiffSquared;

        double radius = Math.sqrt(distanceSquared);

        return radius;
    }

    @Override
    public void periodic() {
        follower.update();
//        Drawing.drawDebug(follower);
//        Drawing.sendPacket();

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "radius", getRadius(false)
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "x", follower.getPose().getX()
        );
        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "y", follower.getPose().getY()
        );
        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "heading", follower.getPose().getHeading()
        );


    }
}