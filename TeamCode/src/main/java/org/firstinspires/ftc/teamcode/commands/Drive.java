package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.TwoMotorDrive;

public class Drive extends CommandBase {

    private final TwoMotorDrive twoMotorDrive;
    private final Gamepad gamepad1;

    public Drive(TwoMotorDrive twoMotorDrive, Gamepad gamepad1) {
        this.twoMotorDrive =   twoMotorDrive;
        this.gamepad1 = gamepad1;
        addRequirements(twoMotorDrive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        twoMotorDrive.drive(gamepad1);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
