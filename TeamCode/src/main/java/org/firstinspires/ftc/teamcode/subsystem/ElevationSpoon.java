package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ElevationSpoon extends SubsystemBase {

    private final CRServo elevationSpoon;

    private final double DOWN = 1.0;
    private final double UP = 0.1;
    public static final long TIME_BETWEEN_UP_AND_DOWN = 850;
   // private final double OFFSET_LEFT = 0.170;
   // private final double OFFSET_RIGHT = 0.1;

    public ElevationSpoon(HardwareMap hardwareMap) {
        elevationSpoon = hardwareMap.get(CRServo.class, "elevationSpoon");

    }

//    public void setPosition(double position) {
//        elevationSpoon.setPosition(position);
//
//    }
//
//    public boolean isDown() {
//        return elevationSpoon.getPosition() > (UP + 0.05);
//    }

//    public void down() {
//        setPosition(DOWN);
//    }
//
//    public void up() {
//        setPosition(UP);
//    }

    public void up() { elevationSpoon.setPower(-1); }

    public void down() { elevationSpoon.setPower(1); }

    public void stop() { elevationSpoon.setPower(0); }
}