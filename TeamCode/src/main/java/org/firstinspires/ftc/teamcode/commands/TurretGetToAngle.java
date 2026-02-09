package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Turret;

public class TurretGetToAngle extends CommandBase {

    private final Turret turret;
    private final double target;
    public TurretGetToAngle(Turret turret, int target) {
        this.turret = turret;
        this.target = target;
        addRequirements(turret);
    }


}
