package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Sorter extends SubsystemBase {

    private final Servo sorter;

    public Sorter(HardwareMap hardwareMap) {
        sorter = hardwareMap.get(Servo.class, "sorter");
    }

    public void setPosition(double position) {
        sorter.setPosition(position);


    }



}
