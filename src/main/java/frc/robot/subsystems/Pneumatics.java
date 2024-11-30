package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticConstants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
			PneumaticConstants.kForwardChannel, PneumaticConstants.kReverseChannel);
	Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
	public Pneumatics() {
		m_compressor.enableAnalog(100, 120);
	}
	// may want to add a toggle option
	public void extendPiston() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void retractPiston() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void setSolenoidOff() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void toggleSolenoid() {
		m_doubleSolenoid.toggle();
	}
}
