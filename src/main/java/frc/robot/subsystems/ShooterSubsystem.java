package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.OperatorConstants;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_VictorSPX m_LeftFlywheel , m_RightFlywheel, m_BottomFlyWheel;
    private MotorControllerGroup m_shooter;
    public ShooterSubsystem(){
        m_LeftFlywheel = new WPI_VictorSPX(OperatorConstants.LEFTFLYWHEEL);
        m_RightFlywheel = new WPI_VictorSPX(OperatorConstants.RIGHTFLYWHEEL);
        m_BottomFlyWheel = new WPI_VictorSPX(OperatorConstants.BOTTOMFLYWHEEL);
        m_shooter = new MotorControllerGroup(m_LeftFlywheel, m_RightFlywheel);
    }

    public void actuatemotor(){
        m_shooter.set(1);
        m_BottomFlyWheel.set(1);
    }

    public void disablemotor(){
      m_shooter.set(0);
      m_BottomFlyWheel.set(0);
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
