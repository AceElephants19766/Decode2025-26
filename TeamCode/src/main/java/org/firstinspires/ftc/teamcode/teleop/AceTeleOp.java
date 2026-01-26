package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.IntakeActivate;
import org.firstinspires.ftc.teamcode.commands.IntakeDeactivate;
import org.firstinspires.ftc.teamcode.commands.ShooterGetToRPM;
import org.firstinspires.ftc.teamcode.subsystem.ElevationSpoon;
import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Shooter;
import org.firstinspires.ftc.teamcode.subsystem.ShooterPID;
import org.firstinspires.ftc.teamcode.subsystem.Spindexer;

import java.lang.annotation.Target;


@TeleOp
public class AceTeleOp extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private GamepadEx gamepadEx1;
    private GamepadEx gamepadEx2;
    private Intake intake;
    private ElevationSpoon elevationSpoon;
    private ShooterPID shooterPID;
    private Spindexer spindexer;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);
        intake = new Intake(hardwareMap);
        elevationSpoon = new ElevationSpoon(hardwareMap);
        shooterPID = new ShooterPID(hardwareMap);
        spindexer = new Spindexer(hardwareMap);


        gamepadEx2.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new SequentialCommandGroup(
                        new InstantCommand(
                                () -> elevationSpoon.up()
                        ),
                        new WaitCommand(650),
                        new InstantCommand(
                                () -> elevationSpoon.down()
                        )
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.X).toggleWhenPressed(
                new ShooterGetToRPM(shooterPID,3000)
        );


        gamepadEx1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new IntakeActivate(intake),
                new IntakeDeactivate(intake)//
        );

        gamepadEx2.getGamepadButton(GamepadKeys.Button.B).toggleWhenPressed(
                new InstantCommand(
                        () -> shooterPID.setPower(-1)
                ),
                new InstantCommand(
                        () -> shooterPID.setPower(0)
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.START).whenPressed(
                new InstantCommand(
                        () -> garyDrivetrain.resetIMU()
                )
        );

        gamepadEx2.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(
                new InstantCommand(
                        () -> spindexer.setPosition(spindexer.ZERO)
                )
        );

        gamepadEx2.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(
                new InstantCommand(
                        () -> spindexer.setPosition(spindexer.ONE)
                )
        );

        gamepadEx2.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(
                new InstantCommand(
                        () -> spindexer.setPosition(spindexer.TWO)
                )
        );

        CommandScheduler.getInstance().setDefaultCommand(garyDrivetrain, new Drive(garyDrivetrain, gamepad1));



    }

    @Override
    public void run() {
        super.run();

//        telemetry.addData("RPM", shooterPID.getRPM());
//        telemetry.addData("joystickX", gamepad2.right_stick_x);
//        telemetry.addData("joystickY", gamepad2.right_stick_y);
        telemetry.addData("imu angle", garyDrivetrain.getAngleYaw());

        telemetry.addData("servoPosition", elevationSpoon.getPosition());
//        telemetry.addData("frontLeftPower", frontLeft.getPower());

          telemetry.update();
          FtcDashboard.getInstance().getTelemetry().update();

    }

}
