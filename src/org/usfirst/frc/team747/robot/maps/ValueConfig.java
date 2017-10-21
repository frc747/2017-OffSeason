package org.usfirst.frc.team747.robot.maps;

/**
 * Distances are in inches
 * Rotations are in degrees
 * Times are in seconds
 * Speed values are in motor %
 */
public final class ValueConfig {
    
    private ValueConfig() {
    } 
    
// All values presumed to be in inches
    
    public final class MeasurementConstants{
        
        private MeasurementConstants(){
        }
        
        public static final double ROBOT_LENGTH = 0.0,
                                   DRIVER_WALL_TO_AUTO_LINE = 0.0,
                                   DRIVER_WALL_TO_GEAR_PEG = 0.0,
                                   EARLY_STOP_DISTANCE = 20.0,
                                   BACK_OFF_GEAR_PEG_DISTANCE = -20;
    }
    
    public final class PIDDriveDistances{
       
        private PIDDriveDistances(){
        }
        
        public static final double FORWARD_TO_CROSS_LINE = MeasurementConstants.DRIVER_WALL_TO_AUTO_LINE - MeasurementConstants.ROBOT_LENGTH,
                                   FORWARD_TO_CENTER_GEAR_STEP_ONE = MeasurementConstants.DRIVER_WALL_TO_GEAR_PEG - 
                                       MeasurementConstants.ROBOT_LENGTH - MeasurementConstants.EARLY_STOP_DISTANCE,
                                   FORWARD_TO_CENTER_GEAR_STEP_TWO = MeasurementConstants.EARLY_STOP_DISTANCE,
                                   BACK_OFF_FROM_CENTER_GEAR = MeasurementConstants.BACK_OFF_GEAR_PEG_DISTANCE;
    }
    public final class PIDGearTransfer{
    	
    	private PIDGearTransfer() {
    		
    	}
    	public static final double 	PICK_UP_POSITION = 9.012568279,
    								HOME_POSITION = 2.3232421875,
    								SCORE_POSITION = 0.0;
    }
   
}