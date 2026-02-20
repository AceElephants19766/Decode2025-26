package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.HoodSubsystem;

import java.util.function.DoubleSupplier;

public class HoodGetToPosition extends InstantCommand {
    public HoodGetToPosition(HoodSubsystem hoodSubsystem, DoubleSupplier pos) {
        super(
                () -> hoodSubsystem.setPos(pos.getAsDouble())
        );
    }
}
