package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ElevationSpoon extends SubsystemBase {

    private final Servo rightServo;
    private final Servo leftServo;

    private final double DOWN = 0.4;
    private final double UP = 1;
    private final double OFFSET_LEFT = 0;
    private final double OFFSET_RIGHT = 0;

    public ElevationSpoon(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
    }

    public void setPosition(double position) {
        leftServo.setPosition(1-position + OFFSET_LEFT );
        rightServo.setPosition(position + OFFSET_RIGHT);
    }

    public double getPosition() {
        return leftServo.getPosition();
    }

    public void down() {
        setPosition(DOWN);
    }

    public void up() {
        setPosition(UP);
    }
}
