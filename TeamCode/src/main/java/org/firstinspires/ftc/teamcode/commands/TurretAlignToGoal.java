package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Turret;

import java.util.function.DoubleSupplier;

public class TurretAlignToGoal extends TurretGetToAngle {

    public TurretAlignToGoal(Turret turret, GaryDrivetrain garyDrivetrain) {
        super(
                turret,
                        () -> {
                            Math.toDegrees()
                        }
        );
    }
}
