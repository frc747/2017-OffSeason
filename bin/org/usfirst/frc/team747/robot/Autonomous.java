package org.usfirst.frc.team747.robot;


import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc.team747.robot.Autonomous.AutoMode;
import org.usfirst.frc.team747.robot.autonomous.*;
//import org.usfirst.frc.team747.robot.autonomous.CrossLine;
//import org.usfirst.frc.team747.robot.autonomous.ScoreGear;
//import org.usfirst.frc.team747.robot.autonomous.VisionGear;




public class Autonomous{
    
    public enum AutoMode{
        AUTOMODE_NONE,
        AUTOMODE_CROSS_LINE,
        AUTOMODE_SCORE_BALLS_RED,
        AUTOMODE_SCORE_BALLS_BLUE,
        AUTOMODE_GEAR_SCORE_BALLS_RED,
        AUTOMODE_GEAR_SCORE_BALLS_BLUE,
        AUTOMODE_SCORE_GEAR,
        AUTOMODE_SCORE_GEAR_RED,
        AUTOMODE_SCORE_GEAR_BLUE,
        AUTOMODE_VISION_GEAR
    }
    
    private SendableChooser autoChooser1;
//    private SendableChooser autoChooser2;
    
    public Autonomous(){
        autoChooser1 = new SendableChooser();
//        autoChooser2 = new SendableChooser();
        
        
        autoChooser1.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
        autoChooser1.addObject("Cross Line", AutoMode.AUTOMODE_CROSS_LINE);
        autoChooser1.addObject("Red Score Balls", AutoMode.AUTOMODE_SCORE_BALLS_RED);
        autoChooser1.addObject("Blue Score Balls", AutoMode.AUTOMODE_SCORE_BALLS_BLUE);
        autoChooser1.addObject("Red Gear Score Balls", AutoMode.AUTOMODE_GEAR_SCORE_BALLS_RED);
        autoChooser1.addObject("Blue Gear Score Balls", AutoMode.AUTOMODE_GEAR_SCORE_BALLS_BLUE);
        autoChooser1.addObject("Score Gear", AutoMode.AUTOMODE_SCORE_GEAR);
        autoChooser1.addObject("Score Gear Red", AutoMode.AUTOMODE_SCORE_GEAR_RED);
        autoChooser1.addObject("Score Gear Blue", AutoMode.AUTOMODE_SCORE_GEAR_BLUE);
        autoChooser1.addObject("Score Vision Gear", AutoMode.AUTOMODE_VISION_GEAR);
        SmartDashboard.putData("Auto mode", autoChooser1);
        
        
    }
    
    public void startMode(){
        
    	System.out.println("In Auto.StartMode");
    	
    	
        AutoMode selectedAutoMode = (AutoMode)(autoChooser1.getSelected());
                    
        switch (selectedAutoMode){
            case AUTOMODE_CROSS_LINE:
                new CrossLine().start();
                break;
            case AUTOMODE_SCORE_BALLS_RED:
                new ShootBallsFromRed().start();
                break;
            case AUTOMODE_SCORE_BALLS_BLUE:
                new ShootBallsFromBlue().start();
                break;
            case AUTOMODE_GEAR_SCORE_BALLS_RED:
                new GearShootBallsFromRed().start();
                break;
            case AUTOMODE_GEAR_SCORE_BALLS_BLUE:
                new GearShootBallsFromBlue().start();
                break;
            case AUTOMODE_SCORE_GEAR:
                new ScoreGear().start();
                break;
            case AUTOMODE_SCORE_GEAR_RED:
                new ScoreGearRed().start();
                break;
            case AUTOMODE_SCORE_GEAR_BLUE:
                new ScoreGearBlue().start();
                break;
            case AUTOMODE_VISION_GEAR:
                new VisionGear().start();
                break;
            case AUTOMODE_NONE:
                //DO NOTHING
            default:
                break;
            }
    }
}