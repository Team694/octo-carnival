package com.stuypulse.frc2017.robot.commands.cv;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetupForBoilerCommand extends CommandGroup {

    public SetupForBoilerCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addSequential(new RotateToBoilerCommand());
        addSequential(new RotateToBoilerCommand(true));

        addSequential(new DriveToBoilerRangeCommand());
        addSequential(new DriveToBoilerRangeCommand());
    }

    @Override
    public boolean isFinished() {
        //make public instead of protected so tat OptionalCVPositionForGearCommand can call
        return super.isFinished();
    }

    @Override
    public void initialize() {
        //make public instead of protected so tat OptionalCVPositionForGearCommand can call
        super.initialize();
    }

    @Override
    public void execute() {
        //make public instead of protected so tat OptionalCVPositionForGearCommand can call
        super.execute();
    }

    @Override
    public void end() {
        //make public instead of protected so tat OptionalCVPositionForGearCommand can call
        super.end();
    }

    @Override
    public void interrupted() {
        //make public instead of protected so tat OptionalCVPositionForGearCommand can call
        super.interrupted();
    }
}
