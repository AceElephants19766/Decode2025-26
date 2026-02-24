package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Hood;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class GetHoodToAngleInterp extends RunCommand {
    public GetHoodToAngleInterp(GaryDrivetrain garyDrivetrain, Hood hood, boolean isGoalBlue) {
        super(() -> {
            hood.setPosition(hood.hoodTable.get(garyDrivetrain.getRadius(isGoalBlue)));
        }, hood);
    }
}
