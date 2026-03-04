// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SoftLimitConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;






public class AngleShooter extends SubsystemBase {
  private final TalonFX bigFlyWheel = new TalonFX(NewShooterConstants.BigFlyWheel.bigFlyWheel_ID,NewShooterConstants.Can);
  private final TalonFX smallFlyWheel = new TalonFX(NewShooterConstants.SmallFlyWheel.smallFlyWheel_ID,NewShooterConstants.Can);
  private final SparkMax angle = new SparkMax(NewShooterConstants.Angle.Angle_ID, MotorType.kBrushless);
  private final SparkMaxConfig angleConfig = new SparkMaxConfig();
  private final SparkClosedLoopController anglectrl = angle.getClosedLoopController();


  public AngleShooter() {
    angle.getAbsoluteEncoder();
    angleConfig.closedLoop
        .feedbackSensor(FeedbackSensor.kAbsoluteEncoder)
        .pid(NewShooterConstants.Angle.Run_P,
             NewShooterConstants.Angle.Run_I, 
             NewShooterConstants.Angle.Run_D, 
             ClosedLoopSlot.kSlot0)
        .maxMotion.allowedProfileError(1, ClosedLoopSlot.kSlot0);

    angleConfig.closedLoop.feedForward
        .kV(NewShooterConstants.Angle.Run_F, ClosedLoopSlot.kSlot0);

    
    angleConfig.closedLoop.maxMotion.maxAcceleration(NewShooterConstants.Angle.maxAcceleration, ClosedLoopSlot.kSlot0)
                                      .cruiseVelocity(NewShooterConstants.Angle.cruiseVelocity, ClosedLoopSlot.kSlot0);
                                      
    angleConfig.inverted(false).apply(new SoftLimitConfig().forwardSoftLimit(3).reverseSoftLimit(0)
    .forwardSoftLimitEnabled(true).reverseSoftLimitEnabled(true));
    angleConfig.absoluteEncoder.zeroOffset(0.3316887).inverted(false).setSparkMaxDataPortConfig().positionConversionFactor(1);
 
    angle.configure(angleConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);



  bigFlyWheel.setPosition(0);
  smallFlyWheel.setPosition(0);
  

  smallFlyWheel.setControl(new Follower(bigFlyWheel.getDeviceID(), MotorAlignmentValue.Opposed));

  bigFlyWheel.getConfigurator().apply(NewShooterConstants.BigFlyWheel.bigflywheelConfiguration);
  
  }

  @Override
  public void periodic() {
      // TODO Auto-generated method stub
      super.periodic();
      SmartDashboard.putNumber("Current Velocity", bigFlyWheel.getVelocity().getValueAsDouble());

    }


  public void out() {
    bigFlyWheel.setControl(new VelocityVoltage(NewShooterConstants.BigFlyWheel.bigFlyWheel).withSlot(0));
  
  }
  // public void stopFlyWheels1() {
  //   bigFlyWheel.setControl(new MotionMagicVelocityVoltage())
  // }

  public void stopFlyWheels() {
    bigFlyWheel.stopMotor();
  }

  public void angleup(){
    angle.set(0.1);
  }

  public void angledown(){
    angle.set(-0.1);
  }
  

  public void anglestop(){
    angle.stopMotor();
  }

  public void angleout(){
      anglectrl.setSetpoint(3, ControlType.kPosition, ClosedLoopSlot.kSlot0);
    System.out.println(angle.getAbsoluteEncoder().getPosition());
  
  }

  public void anglein(){
       anglectrl.setSetpoint(0, ControlType.kPosition, ClosedLoopSlot.kSlot0);
  }
}