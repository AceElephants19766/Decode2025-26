package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Turret;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class TurretAlignToGoal extends CommandBase {

    private Turret turret;
    private GaryDrivetrain garyDrivetrain;
    private final boolean isGoalBlue;

    private double angleRes;
    private Vector2d goalPos;

    public TurretAlignToGoal(
            Turret turret,
            GaryDrivetrain garyDrivetrain,
            boolean isGoalBlue
    ) {
        this.turret = turret;
        this.garyDrivetrain = garyDrivetrain;
        this.isGoalBlue = isGoalBlue;
    }

    @Override
    public void execute() {

        /*
        this is the calculation of the angle:
        notice that this is written inside the execute method.
        if this is too heavy for the control hub, move to the initialize.
        i just think that it will be better to check if the angle has changed if the robot has moved.
        but if it's too heavy to run, then it should be fine in the initialize stage aswell.
        (it just wouldn't update while running, you'll have to stop and start the command
        again - if you moved with the bot's position)
         */

        goalPos = isGoalBlue ? Constants.BLUE_GOAL_POS : Constants.RED_GOAL_POS;
        angleRes = Math.toDegrees(-garyDrivetrain.getFollower().getHeading() + Math.atan2(
                (goalPos.getY() - garyDrivetrain.getFollower().getPose().getY()),
                (goalPos.getX() - garyDrivetrain.getFollower().getPose().getX())
        ));
        angleRes = (angleRes > 180) ? (angleRes - 360) : angleRes;
        angleRes = (angleRes < -180) ? (angleRes + 360) : angleRes;

        turret.getPidfController().setSetPoint(angleRes);

        //this is the end of the angle's calculation - if you need to move it to the initialize.
        //(yes, im talking to you dolev).

        turret.setPower(
                turret.getPidfController().calculate(
                        turret.getPosition()
                )
        );

    }

    @Override
    public boolean isFinished() {
        return turret.getPidfController().atSetPoint();
    }

    @Override
    public void end(boolean interrupted) {
        turret.setPower(0);
    }
}
