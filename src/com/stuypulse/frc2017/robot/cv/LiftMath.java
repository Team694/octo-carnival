package com.stuypulse.frc2017.robot.cv;

import static com.stuypulse.frc2017.robot.CVConstants.CAMERA_Y;
import static com.stuypulse.frc2017.robot.CVConstants.LIFT_TARGET_Y;

import com.stuypulse.frc2017.util.Vector;

public class LiftMath {
    /**
     * @param lift_left Position of the left edge of the lift
     * relative to the lift camera
     * @param lift_right Position of the right edge of the lift
     * relative to the lift camera
     * @param intermediate_dist Distance from the peg base (along the
     * lift's normal) which the bot should go to before rotating and
     * approaching the peg head-on.
     * @param final_dist Distace from the peg to stop at
     * @return Path along which the robot should move, expressed as an
     * array of vectors describing discrete linear movements.
     */
    public static Vector[] getPath(
            Vector lift_left,
            Vector lift_right,
            double intermediate_dist,
            double final_dist
            ) {
        // Get average distance between lift targets (approximate position of peg)
        Vector peg = lift_left.plus(lift_right).scaleBy(0.5);
        // Get distance between left and right lift strips
        Vector lift_ltr = lift_right.minus(lift_left);
        // Get vector from peg to point on our path where we stop and turn
        Vector from_peg = lift_ltr.rotateBy(-90).withMagnitude(intermediate_dist);
        // Get vector from current location to point on our path where we stop and turn
        Vector m1 = peg.plus(from_peg);
        // Get vector from m1 to where the bot will stop, right in front of the peg.
        Vector m2 = from_peg.scaleBy(-1.0).withMagnitude(intermediate_dist - final_dist);
        return new Vector[] {m1, m2};
    }
    
    /**
     * @param stripY Y-position in the frame of a reflexite strip, measured from the top
     * of the strip to the center of the frame.
     * @return Distance to the reflexite strip.
     */
    public static double stripYToDistance(double stripY) {
        return (LIFT_TARGET_Y - CAMERA_Y) * Math.tan(Camera.frameYPxToDegrees(stripY));
    }

    /**
     * @param stripX X position in frame of the center of the reflexite strip.
     * @return Angle between where the camera is pointing and the reflexite strip.
     */
    public static double stripXToAngle(double stripX) {
        return Camera.frameXPxToDegrees(stripX);
    }

    public static Vector stripFramePosToPhysicalPos(double stripX, double stripY) {
        return Vector.fromPolar(stripXToAngle(stripX), stripYToDistance(stripY));
    }
}
