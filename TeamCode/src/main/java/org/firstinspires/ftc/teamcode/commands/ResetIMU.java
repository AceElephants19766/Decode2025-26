package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

public class ResetIMU extends InstantCommand {

    public ResetIMU(GaryDrivetrain garyDrivetrain) {
        super(
                () -> garyDrivetrain.getFollower().setHeading(0)
        );
    }
}
