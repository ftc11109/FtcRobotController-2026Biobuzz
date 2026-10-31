package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    //motor and servo defs
    DcMotor slideMotor;
    Servo tiltServo;
    Servo leftGateServo;
    Servo rightGateServo;
    int game_piece_type;
    Gamepad copilot;
    Gamepad driver;

    public Transfer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setTargetPosition(0);
        slideMotor.setPower(0.5);
        rightGateServo = hardwareMap.get(Servo.class, "right_gate_servo");
        copilot = gamepad2;
        driver = gamepad1;

    }

    public void tick() {
        if(copilot.x) {
            slideMotor.setTargetPosition(0);
            rightGateServo.setPosition(0);
        }
        if(copilot.a) {
            //#FIXME: MAKE THIS AN ACTUAL WORKING VALUE
            slideMotor.setTargetPosition(2000);
        }
        if(slideMotor.getCurrentPosition() > 1000) {
            if(driver.left_bumper) {
                rightGateServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                rightGateServo.setPosition(-10);
            }
        }
    }
}
