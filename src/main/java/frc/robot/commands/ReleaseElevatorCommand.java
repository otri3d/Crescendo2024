package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ReleaseElevatorCommand extends CommandBase{
    private final ElevatorSubsystem m_subsystem;

    public ReleaseElevatorCommand(ElevatorSubsystem subsystem) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      m_subsystem.release();
    }

    // Called every time the scheduler runs while the command is scheduled. Hold B to activate 
    @Override
    public void execute() {
      m_subsystem.release();
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
