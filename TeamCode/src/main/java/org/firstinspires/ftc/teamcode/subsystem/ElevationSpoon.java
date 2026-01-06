package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ElevationSpoon extends SubsystemBase {

    private final Servo rightServo;
    private final Servo leftServo;

    private final double DOWN = 0;
    private final double UP = 0.4549;
    private final double OFFSET_LEFT = 0.170;
    private final double OFFSET_RIGHT = 0.1;

    public ElevationSpoon(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
    }

    public void setPosition(double position) {
        leftServo.setPosition(position + OFFSET_LEFT );
        rightServo.setPosition(1 - position - OFFSET_RIGHT);
    }

    public void down() {
        setPosition(DOWN);
    }

    public void up() {
        setPosition(UP);
    }
}
