package org.team2168.commands.auto;

import org.team2168.RobotMap;
import org.team2168.commands.intake.DriveIntakeWheelsWithConstant;
import org.team2168.commands.intake.StopWheels;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pivots and scores the cube and pivots again
 */
public class ScoreCube extends CommandGroup {

    public ScoreCube() {
    	 
   	 	addSequential(new DriveIntakeWheelsWithConstant(RobotMap.CUBE_INTAKE_MAX_OUTAKE),0.4);
   	 	addParallel(new StopWheels());
   	    
    }
}
