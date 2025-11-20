package org.firstinspires.ftc.teamcode.commands.learning;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

public class MotorStop extends CommandBase {

    private final GaryDrivetrain garyDrivetrain;

    public MotorStop(GaryDrivetrain garyDrivetrain) {
        this.garyDrivetrain = garyDrivetrain;
        addRequirements(garyDrivetrain);
    }

    @Override
    public void initialize() {
        garyDrivetrain.drive(0, 0, 0);
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
