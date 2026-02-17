package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Conveyor extends SubsystemBase {

private final DcMotorEx conveyor;

 public Conveyor(HardwareMap hardwareMap) {
  conveyor = hardwareMap.get(DcMotorEx.class, "conveyor");
 }

 public void SetPower(double power) {
  conveyor.setPower(power);
 }





}
