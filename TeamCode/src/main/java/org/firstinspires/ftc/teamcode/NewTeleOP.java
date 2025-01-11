package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.DriveTrain;
import org.firstinspires.ftc.teamcode.hardware.Grabber;
import org.firstinspires.ftc.teamcode.hardware.Rotator;
import org.firstinspires.ftc.teamcode.hardware.Slide;

@TeleOp(name = "New TeleOp", group = "Wallace")
//@Disabled
public class NewTeleOP extends LinearOpMode {

    //    Grabber grabber = new Grabber(this);
    DriveTrain drive = new DriveTrain(this);
    Arm arm = new Arm(this);
    Rotator rotator = new Rotator(this);
    Slide slide = new Slide(this);
    Grabber grabber = new Grabber(this);
    boolean apushed = false;
    boolean bpushed = false;
    double savepowerarm = 0.;
    double savepowerslide = 0.;
    double maxslidepos = 2900;
    double maxarmpos = 1900;
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        drive.init();
        arm.init();
        grabber.init();
        rotator.init();
        slide.init();
        telemetry.addData(">", "Press Start to run");
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while (opModeIsActive()) {
            if (gamepad2.y) {
                grabber.grab();
            }
            if (gamepad2.x) {
                grabber.release();
            }
            if (gamepad2.a) {
                if (!apushed) {
                    rotator.rotate_left();
                    apushed = true;
                }
            } else {
                apushed = false;
            }
            if (gamepad2.b) {
                if (!bpushed) {
                    rotator.rotate_right();
                    bpushed = true;
                }
            } else {
                bpushed = false;
            }
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x * 0.6;
            drive.driveRobot(axial, lateral, yaw);

            double powerslide = -gamepad2.right_stick_y;  // Note: pushing stick forward gives negative value
            double powerarm = -gamepad2.left_stick_y;  // Note: pushing stick forward gives negative value
            if (Math.abs(powerarm) > 0.05) {
                savepowerarm = powerarm;
            }
            if (Math.abs(powerslide) > 0.05) {
                savepowerslide = powerslide;
            }
            long armposition = arm.getCurrentPosition();
            long slideposition = slide.getCurrentPosition();
            if (armposition >= maxarmpos) {
                powerarm = Math.min(powerarm, 0);
            }
            if (armposition <= 60) {
                powerarm = Math.max(powerarm, 0);
            }
            arm.move(powerarm);
            if (slideposition >= maxslidepos) {
                powerslide = Math.min(powerslide, 0);
            }
            if (slideposition <= 60) {
                powerslide = Math.max(powerslide, 0);
            }

            slide.move(powerslide);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData(">", "Press X to grab.");
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
