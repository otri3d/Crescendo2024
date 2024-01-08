// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.FlywheelCommand;
import frc.robot.commands.FlywheelDisableCommand;
import frc.robot.commands.IntakeExtendCommand;
import frc.robot.commands.ActuateElevatorCommand;
import frc.robot.commands.ReleaseElevatorCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.IntakeRetractCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public static final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public static final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();
  public static final ShooterSubsystem m_shootersubsystem = new ShooterSubsystem();

  private static CommandXboxController  driver;
  private static Trigger lButton;
  private static Trigger rButton;
  private static Trigger aButton;
  private static Trigger yButton; 
  private static Trigger rtrigger;


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.DRIVER1CONTROLLERPORT);
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driver = new CommandXboxController(OperatorConstants.DRIVER1CONTROLLERPORT);
    CommandScheduler.getInstance().setDefaultCommand(m_driveSubsystem, new DefaultDriveCommand(m_driveSubsystem));

    lButton = driver.leftBumper().whileTrue(new ActuateElevatorCommand(m_elevatorSubsystem));
    rButton = driver.rightBumper().whileTrue(new ReleaseElevatorCommand(m_elevatorSubsystem));
    yButton = driver.y().whileTrue(new IntakeExtendCommand(m_intakeSubsystem));
    aButton = driver.a().whileTrue(new IntakeExtendCommand(m_intakeSubsystem));
    rtrigger = driver.rightTrigger(0.5).whileTrue(new FlywheelCommand(m_shootersubsystem));

    yButton.onTrue(new IntakeExtendCommand(m_intakeSubsystem)); 
    aButton.onTrue(new IntakeRetractCommand(m_intakeSubsystem));
    lButton.onTrue(new ActuateElevatorCommand(m_elevatorSubsystem));
    rButton.onTrue(new ReleaseElevatorCommand(m_elevatorSubsystem));
    rtrigger.onTrue(new FlywheelCommand(m_shootersubsystem));
    rtrigger.onFalse(new FlywheelDisableCommand(m_shootersubsystem));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_driveSubsystem::exampleCondition)
        .onTrue(new DefaultDriveCommand(m_driveSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.y().whileTrue(m_driveSubsystem.exampleMethodCommand());
  }
  

  public static CommandXboxController getDriverController() {
    return driver;
  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_driveSubsystem);
  }
}
