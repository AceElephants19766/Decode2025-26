package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.IntakeActivate;
import org.firstinspires.ftc.teamcode.commands.IntakeDeactivate;
import org.firstinspires.ftc.teamcode.subsystem.ElevationSpoon;
import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Shooter;


@TeleOp
public class AceTeleOp extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private GamepadEx gamepadEx1;
    private Intake intake;
    private ElevationSpoon elevationSpoon;
    private Shooter shooter;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);
        intake = new Intake(hardwareMap);
        elevationSpoon = new ElevationSpoon(hardwareMap);
        shooter = new Shooter(hardwareMap);

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new InstantCommand(
                        () -> elevationSpoon.down()
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new InstantCommand(
                        () -> elevationSpoon.up()
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new IntakeActivate(intake),
                new IntakeDeactivate(intake)//
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).toggleWhenPressed(
                new InstantCommand(
                        () -> shooter.setPower(1)
                ),
                new InstantCommand(
                        () -> shooter.setPower(0)
                )
        );

        CommandScheduler.getInstance().setDefaultCommand(garyDrivetrain, new Drive(garyDrivetrain, gamepad1));
    }

    @Override
    public void run() {
        super.run();

        telemetry.addData("joystickX", gamepad2.right_stick_x);
        telemetry.addData("joystickY", gamepad2.right_stick_y);
        telemetry.addData("imu angle", garyDrivetrain.getAngleYaw());
//        telemetry.addData("frontLeftPower", frontLeft.getPower());

        telemetry.update();

    }

}
