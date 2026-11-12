// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class ArmDefaultCommand extends Command { // TODO
  private ArmSubsystem m_arm = null;
  private CommandXboxController m_controller = null;

  public ArmDefaultCommand(ArmSubsystem arm, CommandXboxController controller) {
    addRequirements(arm);
    m_arm = arm;
    m_controller = controller;
  }

  @Override
  public void initialize() {
  }
  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
