package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class ShooterPID extends SubsystemBase {
//    private final DcMotorEx motorRight;
    private final DcMotorEx motorLeft;
    public final PIDController pidController;

    public static double kP = 0.2;
    public static double kI = 0;
    public static double kD = 0.0005;
    private double kF = 0.05;

    private final double TICKS_PER_REVOLUTION = 28;
    private final double RATIO = 30./20.;

    public ShooterPID(HardwareMap hardwareMap) {
//        motorRight = hardwareMap.get(DcMotorEx.class, "motorRight");
        motorLeft = hardwareMap.get(DcMotorEx.class, "motorLeft");
//        motorLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        pidController = new PIDController(kP, kI, kD);
    }

    public double getRPM() {
        return (motorLeft.getVelocity() / TICKS_PER_REVOLUTION) * 60 * RATIO;
    }

    public void setPower(double power) {
//        motorRight.setPower(power);
        motorLeft.setPower(power);
    }

    public double getkF() {
        return kF;
    }

    @Override
    public void periodic() {
        FtcDashboard.getInstance().getTelemetry().addData(
                "RPM",
                getRPM()
        );
        FtcDashboard.getInstance().getTelemetry().addData(
                "target",
                pidController.getSetPoint()
        );
    }
}

