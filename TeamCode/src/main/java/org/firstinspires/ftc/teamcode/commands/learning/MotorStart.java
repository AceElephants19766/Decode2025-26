package org.firstinspires.ftc.teamcode.commands.learning;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

public class MotorStart extends CommandBase {

    private final GaryDrivetrain garyDrivetrain;

    public MotorStart(GaryDrivetrain garyDrivetrain) {
        this.garyDrivetrain = garyDrivetrain;
        addRequirements(garyDrivetrain);
    }

    @Override
    public void initialize() {
        garyDrivetrain.arcadeDrive(0, 1, 0);
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
