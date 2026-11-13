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
    static final float ticksPerRev = 288;
    static final float ticksPerDegree = ticksPerRev / 360;
    static final double pulleyDiameter = 3.5;
    static final float pulleyCircumference = (float) (Math.PI * pulleyDiameter);
    static final float revPerStringInch = pulleyCircumference / (float) (Math.PI * 2);
    static final float ticksPerStringInch = revPerStringInch * 288;
    static final int ticksPerLiftInch = (int) ticksPerStringInch / 2;
    //heights (inches) #TODO MAKE THESE VALUES WORK
    static final int shootHeight = 10;
    static final int flowerHeight = 20;


    public Transfer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        slideMotor = hardwareMap.get(DcMotor.class, "lift_motor");
        slideMotor.setTargetPosition(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(1.0);
        pollenServo = hardwareMap.get(Servo.class, "pollen_servo");
        nectarServo = hardwareMap.get(Servo.class, "nectar_servo");
        flowerServo = hardwareMap.get(Servo.class, "flower_servo");
        tiltMotor = hardwareMap.get(DcMotor.class, "tilt_motor");
        copilot = gamepad2;
        driver = gamepad1;
    }
    public int coreHexDegToTicks(float deg) {
        return (int) (deg * ticksPerDegree);
    }
    public int liftInchesToSlideTicks(float inches) {
        return (int) ((inches / 2) / pulleyCircumference) * 288;
    }
    public void tick() {
        //Slide controls
        if(copilot.x) {
            slideMotor.setTargetPosition(liftInchesToSlideTicks(0));
            pollenServo.setPosition(0.5);
            nectarServo.setPosition(0.5);
            flowerServo.setPosition(0.5);
            tiltMotor.setTargetPosition(coreHexDegToTicks(0));

        }
        if(copilot.a) {
            slideMotor.setTargetPosition(liftInchesToSlideTicks(shootHeight));
            tiltMotor.setTargetPosition(coreHexDegToTicks(-10));
        }
        if(copilot.b) {
            slideMotor.setTargetPosition(liftInchesToSlideTicks(flowerHeight));
            tiltMotor.setTargetPosition(coreHexDegToTicks(10));
        }
        //flower gate controls
        if(slideMotor.getCurrentPosition() > liftInchesToSlideTicks(flowerHeight) - liftInchesToSlideTicks(0.25F) && slideMotor.getTargetPosition() == liftInchesToSlideTicks(flowerHeight)){
            if(driver.left_bumper) {
                flowerServo.setPosition(1.0);
            }
            if(driver.left_trigger_pressed) {
                flowerServo.setPosition(0.0);
            }
        }
        //shooting gate controls
        if(slideMotor.getCurrentPosition() > liftInchesToSlideTicks(shootHeight) - liftInchesToSlideTicks(0.25F) && slideMotor.getTargetPosition() == liftInchesToSlideTicks(shootHeight)) {
            if(driver.left_bumper) {
                pollenServo.setPosition(1.0);
            }
            if(driver.left_trigger_pressed) {
                nectarServo.setPosition(0.0);
            }
        }
    }
}
