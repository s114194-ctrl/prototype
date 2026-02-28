// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class SpindexerConstants  {
  public static final CANBus Can = new CANBus("1");

  public static final class Spindexer_Karken {
    public static final int Spindexer_ID = 10;
    public static double run = 60;//rps
    public static final TalonFXConfiguration SpindexerConfiguration = new TalonFXConfiguration()
        .withSlot0(new Slot0Configs() .withKP(0.2).withKI(0).withKD(0)
        .withKS(0.1).withKV(0.12).withKA(0).withStaticFeedforwardSign(StaticFeedforwardSignValue.UseClosedLoopSign))
        // .withMotorOutput(new MotorOutputConfigs().withNeutralMode(NeutralModeValue.Brake)
        // .withInverted(InvertedValue.Clockwise_Positive))
        .withMotionMagic(new MotionMagicConfigs().withMotionMagicAcceleration(1600).withMotionMagicCruiseVelocity(400)
        .withMotionMagicJerk(5));

  }
  public static final class  Spindexer_Neo {
    public static final int Spindexer_ID = 12;
    public static double RPM = 110;

      
    public static final double Run_P = 0.1;
    public static final double Run_I = 0;
    public static final double Run_D = 0.001;
    public static final double Run_F = 0;

    public static final double Max_Output = 1;//最大輸出
    public static final double Min_Output = -1;//最小輸出

    public static final double maxAcceleration = 2000;
    public static final double cruiseVelocity = 1000;
    public static final double allowedProfileError = 5;
  }


 

 
}
