package org.firstinspires.ftc.teamcode.robot;

import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.commands.Commands.waitUntil;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import dev.nextftc.control.drive.DriveInput;
import dev.nextftc.control.drive.MecanumKinematics;
import dev.nextftc.control.drive.MecanumWheelPowers;
import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.pinpoint;

import java.util.Set;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.robot.drive.DriveCommands;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class pinguim implements NextRobot {
    public static Follower follower;

    //    private final Vision vision = new Vision();
    private static final Drivetrain drivetrain = new Drivetrain();
    public pinguim(){}


//    public Vision getVision() {
//        return vision;
//    }
    public static void initFollower(HardwareMap hardwareMap) {
        follower = Constants.create(hardwareMap);
    }
    public static void startDrive(Gamepad gamepad1) {
        DriveCommands.mecanumDriveFieldCentric(
                drivetrain.frontLeft,
                drivetrain.frontRight,
                drivetrain.backLeft,
                drivetrain.backRight,
                gamepad1,
                () -> follower.pose().heading()
        ).schedule();
    }

    public static Command init(){
        return parallel(
        );
    }

    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(drivetrain);
    }

}