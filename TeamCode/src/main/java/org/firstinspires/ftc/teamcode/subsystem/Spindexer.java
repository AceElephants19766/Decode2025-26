package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spindexer extends SubsystemBase {

    private final Servo servo;

    public enum Positions {

        ZERO(0),
        ONE(0.45),
        TWO(0.87);

        private double val;

        Positions(double val) {
            this.val = val;
        }

        public double getVal() {
            return val;
        }
    }

    private Positions[] positionsArr = Positions.values();
    private int indexer = 0;

    public Spindexer(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, "spindexerServo");
    }

    public void setPosition(double position) {
        servo.setPosition(position);
    }

    public double getPos(){
        return servo.getPosition();
    }

    public void positionSpindexerUp() {
        if(indexer + 1 <= 2) indexer++;
        updatePos();
    }

    public void positionSpindexerDown() {
        if(indexer - 1 >= 0) indexer--;
        updatePos();
    }

    public void updatePos() {
        servo.setPosition(positionsArr[indexer].getVal());
    }
}


