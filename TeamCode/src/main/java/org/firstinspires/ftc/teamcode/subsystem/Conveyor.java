package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Conveyor extends SubsystemBase {

    private final DcMotorEx conveyorMotor;
    private final CRServo conveyorServo;
    private final CRServo secondConveyorServo;

    public Conveyor(HardwareMap hardwareMap) {
        conveyorMotor = hardwareMap.get(DcMotorEx.class, "conveyorMotor");
        conveyorServo = hardwareMap.get(CRServo.class, "conveyorServo");
        secondConveyorServo = hardwareMap.get(CRServo.class, "secondConveyorServo");

    }

    public void SetPower(double power) {
        conveyorMotor.setPower(power);
        conveyorServo.setPower(-power);
        secondConveyorServo.setPower(-power);
    }


}
