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
  public static class ControllerConstants {                        // Controller constants
    public static final int kPort = 0;                               // Controller port
    public static final double kDeadband = 0.05;                     // Controller deadband radius (0.0 - 1.0)
    public static final boolean kDefaultSteer = false;               // Use steer instead of tank controls by default
  }
  public static class MotorConstants {                             // Motor constants
    public static final int kIdLeft = 1;                             // Left motor ID
    public static final int kIdRight = 2;                            // Right motor ID
    public static final int kIdArm = 3;                              // Arm motor ID
    public static final boolean kInvertLeft = false;                 // Invert left motor
    public static final boolean kInvertRight = true;                 // Invert right motor
    public static final boolean kInvertArm = false;                  // Invert arm motor
    public static final double kMaxSpeedDrive = 0.25;                // Maximum drive motor speed (0.0 - 1.0)
    public static final double kMaxSpeedArm = 0.25;                  // Maximum arm motor speed (0.0 - 1.0)
    public static final MotorType kTypeDrive = MotorType.kBrushless; // Drive motor brush type
    public static final MotorType kTypeArm = MotorType.kBrushless;   // Arm motor brush type
  }
  public static class AutoConstants {                              // Auto constants (TODO: Auto arm movement?)
    public static final double kSpeedLeft = 0.1;                     // Left motor speed (-1.0 - 1.0)
    public static final double kSpeedRight = 0.1;                    // Right motor speed (-1.0 - 1.0)
    public static final double kLengthSeconds = 3.0;                 // Seconds until stopping both motors (0.0 +)
  }
}
