package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeReversed extends IntakeSetPower{

    public  IntakeReversed(Intake intake) {
        super(intake, Intake.REVERSED_POWER);
    }
}
