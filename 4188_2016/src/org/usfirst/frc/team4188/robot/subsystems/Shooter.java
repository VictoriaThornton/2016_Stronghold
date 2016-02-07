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
    
    public void runShootorMotors(double throttle)
    {
    	double newThrottle = (throttle+1)/2;
    	shooterMotorRight.set(-1*newThrottle);
    	shooterMotorLeft.set(1*newThrottle);
    }

	public void shooterOff() {
		shooterMotorRight.set(0);
		shooterMotorLeft.set(0);
	}


}

