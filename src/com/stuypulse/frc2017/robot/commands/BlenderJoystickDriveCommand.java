package com.stuypulse.frc2017.robot.commands;

import com.stuypulse.frc2017.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BlenderJoystickDriveCommand extends Command {

    private static final double MIN_MOTOR_VALUE = 0.1;

    public BlenderJoystickDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.blender);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double motorValue = Robot.oi.operatorPad.getLeftY();
        if (Math.abs(motorValue) < MIN_MOTOR_VALUE) {
            Robot.blender.stop();
        } else {
            Robot.blender.joystickDrive(motorValue);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
