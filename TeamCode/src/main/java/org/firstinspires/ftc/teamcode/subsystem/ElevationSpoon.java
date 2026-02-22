package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ElevationSpoon extends SubsystemBase {

    private final Servo elevatioSpoon;

    private final double DOWN = 0;
    private final double UP = 0.4549;
    public static final long TIME_BETWEEN_UP_AND_DOWN = 500;
   // private final double OFFSET_LEFT = 0.170;
   // private final double OFFSET_RIGHT = 0.1;

    public ElevationSpoon(HardwareMap hardwareMap) {
        elevatioSpoon = hardwareMap.get(Servo.class, "elevationSpoon");

    }

    public void setPosition(double position) {
        elevatioSpoon.setPosition(position);

    }

    public void down() {
        setPosition(DOWN);
    }

    public void up() {
        setPosition(UP);
    }
}