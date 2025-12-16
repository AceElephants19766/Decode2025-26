package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.learning.SorterSetPositionShorter;
import org.firstinspires.ftc.teamcode.subsystem.TwoMotorDrive;


@TeleOp
public class MecanumDrive extends CommandOpMode {

    private TwoMotorDrive twoMotorDrive;
    private GamepadEx gamepadEx1;

    @Override
    public void initialize() {

        twoMotorDrive = new TwoMotorDrive(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);

/*        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new MotorStart(garyDrivetrain));
        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new MotorStop(garyDrivetrain));*/

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new SorterSetPositionShorter());

        CommandScheduler.getInstance().setDefaultCommand(twoMotorDrive, new Drive(twoMotorDrive, gamepad1));
    }

    @Override
    public void run() {
        super.run();

        telemetry.addData("joystickX", gamepad2.right_stick_x);
        telemetry.addData("joystickY", gamepad2.right_stick_y);
//        telemetry.addData("frontLeftPower", frontLeft.getPower());

        telemetry.update();

    }

}
