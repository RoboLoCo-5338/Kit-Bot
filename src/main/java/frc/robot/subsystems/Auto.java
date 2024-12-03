package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class Auto {
	public static Command getAuto(RobotContainer robot) {

		return new SequentialCommandGroup( // basic auto to leave zone.
				new WaitCommand(2), new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(0.5, .5)),
				new WaitCommand(2), new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(0, 0)));
	}
}
