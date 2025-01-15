package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.DriveTrain;

@Autonomous(name = "Autonomous Wallace", group = "Wallace")
@Disabled
public class autowallace extends LinearOpMode {

    DriveTrain drive = new DriveTrain(this);

    @Override
    public void runOpMode() {
        drive.init();
        // telemetry.addData("Starting at", "%7d :%7d",
        //         leftFrontDrive.getCurrentPosition(),
        //         rightFrontDrive.getCurrentPosition());
        //BlueFinder.Selected selected;
        // here is what happens after we hit start
        while (!isStarted() && !isStopRequested()) {
        }

    }


}


