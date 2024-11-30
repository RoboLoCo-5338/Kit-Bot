package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoCommands {

	public static InstantCommand setDriveSpeed(double leftSpeed, double rightSpeed) {
		return new InstantCommand(() -> {
			RobotContainer.m_drivetrain.tankDrive(leftSpeed, rightSpeed);
		});
	}

	public static SequentialCommandGroup driveTime(double time, double speed) {
		return new SequentialCommandGroup(setDriveSpeed(speed, speed), new WaitCommand(time), setDriveSpeed(0, 0));
	}
}
