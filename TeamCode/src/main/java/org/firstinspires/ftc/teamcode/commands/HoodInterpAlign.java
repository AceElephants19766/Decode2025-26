package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.geometry.Vector2d;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.HoodSubsystem;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class HoodInterpAlign extends HoodGetToPosition {
    public HoodInterpAlign(
            HoodSubsystem hoodSubsystem,
            GaryDrivetrain garyDrivetrain,
            boolean isGoalBlue
    ) {
        super(hoodSubsystem, () -> {

            Vector2d goalPose = isGoalBlue ? Constants.BLUE_GOAL_POS : Constants.RED_GOAL_POS;
            Pose robotPose = garyDrivetrain.getFollower().getPose();

            double dist = Math.sqrt(
                    Math.pow(
                            (goalPose.getY() - robotPose.getY()), 2
                    ) + Math.pow(
                            (goalPose.getX() - robotPose.getX()), 2
                    )
            );

            return HoodSubsystem.lut.get(dist);

        });
    }
}
