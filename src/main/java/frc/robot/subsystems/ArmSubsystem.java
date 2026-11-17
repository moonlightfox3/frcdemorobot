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

  private double m_cachedAbsPos = 0.0;
  private boolean m_hasCachedAbsPos = false;

  private ArmSubsystem() {
    setSpeed(0.0);
  }
  @Override
  public void periodic() {
    m_hasCachedAbsPos = false;
    if ((m_setpoint > 0.0 && !getCanMoveForward()) || (m_setpoint < 0.0 && !getCanMoveBackward())) setSpeed(0.0);

    Logger.recordOutput("RoboticsClass/Arm/Setpoint", m_setpoint);
    Logger.recordOutput("RoboticsClass/Arm/Absolute Position", getAbsPos());
    Logger.recordOutput("RoboticsClass/Arm/Can Move Forward", getCanMoveForward());
    Logger.recordOutput("RoboticsClass/Arm/Can Move Backward", getCanMoveBackward());
  }

  /** Caches the absolute position for one tick */
  public double getAbsPos () {
    if (m_hasCachedAbsPos) return m_cachedAbsPos;
    else {
      double pos = m_motor.getAbsoluteEncoder().getPosition() + MotorConstants.kArmAbsLimitShift;
      if (pos < 0.0) pos += 1.0;
      if (pos >= 1.0) pos -= 1.0;

      m_cachedAbsPos = pos;
      m_hasCachedAbsPos = true;
      return m_cachedAbsPos;
    }
  }
  /** Forward: Absolute encoder position increases */
  public boolean getCanMoveForward () {
    if (MotorConstants.kArmAbsLimitEnable) return getAbsPos() < MotorConstants.kArmAbsLimitForward;
    else return true;
  }
  /** Backward: Absolute encoder position decreases */
  public boolean getCanMoveBackward () {
    if (MotorConstants.kArmAbsLimitEnable) return getAbsPos() > MotorConstants.kArmAbsLimitBackward;
    else return true;
  }

  /** Speed: -1.0 - 1.0 */
  public void setSpeed (double speed) {
    double setpoint = speed * (MotorConstants.kInvertArm ? -1 : 1);
    if ((setpoint > 0.0 && !getCanMoveForward()) || (setpoint < 0.0 && !getCanMoveBackward())) setpoint = 0.0;
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
