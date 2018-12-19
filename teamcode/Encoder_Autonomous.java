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


@Autonomous(name="Encoder Auto", group="Linear Opmode")
public class Encoder_Autonomous extends LinearOpMode
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

            left  = hardwareMap.get(DcMotor.class, "right");
            right = hardwareMap.get(DcMotor.class, "left");
            climb = hardwareMap.get(DcMotor.class, "climb");
            dropper = hardwareMap.get(Servo.class, "dropper");


            right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            climb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            climb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            right.setDirection(DcMotor.Direction.FORWARD);
            left.setDirection(DcMotor.Direction.REVERSE);

            telemetry.addData("Status", "Initialized");

            //////////////////
            waitForStart();
            //////////////////

            //Drop the robot off of the lander

            climb.setPower(-1);
            while(opModeIsActive() && climb.getCurrentPosition() < 20000){
                telemetry.addData("dropping", climb.getCurrentPosition());
                telemetry.update();
            }
            climb.setPower(0);

            telemetry.addData("value", left.getCurrentPosition());
            telemetry.update();
            sleep(1000);
            //Turn 180
            right.setPower(-1);
            left.setPower(1);
            while(opModeIsActive() && right.getCurrentPosition() < 3600){
                telemetry.addData("turning 180", right.getCurrentPosition());
                telemetry.update();
            }
            left.setPower(0);
            right.setPower(0);

            sleep(1000);

            //Drive into the middle mineral
            right.setPower(-1);
            left.setPower(-1);
            while(opModeIsActive() && right.getCurrentPosition() < 12000){
                telemetry.addData("Moving into the middle mineral", right.getCurrentPosition());
                telemetry.update();
            }
            left.setPower(0);
            right.setPower(0);


            //turn 180
            right.setPower(-1);
            left.setPower(1);
            while(opModeIsActive() && right.getCurrentPosition() < 15000){
                telemetry.addData("turning 180", right.getCurrentPosition());
                telemetry.update();
            }
            left.setPower(0);
            right.setPower(0);


            //Drop the marker
            dropper.setPosition(-1);
            sleep(1000);

            telemetry.addData("done", "done");
            telemetry.update();

    }
}