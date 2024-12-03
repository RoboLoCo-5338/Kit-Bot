// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.PneumaticConstants;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.Pneumatics;
import frc.robot.commands.PneumaticCommands;
import frc.robot.subsystems.Auto;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems are defined here.

	public static final CANDrivetrain m_drivetrain = new CANDrivetrain();

	public static final Pneumatics m_piston = new Pneumatics();
	public static double speedUp = 0.0;
	// public static Compressor m_compressor = new
	// Compressor(PneumaticsModuleType.CTREPCM);

	/*
	 * The gamepad provided in the KOP shows up like an XBox controller if the mode
	 */
	public static final CommandXboxController m_driverController = new CommandXboxController(
			OperatorConstants.kDriverControllerPort);
	private final CommandXboxController m_operatorController = new CommandXboxController(
			OperatorConstants.kOperatorControllerPort);

	/*
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the trigger bindings
		configureBindings();
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be
	 * accessed via the named factory methods in the Command* classes in
	 * edu.wpi.first.wpilibj2.command.button (shown below) or via the Trigger
	 * constructor for arbitary conditions
	 */
	private void configureBindings() {
		// Set the default command for the drivetrain to drive using the joysticks
		m_drivetrain.setDefaultCommand(

				new RunCommand(() -> m_drivetrain.tankDrive(m_driverController.getLeftY() * (0.5 + speedUp),
						m_driverController.getRightY() * (0.5 + speedUp)), m_drivetrain));

		/*
		 * Extends piston when operator presses the "b" button Retracts piston when
		 * operator presses the "a" button Turns the solenoid off when the operator
		 * presses the "x" button Toggles the solenoid (switches the solenoid) between
		 * pushing and pulling air in the piston when the operator presses the "y"
		 * button
		 */
		m_operatorController.leftTrigger().onTrue(PneumaticCommands.pistonExtend());
		m_operatorController.rightTrigger().onTrue(PneumaticCommands.pistonRetract());
		m_operatorController.x().onTrue(PneumaticCommands.solenoidOff());
		m_operatorController.y().onTrue(PneumaticCommands.solenoidToggle());
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */

	public Command getAutonomousCommand() {
		// An example command will be run in autonomous
		return Auto.getAuto(this);
	}
}
