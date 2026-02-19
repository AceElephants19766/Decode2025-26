package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Turret;

import java.util.function.DoubleSupplier;

public class TurretGetToAngle extends CommandBase {


    private final Turret turret;
    private final DoubleSupplier target;
    public TurretGetToAngle(Turret turret, DoubleSupplier target) {
        this.turret = turret;
        this.target = target;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        turret.getPidfController().setSetPoint(target.getAsDouble());
    }

    @Override
    public void execute() {
        turret.setPower(
                turret.getPidfController().calculate(
                        turret.getPosition()
                )
        );

    }

    @Override
    public void end(boolean interrupted) {
        turret.setPower(0);
    }
}
