package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeActivate extends IntakeSetPower {

    public IntakeActivate(Intake intake) {
        super(intake, Intake.ACTIVE_POWER);
    }
}