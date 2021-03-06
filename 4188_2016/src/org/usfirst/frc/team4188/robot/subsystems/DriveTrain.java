
package org.usfirst.frc.team4188.robot.subsystems;


import org.usfirst.frc.team4188.robot.CHSRobotDrive;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	// DAR Test.

    DoubleSolenoid gearShift = RobotMap.gearShift;
    CHSRobotDrive robotDrive = RobotMap.driveBase;
    //CHSRobotDrive robotDriveMiddle = RobotMap.driveBaseMiddle;
	CANTalon frontLeft = RobotMap.frontLeft;
	CANTalon frontRight = RobotMap.frontRight;
	CANTalon rearLeft = RobotMap.rearLeft;
	CANTalon rearRight = RobotMap.rearRight;
	CANTalon middleLeft = RobotMap.middleLeft;
	CANTalon middleRight = RobotMap.middleRight;
	ADXRS450_Gyro gyro = RobotMap.driveTrainGyro;
	//moved to AimHighGoal class
	public PIDController gyroPIDController = RobotMap.gyroPIDController;
	public Vision2 robotVision;
	//PIDSource source = RobotMap.driveTrainGyro;
	//PIDOutput output = RobotMap.driveBase;
	
	
	static final double TICK_DISTANCE = RobotMap.TICKS_PER_INCH;
/**
	 double KP = SmartDashboard.getNumber("Kp value");
	 double KI = SmartDashboard.getNumber("Ki value");
	 double KD = SmartDashboard.getNumber("Kd value");
	**/
	//change to final tuned values for PID loop later
	
	//private static final double KP = 0.1;
	//private static final double KI = 0.005;
	//private static final double KD = 0.0;
	//private static final double KF = 6.0;
	//private static final double SETTLED_TIME = 0.0;
	private Timer timer;
	private static boolean timerRunning;

	//pid controller tuning guide
	//p quickens the approach to the setpoint; larger oscillation;
	//d slows approach to setpoint, stops oscillations
	//increase in i can correct for steady-state error
	
	public void init(){
		gyro.reset();		
	}
	
	public void gyroReset(){
		gyro.reset();
	}


	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
	}
	
	public void driveWithJoystick(double y, double x, double throttle){
		robotDrive.arcadeDrive(y*throttle, x*throttle);        
    }
	
	
	
	
	public double getEncoderFR(){
		return frontRight.getEncPosition();
	}
	
	public double getEncoderFL(){
		return frontLeft.getEncPosition();
	}
	
	public double getEncoderRR(){
		return rearRight.getEncPosition();
	}
	
	public double getEncoderRL(){
		return rearLeft.getEncPosition();
	}
	
	public double getEncoderML(){
		return middleLeft.getEncPosition();
	}
	public double getEncoderMR(){
		return middleRight.getEncPosition();
	}
	
	public void resetEncoders() { 
        frontLeft.setPosition(0);
        frontRight.setPosition(0);
        rearLeft.setPosition(0);
        rearRight.setPosition(0);
        middleLeft.setPosition(0);
        middleRight.setPosition(0);
	}
	
	public double getDistance(){	// Returns value in inches
		double frontLeft = Robot.drivetrain.getEncoderFL();
		double frontRight = -Robot.drivetrain.getEncoderFR();
		double rearLeft = Robot.drivetrain.getEncoderRL();
		double rearRight = -Robot.drivetrain.getEncoderRR();
		double middleLeft = Robot.drivetrain.getEncoderML();
		double middleRight = Robot.drivetrain.getEncoderMR();
        return ((frontLeft + frontRight + rearLeft + rearRight + middleLeft + middleRight) / 4.0) / TICK_DISTANCE;
	}
	
	public void getEncoderValues(){        
        SmartDashboard.putNumber("frontLeftEncoder distance", frontLeft.getEncPosition());
        SmartDashboard.putNumber("frontRightEncoder distance", frontRight.getEncPosition());
        SmartDashboard.putNumber("rearLeftEncoder distance", rearLeft.getEncPosition());
        SmartDashboard.putNumber("rearRightEncoder distance", rearRight.getEncPosition());
	}

	public void autoDrive(double moveValue, double rotateValue){
		 robotDrive.arcadeDrive(moveValue, rotateValue);	 
	}
	
	public void autoDriveBearingAngle(double outputMagnitude, double curve){
		robotDrive.drive(outputMagnitude, curve);
	}
	
	public void setRampRate(double rampRate) {
		frontLeft.setVoltageRampRate(rampRate);
		frontRight.setVoltageRampRate(rampRate);
		rearLeft.setVoltageRampRate(rampRate);
		rearRight.setVoltageRampRate(rampRate);
		middleLeft.setVoltageRampRate(rampRate);
		middleRight.setVoltageRampRate(rampRate);
	}
	
	public void shiftGearForward(){
		gearShift.set(DoubleSolenoid.Value.kForward);
	}
	public void shiftGearBackward(){
		gearShift.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void gearShiftDoNothing(){
		gearShift.set(DoubleSolenoid.Value.kOff);
	}
	
}
    
    

