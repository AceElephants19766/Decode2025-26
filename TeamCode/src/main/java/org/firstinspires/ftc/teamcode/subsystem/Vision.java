package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Vision extends SubsystemBase {

    private final Limelight3A limelight;

    public Vision(HardwareMap hardwareMap) {

        limelight = hardwareMap.get(Limelight3A.class, "limelight");

        //telemetry.setMsTransmissionInterval(11); todo: figure out why it should be here.

        limelight.pipelineSwitch(0);
        limelight.start();
    }

    public LLResult getResult() {
        return limelight.getLatestResult();
    }

    public boolean isResultValid(LLResult result) {
        return (result != null) && (result.isValid());
    }

    public void updateRobotOrientation(GaryDrivetrain garyDrivetrain) {
        limelight.updateRobotOrientation(
                Math.toDegrees(
                        garyDrivetrain.getFollower().getHeading()
                )
        );
    }

}
