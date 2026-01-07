package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterPID extends SubsystemBase {

    private final DcMotor motor;
    private final PIDController pidController;
    private final double kP = 0;
    private final double kI = 0;
    private final double kD = 0;

    public ShooterPID(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "shooter");
        pidController = new PIDController(kP, kI, kD);
    }
    public double getRPM() {
        motor.get
    }

    public void setPower(double power) {
        motor.setPower(power);
    }


}

