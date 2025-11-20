package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motors", group = "Test")
public class TwoMotors extends CommandOpMode {

    DcMotor motor;
    DcMotor motor2;

    @Override
    public void initialize() {
         motor = hardwareMap.get(DcMotor.class, "motor");
         motor2 = hardwareMap.get(DcMotor.class, "motor1");

    }

    @Override
    public void run() {
        super.run();
        motor.setPower(1.0);
        motor2.setPower(-1.0);


    }

}
