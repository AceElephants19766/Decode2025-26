package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeSetPower extends InstantCommand {

    public IntakeSetPower(Intake intake, double power) {
        super(
                () -> intake.setPower(power),
                intake
        );
    }
}
