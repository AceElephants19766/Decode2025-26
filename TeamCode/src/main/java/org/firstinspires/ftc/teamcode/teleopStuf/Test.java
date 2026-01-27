package org.firstinspires.ftc.teamcode.teleopStuf;
import com.arcrobotics.ftclib.command.CommandOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Raw Motor Test", group = "Test")
public class Test extends CommandOpMode {

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

        // הפעלה בעוצמה מלאה
        motor.setPower(1.0);
        motor2.setPower(-1.0);
        telemetry.addData("Power", motor.getPower());
        telemetry.update();

    }

    @Override
    public void reset() {
        super.reset();
        // עצירה בסוף
        motor.setPower(0);
        motor2.setPower(0);
    }
}
