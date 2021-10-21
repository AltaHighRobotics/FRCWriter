// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.testSub; 

public class testOnCommand extends CommandBase { 
  /** Creates a new testOnCommand. */ 
  private final testSub m_testSub; 

  public testOnCommand(testSub testSub) { 
    m_testSub = testSub; 
    addRequirements(m_testSub); 
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_testSub.testOn(); 
  } 

  // Called once the command ends or is interrupted. 
  @Override 
  public void end(boolean interrupted) { 
    m_testSub.testOff(); 
  } 

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}