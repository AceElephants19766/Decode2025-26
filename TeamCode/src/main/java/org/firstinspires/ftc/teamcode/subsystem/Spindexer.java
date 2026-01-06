package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spindexer extends SubsystemBase {

    private final Servo servo;

    private final double ZERO = 0;

    public Spindexer(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, "spindexerServo");
    }
    public void setPosition(double position) {
        servo.setPosition(position);
    }

    public void zero() {
        setPosition(ZERO);
    }
}
