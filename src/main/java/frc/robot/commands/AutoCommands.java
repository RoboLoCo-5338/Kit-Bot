package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoCommands {

    public static InstantCommand setDriveSpeed(double leftSpeed, double rightSpeed){
        return new InstantCommand(()->{RobotContainer.m_drivetrain.tankDrive(leftSpeed, rightSpeed);});
    }
    
    public static SequentialCommandGroup driveTime(double time, double speed) {
        return new SequentialCommandGroup(setDriveSpeed(speed, speed), new WaitCommand(time),setDriveSpeed(0, 0) );
    }

    //NOTE: Assuming direction of speeds right now, change it at practice field
    public static SequentialCommandGroup shootNote(){
        return new SequentialCommandGroup(
            LauncherCommands.LauncherOutput(1),
            new WaitCommand(1),
            LauncherCommands.FeederOutput(1),
            new WaitCommand(0.5),
            LauncherCommands.FeederStop(),
            LauncherCommands.LauncherStop()
        );
    }

    public static SequentialCommandGroup driveAndShootAuto(){
        return new SequentialCommandGroup(
            shootNote(),
            new WaitCommand(Constants.AutoConstants.delay),
            driveTime(Constants.AutoConstants.driveTime, Constants.AutoConstants.driveSpeed)
        );
    }

}
