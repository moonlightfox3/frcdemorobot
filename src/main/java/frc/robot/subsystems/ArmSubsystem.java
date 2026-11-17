// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class ArmSubsystem extends SubsystemBase {
  private SparkFlex m_motor = new SparkFlex(MotorConstants.kIdArm, MotorConstants.kTypeArm);

  private double m_setpoint = 0.0;

  private ArmSubsystem() {
    setSpeed(0.0);
  }
  @Override
  public void periodic() {
    Logger.recordOutput("RoboticsClass/Arm/Setpoint", m_setpoint);
  }

  /** Speed: -1.0 - 1.0 */
  public void setSpeed (double speed) {
    double setpoint = speed * (MotorConstants.kInvertArm ? -1 : 1);
    if (setpoint != m_setpoint) {
      m_setpoint = setpoint;
      m_motor.set(m_setpoint);
    }
  }
  
  private static ArmSubsystem INSTANCE = null;
  public static ArmSubsystem getInstance() {
    if (INSTANCE == null) INSTANCE = new ArmSubsystem();
    return INSTANCE;
  }
}
