package org.usfirst.frc.team747.robot.commands;

import org.usfirst.frc.team747.robot.OI;
import org.usfirst.frc.team747.robot.Robot;
import org.usfirst.frc.team747.robot.maps.DriverStation;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabGearCommand extends Command {
	
			
    public GrabGearCommand() {
        requires(Robot.GEAR_MECH);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.GEAR_MECH.GrabGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.GEAR_MECH.DoNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
