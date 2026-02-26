
package frc.robot;

import static edu.wpi.first.units.Units.*;




import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


//import com.pathplanner.lib.path.PathPlannerPath;
import frc.robot.Shooter;
// import frc.robot.Shootin;
// import frc.robot.Shootout;


public class RobotContainer {
 
    // private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 最大角速

    // /* Setting up bindings for necessary control of the swerve drive platform */
    // private final SwerveRequest.RobotCentric drive = new SwerveRequest.RobotCentric()
    //         .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% 死區(搖桿靈敏度下降)
    //         .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors(開放迴圈控制)
    // private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();//(X行煞車)內八
    // private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();//方向控制


    private final CommandXboxController joystick = new CommandXboxController(0);
   // private final CommandXboxController joystick2 = new CommandXboxController(1);

    private final Shooter shooter = new Shooter();
    //private final NewShooter shooter = new NewShooter();

    private final Indexer_Neo indexer_Neo = new Indexer_Neo();
    private final Spindexer_Neo spindexer_Neo = new Spindexer_Neo();
    // private final Shootin shootin = new Shootin(shooter, indexer_Neo);
    // private final Shootout shootout = new Shootout(shooter, indexer_Neo);
    

    private SendableChooser<Command> autoChooser;


    public RobotContainer() {
    configureBindings();
    }

    private void configureBindings() {
            joystick.x().whileTrue(new InstantCommand(shooter::Shooter_Out))
            .onFalse(new InstantCommand(shooter::stopFlyWheels));
            


            joystick.y().whileTrue((new InstantCommand(indexer_Neo::run)))
            .onFalse((new InstantCommand(indexer_Neo::stop)));

            joystick.a().whileTrue((new InstantCommand(spindexer_Neo::run)))
            .onFalse((new InstantCommand(spindexer_Neo::stop)));

            //     joystick2.a().whileTrue(deploy);
        
            //     // intake按鍵
            //     joystick2.y().whileTrue(intakeout).onFalse(intakeback);

            //     shooter.angle(joystick2.getLeftY()*0.3);

                
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
       
    

        // Idle while the robot is disabled. This ensures the configured
        // neutral mode is applied to the drive motors while disabled.
       
        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
      
    }

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }

}
