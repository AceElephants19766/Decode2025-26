package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeDeactivate extends IntakeSetPower {

    public IntakeDeactivate(Intake intake) {
        super(intake, 0);
    }
}