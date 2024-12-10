
package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;


public class Grabber {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private Servo GrabServo = null;
    private Servo TurnServo = null;
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Grabber(LinearOpMode opmode) {
        myOpMode = opmode;
    }

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init()    {
        // Define and Initialize Motors (note: need to use reference to actual OpMode).
GrabServo = myOpMode.hardwareMap.get(Servo.class, "grabber1");
TurnServo = myOpMode.hardwareMap.get(Servo.class, "rotator0");
        myOpMode.telemetry.addData(">", "Grabber Servos Initialized");
        myOpMode.telemetry.update();
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions using the input values from the controler.
     * Then sends these power levels to the motors.
     */
    public void grab() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	GrabServo.setPosition(MAX_POS);
    }
    public void release() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	GrabServo.setPosition(MIN_POS);
    }
    public void rotate_left() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	TurnServo.setPosition(MAX_POS);
    }
    public void rotate_right() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	TurnServo.setPosition(MIN_POS);
    }


}
