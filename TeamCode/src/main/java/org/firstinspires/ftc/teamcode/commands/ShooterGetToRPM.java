package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.ShooterPID;

import java.lang.annotation.Target;

public class ShooterGetToRPM extends CommandBase {

    private ShooterPID shooterPID;
    private int target;

    public ShooterGetToRPM(ShooterPID shooterPID, int target) {
        this.shooterPID = shooterPID;
        this.target = target;
        addRequirements(shooterPID);
    }

    @Override
    public void initialize() {
        shooterPID.pidController.setSetPoint(target);
    }

    @Override
    public void execute() {
        shooterPID.setPower(
                shooterPID.pidController.calculate(
                        shooterPID.getRPM()
                )
        );
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        shooterPID.setPower(0);
    }
}
