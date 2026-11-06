// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControlConstants;
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
    if (Math.abs(lY) <= ControlConstants.kControllerDeadband) lY = 0;
    if (Math.abs(rY) <= ControlConstants.kControllerDeadband) rY = 0;
    if (Math.abs(rX) <= ControlConstants.kControllerDeadband) rX = 0;

    double lS = 0.0;
    double rS = 0.0;
    if (m_controller.leftTrigger().getAsBoolean() || m_controller.rightTrigger().getAsBoolean()) {
      lS = (lY * (1 + Math.min(rX, 0))) * -ControlConstants.kMotorMaxSpeed;
      rS = (lY * (1 - Math.max(rX, 0))) * -ControlConstants.kMotorMaxSpeed;
    } else {
      lS = lY * -ControlConstants.kMotorMaxSpeed;
      rS = rY * -ControlConstants.kMotorMaxSpeed;
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
