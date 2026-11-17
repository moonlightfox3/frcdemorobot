// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.Drivetrain;

public class AutoCommand extends Command {
  private Drivetrain m_drivetrain = null;
  private Timer m_timer = null;

  public AutoCommand(Drivetrain drivetrain) {
    addRequirements(drivetrain);
    m_drivetrain = drivetrain;
    m_timer = new Timer();
  }

  @Override
  public void initialize() {
    m_timer.restart();
    // TODO
  }
  @Override
  public void execute() {
    // TODO
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setSpeed(0.0, 0.0);
  }
  @Override
  public boolean isFinished() {
    return false; // TODO
  }
}
