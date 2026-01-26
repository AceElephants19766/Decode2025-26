package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TuningServos extends CommandOpMode {

    private Servo leftServo;
    private Servo rightServo;

    @Override
    public void initialize() {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
    }

    @Override
    public void run() {
        super.run();

        rightServo.setPosition(1-  gamepad1.right_trigger);
        leftServo.setPosition(gamepad1.right_trigger);

        telemetry.addData("rightTrigger", gamepad1.right_trigger);

        telemetry.update();
    }

}
