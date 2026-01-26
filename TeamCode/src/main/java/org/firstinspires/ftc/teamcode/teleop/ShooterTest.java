package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class ShooterTest extends CommandOpMode {

    DcMotorEx shooterMotor;
    GamepadEx gamepadEx1;

    @Override
    public void initialize() {

        shooterMotor = hardwareMap.get(DcMotorEx.class, "shooter");
        gamepadEx1 = new GamepadEx(gamepad1);

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).toggleWhenPressed(
                new InstantCommand(() -> shooterMotor.setPower(0.5)),
                new InstantCommand(() -> shooterMotor.setPower(0))
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).toggleWhenPressed(
                new InstantCommand(() -> shooterMotor.setPower(-0.5)),
                new InstantCommand(() -> shooterMotor.setPower(0))
        );
    }
}
