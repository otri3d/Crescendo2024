// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class DefaultDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  private final XboxController m_controller = RobotContainer.getDriverController();
  private boolean modeSwitch = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DefaultDriveCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_controller.getXButtonPressed()){
      modeSwitch = !modeSwitch;
    }
    if(!modeSwitch){
      m_subsystem.setLeftSpeed(-m_controller.getLeftY());
      m_subsystem.setRightSpeed(m_controller.getRightY());
    }
    else{
      m_subsystem.setAcceleratingLeftMotors(1*(m_controller.getLeftY()+m_controller.getLeftX()));
      m_subsystem.setAcceleratingRightMotors(-1*(m_controller.getLeftY()-m_controller.getLeftX()));
      // m_subsystem.setAcceleratingLeftMotors(m_controller.getLeftY());
      // m_subsystem.setAcceleratingRightMotors(m_controller.getRightY());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
