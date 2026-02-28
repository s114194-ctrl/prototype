
package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;


import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.revrobotics.spark.SparkAbsoluteEncoder;


import java.util.HashMap;
import java.util.List;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicDutyCycle;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import frc.robot.ShooterConstants;


public class Shooter extends SubsystemBase {
  private final TalonFX bigFlyWheel = new TalonFX(ShooterConstants.BigFlyWheel_ID,ShooterConstants.Can);
  private final TalonFX smallFlyWheel = new TalonFX(ShooterConstants.SmallFlyWheel_ID,ShooterConstants.Can);
  private final SparkMax angle = new SparkMax(IndexerConstants.Indexer_Neo.Indexer_ID, MotorType.kBrushless);

  //private final SparkMax angleMotor = new SparkMax(ShooterConstants.angleMotor_ID, SparkLowLevel.MotorType.kBrushless);

  
  private TalonFXConfiguration bigflytwheelConfig = new TalonFXConfiguration();
  private TalonFXConfiguration smallflywheelConfig = new TalonFXConfiguration();
  private TalonFXConfiguration angleConfig = new TalonFXConfiguration();

  //private final SparkClosedLoopController anglePID = angleMotor.getClosedLoopController();

  //private final SparkMaxConfig conveyorConfig = new SparkMaxConfig();
  //private final SparkMaxConfig angleConfig = new SparkMaxConfig();


  //private SparkAbsoluteEncoder encoder;

  public WaitCommand timmer;
  public double smoothSpeed;
  public double targetSpeed = 0.8;
  //private double angle;
  public Pose2d TargetPose = new Pose2d();
  public static HashMap<Integer, List<Pose2d>> hubMap = new HashMap<>();
  

  public Shooter() {
  bigflytwheelConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  smallflywheelConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    


  bigflytwheelConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RotorSensor;
  smallflywheelConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RotorSensor;


  var bigFlyWheelConfigurator = bigFlyWheel.getConfigurator();
  var smallFlyWheelConfigurator = smallFlyWheel.getConfigurator();
   

  bigFlyWheelConfigurator.apply(bigflytwheelConfig);
  smallFlyWheelConfigurator.apply(smallflywheelConfig);


  bigFlyWheel.setNeutralMode(NeutralModeValue.Brake);
  smallFlyWheel.setNeutralMode(NeutralModeValue.Brake);


  bigFlyWheelConfigurator
  .apply(new MotionMagicConfigs().withMotionMagicAcceleration(ShooterConstants.ShooterB_MAX_ACCEL)
  .withMotionMagicCruiseVelocity(ShooterConstants.ShooterB_MAX_VELOCITY));

  smallFlyWheelConfigurator
  .apply(new MotionMagicConfigs().withMotionMagicAcceleration(ShooterConstants.ShooterS_MAX_ACCEL)
  .withMotionMagicCruiseVelocity(ShooterConstants.ShooterS_MAX_VELOCITY));



  Slot0Configs BFW_Out_PIDConfig = new Slot0Configs();
  BFW_Out_PIDConfig.kP = ShooterConstants.ShooterB_Out_P;
  BFW_Out_PIDConfig.kI = ShooterConstants.ShooterB_Out_I;
  BFW_Out_PIDConfig.kD = ShooterConstants.ShooterB_Out_D;
  BFW_Out_PIDConfig.kV = ShooterConstants.ShooterB_Out_F;
  bigFlyWheelConfigurator.apply(BFW_Out_PIDConfig);


  bigFlyWheel.setPosition(0);
  smallFlyWheel.setPosition(0);

  smallFlyWheel.setControl(new Follower(bigFlyWheel.getDeviceID(), MotorAlignmentValue.Opposed));

  }



  public void out() {
    System.out.println("88888888888");
     bigFlyWheel.setControl(new MotionMagicVelocityVoltage(ShooterConstants.BigFlyWheel).withSlot(0));
     
  }

  public void stopFlyWheels() {
    bigFlyWheel.stopMotor();

  }

  public void angleup(){
    angle.set(0.5);
  }

  public void angledown(){
    angle.set(-0.5);
  }



}