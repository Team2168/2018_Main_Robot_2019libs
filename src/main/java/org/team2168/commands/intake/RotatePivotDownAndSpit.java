package org.team2168.commands.intake;

import org.team2168.RobotMap;
import org.team2168.commands.auto.Sleep;
import org.team2168.commands.hardStop.EngageIntakePivotHardStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pivot arm down and spit cube
 */
public class RotatePivotDownAndSpit extends CommandGroup {

    public RotatePivotDownAndSpit() {
        addSequential(new EngageIntakePivotHardStop(), 0.6);
        addSequential(new DriveIntakeWheelsWithConstant(RobotMap.CUBE_INTAKE_MAX_OUTAKE));
    }
}
