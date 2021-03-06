package com.stuypulse.frc2017.robot.commands;

import com.stuypulse.frc2017.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchRunMotorFastCommand extends Command {

    public WinchRunMotorFastCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.winch.startWinchFast();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return !Robot.oi.operatorPad.getLeftTrigger().get();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.winch.stopWinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
