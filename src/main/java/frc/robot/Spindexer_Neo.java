// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Spindexer_Neo extends SubsystemBase {
  private final SparkMax spindexerNeo = new SparkMax(SpindexerConstants.Spindexer_Neo.Spindexer_ID, MotorType.kBrushless); 
  private final SparkMaxConfig spindexerConfig = new SparkMaxConfig();
  private final SparkClosedLoopController spindexerCLoopController = spindexerNeo.getClosedLoopController();
  /** Creates a new Indexer. */
  public Spindexer_Neo() {
    spindexerConfig.smartCurrentLimit(30)
                   .idleMode(IdleMode.kBrake);

    spindexerConfig.closedLoop
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        .pid(SpindexerConstants.Spindexer_Neo.Run_P,
             SpindexerConstants.Spindexer_Neo.Run_I, 
             SpindexerConstants.Spindexer_Neo.Run_D, 
             ClosedLoopSlot.kSlot0)
        .maxMotion.allowedProfileError(0.05, ClosedLoopSlot.kSlot0);

    spindexerConfig.closedLoop.feedForward
        .kV(SpindexerConstants.Spindexer_Neo.Run_F, ClosedLoopSlot.kSlot0);

    spindexerNeo.configure(spindexerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void run () {
    // spindexerCLoopController.setSetpoint(SpindexerConstants.Spindexer_Neo.RPM, ControlType.kCurrent,
    //     ClosedLoopSlot.kSlot0);
    spindexerNeo.set(0.8);

  }
  public void stop(){
    spindexerNeo.stopMotor();
  }
}
