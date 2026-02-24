package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TuningServos extends CommandOpMode {

    private Servo rightServo;
    private Servo leftServo;

    @Override
    public void initialize() {
        rightServo = hardwareMap.get(Servo.class, "rightServo");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
    }

    @Override
    public void run() {
        super.run();

        rightServo.setPosition(gamepad1.right_trigger);
        leftServo.setPosition(1-gamepad1.right_trigger);

        telemetry.addData("rightTrigger", gamepad1.right_trigger);

        telemetry.update();
    }

}
