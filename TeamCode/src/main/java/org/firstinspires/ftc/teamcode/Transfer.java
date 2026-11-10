package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    //motor and servo defs
    DcMotor slideMotor;
    Servo pollenServo;
    Servo nectarServo;
    Servo flowerServo;
    DcMotor tiltMotor;
    Gamepad copilot;
    Gamepad driver;

    public Transfer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setTargetPosition(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(0.0);
        pollenServo = hardwareMap.get(Servo.class, "pollen_servo");
        nectarServo = hardwareMap.get(Servo.class, "nectar_servo");
        flowerServo = hardwareMap.get(Servo.class, "flower_servo");
        tiltMotor = hardwareMap.get(DcMotor.class, "tilt_motor");
        copilot = gamepad2;
        driver = gamepad1;

    }

    public void tick() {
        //Slide controls
        if(copilot.x) {
            slideMotor.setTargetPosition(0);
            pollenServo.setPosition(0);
            nectarServo.setPosition(0);
            tiltMotor.setTargetPosition(0);

        }
        if(copilot.a) {
            //#FIXME: MAKE THIS AN ACTUAL WORKING VALUE AND EVERY OTHER VALUE BELOW THIS
            slideMotor.setTargetPosition(300);
            tiltMotor.setTargetPosition(-8);
        }
        if(copilot.b) {
            slideMotor.setTargetPosition(1000);
            tiltMotor.setTargetPosition(8);
        }
        //Shooting gate controls
        if(slideMotor.getCurrentPosition() > 800 && slideMotor.getTargetPosition() == 1000){
            if(driver.left_bumper) {
                pollenServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                nectarServo.setPosition(10);
            }
        }
        //Flower gate controls
        if(slideMotor.getTargetPosition() == 300) {
            if(driver.left_bumper) {
                flowerServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                flowerServo.setPosition(10);
            }
        }
    }
}
