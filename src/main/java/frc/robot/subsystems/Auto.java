package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.commands.PneumaticCommands;

public class Auto {
	public static Command getAuto(RobotContainer robot) {

		return new SequentialCommandGroup( // basic auto to leave zone.
				PneumaticCommands.pistonExtend(), new WaitCommand(2),
				new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(-0.5, -0.5)),
				PneumaticCommands.pistonRetract(), new WaitCommand(2),
				new InstantCommand(() -> RobotContainer.m_drivetrain.tankDrive(0, 0)));
	}
}
