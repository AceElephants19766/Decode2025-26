/*package org.firstinspires.ftc.teamcode.commands.learning;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ControlSystem;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class turretAutoAim extends OpMode {

    DcMotorEx turret;
    Follower follower;
    Pose trackPoint = GlobalVariables.BlueGoalPos;//(x:0,y:144)
    Pose startPose = GlobalVariables.startPoseFarBlue;
    double ppr = 751.8;// from motor, idk the motor im using rn
    public static PIDCoefficients turretpid = new PIDCoefficients(0,0,0);

    ControlSystem pid;

    double gearRatio = 1/(4.6);
    double getDegrees() {
        return turret.getCurrentPosition() * 360.0/(ppr*gearRatio);
    }

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startPose);
        turret = hardwareMap.get(DcMotorEx.class,"turret");

        pid = ControlSystem.builder()
                .velPid(turretpid)
                .build();
    }

    @Override
    public void loop() {
        double setpoint = Math.toDegrees(Math.atan2(trackPoint.getY()-follower.getPose().getY(),
                trackPoint.getX()-follower.getPose().getX())); //חשוב
        if(setpoint>180) {
            setpoint = 180;
        }else if(setpoint<-180){
            setpoint = -180;
        }
        pid.setGoal(new KineticState(setpoint,0));

        turret.setPower(pid.calculate(new KineticState(getDegrees(),0)));
        telemetry.addData("setPoint",setpoint);
        telemetry.addData("turretPos",turret.getCurrentPosition());
        telemetry.addData("turretAngle",getDegrees());
        telemetry.update();
    }
}
*/