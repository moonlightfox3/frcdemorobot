// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainDefaultCommand extends Command {
  private DrivetrainSubsystem m_drivetrain = null;
  private CommandXboxController m_controller = null;

  public DrivetrainDefaultCommand(DrivetrainSubsystem drivetrain, CommandXboxController controller) {
    addRequirements(drivetrain);
    m_drivetrain = drivetrain;
    m_controller = controller;
    
    Logger.recordOutput("RoboticsClass/Drivetrain/Steer Controls", ControllerConstants.kDefaultSteer);
  }
  
  @Override
  public void initialize() {
  }
  @Override
  public void execute() {
    if (DriverStation.isDisabled() || DriverStation.isAutonomous()) return;

    if (ControllerConstants.kAllowDrive) {
      double lY = m_controller.getLeftY();
      double rY = m_controller.getRightY();
      double rX = m_controller.getRightX();
      if (Math.abs(lY) <= ControllerConstants.kDeadband) lY = 0;
      if (Math.abs(rY) <= ControllerConstants.kDeadband) rY = 0;
      if (Math.abs(rX) <= ControllerConstants.kDeadband) rX = 0;

      boolean steer = ControllerConstants.kAllowSwitch
        ? (ControllerConstants.kDefaultSteer != (m_controller.leftTrigger().getAsBoolean() || m_controller.rightTrigger().getAsBoolean()))
        : ControllerConstants.kDefaultSteer;
      Logger.recordOutput("RoboticsClass/Drivetrain/Steer Controls", steer);
      
      double lS = -lY * ControllerConstants.kMaxSpeedDrive;
      double rS = -(steer ? lY : rY) * ControllerConstants.kMaxSpeedDrive;
      if (steer) {
        lS *= 1 + Math.min(rX, 0);
        rS *= 1 - Math.max(rX, 0);
      }
      m_drivetrain.setSpeed(lS, rS);
    } else m_drivetrain.setSpeed(0.0, 0.0);
  }

  @Override
  public void end(boolean interrupted) {
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
