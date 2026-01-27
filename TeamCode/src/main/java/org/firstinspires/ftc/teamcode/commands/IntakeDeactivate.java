package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeDeactivate extends CommandBase {

    private final Intake intake;

    public IntakeDeactivate(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setPower(0);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

