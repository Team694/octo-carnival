package com.stuypulse.frc2017.robot.commands.auton;

import com.stuypulse.frc2017.robot.RobotMap;
import com.stuypulse.frc2017.robot.commands.DriveInchesEncodersCommand;
import com.stuypulse.frc2017.robot.commands.RotateDegreesGyroCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ApproachAllianceHopperFromBoilerCommand extends CommandGroup {
    private static final double TURN_TO_HOPPER = -45;
    private static final double DRIVE_TO_HOPPER = 77;

    public ApproachAllianceHopperFromBoilerCommand() {
        addSequential(new DriveInchesEncodersCommand(RobotMap.BOILER_TO_HOPPER_BACKUP_DISTANCE));
        addSequential(new RotateDegreesGyroCommand(TURN_TO_HOPPER, true));
        addSequential(new DriveInchesEncodersCommand(DRIVE_TO_HOPPER));
    }
}
