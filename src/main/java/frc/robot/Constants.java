// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ControlConstants {
    public static final int kControllerPort = 0;
    public static final double kControllerDeadband = 0.05;
    public static final double kMotorMaxSpeed = 0.25;
  }
  public static class MotorConstants {
    public static final int kMotorLeftId = 1;
    public static final int kMotorRightId = 2;
    public static final MotorType kMotorType = MotorType.kBrushless;
  }
  public static class BehaviorConstants {
    public static final double kAutoSpeedLeft = 0.1;
    public static final double kAutoSpeedRight = 0.1;
    public static final double kAutoLengthSeconds = 3.0;
  }
}
