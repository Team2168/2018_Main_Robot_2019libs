package org.team2168.PID.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import org.team2168.utils.consoleprinter.ConsolePrinter;
import org.team2168.Robot;

public class Limelight
{

    // Target position and camera settings
    private NetworkTable networkTable;
    private NetworkTableEntry tx;
    private NetworkTableEntry ta;
    private NetworkTableEntry camtran;
    private NetworkTableEntry ledMode;
    private NetworkTableEntry camMode;
    private NetworkTableEntry pipeline;

    /**
     * Default constructor
     */
    public Limelight()
    {
        // Variables to get data from Limelight
        networkTable = NetworkTableInstance.getDefault().getTable("limelight");
        tx = networkTable.getEntry("tx");
        ta = networkTable.getEntry("ta");
        camtran = networkTable.getEntry("camtran");

        // Variables to set data on Limelight
        ledMode = networkTable.getEntry("ledMode");
        camMode = networkTable.getEntry("camMode");
        pipeline = networkTable.getEntry("pipeline");

        // Sets the camera controls
        ledMode.setNumber(0);
        camMode.setNumber(0);
        pipeline.setNumber(4);

        // Testing only
		ConsolePrinter.putNumber("Vision Target Bearing", () -> {return Robot.drivetrain.limelight.getTargetBearing();}, true, false);
		ConsolePrinter.putNumber("Vision Target Area", () -> {return Robot.drivetrain.limelight.getTargetArea();}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 1", () -> {return Robot.drivetrain.limelight.getTargetPosition()[0];}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 2", () -> {return Robot.drivetrain.limelight.getTargetPosition()[1];}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 3", () -> {return Robot.drivetrain.limelight.getTargetPosition()[2];}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 4", () -> {return Robot.drivetrain.limelight.getTargetPosition()[3];}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 5", () -> {return Robot.drivetrain.limelight.getTargetPosition()[4];}, true, false);
		ConsolePrinter.putNumber("Vision Target Position 6", () -> {return Robot.drivetrain.limelight.getTargetPosition()[5];}, true, false);
    }

    /**
     * Returns the target bearing
     * @return is a double from -27.0 to 27.0
     */
    public double getTargetBearing()
    {
        return tx.getDouble(0.0);
    }

    /**
     * Returns the target's area, measured by the percentage of the frame it takes up
     * @return is a double from 0.0 to 100.0
     */
    public double getTargetArea()
    {
        return ta.getDouble(0.0);
    }

    /**
     * Returns the target's 3D position
     * @return is an array of 6 doubles; gives the translation (x,y,z) and rotation (pitch,yaw,roll)
     */
    public double[] getTargetPosition()
    {
        double[] defaultValues = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        return camtran.getDoubleArray(defaultValues);
    }

    /**
     * Sets the pipeline being used
     * @param pipelineNumber is an int from 0 to 9
     */
    public void setPipeline(int pipelineNumber)
    {
        if(pipelineNumber >= 0 && pipelineNumber <= 9)
        {
            pipeline.setNumber(pipelineNumber);
        }
    }
    
}