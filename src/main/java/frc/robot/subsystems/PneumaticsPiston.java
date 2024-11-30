package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;
public class PneumaticsPiston extends SubsystemBase {
	DoubleSolenoid m_solenoid;
	public PneumaticsPiston() {
		m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PneumaticsConstants.kforwardChannel,
				PneumaticsConstants.kreverseChannel);
	}

	public void pistonOut() {
		m_solenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pistonReverse() {
		m_solenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void solenoidOff() {
		m_solenoid.set(DoubleSolenoid.Value.kOff);
	}

	public void togglePiston() {
		m_solenoid.toggle();
	}

}
