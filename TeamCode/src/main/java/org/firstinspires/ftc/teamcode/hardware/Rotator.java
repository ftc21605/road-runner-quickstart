
package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;


public class Rotator {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private Servo TurnServo = null;
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position
    double currpos = 0.5;
    double increment = 0.05;
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Rotator(LinearOpMode opmode) {
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
TurnServo = myOpMode.hardwareMap.get(Servo.class, "rotator");
TurnServo.setPosition(currpos);
        myOpMode.telemetry.addData(">", "Rotator Servo Initialized");
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions using the input values from the controler.
     * Then sends these power levels to the motors.
     */
    public void rotate_all_left() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	TurnServo.setPosition(MIN_POS);
	currpos = MIN_POS;
	myOpMode.telemetry.addData("rot all left:", "%5.2f", currpos );
    }
    public void rotate_left() {
	if (currpos > MIN_POS)
	    {
	currpos = currpos-increment;
	TurnServo.setPosition(currpos);
	    }
	myOpMode.telemetry.addData("rotleft:", "%5.2f", currpos );

	    }
    public void rotate_all_right() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	TurnServo.setPosition(MAX_POS);
	currpos = MAX_POS;
	myOpMode.telemetry.addData("rot all right:", "%5.2f", currpos );
    }
    public void rotate_right() {
        // Combine drive and turn for blended motion.
            // Send calculated power to wheels
	if (currpos < MAX_POS)
	    {
	currpos = currpos+increment;
	TurnServo.setPosition(currpos);
	    }
	myOpMode.telemetry.addData("rot right:", "%5.2f", currpos );
	    }
    public double currpos(){
	return currpos;
    }

}
