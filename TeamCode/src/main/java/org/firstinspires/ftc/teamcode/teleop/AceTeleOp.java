package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.IntakeActivate;
import org.firstinspires.ftc.teamcode.commands.IntakeDeactivate;
import org.firstinspires.ftc.teamcode.commands.SorterSetPosition;
import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.Sorter;


@TeleOp
public class AceTeleOp extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private GamepadEx gamepadEx1;
    private Sorter sorter;
    private Intake intake;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);
        sorter = new Sorter(hardwareMap);
        intake = new Intake(hardwareMap);

/*        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new MotorStart(garyDrivetrain));
        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new MotorStop(garyDrivetrain));*/

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new SorterSetPosition(sorter, 0.5));
        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new SorterSetPosition(sorter, 1));
        gamepadEx1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new IntakeActivate(intake),
                new IntakeDeactivate(intake)//
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
