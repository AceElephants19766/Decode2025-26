package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.ShooterGetToRPM;
import org.firstinspires.ftc.teamcode.subsystem.ShooterPID;

@TeleOp
public class TuningHoodAndShooter extends CommandOpMode {

    private GamepadEx gamepadEx1;

    private ShooterPID shooterPID;

    private Servo hood;


    @Override
    public void initialize() {
        shooterPID = new ShooterPID(hardwareMap);
        hood = hardwareMap.get(Servo.class, "hood");
        gamepadEx1 = new GamepadEx(gamepad1);
    }

    @Override
    public void run() {
        super.run();

        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new ShooterGetToRPM(shooterPID, -2200)
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new InstantCommand(
                        () -> hood.setPosition(1)
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.X).whenPressed(
                new InstantCommand(
                        () -> hood.setPosition(0.8)
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new InstantCommand(
                        () -> hood.setPosition(0)
                )
        );

        telemetry.addData("RPM", shooterPID.getRPM());
        telemetry.update();
        FtcDashboard.getInstance().getTelemetry().update();
    }
}


