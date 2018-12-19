package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import static java.lang.Thread.sleep;


@Autonomous(name="Main Auto", group="Linear Opmode")
public class Main_Autonomous extends LinearOpMode
{


    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor right = null;
    private DcMotor left = null;
    private DcMotor climb = null;
    private Servo dropper = null;

    @Override
        public void runOpMode() {

            telemetry.addData("Status", "Initialized");

            right = hardwareMap.get(DcMotor.class, "right");
            left = hardwareMap.get(DcMotor.class, "left");
            climb = hardwareMap.get(DcMotor.class, "climb");
            dropper = hardwareMap.get(Servo.class, "dropper");

            right.setDirection(DcMotor.Direction.FORWARD);
            left.setDirection(DcMotor.Direction.REVERSE);
            climb.setDirection(DcMotor.Direction.REVERSE);

            telemetry.addData("Status", "Initialized");

            waitForStart();

            telemetry.addData("Mode", "Running");
            telemetry.update();

            runtime.reset();

            //Lower the robot
            climb.setPower(1);
            sleep(6000);
            climb.setPower(0);

            //Turn the robot 180
            left.setPower(1);
            right.setPower(-1);

            sleep(1400);

            //Drive forward
            right.setPower(1);

            sleep(1900);

            left.setPower(0);
            right.setPower(0);
            climb.setPower(0);

    }
}