package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.Hood;

import java.util.function.DoubleSupplier;

public class HoodSetPosition extends InstantCommand {

    public HoodSetPosition(Hood hood, DoubleSupplier position) {
        super(
                () -> hood.setPosition(position.getAsDouble()),
                hood
        );
    }
}
