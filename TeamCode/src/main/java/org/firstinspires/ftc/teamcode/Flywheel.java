package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Flywheel {
    DcMotorEx flywheelMotor;
    Gamepad driver;

    //#TODO: REQUIRE CAMERA PASSED IN FOR TARGETING
    public Flywheel(HardwareMap hardwareMap, Gamepad gamepad1) {
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "flywheel_motor");
        //flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        PIDFCoefficients pidf = new PIDFCoefficients(20, 3, 5, 0);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, pidf);
        driver = gamepad1;
    }
    public void tick() {
        //#TODO: ADD TICK METHOD
        if(driver.x) {
            this.setSpeed(0);
        }
        if(driver.y) {
            this.setSpeed(2525);
        }
        if(driver.b) {
            this.setSpeed(2525);
        }
    }
    public void setSpeed(int speed) {
        flywheelMotor.setVelocity(speed);
    }
}
