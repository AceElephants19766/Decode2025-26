package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TuningServos extends CommandOpMode {

    private Servo servo;

    @Override
    public void initialize() {
        servo = hardwareMap.get(Servo.class, "servo") ;
    }

    @Override
    public void run() {
        super.run();

        servo.setPosition(gamepad1.right_trigger);
        telemetry.addData("rightTrigger", gamepad1.right_trigger);

        telemetry.update();
    }

}
