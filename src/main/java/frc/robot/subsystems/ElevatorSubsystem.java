package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.OperatorConstants;

public class ElevatorSubsystem extends SubsystemBase {
    private Solenoid m_leftIn, m_leftOut, m_rightIn, m_rightOut;
    private final Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    //private WPI_VictorSPX m_elevatorLeft, m_elevatorRight;
    //private MotorControllerGroup m_elevator;


    public ElevatorSubsystem(){
        //Solenoid
        m_leftIn = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.LEFTINPUTPORT);
        m_rightIn = new Solenoid(PneumaticsModuleType.CTREPCM,OperatorConstants.RIGHTINPUTPORT);
        m_leftOut = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.LEFTOUTPUTPORT);
        m_rightOut = new Solenoid(PneumaticsModuleType.CTREPCM, OperatorConstants.RIGHTOUTPUTPORT);

        //Default Config
        m_leftIn.set(false);
        m_rightIn.set(false);
        m_leftOut.set(true);
        m_rightOut.set(true);
    }

    //4 single ones on each side, Default input off, output on

    //TODO: Actuate the Solenoid, input on, output off

    //TODO: Release Solenoid input off, output on

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
