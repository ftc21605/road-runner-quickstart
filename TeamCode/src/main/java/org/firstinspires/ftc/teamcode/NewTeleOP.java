package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.DriveTrain;
//import org.firstinspires.ftc.teamcode.hardware.Grabber;

@TeleOp(name = "New TeleOp", group = "Wallace")
//@Disabled
public class NewTeleOP extends LinearOpMode {

    //    Grabber grabber = new Grabber(this);
    DriveTrain drive = new DriveTrain(this);
    Arm arm = new Arm(this);
   private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
	drive.init();
	arm.init();
	//        grabber.init();
        telemetry.addData(">", "Press Start to run" );
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){
	    /*
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
	    */
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x*0.6;
	    drive.driveRobot(axial,lateral,yaw);
	    
            telemetry.addData("Status", "Run Time: " + runtime.toString());
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
