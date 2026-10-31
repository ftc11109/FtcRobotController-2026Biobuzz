package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intakeMotor;
    Gamepad gamepad;
    public Intake(HardwareMap hardwareMap, Gamepad gamepad) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        this.gamepad = gamepad;
        //intakeMotor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void tick() {
        //#TODO: ADD TICK METHOD
        if(this.gamepad.right_bumper) {
            intakeMotor.setPower(-1);
        }
        else if(this.gamepad.right_trigger_pressed) {
            intakeMotor.setPower(1);
        }
        else {
            intakeMotor.setPower(0);
        }
    }
}
