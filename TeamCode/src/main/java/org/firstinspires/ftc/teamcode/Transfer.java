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
    static final int flowerHeight = 17;


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
    public int coreHexDegToTicks(float deg) {
        return (int) (deg * ticksPerDegree);
    }
    public int inchesToSlideTicks(float inches) {
        return (int) inches * ticksPerLiftInch;
    }
    public void tick() {
        //Slide controls
        if(copilot.x) {
            slideMotor.setTargetPosition(inchesToSlideTicks(0));
            pollenServo.setPosition(0);
            nectarServo.setPosition(0);
            flowerServo.setPosition(0);
            tiltMotor.setTargetPosition(coreHexDegToTicks(10));

        }
        if(copilot.a) {
            slideMotor.setTargetPosition(inchesToSlideTicks(shootHeight));
            tiltMotor.setTargetPosition(coreHexDegToTicks(-10));
        }
        if(copilot.b) {
            slideMotor.setTargetPosition(inchesToSlideTicks(flowerHeight));
            tiltMotor.setTargetPosition(coreHexDegToTicks(10));
        }
        //flower gate controls
        if(slideMotor.getCurrentPosition() > inchesToSlideTicks(flowerHeight) - inchesToSlideTicks(0.25F) && slideMotor.getTargetPosition() == inchesToSlideTicks(flowerHeight)){
            if(driver.left_bumper) {
                flowerServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                flowerServo.setPosition(10);
            }
        }
        //shooting gate controls
        if(slideMotor.getCurrentPosition() > inchesToSlideTicks(shootHeight) - inchesToSlideTicks(0.25F) && slideMotor.getTargetPosition() == inchesToSlideTicks(shootHeight)) {
            if(driver.left_bumper) {
                pollenServo.setPosition(10);
            }
            if(driver.left_trigger_pressed) {
                nectarServo.setPosition(10);
            }
        }
    }
}
