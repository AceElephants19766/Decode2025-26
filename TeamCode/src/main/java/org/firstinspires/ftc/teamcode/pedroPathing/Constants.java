
package org.firstinspires.ftc.teamcode.pedroPathing;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@Config

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(7)

            .forwardZeroPowerAcceleration(53.5844)
            .lateralZeroPowerAcceleration(85.3676)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.02, 0, 0.001, 0.0039))
            .headingPIDFCoefficients(new PIDFCoefficients(0.7, 0, 0.02, 0))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.0, 0.0, 0.0, 0.0, 0.0));

    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,
            100,
            1,
            1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pinpointLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .build();
    }

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("frontRight")
            .rightRearMotorName("backRight")
            .leftRearMotorName("backLeft")
            .leftFrontMotorName("frontLeft")

            .leftRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .leftFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)


            .xVelocity(63.81357496366727)
            .yVelocity(60.81);

    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(-120)
            .strafePodX(-160)
            .distanceUnit(DistanceUnit.METER) //mm
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);
}


/*      -304875.72966215754

Multiplier: -79563.43057570595
Multiplier: -75416.55874829272
Multiplier: -75416.55874829272
Multiplier: 39253.15359594284
Multiplier: 99981.44185367873












 */