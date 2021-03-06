package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.ShooterDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon shooterMotorRight = RobotMap.shooterRight;
	CANTalon shooterMotorLeft = RobotMap.shooterLeft;
/**
    public Shooter(double rampRate){
    	shooterMotorRight.setVoltageRampRate(rampRate);
		shooterMotorLeft.setVoltageRampRate(rampRate);
    }
	
	**/
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    	
    }
    
    public void runShooterMotorRightWithThrottleForward(double throttle){
    	shooterMotorRight.set(1*throttle);
    	
    }
    public void runShooterMotorRightWithThrottleBackward(double throttle){
    	shooterMotorRight.set(-1*throttle);
    }
    
    public void runShooterMotors(double throttle)
    {
    	double newThrottle = (throttle+1.0)/2.0;
    	shooterMotorRight.set(-1.0*throttle);
    	shooterMotorLeft.set(throttle);
    }
    
    public void runShooterMotorsBackwards(double throttle)
    {
    	shooterMotorRight.set(throttle);
    	shooterMotorLeft.set(-1*throttle);
    }
    
	public void shooterOff() {
		shooterMotorRight.set(0);
		shooterMotorLeft.set(0); 
	}
	
	public double getShooterRightEncoderReading(){
		return shooterMotorRight.getEncPosition();
	}
	
	public double getShooterLeftEncoderReading(){
		return shooterMotorLeft.getEncPosition();
	}
	
	public void resetShooterEncoders(){
		shooterMotorRight.setPosition(0);
		shooterMotorLeft.setPosition(0);
	}

	public void init() {
		// TO DO Auto-generated method stub
		
	}


}

