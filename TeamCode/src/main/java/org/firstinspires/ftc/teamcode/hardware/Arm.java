
package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class Arm {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private DcMotor Arm = null;

    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Arm(LinearOpMode opmode) {
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
        Arm = myOpMode.hardwareMap.get(DcMotor.class, "arm");

        Arm.setDirection(DcMotor.Direction.FORWARD);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	//	Arm.setMode(DcMotor.STOP_AND_RESET_ENCODER);
        myOpMode.telemetry.addData(">", "Arm Initialized");
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions using the input values from the controler.
     * Then sends these power levels to the motors.
     */
    public void move(double power) {
            Arm.setPower(power);
    }
    public long getCurrentPosition() {
	return Arm.getCurrentPosition();
    }
    

}
