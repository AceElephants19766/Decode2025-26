package org.firstinspires.ftc.teamcode.subsystem;

import android.provider.Settings;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.TurretGetToAngle;

@Configurable
public class Turret extends SubsystemBase {

    //Hardware
    private final DcMotorEx turretMotor;

    //Control
    private final PIDFController pidfController;
    public static double kP = 0.01;
    public static double kI = 0.00001;
    public static double kD = 0.;
    public static double kF = 0.;
    private final double TOLERANCE = 5;
    //Constants
    private final double REV_TO_ANGLE = 360;
    private final double TICKS_PER_REV = 537.7;
    private final double RATIO = 37./ 160;

    public Turret(HardwareMap hardwareMap) {
        turretMotor = hardwareMap.get(DcMotorEx.class, "turretMotor");
        pidfController = new PIDFController(kP, kI, kD, kF);
        pidfController.setTolerance(TOLERANCE);

        turretMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }



    public PIDFController getPidfController() {
        return pidfController;
    }

    public double getPosition() {
        return (-turretMotor.getCurrentPosition() / TICKS_PER_REV) * RATIO * REV_TO_ANGLE;
    }

    public void setPower(double power) {
        turretMotor.setPower(power);
    }

    @Override
    public void periodic() {
      PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretTarget", pidfController.getSetPoint()
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretAngle", getPosition()
        );
    }
}

