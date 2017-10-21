package org.usfirst.frc.team747.robot.autonomous;

import org.usfirst.frc.team747.robot.Robot;
import org.usfirst.frc.team747.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team747.robot.commands.GearTransferHomingCommand;
import org.usfirst.frc.team747.robot.commands.PIDDriveRevolutionsCommand;
import org.usfirst.frc.team747.robot.maps.ValueConfig;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLine extends CommandGroup {

    public CrossLine() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.GEAR_MECH);
        
        addParallel(new GearTransferHomingCommand());
//        addSequential(new DriveDistanceCommand(95, 0.5));
        addSequential(new PIDDriveRevolutionsCommand(ValueConfig.PIDDriveDistances.FORWARD_TO_CROSS_LINE, false));

    }
}