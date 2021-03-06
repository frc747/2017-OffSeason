package org.usfirst.frc.team747.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team747.robot.maps.AutonomousConfig;
import org.usfirst.frc.team747.robot.Robot;
import org.usfirst.frc.team747.robot.commands.*;

public class ScoreGearRed extends CommandGroup {
    
    public  ScoreGearRed() {
        
        requires(Robot.DRIVE_TRAIN);

        addParallel(new IntakeTimeCommand(2));        
        addSequential(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_CENTER_GEAR, false));
        addSequential(new PauseCommand(2));
        
//        addSequential(new DriveDistanceCommand(AutonomousConfig.ScoreGearRed.DISTANCE, AutonomousConfig.ScoreGearRed.SPEED));
//        addSequential(new PauseCommand(2));
//        addSequential(new DriveDistanceCommand(6, .3));
    }
}
