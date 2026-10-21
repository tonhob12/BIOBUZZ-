package org.firstinspires.ftc.teamcode.teleop;


import static com.pedropathing.ivy.commands.Commands.instant;

import static org.firstinspires.ftc.teamcode.robot.pinguim.follower;
import static org.firstinspires.ftc.teamcode.robot.pinguim.initFollower;
import static dev.nextftc.units.Units.RotationsPerMinute;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.ivy.commands.Commands;

import org.firstinspires.ftc.teamcode.robot.pinguim;


import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@NextTeleop(name = "Teleop")
public class teleopteste extends NextOpMode {
    private final pinguim Pinguim;

    public teleopteste(pinguim Pinguim) {
        super(Pinguim);
        this.Pinguim = Pinguim;

        Scheduler.reset();
    }

    @Override
    public void start() {
        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);
        Commands.infinite(() ->
                DriveCommands.setScalar(
                        0.3 + (gp1.rightTrigger().getValue() * 0.7)
                )
        ).schedule();

        pinguim.init().schedule();

        pinguim.initFollower(hardwareMap);

        pinguim.follower.setPose(
                PoseFactory.degrees().of(133, 9, 90)
        );
        pinguim.startDrive(gamepad1);
    }

    @Override
    public void periodic() {
        follower.update();
        telemetry.addData("Heading Pedro", follower.pose().heading());
        telemetry.addData("Heading graus",
                Math.toDegrees(follower.pose().heading()));
        telemetry.update();
    }

    @Override
    public void end() {
    }
}