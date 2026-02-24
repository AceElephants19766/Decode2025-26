package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.bylazar.telemetry.PanelsTelemetry;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Turret;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class TurretAlignToGoalExecute extends CommandBase {

    private final Turret turret;
    private final GaryDrivetrain garyDrivetrain;
    private final boolean isGoalBlue;

    public TurretAlignToGoalExecute(Turret turret, GaryDrivetrain garyDrivetrain, boolean isGoalBlue) {
        this.turret = turret;
        this.garyDrivetrain = garyDrivetrain;
        this.isGoalBlue = isGoalBlue;
        addRequirements(turret);
    }

    @Override
    public void execute() {

        Vector2d goalPose = isGoalBlue ? Constants.BLUE_GOAL_POS : Constants.RED_GOAL_POS;

        double absAngle = Math.atan2(
                goalPose.getY() - garyDrivetrain.getFollower().getPose().getY(),
                goalPose.getX() - garyDrivetrain.getFollower().getPose().getX()
        );

        double turretAngle = Math.toDegrees(
                absAngle - garyDrivetrain.getHeadingNormal()
        );

        turretAngle = (turretAngle > 90) ? 90 : turretAngle;

        turretAngle = (turretAngle < -90) ? -90 : turretAngle;

        PanelsTelemetry.INSTANCE.getTelemetry().addData(
                "turretAlignToAngle", turretAngle
        );

        turret.getPidController().setGoal(turretAngle);

        turret.setPower(
                turret.getPidController().calculate(
                        turret.getPosition()
                )
        );
    }

    @Override
    public void end(boolean interrupted) {
        turret.setPower(0);
    }
}