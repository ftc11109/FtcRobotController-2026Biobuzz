package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intakeMotor;
    Gamepad driver;
    public Intake(HardwareMap hardwareMap, Gamepad gamepad) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        driver = gamepad;
    }
    public void tick() {
        if(driver.right_bumper) {
            intakeMotor.setPower(-1);
        }
        else if(driver.right_trigger_pressed) {
            intakeMotor.setPower(1);
        }
        else {
            intakeMotor.setPower(0);
        }
    }
}
