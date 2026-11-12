// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.MotorConstants;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainDefaultCommand extends Command {
  private Drivetrain m_drivetrain = null;
  private CommandXboxController m_controller = null;

  public DrivetrainDefaultCommand(Drivetrain drivetrain, CommandXboxController controller) {
    addRequirements(drivetrain);
    m_drivetrain = drivetrain;
    m_controller = controller;
  }
  
  @Override
  public void initialize() {
  }
  @Override
  public void execute() {
    double lY = m_controller.getLeftY();
    double rY = m_controller.getRightY();
    double rX = m_controller.getRightX();
    if (Math.abs(lY) <= ControllerConstants.kDeadband) lY = 0;
    if (Math.abs(rY) <= ControllerConstants.kDeadband) rY = 0;
    if (Math.abs(rX) <= ControllerConstants.kDeadband) rX = 0;

    boolean steer = ControllerConstants.kDefaultSteer != (m_controller.leftTrigger().getAsBoolean() || m_controller.rightTrigger().getAsBoolean());
    Logger.recordOutput("RoboticsClass/Drivetrain/Steer Controls", steer);
    
    double lS = -lY * MotorConstants.kMaxSpeed;
    double rS = -(steer ? lY : rY) * MotorConstants.kMaxSpeed;
    if (steer) {
      lS *= 1 + Math.min(rX, 0);
      rS *= 1 - Math.max(rX, 0);
    }
    m_drivetrain.setSpeed(lS, rS);
  }

  @Override
  public void end(boolean interrupted) {
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
