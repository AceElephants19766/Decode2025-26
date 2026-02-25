package org.firstinspires.ftc.teamcode.utils;

import com.arcrobotics.ftclib.geometry.Vector2d;
import com.pedropathing.geometry.Pose;

public class Constants {

    public static final Vector2d RED_GOAL_POS = new Vector2d(138,138);
    public static final Vector2d BLUE_GOAL_POS = new Vector2d(6,138);

    public static final Pose RED_WALL_STARTING_POSE = new Pose(48, 9, Math.toRadians(90));
    public static final Pose RED_GOAL_STARTING_POSE = new Pose(0, 0, Math.toRadians(0)); //todo

    public static final Pose BLUE_WALL_STARTING_POSE = new Pose(96, 9, Math.toRadians(90));
    public static final Pose BLUE_GOAL_STARTING_POSE = new Pose(0, 0, Math.toRadians(0));
}