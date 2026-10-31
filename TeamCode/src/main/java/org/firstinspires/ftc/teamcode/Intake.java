package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intakeMotor;
    Gamepad driver;
    Gamepad copilot;
    public Intake(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        driver = gamepad1;
        copilot = gamepad2;
    }
    public void tick() {
        if(driver.right_trigger_pressed || copilot.right_trigger_pressed) {
            intakeMotor.setPower(1);
        }
        else if(driver.right_bumper || copilot.right_bumper) {
            intakeMotor.setPower(-1);
        }

        else {
            intakeMotor.setPower(0);
        }
    }
}
