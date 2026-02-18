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
public class Auto extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private boolean firstIteration = true;
    public SequentialCommandGroup moveForward;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);

        moveForward = new SequentialCommandGroup(
                new InstantCommand(
                        () -> garyDrivetrain.getFollower().drivetrain.runDrive(
                                new double[] {
                                        0.5, 0.5, 0.5, 0.5
                                }
                        )
                ),
                new WaitCommand(1500),
                new InstantCommand(
                        () -> garyDrivetrain.getFollower().drivetrain.runDrive(
                                new double[] {
                                        0, 0, 0, 0
                                }
                        )
                )
        );


    }

    @Override
    public void run() {
        super.run();

        if(firstIteration) {
            schedule(
                    new InstantCommand(),
                    moveForward
            );
            firstIteration = false;
        }
    }
}
