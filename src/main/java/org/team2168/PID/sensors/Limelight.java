package org.team2168.PID.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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
    private Limelight()
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
        pipeline.setNumber(0);
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