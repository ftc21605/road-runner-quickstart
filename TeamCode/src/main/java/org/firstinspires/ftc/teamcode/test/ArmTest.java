
package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/*
 * This OpMode scans a single servo back and forward until Stop is pressed.
 * The code is structured as a LinearOpMode
 * INCREMENT sets how much to increase/decrease the servo position each cycle
 * CYCLE_MS sets the update period.
 *
 * This code assumes a Servo configured with the name "left_hand" as is found on a Robot.
 *
 * NOTE: When any servo position is set, ALL attached servos are activated, so ensure that any other
 * connected servos are able to move freely before running this test.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */
@TeleOp(name = "Test: Arm Test", group = "Test")
//@Disabled
public class ArmTest extends LinearOpMode {

    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  0.9;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position

    DcMotor motor;
    // Define class members
    Servo   grabber_servo;
    Servo   rotator_servo;
    double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    boolean rampUp = true;


    @Override
    public void runOpMode() {

       motor = hardwareMap.get(DcMotor.class, "extender1");
        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        // grabber_servo = hardwareMap.get(Servo.class, "grabber0");
        // rotator_servo = hardwareMap.get(Servo.class, "rotator1");

        // Wait for the start button
        telemetry.addData(">", "Press Start to scan Servo." );
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){

            // slew the servo, according to the rampUp (direction) variable.
            if (rampUp) {
                // Keep stepping up until we hit the max value.
                position += INCREMENT ;
                if (position >= MAX_POS ) {
                    position = MAX_POS;
                    rampUp = !rampUp;   // Switch ramp direction
                }
            }
            else {
                // Keep stepping down until we hit the min value.
                position -= INCREMENT ;
                if (position <= MIN_POS ) {
                    position = MIN_POS;
                    rampUp = !rampUp;  // Switch ramp direction
                }
            }
	    if (gamepad1.y)
		{
		    motor.setPower(-1.);
		}
	    if (gamepad1.a)
		{
		    motor.setPower(-0.8);
		}
	    if (gamepad1.x)
		{
		    motor.setPower(1.);
		}
	    if (!gamepad1.y && !gamepad1.x && !gamepad1.a)
 		{
		    motor.setPower(0);
		}
	    if (gamepad1.a)
		{
            grabber_servo.setPosition(MAX_POS);
		}
	    if (gamepad1.b)
		{
            grabber_servo.setPosition(MIN_POS);
		}
	    // Display the current value
            telemetry.addData("Servo Position", "%5.2f", position);
            telemetry.addData(">", "Press Stop to end test." );
            telemetry.addData(">", "Press Stop to end test." );
            telemetry.update();

            // Set the servo to the new position and pause;
	    //            rotator_servo.setPosition(position);
	    //            sleep(CYCLE_MS);
            //idle();
        }

        // Signal done;
        telemetry.addData(">", "Done");
        telemetry.update();
    }
}
