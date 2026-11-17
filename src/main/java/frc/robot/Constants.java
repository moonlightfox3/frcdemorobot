// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.util.AutoBuilder;
import frc.robot.util.AutoBuilder.AutoPartArm;
import frc.robot.util.AutoBuilder.AutoPartDrive;

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
    public static final double kDeadband = 0.05;                     // Controller deadband radius

    public static final boolean kDefaultSteer = false;               // Use steer instead of tank controls by default
    public static final boolean kAllowSwitch = true;                 // Allow switching controls between tank and steer

    public static final boolean kAllowArm = true;                    // Allow controlling the arm
    public static final double kArmSpeed = 0.1;                      // Arm control speed
    public static final String kArmButtonForward = "left";           // POV button for moving the arm forward ("up", "down", "left", "right")
    public static final String kArmButtonBackward = "right";         // POV button for moving the arm backward ("up", "down", "left", "right")
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
    public static final MotorType kTypeDrive = MotorType.kBrushless; // Drive motors brush type
    public static final MotorType kTypeArm = MotorType.kBrushless;   // Arm motor brush type

    public static final boolean kArmAbsLimitEnable = true;           // Enable arm motor absolute position limits
    public static final double kArmAbsLimitForward = 0.8;            // Arm motor forward absolute position limit in rotations
    public static final double kArmAbsLimitBackward = 0.2;           // Arm motor backward absolute position limit in rotations
    public static final double kArmAbsLimitShift = 0.5;              // Arm motor absolute position shift in rotations (-1.0 - 1.0)
  }

  public static class AutoConstants {                              // Auto constants
    public static final AutoBuilder kAuto = new AutoBuilder(         // Auto path
      new AutoPartDrive(0.2, 0.2, 3.0),
      new AutoPartArm(0.1, 2.0),
      new AutoPartDrive(-0.2, -0.2, 3.0),
      new AutoPartArm(-0.1, 2.0)
    );
  }
}
