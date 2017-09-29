package org.usfirst.frc.team747.robot;

import org.usfirst.frc.team747.robot.commands.*;
//import org.usfirst.frc.team747.robot.maps.AutonomousConfig;
import org.usfirst.frc.team747.robot.maps.DriverStation;
import org.usfirst.frc.team747.robot.maps.RobotMap;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

	
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	 public static final Joystick 
	 //Joysticks control both climb and drive
		JOYSTICK_DRIVER_LEFT= new Joystick(DriverStation.Controller.DRIVER_LEFT.getValue()),
		JOYSTICK_DRIVER_RIGHT = new Joystick(DriverStation.Controller.DRIVER_RIGHT.getValue()),
		CONTROLLER_OPERATOR = new Joystick(DriverStation.Controller.OPERATOR.getValue());
	 
	 public static final JoystickButton
	 	BUTTON_GEAR_INTAKE 
	 		= new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.BUTTON_LB.getValue()),
	 	BUTTON_GEAR_DEPLOY
	 		= new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.BUTTON_RB.getValue());
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
		
	
    //THESE NEXT BUTTONS ARE ONLY FOR WHEN WE ARE TESTING, MAKE SURE TO COMMENT OUT WHEN IN COMPETITION
    public static final JoystickButton BUTTON_PID_ROTATE_TEST_BUTTON_ONE
                = new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.BUTTON_BACK.getValue()),
            BUTTON_PID_ROTATE_TEST_BUTTON_TWO
                = new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.BUTTON_START.getValue()),
            BUTTON_PID_ROTATE_TEST_BUTTON_THREE
                = new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.STICK_LEFT.getValue()),
            BUTTON_PID_ROTATE_TEST_BUTTON_FOUR
                = new JoystickButton(CONTROLLER_OPERATOR, DriverStation.GamePad.STICK_RIGHT.getValue()),
            BUTTON_PID_TEST_ROTATE_BOILER
                = new JoystickButton(JOYSTICK_DRIVER_RIGHT, DriverStation.Joystick.BUTTON_2.getValue()),    
            BUTTON_PID_TEST_BUTTON_ONE
                = new JoystickButton(JOYSTICK_DRIVER_LEFT, DriverStation.Joystick.BUTTON_3.getValue()),
            BUTTON_PID_TEST_BUTTON_TWO
                = new JoystickButton(JOYSTICK_DRIVER_LEFT, DriverStation.Joystick.BUTTON_4.getValue()),
            BUTTON_PID_TEST_BUTTON_THREE
                = new JoystickButton(JOYSTICK_DRIVER_LEFT, DriverStation.Joystick.BUTTON_5.getValue()),
            BUTTON_PID_TEST_BUTTON_FOUR
                = new JoystickButton(JOYSTICK_DRIVER_LEFT, DriverStation.Joystick.BUTTON_6.getValue()),
            BUTTON_PID_TEST_REVERSE_BUTTON_ONE
                = new JoystickButton(JOYSTICK_DRIVER_RIGHT, DriverStation.Joystick.BUTTON_3.getValue()),
            BUTTON_PID_TEST_REVERSE_BUTTON_TWO
                = new JoystickButton(JOYSTICK_DRIVER_RIGHT, DriverStation.Joystick.BUTTON_4.getValue()),
            BUTTON_PID_TEST_REVERSE_BUTTON_THREE
                = new JoystickButton(JOYSTICK_DRIVER_RIGHT, DriverStation.Joystick.BUTTON_5.getValue()),
            BUTTON_PID_TEST_REVERSE_BUTTON_FOUR
                = new JoystickButton(JOYSTICK_DRIVER_RIGHT, DriverStation.Joystick.BUTTON_6.getValue());	
    	
    static Preferences prefs;
    
	public OI() {
//		BUTTON_GEAR_INTAKE.whileHeld(new GrabGearCommand());
		BUTTON_GEAR_DEPLOY.whileHeld(new SpitOutGearCommand());
		
        // THESE NEXT BUTTONS ARE ONLY FOR WHEN WE ARE TESTING, MAKE SURE TO COMMENT OUT WHEN IN COMPETITION
        
//      BUTTON_PID_ROTATE_TEST_BUTTON_ONE.toggleWhenPressed(new PIDDriveRotateCommand(-45));
//      BUTTON_PID_ROTATE_TEST_BUTTON_TWO.toggleWhenPressed(new PIDDriveRotateCommand(45));
//      BUTTON_PID_ROTATE_TEST_BUTTON_THREE.toggleWhenPressed(new PIDDriveRotateCommand(-90));
//      BUTTON_PID_ROTATE_TEST_BUTTON_FOUR.toggleWhenPressed(new PIDDriveRotateWithVisionCommand(Robot.VISION_TRACKING_REAR, "GEAR"));
//      BUTTON_PID_ROTATE_TEST_BUTTON_FOUR.toggleWhenPressed(new PIDDriveRotateCommand(90));
//      BUTTON_PID_TEST_ROTATE_BOILER.toggleWhenPressed(new PIDDriveRotateWithVisionCommand(Robot.VISION_TRACKING_REAR, "BOILER"));
//      
//      BUTTON_PID_TEST_BUTTON_ONE.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_CENTER_GEAR, false));
//      BUTTON_PID_TEST_BUTTON_TWO.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.REVERSE_AWAY_FROM_CENTER_GEAR, false));
//      BUTTON_PID_TEST_BUTTON_THREE.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_FRONT_OF_KEY, false));
//      BUTTON_PID_TEST_BUTTON_FOUR.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_SHOOT, false));
//
//      BUTTON_PID_TEST_REVERSE_BUTTON_ONE.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_CENTER_GEAR, true));
//      BUTTON_PID_TEST_REVERSE_BUTTON_TWO.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.REVERSE_AWAY_FROM_CENTER_GEAR, true));
//      BUTTON_PID_TEST_REVERSE_BUTTON_THREE.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_FRONT_OF_KEY, true));
//      BUTTON_PID_TEST_REVERSE_BUTTON_FOUR.toggleWhenPressed(new PIDDriveRevolutionsCommand(AutonomousConfig.PIDDriveDistances.FORWARD_TO_SHOOT, true));

//      BUTTON_RESET_ENCODERS.whenPressed(new ResetSensorsCommand());

      
//      BUTTON_INDEXER_FORWARD.whileHeld(new ShooterIndexerForwardCommand());
//      if (OI.getClimbState()) {
//      	BUTTON_CLIMB_SLOW.whileHeld(new ClimberClimbUpSlowCommand());
//      	
//      } else {
//          BUTTON_CLIMB_FAST.whileHeld(new ClimberClimbUpFastCommand());
//      }

      
//      BUTTON_GEAR.toggleWhenPressed(new VisionDriveCommand(Robot.VISION_TRACKING_FRONT, "GEAR", 8));
//      BUTTON_SECOND_GEAR.toggleWhenPressed(new VisionDriveCommand(Robot.VISION_TRACKING_FRONT, "GEAR", 8));
//      BUTTON_BOILER.toggleWhenPressed(new VisionDriveCommand(Robot.VISION_TRACKING_REAR, "BOILER", 0));

      
//      BUTTON_DRIVE_DISTANCE.toggleWhenPressed(new PIDDriveInchesCommand(-30)); //3.725 Revolutions * 18.85 in. per revolutions
//      BUTTON_DRIVE_REVERSE_DISTANCE.toggleWhenPressed(new PIDDriveInchesCommand(89.5)); //75.25 inches for distance to pin
//      BUTTON_DRIVE_ROTATE.toggleWhenPressed(new PIDDriveRotateWithVisionCommand(Robot.VISION_TRACKING_REAR, "BOILER"));

//      BUTTON_DRIVE_ROTATE.toggleWhenPressed(new PIDDriveInchesCommand(75.25));
      

			
	new Notifier(() -> updateOI()).startPeriodic(0.100); //value in seconds
	}
	
		public void updateOI() {
		SmartDashboard.putNumber("Left Encoder Position:", Robot.DRIVE_TRAIN.getLeftEncoderPosition());
		SmartDashboard.putNumber("Right Encoder Position:", Robot.DRIVE_TRAIN.getRightEncoderPosition());
		//SmartDashboard.putNumber("Left Encoder Position:", Robot.DRIVE_TRAIN.getLeftEncoderPosition() * 4);
		//SmartDashboard.putNumber("Right Encoder Position:", Robot.DRIVE_TRAIN.getRightEncoderPosition() * 4);
		//SmartDashboard.putNumber("Left Position (Revolutions):", Robot.DRIVE_TRAIN.getLeftPosition() * 4);
		//SmartDashboard.putNumber("Right Position (Revolutions):", Robot.DRIVE_TRAIN.getRightPosition() * 4);
		SmartDashboard.putNumber("Left Position (Inches):", Robot.DRIVE_TRAIN.convertRevsToInches(Robot.DRIVE_TRAIN.getLeftPosition()));
		SmartDashboard.putNumber("Right Position (Inches):", Robot.DRIVE_TRAIN.convertRevsToInches(Robot.DRIVE_TRAIN.getRightPosition()));
		SmartDashboard.putNumber("NavX Angle:", Robot.getNavXAngle());
		//SmartDashboard.putNumber("Distance to Boiler Target:", Robot.getCVDistance(Robot.VISION_TRACKING_REAR, "BOILER"));
		//SmartDashboard.putNumber("Degrees to Boiler Target:", Robot.getCVAngle(Robot.VISION_TRACKING_REAR, "BOILER"));
//		SmartDashboard.putNumber("Distance to Target:", Robot.getCVDistance(Robot.VISION_TRACKING_REAR, "GEAR"));
//		SmartDashboard.putNumber("Degrees to Target:", (Robot.getCVAngle(Robot.VISION_TRACKING_REAR, "GEAR")));
		}
	
		public static boolean getClimbState(){
		return CONTROLLER_OPERATOR.getRawButton(DriverStation.GamePad.BUTTON_Y.getValue()) && 
		        CONTROLLER_OPERATOR.getRawButton(DriverStation.GamePad.BUTTON_X.getValue());
		}
		
		public static double getLeftShooterSpeed() {
		prefs = Preferences.getInstance();
		return prefs.getDouble("Motor1", 1);
		}
		
		public static double getRightShooterSpeed() {
		prefs = Preferences.getInstance();
		return prefs.getDouble("Motor2", 1);
		}
		
		public static double getIndexerSpeed() {
		prefs = Preferences.getInstance(); // had it at .4 seemed to work but let's try faster to give it inertia
		return prefs.getDouble("Indexer", .65);
		}
		
		public static boolean getShootButton() {
		return CONTROLLER_OPERATOR.getRawAxis(DriverStation.GamePad.TRIGGER_RIGHT.getValue())
		        >= 0.5;
		}
		
		public static boolean getIndexerReverseButton() {
		return CONTROLLER_OPERATOR.getRawAxis(DriverStation.GamePad.TRIGGER_LEFT.getValue())
		        >= 0.5;
		}
}

