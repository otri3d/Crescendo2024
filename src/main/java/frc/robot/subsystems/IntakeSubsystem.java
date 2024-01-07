
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.InputConstants;
public class IntakeSubsystem extends SubsystemBase {

    private WPI_VictorSPX m_intakearm1, m_intakearm2, m_gripper;
    private MotorControllerGroup m_intake;
    private DigitalInput upper_limit, lower_limit;
    private Encoder encoder;
  /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem(){
        m_intakearm1 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT5);
        m_intakearm2 = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT6);
        m_intake = new MotorControllerGroup(m_intakearm1,m_intakearm2);
        m_gripper = new WPI_VictorSPX(OperatorConstants.MOTORCONTROLPORT7);
        encoder = new Encoder(InputConstants.ENCODERDIO1, InputConstants.ENCODERDIO2, false, Encoder.EncodingType.k2X);
    }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }
  

  public void toggleGripperVelocty(){
    if(encoder.get() != 0){
        m_gripper.set(0);
    }
    if(encoder.get() == 0){
        m_gripper.set(1);
    }    
  }
  public void setIntakePosition(double position){
    if(encoder.getDistance() == position){
      m_intake.set(0);
    } 
    else if(encoder.getDistance() < position){
      m_intake.set(1);
    } 
    else if(encoder.getDistance() > position){
      m_intake.set(-1);
    }
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    setIntakePosition(0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}