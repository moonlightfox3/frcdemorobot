// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Drivetrain extends SubsystemBase {
  private SparkFlex m_leftMotor = new SparkFlex(MotorConstants.kIdLeft, MotorConstants.kType);
  private SparkFlex m_rightMotor = new SparkFlex(MotorConstants.kIdRight, MotorConstants.kType);

  private double m_leftSetpoint = 0.0;
  private double m_rightSetpoint = 0.0;

  public Drivetrain() {
    setSpeed(0.0, 0.0);
  }
  @Override
  public void periodic() {
    Logger.recordOutput("RoboticsClass/Drivetrain/Left Setpoint", m_leftSetpoint);
    Logger.recordOutput("RoboticsClass/Drivetrain/Right Setpoint", m_rightSetpoint);
  }

  /** Speed: -1 to 1 */
  public void setLeftSpeed(double speed) {
    m_leftSetpoint = speed * (MotorConstants.kInvertLeft ? -1 : 1);
    m_leftMotor.set(m_leftSetpoint);
  }
  /** Speed: -1 to 1 */
  public void setRightSpeed(double speed) {
    m_rightSetpoint = speed * (MotorConstants.kInvertRight ? -1 : 1);
    m_rightMotor.set(m_rightSetpoint);
  }
  /** Speed: -1 to 1 */
  public void setSpeed(double lSpeed, double rSpeed) {
    setLeftSpeed(lSpeed);
    setRightSpeed(rSpeed);
  }
  
  private static Drivetrain INSTANCE = null;
  public static Drivetrain getInstance() {
    if (INSTANCE == null) INSTANCE = new Drivetrain();
    return INSTANCE;
  }
}
