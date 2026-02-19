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
    public void initialize() {
        garyDrivetrain.getFollower().startTeleOpDrive(true);
        garyDrivetrain.getFollower().update();
    }

    @Override
    public void execute() {
        garyDrivetrain.getFollower().setTeleOpDrive(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                false
        );
        garyDrivetrain.getFollower().update();
    }
}
