package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Breno1 extends OpMode {

    DcMotor fe, fd, td, te;
    Servo s1, s2, s3, s4, s5;

    //-----------

    double AzulFE;
    double AzulTD;
    double VermelhoTE;
    double VermelhoFD;

    //----------------
    @Override
    public void init() {

        /*definir*/
        fd = hardwareMap.get(DcMotor.class, "FD");
        fe = hardwareMap.get(DcMotor.class, "FE");
        te = hardwareMap.get(DcMotor.class, "TE");
        td = hardwareMap.get(DcMotor.class, "TD");

        /*-----*/
        s1 = hardwareMap.get(Servo.class, "S1");
        s2 = hardwareMap.get(Servo.class, "S2");
        s3 = hardwareMap.get(Servo.class, "S3");
        s4 = hardwareMap.get(Servo.class, "S4");
        s5 = hardwareMap.get(Servo.class, "S5");
        /*reverso*/
        fe.setDirection(DcMotorSimple.Direction.REVERSE);
        te.setDirection(DcMotorSimple.Direction.REVERSE);
    }

