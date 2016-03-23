package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    public static final double TICKS_PER_INCH = 45;
    
    public static double startTime;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	
public static CHSRobotDrive driveBase;
public static CHSRobotDrive driveBaseMiddle;
public static CANTalon frontLeft;
public static CANTalon frontRight;
public static CANTalon rearLeft;
public static CANTalon rearRight;
public static CANTalon middleLeft;
public static CANTalon middleRight;
public static DoubleSolenoid gearShift;

public static CANTalon shooterRight;
public static CANTalon shooterLeft;

public static DoubleSolenoid retrieverDoubleSolenoidRight;
public static DoubleSolenoid retrieverDoubleSolenoidLeft;
public static CANTalon retrieverTalonOuter;
public static CANTalon retrieverTalonInner;
public static Compressor compressor;


public static CANTalon scalerTalonRight;
public static CANTalon scalerTalonLeft;
public static PIDController gyroPIDController;

public static ADXRS450_Gyro driveTrainGyro;

public static Relay cameraLightRelay;





public static void init(){
	
	driveTrainGyro = new ADXRS450_Gyro();
	gearShift = new DoubleSolenoid(0,1);//CHANGE TO 1,2 TO ACTUAL ROBOT
	
	frontLeft = new CANTalon(10);
	frontRight = new CANTalon(13);
	rearLeft = new CANTalon(12);
	rearRight = new CANTalon(15);
	middleLeft = new CANTalon(11);
	middleRight = new CANTalon(14);
	
	
	frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	middleLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	middleRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	rearLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	rearRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	
	
	
	
	driveBase = new CHSRobotDrive (frontLeft, rearLeft, frontRight, rearRight);
	driveBaseMiddle = new CHSRobotDrive(middleLeft, middleRight);
	

	driveBaseMiddle.setSafetyEnabled(false);
	driveBaseMiddle.setExpiration(0.1);
	driveBaseMiddle.setSensitivity(0.5);
	driveBaseMiddle.setMaxOutput(1.0);
	
	driveBase.setSafetyEnabled(false);
	driveBase.setExpiration(0.1);
	driveBase.setSensitivity(0.5);
	driveBase.setMaxOutput(1.0);
	
	shooterRight = new CANTalon(17);
	shooterLeft = new CANTalon(18);//CHANGE TO 18 ON ACTUAL ROBOT
	
	compressor = new Compressor(0);
	retrieverDoubleSolenoidRight = new DoubleSolenoid(6,7);
	retrieverDoubleSolenoidLeft = new DoubleSolenoid(4,5);
	retrieverTalonOuter = new CANTalon(19);
	retrieverTalonInner = new CANTalon(21);
	
	cameraLightRelay = new Relay(2);
	
	scalerTalonRight = new CANTalon(20);
	scalerTalonLeft = new CANTalon(16);
	
	
}


}
