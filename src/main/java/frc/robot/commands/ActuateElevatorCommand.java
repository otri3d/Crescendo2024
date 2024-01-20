package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;

public class ActuateElevatorCommand extends CommandBase{
    private final ElevatorSubsystem m_subsystem;
    private CommandPS4Controller m_controller2 = RobotContainer.getDriverController2();

    public ActuateElevatorCommand(ElevatorSubsystem subsystem) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially swheduled.
    @Override
    public void initialize() {
      
    }

    // Called every time the scheduler runs while the command is scheduled. Hold B to activate 
    @Override
    public void execute() {
      m_subsystem.setElevatorSpeed(m_controller2.getRightY() * DriveConstants.ELEVATOR_ACCELERATION_CONSTANT);
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
