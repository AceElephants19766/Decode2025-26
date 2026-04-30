package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Configurable
public class ShooterPID extends SubsystemBase {
//    private final DcMotorEx motorRight;
    private final DcMotorEx lowerMotor; //
    public final PIDController pidController;

    public static double kP = 0.015;
    public static double kI = 0.2;
    public static double kD = 0;
    private final double TOLERANCE = 20;

    private final double TICKS_PER_REVOLUTION = 28;
    private final double RATIO = 20./20.;
    private final double SECOND_TO_MINUTE = 60;

    public ShooterPID(HardwareMap hardwareMap) {
        lowerMotor = hardwareMap.get(DcMotorEx.class, "lowerMotor");
        lowerMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        pidController = new PIDController(kP, kI, kD);
        pidController.setTolerance(TOLERANCE);
    }

    public double getRPM() {
        return (lowerMotor.getVelocity() / TICKS_PER_REVOLUTION) * SECOND_TO_MINUTE * RATIO;
    }

    public void setPower(double power) {
//        motorRight.setPower(power);
        lowerMotor.setPower(power);
    }

    @Override
    public void periodic() {

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "shooterRPM",
                getRPM()
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "shooterTarget",
                pidController.getSetPoint()
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "shooterPower",
                lowerMotor.getPower()
        );
    }
}