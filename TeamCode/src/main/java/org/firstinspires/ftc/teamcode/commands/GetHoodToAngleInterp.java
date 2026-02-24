package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Hood;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class GetHoodToAngleInterp extends HoodSetPosition {
    public GetHoodToAngleInterp(GaryDrivetrain garyDrivetrain, Hood hood, boolean isGoalBlue) {
        super(hood, () -> {

           double hoodAngle = hood.hoodTable.get(garyDrivetrain.getRadius(isGoalBlue));

           return hoodAngle;
        } );
    }
}
