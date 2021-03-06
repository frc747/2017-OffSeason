package org.usfirst.frc.team747.robot.subsystems;

import org.usfirst.frc.team747.robot.commands.ClimberDoNothing;
import org.usfirst.frc.team747.robot.maps.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

	private CANTalon talonClimb1 = new CANTalon(RobotMap.Climber.CLIMB_1.getValue()),
					 talonClimb2 = new CANTalon(RobotMap.Climber.CLIMB_2.getValue());
		
	public ClimberSubsystem() {
		LiveWindow.addActuator("Climber System", "Climb Motor Speed 1", talonClimb1);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimberDoNothing());
    }
    
    public void upFast() {
    	//POSITIVE SPEEDS ONLY!!!!!!!
    	talonClimb1.set(1);
    	talonClimb2.set(1);
    }
    
    public void upSlow(){
    	
    	//POSITIVE SPEEDS ONLY!!!!!!!
    	talonClimb1.set(.75);
    	talonClimb2.set(.75);
    }
    
    public void doNothing() {
    	talonClimb1.set(0);
    	talonClimb2.set(0);
    }
}

