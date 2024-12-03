package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.PneumaticConstants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	// public Pneumatics() {
	// RobotContainer.m_compressor.enableDigital();
	// }
	public DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(15, PneumaticsModuleType.CTREPCM,
			PneumaticConstants.kForwardChannel, PneumaticConstants.kReverseChannel);
	public void extendPiston() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void retractPiston() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void setSolenoidOff() {
		m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	public void toggleSolenoid() {
		m_doubleSolenoid.toggle();
	}
}
