package com.stuypulse.frc2017.robot.commands.auton;

import com.stuypulse.frc2017.robot.RobotMap;
import com.stuypulse.frc2017.robot.commands.DriveInchesEncodersCommand;
import com.stuypulse.frc2017.robot.commands.DriveInchesPIDCommand;
import com.stuypulse.frc2017.robot.commands.GearTrapTrapGearCommand;
import com.stuypulse.frc2017.robot.commands.RotateDegreesGyroCommand;
import com.stuypulse.frc2017.robot.commands.ScoreGearCommand;
import com.stuypulse.frc2017.robot.commands.cv.SetupForGearCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreHPGearCommand extends CommandGroup {
    public static final double START_TO_HP_GEAR_TURN_DISTANCE = 74.0;
    public static final double HP_GEAR_TURN_TO_HP_GEAR_ANGLE = 60.0;
    public static final double AFTER_TURN_TO_HP_GEAR_DISTANCE = 16.0;
    public static final double HP_GEAR_REVERSE_DISTANCE = -24.0;

    public ScoreHPGearCommand(boolean score, boolean useCV) {
        int direction;
        double extra; // extra distance to go due to field irregularities, based on alliance color
        if (RobotMap.ALLIANCE == DriverStation.Alliance.Red) {
            direction = 1;
            extra = 3.375;
        } else {
            direction = -1;
            extra = 3.0;
        }
        addSequential(new DriveInchesPIDCommand(0.5, START_TO_HP_GEAR_TURN_DISTANCE + extra));
        addSequential(new RotateDegreesGyroCommand(direction * HP_GEAR_TURN_TO_HP_GEAR_ANGLE));

        // Extra CV rotation
        if (useCV) {
            addSequential(new SetupForGearCommand());
        }

        // Approach the peg
        addSequential(new DriveInchesPIDCommand(0.5, AFTER_TURN_TO_HP_GEAR_DISTANCE), 2.0);

        if (score) {
            addSequential(new ScoreGearCommand());
            addSequential(new DriveInchesEncodersCommand(HP_GEAR_REVERSE_DISTANCE), 1.5);
            addSequential(new GearTrapTrapGearCommand());

            addSequential(new RotateDegreesGyroCommand(direction * -HP_GEAR_TURN_TO_HP_GEAR_ANGLE, 4.0), 1.5);
            // FIXME: Uncomment this
            //addSequential(new DriveInchesEncodersCommand(200.0));
        }
    }

}
