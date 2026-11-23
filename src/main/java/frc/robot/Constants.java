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
    public static final int kPort = 0;                               // Controller port number
    public static final double kDeadband = 0.05;                     // Controller deadband radius

    public static final boolean kAllowSwitch = true;                 // Allow switching tank/steer controls
    public static final boolean kDefaultSteer = false;               // Default to steer controls

    public static final boolean kAllowDrive = true;                  // Allow controlling the drivetrain
    public static final double kMaxSpeedDrive = 0.25;                // Maximum drivetrain motor speed

    public static final boolean kAllowArm = true;                    // Allow controlling the arm
    public static final double kArmSpeed = 0.5;                      // Arm motor speed
    public static final String kArmButtonForward = "left";           // POV button to move the arm forward
    public static final String kArmButtonBackward = "right";         // POV button to move the arm backward
  }

  public static class MotorConstants {                             // Motor constants
    public static final int kIdLeft = 1;                             // Left drivetrain motor ID
    public static final int kIdRight = 2;                            // Right drivetrain motor ID
    public static final int kIdArm = 3;                              // Arm motor ID

    public static final boolean kInvertLeft = false;                 // Invert left drivetrain motor
    public static final boolean kInvertRight = false;                // Invert right drivetrain motor
    public static final boolean kInvertArm = false;                  // Invert arm motor

    public static final MotorType kTypeDrive = MotorType.kBrushless; // Drivetrain motor brush type
    public static final MotorType kTypeArm = MotorType.kBrushless;   // Arm motor brush type
  }
}
