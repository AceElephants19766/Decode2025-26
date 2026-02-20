package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

public class IntakeActivate extends CommandBase {

    private final Intake leftServo;
    private final Intake rightServo;

    public IntakeActivate(Intake leftServo, Intake rightServo) {
        this.leftServo = leftServo;
        this.rightServo = rightServo;
        addRequirements(rightServo,leftServo);
    }

    @Override
    public void initialize() {
        leftServo.setPower(1);
        rightServo.setPower(1);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

