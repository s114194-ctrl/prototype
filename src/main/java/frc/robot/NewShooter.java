
// package frc.robot;

// import edu.wpi.first.math.geometry.Pose2d;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import java.util.HashMap;
// import java.util.List;

// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import com.revrobotics.spark.ClosedLoopSlot;
// import com.revrobotics.spark.FeedbackSensor;
// import com.revrobotics.spark.SparkLowLevel.MotorType;

// import com.revrobotics.PersistMode;
// import com.revrobotics.ResetMode;

// import com.ctre.phoenix6.controls.Follower;
// import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
// import com.ctre.phoenix6.controls.VelocityVoltage;
// import com.ctre.phoenix6.hardware.TalonFX;

// import com.ctre.phoenix6.signals.MotorAlignmentValue;






// public class NewShooter extends SubsystemBase {
//   private final TalonFX bigFlyWheel = new TalonFX(NewShooterConstants.BigFlyWheel.bigFlyWheel_ID,NewShooterConstants.Can);
//   private final TalonFX smallFlyWheel = new TalonFX(NewShooterConstants.SmallFlyWheel.smallFlyWheel_ID,NewShooterConstants.Can);
//   //private final SparkMax angle = new SparkMax(NewShooterConstants.Angle.Angle_ID, MotorType.kBrushless);
//   private final SparkMaxConfig angleConfig = new SparkMaxConfig();

//   public NewShooter() {
//     angleConfig.closedLoop
//         .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
//         .pid(NewShooterConstants.Angle.Run_P,
//              NewShooterConstants.Angle.Run_I, 
//              NewShooterConstants.Angle.Run_D, 
//              ClosedLoopSlot.kSlot0)
//         .maxMotion.allowedProfileError(0.05, ClosedLoopSlot.kSlot0);

//     angleConfig.closedLoop.feedForward
//         .kV(NewShooterConstants.Angle.Run_F, ClosedLoopSlot.kSlot0);

    
//     angleConfig.closedLoop.maxMotion.maxAcceleration(NewShooterConstants.Angle.maxAcceleration)
//                                       .cruiseVelocity(NewShooterConstants.Angle.cruiseVelocity)
//                                       .allowedProfileError(NewShooterConstants.Angle.allowedProfileError, ClosedLoopSlot.kSlot0);

//     //angle.configure(angleConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


//   bigFlyWheel.setPosition(0);
//   smallFlyWheel.setPosition(0);

//   smallFlyWheel.setControl(new Follower(bigFlyWheel.getDeviceID(), MotorAlignmentValue.Opposed));

//   bigFlyWheel.getConfigurator().apply(NewShooterConstants.BigFlyWheel.bigflywheelConfiguration);
  
//   }


//   public void out() {
//     bigFlyWheel.setControl(new MotionMagicVelocityVoltage(NewShooterConstants.BigFlyWheel.bigFlyWheel).withSlot(0));
  
//   }

//   public void stopFlyWheels() {
//     bigFlyWheel.stopMotor();
//   }

//   public void angleup(){
//     //angle.set(0.5);
//   }

//   public void angledown(){
//     //angle.set(-0.5);
//   }

// }