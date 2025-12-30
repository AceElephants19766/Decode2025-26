package org.firstinspires.ftc.teamcode.commands;

import android.icu.text.Transliterator;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.subsystem.Sorter;

public class SorterSetPosition extends CommandBase {

    private final double position;
    private final Sorter sorter;

    public SorterSetPosition(Sorter sorter, double position) {
        this.sorter = sorter;
        this.position = position;
    }

    @Override
    public void initialize() {
        sorter.setPosition(position);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
