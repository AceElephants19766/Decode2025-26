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
    private final DcMotorEx lowerMotor;
    private final DcMotorEx upperMotor;
    public final PIDController pidController;

    public static double kP = 0.2;
    public static double kI = 0;
    public static double kD = 0.0005;
    private double kF = 0.05;

    private final double TICKS_PER_REVOLUTION = 28;
    private final double RATIO = 20./20.;
    private final double SECOND_TO_MINUTE = 60;

    public ShooterPID(HardwareMap hardwareMap) {
        lowerMotor = hardwareMap.get(DcMotorEx.class, "lowerMotor");
        upperMotor = hardwareMap.get(DcMotorEx.class, "upperMotor");
        upperMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        pidController = new PIDController(kP, kI, kD);
    }

    public double getRPM() {
        return (lowerMotor.getVelocity() / TICKS_PER_REVOLUTION) * SECOND_TO_MINUTE * RATIO;
    }

    public void setPower(double power) {
//        motorRight.setPower(power);
        upperMotor.setPower(power);
        lowerMotor.setPower(power);
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

