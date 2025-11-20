package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.learning.MotorStart;
import org.firstinspires.ftc.teamcode.commands.learning.MotorStop;
import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;

@TeleOp
public class MecanumDrive extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private GamepadEx gamepadEx1;

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap);
        gamepadEx1 = new GamepadEx(gamepad1);

/*        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new MotorStart(garyDrivetrain));
        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new MotorStop(garyDrivetrain));*/

        CommandScheduler.getInstance().setDefaultCommand(garyDrivetrain, new Drive(garyDrivetrain, gamepad1));
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
