package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TuningSpindexerServo extends CommandOpMode {

    private Servo servo;

    @Override
    public void initialize() {
        servo = hardwareMap.get(Servo.class, "spindexerServo");
    }

    @Override
    public void run() {
        super.run();
        servo.setPosition(gamepad1.right_stick_x);
        telemetry.addData("spindexerPosition", servo.getPosition());

        telemetry.update();
    }
}
