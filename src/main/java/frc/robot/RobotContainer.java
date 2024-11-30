// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoCommands;
// import frc.robot.subsystems.PWMDrivetrain;
// import frc.robot.subsystems.PWMLauncher;

import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANLauncher;
import frc.robot.subsystems.PneumaticsPiston;
import frc.robot.commands.LauncherCommands;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems are defined here.
	// private final PWMDrivetrain m_drivetrain = new PWMDrivetrain();
	public static final CANDrivetrain m_drivetrain = new CANDrivetrain();
	// private final PWMLauncher m_launcher = new PWMLauncher();
	public static final CANLauncher m_launcher = new CANLauncher();
	public static final PneumaticsPiston m_piston = new PneumaticsPiston();
	public static double speedUp = 0.0;

	/*
	 * The gamepad provided in the KOP shows up like an XBox controller if the mode
	 * switch is set to X mode using the switch on the top.
	 */
	public static final CommandXboxController m_driverController = new CommandXboxController(
			OperatorConstants.kDriverControllerPort);
	private final CommandXboxController m_operatorController = new CommandXboxController(
			OperatorConstants.kOperatorControllerPort);

	/**
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

				new RunCommand(() -> m_drivetrain.arcadeDrive(m_driverController.getLeftY() * (0.5 + speedUp),
						m_driverController.getRightX() * (0.5 + speedUp)), m_drivetrain));

		/*
		 * Create an inline sequence to run when the operator presses and holds the A
		 * (green) button. Run the PrepareLaunch command for 1 seconds and then run the
		 * LaunchNote command
		 */
		// m_operatorController
		// .a()
		// .whileTrue(
		// new PrepareLaunch(m_launcher)
		// .withTimeout(LauncherConstants.kLauncherDelay)
		// .andThen(new LaunchNote(m_launcher))
		// .handleInterrupt(() -> m_launcher.stop()));

		// Set up a binding to run the intake command while the operator is pressing and
		// holding the
		// left Bumper

		// changed controls, check them at practice field

		// stop shooter
		m_operatorController.leftBumper().onTrue(LauncherCommands.LauncherOutput(0));
		m_operatorController.leftBumper().onTrue(LauncherCommands.FeederOutput(0));

		// intake
		m_operatorController.leftTrigger().onTrue(LauncherCommands.LauncherOutput(-1));
		m_operatorController.leftTrigger().onTrue(LauncherCommands.FeederOutput(-1));
		m_operatorController.leftTrigger().onFalse(LauncherCommands.LauncherOutput(0));
		m_operatorController.leftTrigger().onFalse(LauncherCommands.FeederOutput(0));

		// outake
		m_operatorController.rightTrigger().onTrue(LauncherCommands.LauncherOutput(1));
		m_operatorController.rightBumper().onTrue(LauncherCommands.FeederOutput(1));
		m_operatorController.rightTrigger().onFalse(LauncherCommands.LauncherOutput(0));
		m_operatorController.rightBumper().onFalse(LauncherCommands.FeederOutput(0));

		m_operatorController.a().onTrue(LauncherCommands.LauncherOutput(0.3));
		m_operatorController.a().onTrue(LauncherCommands.FeederOutput(0.3));
		m_operatorController.a().onFalse(LauncherCommands.LauncherOutput(0));
		m_operatorController.a().onFalse(LauncherCommands.FeederOutput(0));

		// m_driverController.rightTrigger().onFalse( new InstantCommand(()->
		// {speedUp=0.0;}));

	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An example command will be run in autonomous
		return AutoCommands.driveAndShootAuto();
	}
}
