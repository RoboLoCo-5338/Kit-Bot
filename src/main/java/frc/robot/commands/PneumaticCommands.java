package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class PneumaticCommands {
	public static Command pistonExtend() {
		return new InstantCommand(() -> RobotContainer.m_piston.extendPiston());
	}

	public static Command pistonRetract() {
		return new InstantCommand(() -> RobotContainer.m_piston.retractPiston());
	}

	public static Command solenoidOff() {
		return new InstantCommand(() -> RobotContainer.m_piston.setSolenoidOff());
	}

	public static Command solenoidToggle() {
		return new InstantCommand(() -> RobotContainer.m_piston.toggleSolenoid());
	}
}
