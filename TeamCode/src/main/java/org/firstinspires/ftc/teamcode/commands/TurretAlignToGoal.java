package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Turret;
import org.firstinspires.ftc.teamcode.utils.Constants;

import java.util.function.DoubleSupplier;

public class TurretAlignToGoal extends TurretGetToAngle {

    public TurretAlignToGoal(Turret turret, GaryDrivetrain garyDrivetrain, boolean isGoalBlue) {
        super(turret, () -> {
                    Vector2d goalPose = isGoalBlue ? Constants.BLUE_GOAL_POS : Constants.RED_GOAL_POS;

                    double absAngle = Math.atan2(
                            goalPose.getY() - garyDrivetrain.getFollower().getPose().getY(),
                            goalPose.getX() - garyDrivetrain.getFollower().getPose().getX()
                    );

                    double turretAngle = Math.toDegrees(
                            absAngle - garyDrivetrain.getFollower().getHeading()
                    );

                    turretAngle = (turretAngle > 180) ? (turretAngle - 360) : turretAngle;

                    turretAngle = (turretAngle < -180) ? (turretAngle + 360) : turretAngle;

                    return turretAngle;
                }
        );
    }
}
