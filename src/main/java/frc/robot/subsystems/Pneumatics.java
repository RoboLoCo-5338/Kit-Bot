package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	// public Pneumatics() {
	// RobotContainer.m_compressor.enableDigital();
	// }
	public void extendPiston() {
		RobotContainer.m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void retractPiston() {
		RobotContainer.m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void setSolenoidOff() {
		RobotContainer.m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	public void toggleSolenoid() {
		RobotContainer.m_doubleSolenoid.toggle();
	}
}
