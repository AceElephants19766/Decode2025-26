package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.util.InterpLUT;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HoodSubsystem extends SubsystemBase {
    public static final InterpLUT lut = new InterpLUT();

    {
        //DistanceFromGoal -> ServoPositionValue (x -> y) - y(x)
        lut.add(0, 0);
        lut.add(0, 0);
        lut.add(0, 0);
        lut.add(0, 0);
        lut.add(0, 0);
        lut.createLUT();
    }

    private final Servo servo;

    public HoodSubsystem(HardwareMap hardwareMap) {
        this.servo = hardwareMap.get(Servo.class, "NAME");
    }

    public void setPos(double position) {
        servo.setPosition(position);
    }

}
