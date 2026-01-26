package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeActivate extends CommandBase {

    private final Intake intake;

    public IntakeActivate(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setPower(1);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

