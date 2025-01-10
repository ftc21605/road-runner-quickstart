
package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.DriveTrain;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "MecanumDrive", group = "Test")
//@Disabled
public class MecanumDrive extends LinearOpMode {

    DriveTrain drive = new DriveTrain(this);
    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

  @Override
    public void runOpMode() {

		// Wait for the game to start (driver presses PLAY)
	drive.init();
         telemetry.addData(">", "Press Start to run" );
        telemetry.update();
       waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x*0.6;
	    drive.driveRobot(axial,lateral,yaw);
	}
  }
}


