package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hood extends SubsystemBase {

    private final Servo hood;
    public static final double HOOD_POSITION = 0.5;

    public Hood(HardwareMap hardwareMap) {
        hood = hardwareMap.get(Servo.class, "hood");
    }

    public void setPosition(double position) {
        hood.setPosition(position);
    }
}
