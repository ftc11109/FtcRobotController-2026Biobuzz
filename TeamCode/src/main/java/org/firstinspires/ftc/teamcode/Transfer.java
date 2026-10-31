package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    //motor and servo defs
    DcMotor slideMotor;
    Servo rightGateServo;
    Gamepad copilot;
    Gamepad driver;

    public Transfer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setTargetPosition(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(0.0);
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
            slideMotor.setTargetPosition(1000);
        }
        if(copilot.b) {
            slideMotor.setTargetPosition(300);
        }
        if(slideMotor.getCurrentPosition() > 800){
            if(driver.left_bumper) {
                rightGateServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                rightGateServo.setPosition(-10);
            }
        }
    }
}
