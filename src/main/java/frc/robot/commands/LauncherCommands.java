package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class LauncherCommands {
	public static Command LauncherOutput(double speed) {
		return new InstantCommand(() -> RobotContainer.m_launcher.setLaunchWheel(speed));
	}

	public static Command FeederOutput(double speed) {
		return new InstantCommand(() -> RobotContainer.m_launcher.setFeedWheel(speed));
	}

	public static Command FeederStop() {
		return new InstantCommand(() -> RobotContainer.m_launcher.setFeedWheel(0));
	}

	public static Command LauncherStop() {
		return new InstantCommand(() -> RobotContainer.m_launcher.setLaunchWheel(0));
	}
}
