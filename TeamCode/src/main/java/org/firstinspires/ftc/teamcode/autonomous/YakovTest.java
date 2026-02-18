package org.firstinspires.ftc.teamcode.autonomous;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

@Autonomous
public class YakovTest extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    public PathChain path1;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);

        garyDrivetrain.getFollower().setStartingPose(new Pose(72, 72));


        path1 = garyDrivetrain.getFollower().pathBuilder().addPath(
                        new BezierLine(
                                new Pose(55.000, 7.000),
                                new Pose(56.000, 36.000)
                        )).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(90))
                .build();


        garyDrivetrain.getFollower().followPath(
                path1
        );
    }

    @Override
    public void run() {
        super.run();

        garyDrivetrain.getFollower().update();
    }
}
