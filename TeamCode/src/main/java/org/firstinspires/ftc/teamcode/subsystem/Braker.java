package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Braker extends SubsystemBase {

    private final Servo braker;

    private final double BLOCKING = 0.694;
    private final double FREE = 0.94;


    public Braker(HardwareMap hardwareMap) {
        braker = hardwareMap.get(Servo.class, "braker");
    }

    public void setPosition(double position) {
        braker.setPosition(position);
    }

    public boolean isBlocking() {
        return braker.getPosition() < (FREE - 0.05);
    }

    public void blocking() {
        setPosition(BLOCKING);
    }

    public void free() {
        setPosition(FREE);
    }
}

