package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.Hood;

public class HoodSetPosition extends InstantCommand {

    public HoodSetPosition(Hood hood, double position) {
        super(
                () -> hood.setPosition(position),
                hood
        );
    }
}
