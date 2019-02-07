package org.team2168.commands.intake;

import org.team2168.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotIntakeUp extends Command {

    public PivotIntakeUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intakePivotPiston);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intakePivotPiston.extendPivotPiston();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.intakePivotPiston.getPistonStatus();
        }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
