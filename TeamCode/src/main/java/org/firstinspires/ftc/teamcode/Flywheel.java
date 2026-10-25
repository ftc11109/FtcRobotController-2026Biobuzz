package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Flywheel {
    DcMotorEx flywheelMotor;
    //#TODO: REQUIRE CAMERA PASSED IN FOR TARGETING
    public Flywheel(HardwareMap hardwareMap) {
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "flywheel_motor");
        //flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        PIDFCoefficients pidf = new PIDFCoefficients(20, 3, 5, 0);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, pidf);
    }
    public void tick() {
        //#TODO: ADD TICK METHOD
    }
    public void setSpeed(int speed) {
        flywheelMotor.setVelocity(speed);
    }
}
