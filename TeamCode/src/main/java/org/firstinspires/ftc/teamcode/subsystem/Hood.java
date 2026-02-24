package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.util.InterpLUT;
import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Configurable
public class Hood extends SubsystemBase {

    private final Servo hood;

    public static final double MIN_POS = 0.55;
    public static final double MAX_POS = 0.94;

    public static double TUNING_POS = MAX_POS;

    public InterpLUT hoodTable;

    public void setTable() {
        hoodTable = new InterpLUT();
        hoodTable.add(0,0);
        hoodTable.add(0,0);
//        hoodTable.createLUT();
    }

    public Hood(HardwareMap hardwareMap) {
        hood = hardwareMap.get(Servo.class, "hood");
        setTable();
    }

    public void setPosition(double position) {
        position = Math.max(position, MIN_POS);
        hood.setPosition(position);
    }

}
