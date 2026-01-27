package org.firstinspires.ftc.teamcode.subsystem;

import android.net.Uri;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Gary extends SubsystemBase {
    public DcMotor motor;

    public Gary(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "gary");
    }


    public void setPower(double power) {
        motor.setPower(power);
    }

    public void stop() {
        motor.setPower(0);
    }
}
