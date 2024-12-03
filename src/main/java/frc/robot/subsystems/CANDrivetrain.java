// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.Follower;
// import com.pathplanner.con;
import com.pathplanner.lib.commands.*;

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
	 */
	DifferentialDrive m_drivetrain;
	DifferentialDriveOdometry m_odometry;
	DifferentialDriveKinematics m_kine;
	// DifferentialDriveWheelSpeeds m_speed;
	// DifferentialDrive
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

		TalonFX leftFront = new TalonFX(kLeftFrontID);
		TalonFX leftRear = new TalonFX(kLeftRearID);
		TalonFX rightFront = new TalonFX(kRightFrontID);
		TalonFX rightRear = new TalonFX(kRightRearID);
		leftFront.setInverted(true);
		leftRear.setControl(new Follower(leftFront.getDeviceID(), false));
		rightRear.setControl(new Follower(rightFront.getDeviceID(), false));
		leftFront.setSafetyEnabled(true);
		rightFront.setSafetyEnabled(true);

		m_drivetrain = new DifferentialDrive(leftFront, rightFront);
		// new DifferentialDriveOdometry()
		// IMPORTANT TODO: there appears to be NO gyposcope in this code, which is
		// NEEDED for auto to work. I just put a placeholder `new Rotation(0,0)` as the
		// gyroscopes value.
		m_odometry = new DifferentialDriveOdometry(new Rotation2d(0, 0), leftRear.getPosition().getValue(),
				rightRear.getPosition().getValue());
		// m_kine = new DifferentialDriveKinematics(null)
		// new SimpleMotorFeedforward(kLeftFrontID, kCurrentLimit).
		// m_speed.desaturate
		// m_speed
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
	public void updateOdometry() {
		// m_odometry.update(
		// m_gyro.getRotation2d(), m_leftEncoder.getDistance(),
		// m_rightEncoder.getDistance());
	} // need gyro for this to work
}
