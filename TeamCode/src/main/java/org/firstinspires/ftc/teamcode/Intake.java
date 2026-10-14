package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intakeMotor;
    public Intake(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        //intakeMotor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void tick() {
        //#TODO: ADD TICK METHOD
    }
}
