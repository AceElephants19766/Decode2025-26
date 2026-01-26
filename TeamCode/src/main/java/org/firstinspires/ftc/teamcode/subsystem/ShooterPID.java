package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class ShooterPID extends SubsystemBase {

    private final DcMotorEx motor;
    public final PIDController pidController;

    public static double kP = 0;
    public static double kI = 0;
    public static double kD = 0;

    private final double TICKS_PER_REVOLUTION = 28;
    private final double RATIO = 30./20.;

    public ShooterPID(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "shooter");
        pidController = new PIDController(kP, kI, kD);
    }

    public double getRPM() {
        return (-motor.getVelocity() / TICKS_PER_REVOLUTION) * 60 * RATIO;
    }

    public void setPower(double power) {
        motor.setPower(power);
    }

    @Override
    public void periodic() {
        FtcDashboard.getInstance().getTelemetry().addData(
                "RPM",
                getRPM()
        );
    }
}

