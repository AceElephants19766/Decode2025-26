package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

public class Drive extends CommandBase {

    private final GaryDrivetrain garyDrivetrain;
    private final Gamepad gamepad1;

    public Drive(GaryDrivetrain garyDrivetrain, Gamepad gamepad1) {
        this.garyDrivetrain = garyDrivetrain;
        this.gamepad1 = gamepad1;
        addRequirements(garyDrivetrain);
    }

    @Override
    public void execute() {
        garyDrivetrain.fieldOrientedDrive(gamepad1);
    }

}
