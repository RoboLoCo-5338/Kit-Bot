package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

// import frc.robot.subsystems.CANDrivetrain;

public final class Auto {
	/** Example static factory for an autonomous command. */
	public static Command exampleAuto() {
		/**
		 * RunCommand is a helper class that creates a command from a single method, in
		 * this case we pass it the arcadeDrive method to drive straight back at half
		 * power. We modify that command with the .withTimeout(1) decorator to timeout
		 * after 1 second, and use the .andThen decorator to stop the drivetrain after
		 * the first command times out
		 */
		return new SequentialCommandGroup(PneumaticCommands.pistonExtend(), new WaitCommand(2),
				new RunCommand(() -> RobotContainer.m_drivetrain.tankDrive(.5, .5), RobotContainer.m_drivetrain)
						.withTimeout(1),
				new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(0, 0), RobotContainer.m_drivetrain),
				PneumaticCommands.pistonRetract());
		// return new InstantCommand(() -> PneumaticCommands.pistonExtend()).andThen(new
		// RunCommand(() -> drivetrain.arcadeDrive(-.5, 0), drivetrain)
		// .withTimeout(1)
		// .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain)));
	}
	// public static Command auto() {
	// return new SequentialCommandGroup(
	// new RunCommand(() -> RobotContainer.m_drivetrain.tankDrive(.5, .5),
	// RobotContainer.m_drivetrain)
	// .withTimeout(0.33),
	// new RunCommand(() -> RobotContainer.m_drivetrain.tankDrive(0, -.5),
	// RobotContainer.m_drivetrain)
	// .withTimeout(0.1);
	// new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(0, 0),
	// RobotContainer.m_drivetrain),
	// PneumaticCommands.pistonExtend());
	// }
}
