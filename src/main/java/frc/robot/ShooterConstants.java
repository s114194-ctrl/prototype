package frc.robot;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;


/** Add your docs here. */
public class ShooterConstants {

    public static final CANBus Can = new CANBus("888");
    public static final int BigFlyWheel_ID = 1;
    public static final int SmallFlyWheel_ID = 2;
    public static final int angleMotor_ID = 4;

    public static final boolean BigFlyWheel_Inverted = false;
    public static final boolean SmallFlyWheel_Inverted = false;
    public static final boolean superneo_Inverted = false;

     public static double BigFlyWheel = -80;//rps
    
        public static final double ShooterB_Out = 0.65;
        public static final double ShooterS_Out = 0.65;
        public static final double ShooterB_Back = 0;
        public static final double ShooterS_Back = 0;

        // Shooter BigFlyWheel PIDF
        public static final double ShooterB_Out_P = 0.1;
        public static final double ShooterB_Out_I = 0;
        public static final double ShooterB_Out_D = 0.001;
        public static final double ShooterB_Out_F = 0;

        public static final double ShooterB_MAX_ACCEL = 100;
        public static final double ShooterB_MAX_VELOCITY = 50;

        public static final double ShooterS_MAX_ACCEL = 100;
        public static final double ShooterS_MAX_VELOCITY = 50;


        public static class  angle {
        public static final int angleMotor_ID = 1;
        public static double RPM = 115;

      
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