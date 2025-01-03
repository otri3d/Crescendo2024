// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.DisableIntakeChain;
import frc.robot.commands.FlywheelCommand;
import frc.robot.commands.FlywheelDisableCommand;
import frc.robot.commands.FlywheelReverseCommand;
import frc.robot.commands.IntakeDisableGripCommand;
import frc.robot.commands.IntakeExtendCommand;
import frc.robot.commands.IntakeGripCommand;
import frc.robot.commands.RampDeployment;
import frc.robot.commands.RampRetractment;
import frc.robot.commands.ActuateElevatorCommand;
import frc.robot.commands.ActuateIntakeChain;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RampSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.IntakeExtendCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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
  public static final RampSubsystem m_rampSubsystem = new RampSubsystem();

  private static CommandXboxController  driver;
  private static CommandPS4Controller driver2;
  private static Trigger crossButton;
  private static Trigger triangleButton;
  private static Trigger rightBumper;
  private static Trigger leftBumper;
  public static Trigger ltrigger;
  private static Trigger xButton;
  private static Trigger yButton;
  private static Trigger rtrigger;


  // Replace with CommandPS4Controller or CommandJoystick if needed
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driver = new CommandXboxController(OperatorConstants.DRIVER1CONTROLLERPORT);
    driver2 = new CommandPS4Controller(OperatorConstants.DRIVER2CONTROLLERPORT);
    CommandScheduler.getInstance().setDefaultCommand(m_driveSubsystem, new DefaultDriveCommand(m_driveSubsystem));
    CommandScheduler.getInstance().setDefaultCommand(m_elevatorSubsystem, new ActuateElevatorCommand(m_elevatorSubsystem));
    CommandScheduler.getInstance().setDefaultCommand(m_intakeSubsystem, new IntakeExtendCommand(m_intakeSubsystem));
    crossButton = driver2.cross();
    triangleButton = driver2.triangle();
    leftBumper = driver.leftBumper();
    xButton = driver.x();
    yButton = driver.y();
    rightBumper = driver.rightBumper();
    rtrigger = driver.rightTrigger(0.1 );
    ltrigger = driver.leftTrigger(0.1 );

    crossButton.onTrue(new RampRetractment(m_rampSubsystem));
    triangleButton.onTrue(new RampDeployment(m_rampSubsystem));
    yButton.onTrue(new IntakeDisableGripCommand(m_intakeSubsystem));
    rightBumper.onTrue(new IntakeGripCommand(m_intakeSubsystem));
    rtrigger.onTrue(new FlywheelCommand(m_shootersubsystem));
    rtrigger.onFalse(new FlywheelDisableCommand(m_shootersubsystem));
    ltrigger.onTrue(new FlywheelReverseCommand(m_shootersubsystem));
    ltrigger.onFalse(new FlywheelDisableCommand(m_shootersubsystem));
    leftBumper.onTrue(new ActuateIntakeChain(m_intakeSubsystem));
    xButton.onTrue(new DisableIntakeChain(m_intakeSubsystem));
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
    // m_driverController.y().whileTrue(m_driveSubsystem.exampleMethodCommand());
  }
  

  public static CommandXboxController getDriverController() {
    return driver;
  }

  public static CommandPS4Controller getDriverController2() {
    return driver2;
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
