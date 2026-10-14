package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {
    DcMotor slideMotor;
    public enum HEIGHT_POSITIONS {
        IDLE(0),
        SHOOT(200),
        FLOWER(1000);
        public final int ticks;
        private HEIGHT_POSITIONS(int ticks) {
            this.ticks = ticks;
        }
    }
    public enum GAME_PIECE_TYPES {
        IDLE(0),
        POLLEN(-15),
        NECTAR(15);
        public final int rotation;
        private GAME_PIECE_TYPES(int rotation) {
            this.rotation = rotation;
        }

    }
    public Transfer(HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void changeSlide(HEIGHT_POSITIONS height) {
        switch(height) {
            //#TODO: ACTUALLY MAKE STUFF HAPPEN HERE
            case IDLE: {

            }
            case SHOOT: {

            }
            case FLOWER: {

            }
        }
    }
    public void changeTrough(GAME_PIECE_TYPES type) {
        switch(type) {
            //#TODO: AND HERE
            case IDLE: {

            }
            case NECTAR: {

            }
            case POLLEN: {

            }
        }
    }
    public void tick() {
        //#TODO: AND HERE
    }
}
