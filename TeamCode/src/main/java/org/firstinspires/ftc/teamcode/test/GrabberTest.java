package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Grabber;
import org.firstinspires.ftc.teamcode.hardware.Rotator;

@TeleOp(name = "Test: Grabber Test", group = "Test")
//@Disabled
public class GrabberTest extends LinearOpMode {

    Rotator rotator = new Rotator(this);
    Grabber grabber = new Grabber(this);
    boolean apushed = false;
    boolean bpushed = false;

    @Override
    public void runOpMode() {
        grabber.init();
        rotator.init();
        telemetry.addData(">", "Press Start to test Grabber");
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while (opModeIsActive()) {

            if (gamepad1.y) {
                grabber.grab();
            }
            if (gamepad1.x) {
                grabber.release();
            }
            if (gamepad1.a) {
                if (!apushed) {
                    rotator.rotate_left();
                    apushed = true;
                }
            } else {
                apushed = false;
            }
            if (gamepad1.b) {
                if (!bpushed) {
                    rotator.rotate_right();
                    bpushed = true;
                }
            } else {
                bpushed = false;
            }
            telemetry.addData("currpos:", "%5.2f", rotator.currpos());
            telemetry.addData(">", "Press a to turn left.");
            telemetry.addData(">", "Press b to turn right.");
            telemetry.addData(">", "Press X to grab.");
            telemetry.addData(">", "Press y to release.");
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
