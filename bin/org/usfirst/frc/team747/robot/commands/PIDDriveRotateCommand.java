package org.usfirst.frc.team747.robot.commands;

import org.usfirst.frc.team747.robot.Robot;
import org.usfirst.frc.team747.robot.vision.Target;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PIDDriveRotateCommand extends PIDCommand {

    private double angleToRotate;
    
    private int onTargetCount;
private final static int TARGET_COUNT_ONE_SECOND = 50;
    
    //Half a second is being multiplied by the user input to achieve the desired "ON_TARGET_COUNT"
    private final static double ON_TARGET_MINIMUM_COUNT = TARGET_COUNT_ONE_SECOND * 0.25; //times 10 is 5 seconds, times 20 is 10 seconds, etc...
    
    private final static double STOP_THRESHOLD_DEGREES = 5;
    private final static double MAX_PERCENT_VBUS = 0.5;
    
    private final static double DRIVE_SPEED_MINIMUM = 0.30;
    
    public PIDDriveRotateCommand(double degreesRotate) {
//        super(0.05, 0.0005, 0.5);
        super(0.05, 0.0, 0.13);
        
        this.angleToRotate = degreesRotate;
        
        requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        onTargetCount = 0;
        
        Robot.resetNavXAngle();
        
        getPIDController().setContinuous(true); //will reset back to the minimum value after reaching the max value
        getPIDController().setAbsoluteTolerance(STOP_THRESHOLD_DEGREES); //the threshold that the PID Controller abides by to consider the value as "on target"
        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-MAX_PERCENT_VBUS, MAX_PERCENT_VBUS);
        
        getPIDController().setSetpoint(angleToRotate);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        if (getPIDController().onTarget()) {
            onTargetCount++;
        } else {
            onTargetCount = 0;
        }
                    
        return (onTargetCount > ON_TARGET_MINIMUM_COUNT);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    @Override
    protected double returnPIDInput() {
        return Robot.getNavXAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        
//        double sign = output > 0 ? 1.0 : -1.0; //google ternary operator
        
        double sign = Math.signum(output);
        
        if (output != 0 && Math.abs(output) < DRIVE_SPEED_MINIMUM) { //bang means "!" which is not in java, computer/programming slang
            output = sign * DRIVE_SPEED_MINIMUM;
        }
        
        Robot.DRIVE_TRAIN.set(output, -output);
    }
}
