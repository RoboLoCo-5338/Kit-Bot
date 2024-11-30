// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.Follower;

//phoenix 5 imports
// import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/* This class declares the subsystem for the robot drivetrain if controllers are connected via CAN. Make sure to go to
 * RobotContainer and uncomment the line declaring this subsystem and comment the line for PWMDrivetrain.
 *
 * The subsystem contains the objects for the hardware contained in the mechanism and handles low level logic
 * for control. Subsystems are a mechanism that, when used in conjuction with command "Requirements", ensure
 * that hardware is only being used by 1 command at a time.
 */
public class CANDrivetrain extends SubsystemBase {
	/*
	 * Class member variables. These variables represent things the class needs to
	 * keep track of and use between different method calls.
	 */
	DifferentialDrive m_drivetrain;

	TalonFX leftFront;
	TalonFX leftRear;
	TalonFX rightFront;
	TalonFX rightRear;

	/*
	 * Constructor. This method is called when an instance of the class is created.
	 * This should generally be used to set up member variables and perform any
	 * configuration or set up necessary on hardware.
	 */
	public CANDrivetrain() {

		// phoenix 5 code is deprecated, current code used SparkMaxes(?) so I will write
		// code for both phoenix 6 and 5

		// phoenix 6 code
		TalonFX leftFront = new TalonFX(kLeftFrontID);
		TalonFX leftRear = new TalonFX(kLeftRearID);
		TalonFX rightFront = new TalonFX(kRightFrontID);
		TalonFX rightRear = new TalonFX(kRightRearID);
		leftFront.setInverted(true);
		leftRear.setControl(new Follower(leftFront.getDeviceID(), false));
		rightRear.setControl(new Follower(rightFront.getDeviceID(), false));
		leftFront.setSafetyEnabled(true);
		rightFront.setSafetyEnabled(true);

		// phoenix 5 code
		// TalonFX leftFront = new TalonFX(kLeftFrontID);
		// TalonFX leftRear = new TalonFX(kLeftRearID);
		// TalonFX rightFront = new TalonFX(kRightFrontID);
		// TalonFX rightRear = new TalonFX(kRightRearID);
		// leftFront.setInverted(true);
		// leftRear.follow(leftFront);
		// rightRear.follow(rightFront);

		/*
		 * Sets current limits for the drivetrain motors. This helps reduce the
		 * likelihood of wheel spin, reduces motor heating at stall (Drivetrain pushing
		 * against something) and helps maintain battery voltage under heavy demand
		 */

		// Set the rear motors to follow the front motors.

		// Put the front motors into the differential drive object. This will control
		// all 4 motors with
		// the rears set to follow the fronts

		m_drivetrain = new DifferentialDrive(leftFront, rightFront);
	}

	/*
	 * Method to control the drivetrain using arcade drive. Arcade drive takes a
	 * speed in the X (forward/back) direction and a rotation about the Z (turning
	 * the robot about it's center) and uses these to control the drivetrain motors
	 */
	public void arcadeDrive(double speed, double rotation) {

		SmartDashboard.putString("In arcade drive", "in drive");
		m_drivetrain.arcadeDrive(speed, rotation);
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		// phoenix 5
		// leftFront.set(TalonFXControlMode.PercentOutput, leftSpeed);
		// rightFront.set(TalonFXControlMode.PercentOutput, rightSpeed);

		SmartDashboard.putString("In tank drive", "in drive");
		m_drivetrain.tankDrive(leftSpeed, rightSpeed);
	}
	@Override
	public void periodic() {
		/*
		 * This method will be called once per scheduler run. It can be used for running
		 * tasks we know we want to update each loop such as processing sensor data. Our
		 * drivetrain is simple so we don't have anything to put here
		 */
	}
}
