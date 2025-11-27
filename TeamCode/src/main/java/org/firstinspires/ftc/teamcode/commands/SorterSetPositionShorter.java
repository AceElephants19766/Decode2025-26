package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystem.Sorter;

public class SorterSetPositionShorter extends InstantCommand {
    public SorterSetPositionShorter(Sorter sorter, double position) {
        super(
                () -> sorter.setPosition(position)
        );
    }
}
