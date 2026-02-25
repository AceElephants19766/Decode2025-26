package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.RunCommand;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Hood;

public class GetHoodToAngleInterp extends RunCommand {
    public GetHoodToAngleInterp(GaryDrivetrain garyDrivetrain, Hood hood, boolean isGoalBlue) {
        super(() -> {
            try {
                hood.setPosition(hood.hoodTable.get(garyDrivetrain.getRadius(isGoalBlue)));
            } catch (Exception ignored) {}
        }, hood);
    }
}
