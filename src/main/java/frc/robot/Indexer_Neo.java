// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DutyCycle;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer_Neo extends SubsystemBase {
  private final SparkMax indexerNeo = new SparkMax(IndexerConstants.Indexer_Neo.Indexer_ID, MotorType.kBrushless);
  private final SparkMaxConfig indexerConfig = new SparkMaxConfig();
  private final SparkClosedLoopController indexerCloseloop = indexerNeo.getClosedLoopController();

  /** Creates a new Indexer_Neo. */
  public Indexer_Neo() {
    indexerConfig.closedLoop
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        .pid(IndexerConstants.Indexer_Neo.Run_P,
             IndexerConstants.Indexer_Neo.Run_I, 
             IndexerConstants.Indexer_Neo.Run_D, 
             ClosedLoopSlot.kSlot0)
        .maxMotion.allowedProfileError(0.05, ClosedLoopSlot.kSlot0);

    indexerConfig.closedLoop.feedForward
        .kV(IndexerConstants.Indexer_Neo.Run_F, ClosedLoopSlot.kSlot0);

    
    indexerConfig.closedLoop.maxMotion.maxAcceleration(IndexerConstants.Indexer_Neo.maxAcceleration)
                                      .cruiseVelocity(IndexerConstants.Indexer_Neo.cruiseVelocity)
                                      .allowedProfileError(IndexerConstants.Indexer_Neo.allowedProfileError, ClosedLoopSlot.kSlot0);

    indexerNeo.configure(indexerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void run() {
    // indexerCloseloop.setSetpoint(IndexerConstants.Indexer_Neo.RPM, ControlType.kCurrent,
    //     ClosedLoopSlot.kSlot0);
    indexerNeo.set(-0.7);
  }

  public void stop() {
    indexerNeo.stopMotor();
  }

}
