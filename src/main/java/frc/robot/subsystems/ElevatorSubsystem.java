package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.PCMConstants;

public class ElevatorSubsystem extends SubsystemBase {
    private Solenoid m_leftIn, m_leftOut, m_rightIn, m_rightOut;

    public ElevatorSubsystem(){
        //Solenoid
        m_leftIn = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.LEFTINPUTPORT);
        m_rightIn = new Solenoid(PneumaticsModuleType.CTREPCM,PCMConstants.RIGHTINPUTPORT);
        m_leftOut = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.LEFTOUTPUTPORT);
        m_rightOut = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.RIGHTOUTPUTPORT);

        //Default Config
        m_leftIn.set(false);
        m_rightIn.set(false);
        m_leftOut.set(true);
        m_rightOut.set(true);
    }

    //4 single ones on each side, Default input off, output on

    //TODO: Actuate the Solenoid, input on, output off

    public void actuate(){
        m_leftIn.set(true);
        m_rightIn.set(true);
        m_leftOut.set(false);
        m_rightOut.set(false);     
    }

    //TODO: Release Solenoid input off, output on

    public void release(){
        m_leftIn.set(false);
        m_rightIn.set(false);
        m_leftOut.set(true);
        m_rightOut.set(true);   
    }

     public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
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
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
