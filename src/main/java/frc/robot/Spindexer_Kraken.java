// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Spindexer_Kraken extends SubsystemBase {
  private final TalonFX spindexerKraken = new TalonFX(SpindexerConstants.Spindexer_Karken.Spindexer_ID, SpindexerConstants.Can);
  /** Creates a new Indexer_Kraken. */
  public Spindexer_Kraken() {
    spindexerKraken.getConfigurator().apply(SpindexerConstants.Spindexer_Karken.SpindexerConfiguration);
  }

  public void run(){
    spindexerKraken.setControl(new MotionMagicVelocityVoltage(SpindexerConstants.Spindexer_Karken.run).withSlot(0));
  }
  public void stop (){
    spindexerKraken.stopMotor();
  }
}
