package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Turret;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class TurretAlignToGoal2 extends TurretGetToAngle {
    public TurretAlignToGoal2(Turret turret, GaryDrivetrain garyDrivetrain, boolean isGoalBlue) {
        super(turret, () -> {
            Vector2d goalPos = isGoalBlue ? Constants.BLUE_GOAL_POS : Constants.RED_GOAL_POS;
            double angleRes = Math.toDegrees(-garyDrivetrain.getFollower().getHeading() + Math.atan2(
                    (goalPos.getY() - garyDrivetrain.getFollower().getPose().getY()),
                    (goalPos.getX() - garyDrivetrain.getFollower().getPose().getX())
            ));
            angleRes = (angleRes > 180) ? (angleRes - 360) : angleRes;
            angleRes = (angleRes < -180) ? (angleRes + 360) : angleRes;

            return angleRes;
        });
    }
}
