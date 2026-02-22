package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

public class GetHoodToAngleInterp extends InstantCommand {

    public GetHoodToAngleInterp(GaryDrivetrain garyDrivetrain) {
        super(
                () -> {
                    garyDrivetrain.getFollower().getPose().
                }
        );
    }


}
