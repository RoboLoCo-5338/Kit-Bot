package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticConstants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
	DoubleSolenoid doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.kForwardChannel,
			PneumaticConstants.kReverseChannel);

	public Pneumatics() {
		setSolenoidOff();
	}

	// may want to add a toggle option
	public void extendPiston() {
		doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void retractPiston() {
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void setSolenoidOff() {
		doubleSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	public void toggleSolenoid() {
		doubleSolenoid.toggle();
	}
}
