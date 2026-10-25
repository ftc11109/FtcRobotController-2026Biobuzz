package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    //motor and servo defs
    DcMotor slideMotor;
    Servo tiltServo;
    Servo leftGateServo;
    Servo rightGateServo;
    //define flywheel before assingment
    Flywheel flywheel;
    //#FIXME: ADD CORRECT VALUES INSTEAD OF PLACEHOLDER
    //enums for clean, labeled data storage
    public enum HEIGHT_VALUES {
        IDLE(0,0),
        SHOOT(200, -15),
        FLOWER(1000, 15);
        public final int ticks;
        public final int tilt;
        private HEIGHT_VALUES(int ticks, int tilt) {
            this.ticks = ticks;
            this.tilt = tilt;
        }
    }
    public enum SHOOTER_SPEEDS {
        NECTAR(2000),
        POLLEN(1500);
        public final int speed;
        private SHOOTER_SPEEDS(int speed) {
            this.speed = speed;
        }
    }
    HEIGHT_VALUES current_height = HEIGHT_VALUES.IDLE;

    public Transfer(HardwareMap hardwareMap, Flywheel flywheel) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        tiltServo = hardwareMap.get(Servo.class, "tilt_servo");
        leftGateServo = hardwareMap.get(Servo.class, "left_gate_servo");
        rightGateServo = hardwareMap.get(Servo.class, "right_gate_servo");

    }
    public void changeSlide(HEIGHT_VALUES height, SHOOTER_SPEEDS speed) {
        slideMotor.setTargetPosition(height.ticks);
        tiltServo.setPosition(height.tilt);
        if(height == HEIGHT_VALUES.SHOOT) {
            flywheel.setSpeed(speed.speed);
        }
    }
    public void openGate() {

    }
    public void tick() {
        //#TODO: AND HERE
    }
}
