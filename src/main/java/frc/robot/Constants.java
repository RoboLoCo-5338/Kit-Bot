// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static class OperatorConstants {
		// Port numbers for driver and operator gamepads. These correspond with the
		// numbers on the USB
		// tab of the DriverStation
		public static final int kDriverControllerPort = 0;
		public static final int kOperatorControllerPort = 1;
	}

	public static class DrivetrainConstants {
		// PWM ports/CAN IDs for motor controllers
		public static final int kLeftRearID = 1;
		public static final int kLeftFrontID = 0;
		public static final int kRightRearID = 3;
		public static final int kRightFrontID = 2;

		// Current limit for drivetrain motors
		public static final int kCurrentLimit = 60;
	}

	public static class PneumaticConstants {
		public static final int kForwardChannel = 0; // TODO: Update these channel values
		public static final int kReverseChannel = 2;
	}

	public static class AutoConstants {
		// constants for auto code
		public static final double driveTime = 6.0;
		public static final double delay = 2.0;
		public static final double driveSpeed = -0.5;
	}
}
