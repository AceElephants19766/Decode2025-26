package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.ShooterPID;
import org.firstinspires.ftc.teamcode.subsystem.Turret;

@TeleOp
public class TurretTest extends CommandOpMode {

    private Turret turret;

    @Override
    public void initialize() {
        turret = new Turret(hardwareMap);
    }

    @Override
    public void run() {
        super.run();
        turret.setPower(gamepad1.left_stick_x);
        telemetry.addData("turret power", gamepad1.left_stick_x);
        telemetry.update();
    }
}
