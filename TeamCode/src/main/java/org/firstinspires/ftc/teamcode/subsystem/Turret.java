package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.ProfiledPIDController;
import org.firstinspires.ftc.teamcode.utils.TrapezoidProfile;

@Configurable
public class Turret extends SubsystemBase {

    //Hardware
    private final DcMotorEx turretMotor;

    //Control
    private final ProfiledPIDController pidController;
    public static double kP = 0.08;
    public static double kI = 0.00001;
    public static double kD = 0.;
    private final double TOLERANCE = 5;

    public static double MAX_VELOCITY = Integer.MAX_VALUE;
    public static double MAX_ACCELERATION = 60;

    //Constants
    private final double REV_TO_ANGLE = 360;
    private final double TICKS_PER_REV = 537.7;
    private final double RATIO = 37./ 160;

    public Turret(HardwareMap hardwareMap) {
        turretMotor = hardwareMap.get(DcMotorEx.class, "turretMotor");
        turretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pidController = new ProfiledPIDController(kP, kI, kD, new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));
        pidController.setTolerance(TOLERANCE);

        turretMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }



    public ProfiledPIDController getPidController() {
        return pidController;
    }

    private double convertEncoderValToTurretAngle(double encoderVal) {
        return (-encoderVal / TICKS_PER_REV) * RATIO * REV_TO_ANGLE;
    }

    public double getPosition() {
        return convertEncoderValToTurretAngle(turretMotor.getCurrentPosition());
    }

    public double getVelocity() {
        return convertEncoderValToTurretAngle(turretMotor.getVelocity());
    }

    public void setPower(double power) {
        turretMotor.setPower(power);
    }

    @Override
    public void periodic() {
      PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretTarget", pidController.getGoal().position
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretAngle", getPosition()
        );

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretVel", getVelocity()
        );
    }
}

