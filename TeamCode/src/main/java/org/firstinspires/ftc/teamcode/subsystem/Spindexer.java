package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spindexer extends SubsystemBase {

    private final Servo servo;

    public final double ZERO = 0.;
    public final double ONE = 0.45;
    public final double TWO = 0.87;

    public Spindexer(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, "spindexerServo");
    }

    public void setPosition(double position) {
        servo.setPosition(position);
    }

    public double getPos(){
        return servo.getPosition();
    }

    public void zero() {
        setPosition(ZERO);
    }

    public void one() {

        setPosition(ONE);
    }

    public void two() {

        setPosition(TWO);
    }
}
