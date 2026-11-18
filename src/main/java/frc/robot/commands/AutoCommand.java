// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.util.AutoBuilder.AutoPart;
import frc.robot.util.AutoBuilder.AutoPartArm;
import frc.robot.util.AutoBuilder.AutoPartDrive;

public class AutoCommand extends Command {
  private DrivetrainSubsystem m_drivetrain = null;
  private ArmSubsystem m_arm = null;
  private Timer m_timer = null;
  private AutoPart[] m_parts = null;

  private int m_currentPart = 0;

  public AutoCommand(DrivetrainSubsystem drivetrain, ArmSubsystem arm) {
    addRequirements(drivetrain, arm);
    m_drivetrain = drivetrain;
    m_arm = arm;
    
    m_timer = new Timer();
    m_parts = AutoConstants.kAuto.getParts();
    
    Logger.recordOutput("RoboticsClass/Auto/Current Part", 0);
    Logger.recordOutput("RoboticsClass/Auto/Is Finished", false);
  }

  @Override
  public void initialize() {
    m_currentPart = 0;
    m_timer.restart();
  }
  @Override
  public void execute() {
    if (m_currentPart < m_parts.length) {
      AutoPart part = m_parts[m_currentPart];

      if (part.kType == "drive") {
        AutoPartDrive partDrive = (AutoPartDrive) part;
        m_drivetrain.setSpeed(partDrive.kSpeedLeft, partDrive.kSpeedRight);
      } else if (part.kType == "arm") {
        AutoPartArm partArm = (AutoPartArm) part;
        m_arm.setSpeed(partArm.kSpeed);
      } else {}

      if (m_timer.advanceIfElapsed(part.kDuration)) m_currentPart++;
    }
    
    Logger.recordOutput("RoboticsClass/Auto/Current Part", m_currentPart);
    Logger.recordOutput("RoboticsClass/Auto/Is Finished", m_currentPart >= m_parts.length);
  }

  @Override
  public void end(boolean interrupted) {
    m_timer.stop();
    m_drivetrain.setSpeed(0.0, 0.0);
    m_arm.setSpeed(0.0);
  }
  @Override
  public boolean isFinished() {
    return m_currentPart >= m_parts.length;
  }
}
