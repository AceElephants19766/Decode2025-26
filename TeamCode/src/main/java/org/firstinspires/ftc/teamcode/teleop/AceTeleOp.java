package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.PerpetualCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.bylazar.telemetry.PanelsTelemetry;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.GetHoodToAngleInterp;
import org.firstinspires.ftc.teamcode.commands.HoodSetPosition;
import org.firstinspires.ftc.teamcode.commands.IntakeActivate;
import org.firstinspires.ftc.teamcode.commands.IntakeDeactivate;
import org.firstinspires.ftc.teamcode.commands.ResetIMU;
import org.firstinspires.ftc.teamcode.commands.ShooterGetToRPM;
import org.firstinspires.ftc.teamcode.commands.TurretAlignToGoal;
import org.firstinspires.ftc.teamcode.commands.TurretAlignToGoalExecute;
import org.firstinspires.ftc.teamcode.commands.TurretGetToAngle;
import org.firstinspires.ftc.teamcode.subsystem.Braker;
import org.firstinspires.ftc.teamcode.subsystem.Conveyor;
import org.firstinspires.ftc.teamcode.subsystem.ElevationSpoon;
import org.firstinspires.ftc.teamcode.subsystem.GaryDrivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Hood;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.ShooterPID;
import org.firstinspires.ftc.teamcode.subsystem.Turret;
import org.firstinspires.ftc.teamcode.utils.Constants;

public class AceTeleOp extends CommandOpMode {

    private GaryDrivetrain garyDrivetrain;
    private GamepadEx gamepadEx1;
    private GamepadEx gamepadEx2;
    private Intake intake;
    private Conveyor conveyor;
    private ShooterPID shooterPID;
    private Turret turret;
    private ElevationSpoon elevationSpoon;
    private Braker braker;
    private Hood hood;

    private boolean isBlue;
    private boolean isNextToWall;

    private Pose startingPose;

    public AceTeleOp(boolean isBlue, boolean isNextToWall) {
        this.isBlue = isBlue;
        this.isNextToWall = isNextToWall;
    }

    @Override
    public void initialize() {

        garyDrivetrain = new GaryDrivetrain(hardwareMap, isBlue);
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);
        intake = new Intake(hardwareMap);
        conveyor = new Conveyor(hardwareMap);
        shooterPID = new ShooterPID(hardwareMap);
        turret = new Turret(hardwareMap);
        elevationSpoon = new ElevationSpoon(hardwareMap);
        braker = new Braker(hardwareMap);
        hood = new Hood(hardwareMap);

        if (isBlue) {
            startingPose = isNextToWall ? Constants.BLUE_WALL_STARTING_POSE : Constants.BLUE_GOAL_STARTING_POSE;
        } else {
            startingPose = isNextToWall ? Constants.RED_WALL_STARTING_POSE : Constants.RED_GOAL_STARTING_POSE;
        }

        garyDrivetrain.getFollower().setStartingPose(startingPose);

        gamepadEx1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).toggleWhenPressed(
                new InstantCommand(
                        () -> conveyor.SetPower(-1)
                ),
                new InstantCommand(
                        () -> conveyor.SetPower(0)
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.X).toggleWhenPressed(
                new ShooterGetToRPM(shooterPID, 2500)
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new IntakeActivate(intake),
                new IntakeDeactivate(intake)
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(
                new HoodSetPosition(hood, () -> Hood.TUNING_POS)
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new SequentialCommandGroup(
                        new InstantCommand(
                                () -> elevationSpoon.up()
                        ),
                        new WaitCommand(
                                ElevationSpoon.TIME_BETWEEN_UP_AND_DOWN
                        ),
                        new InstantCommand(
                                () -> elevationSpoon.down()
                        )
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.DPAD_UP).toggleWhenPressed(
                new InstantCommand(
                        () -> braker.blocking()
                ),
                new InstantCommand(
                        () -> braker.free()
                )
        );

        gamepadEx1.getGamepadButton(GamepadKeys.Button.B).toggleWhenPressed(
                new TurretAlignToGoalExecute(turret, garyDrivetrain, isBlue)
        );

        CommandScheduler.getInstance().setDefaultCommand(garyDrivetrain, new Drive(garyDrivetrain, gamepad1));

        hood.setDefaultCommand(
                new GetHoodToAngleInterp(garyDrivetrain, hood, isBlue)
        );
    }

    @Override
    public void run() {
        super.run();

        garyDrivetrain.getFollower().update();

        telemetry.addData("isElevationSpoonDown", elevationSpoon.isDown());
        telemetry.addData("isShooterBlocked", braker.isBlocking());

        PanelsTelemetry.INSTANCE.getTelemetry().update();
        telemetry.update();
    }
}
