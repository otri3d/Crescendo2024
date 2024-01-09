package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.PCMConstants;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class RampSubsystem extends SubsystemBase {
    private Solenoid m_solenoid1, m_solenoid2, m_solenoid3, m_solenoid4;
    private final Compressor m_compressor = new Compressor(PneumaticsModuleType.REVPH); 
    public RampSubsystem(){
        m_solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.LEFTINPUTPORT);
        m_solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.LEFTOUTPUTPORT);
        m_solenoid3 = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.RIGHTINPUTPORT);
        m_solenoid4 = new Solenoid(PneumaticsModuleType.CTREPCM, PCMConstants.RIGHTOUTPUTPORT);
    }

    public void actuateSolenoid(){
        m_solenoid1.set(true);
        m_solenoid2.set(false);
        m_solenoid3.set(true);
        m_solenoid4.set(false);
    }

    public void decompressSolenoid(){
        m_solenoid1.set(false);
        m_solenoid2.set(true);
        m_solenoid3.set(false);
        m_solenoid4.set(true);
    }
    public Compressor getCompressor(){
        return m_compressor;
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
