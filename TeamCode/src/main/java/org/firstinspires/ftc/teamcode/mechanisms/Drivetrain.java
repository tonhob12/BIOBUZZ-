package org.firstinspires.ftc.teamcode.mechanisms;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Drivetrain implements Mechanism {

    public Drivetrain(){
        frontRight.setDirection(NextMotor.Direction.REVERSE);
        backRight.setDirection(NextMotor.Direction.REVERSE);
        backLeft.setDirection(NextMotor.Direction.FORWARD);
        frontLeft.setDirection(NextMotor.Direction.FORWARD);
    }
    public final NextMotor frontLeft = new NextMotor(RobotController.controlHub(), 0);
    public final NextMotor frontRight = new NextMotor(RobotController.controlHub(), 2);
    public final NextMotor backLeft = new NextMotor(RobotController.controlHub(), 1);
    public final NextMotor backRight =  new NextMotor(RobotController.controlHub(), 3);




}