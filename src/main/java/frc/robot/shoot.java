package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class shoot extends SequentialCommandGroup {
  /** Creates a new shoot. */
  public shoot(NewShooter shooter, Indexer_Neo indexer, Spindexer_Kraken spindexer) {
    addCommands(
      new InstantCommand(()-> shooter.out(),shooter),
      new WaitUntilCommand(() -> shooter.isVelocityTarget()),
      new InstantCommand(()-> indexer.run(),indexer),
      new InstantCommand(()-> spindexer.run(),spindexer)     
    );
  }
}
