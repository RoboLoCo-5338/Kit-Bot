package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class SolenoidCommands {
	public static Command toggleSolenoid() {
		return new InstantCommand(RobotContainer.m_piston::togglePiston, RobotContainer.m_piston);
	}
}
