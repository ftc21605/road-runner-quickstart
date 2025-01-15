package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Slide;

@TeleOp(name = "Test: Arm Lock Test", group = "Test")
//@Disabled
public class ArmLockTest extends LinearOpMode {

    Arm arm = new Arm(this);
    Slide slide = new Slide(this);
    double savepower = 0.;
    boolean apushed = false;
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        arm.init();
        slide.init();
        telemetry.addData(">", "Press Start to run.");
        telemetry.update();
        waitForStart();

        double slidepower = 0;

        // Scan servo till stop pressed.
        while (opModeIsActive()) {
            double armpower = 0;
            long slideposition = slide.getCurrentPosition();
            if (gamepad1.a) {
                if (!apushed) {
                    slidepower -= 0.05;  // Note: pushing stick forward gives negative value
                    apushed = true;
                }
            } else {
                apushed = false;
            }
            if (gamepad1.x) {
                slidepower = 0.07;
            }
            if (gamepad1.b) {
                slidepower = 0;  // Note: pushing stick forward gives negative value
            }
            if (Math.abs(gamepad1.left_stick_y) > 0.1) {
                armpower = -gamepad1.left_stick_y;  // Note: pushing stick forwa	// Display the current value
            }
            if (Math.abs(gamepad1.right_stick_y) > 0.1) {
                slidepower = -gamepad1.right_stick_y;  // Note: pushing stick forwa	// Display the current value
            }
            arm.move(armpower);
            slide.move(slidepower);

            telemetry.addData("Slide Position", "%10d", slideposition);
            telemetry.addData("current slidepower", "%5.2f", slidepower);
            telemetry.update();
        }
        // Set the servo to the new position and pause;
        //            rotator_servo.setPosition(position);
        //            sleep(CYCLE_MS);
        //idle();


    }
}
