package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShoot2 extends CommandGroup {
    
    public  AutoShoot2() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new EjectBallFullSpeed(),0.1);//CHANGED FROM 0.25
    	addParallel(new RunShooterMotorsWithThrottle(),2);
    	addSequential(new DoNothingRetriever(),1.2511);
    	addParallel(new RetrieveBall(), 1);
    	//Feeds Ball into Running Shooter Motors
    	
    }
}
