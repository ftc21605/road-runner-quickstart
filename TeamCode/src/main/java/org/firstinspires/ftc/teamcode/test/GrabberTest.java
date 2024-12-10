package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Grabber;

@TeleOp(name = "Test: Grabber Test", group = "Test")
//@Disabled
public class GrabberTest extends LinearOpMode {

    Grabber grabber = new Grabber(this);
    @Override
    public void runOpMode() {
        grabber.init();
        telemetry.addData(">", "Press Start to test Grabber Servos." );
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){

	    if (gamepad1.y)
		{
		    grabber.grab();
		}
	    if (gamepad1.x)
		{
		    grabber.release();
		}
	    if (gamepad1.a)
		{
		    grabber.rotate_left();
		}
	    if (gamepad1.b)
		{
		    grabber.rotate_right();
		}
            telemetry.addData(">", "Press X to grab." );
            telemetry.addData(">", "Press y to release." );
            telemetry.addData(">", "Press a to turn left." );
            telemetry.addData(">", "Press b to turn right." );
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
