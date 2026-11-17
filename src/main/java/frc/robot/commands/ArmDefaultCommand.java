// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.ArmSubsystem;

public class ArmDefaultCommand extends Command {
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
    if (ControllerConstants.kAllowArm) {
      boolean up = m_controller.povUp().getAsBoolean();
      boolean down = m_controller.povDown().getAsBoolean();
      boolean left = m_controller.povLeft().getAsBoolean();
      boolean right = m_controller.povRight().getAsBoolean();
      @SuppressWarnings("unused")
      boolean forward =
        ControllerConstants.kArmButtonForward == "up" ? up :
        ControllerConstants.kArmButtonForward == "down" ? down :
        ControllerConstants.kArmButtonForward == "left" ? left :
        ControllerConstants.kArmButtonForward == "right" ? right :
        false;
      @SuppressWarnings("unused")
      boolean backward =
        ControllerConstants.kArmButtonBackward == "up" ? up :
        ControllerConstants.kArmButtonBackward == "down" ? down :
        ControllerConstants.kArmButtonBackward == "left" ? left :
        ControllerConstants.kArmButtonBackward == "right" ? right :
        false;

        if (forward && !backward) m_arm.setSpeed(ControllerConstants.kArmSpeed);
        else if (!forward && backward) m_arm.setSpeed(-ControllerConstants.kArmSpeed);
        else m_arm.setSpeed(0.0);
    } else m_arm.setSpeed(0.0);
  }

  @Override
  public void end(boolean interrupted) {
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
