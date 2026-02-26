package frc.robot;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;


/** Add your docs here. */
public class NewShooterConstants {
    public static final CANBus Can = new CANBus("888");

    public static final int angleMotor_ID = 4;

    public static final boolean superneo_Inverted = false;

    public static class BigFlyWheel{

        public static final int bigFlyWheel_ID = 1;
        public static final boolean bigFlyWheel_Inverted = false;
        public static double bigFlyWheel = -100;//rps

        public static final TalonFXConfiguration bigflywheelConfiguration = new TalonFXConfiguration()
        .withSlot0(new Slot0Configs().withKP(0.2).withKI(0).withKD(0.5)
        .withKS(0.1).withKV(0.12).withKA(0).withStaticFeedforwardSign(StaticFeedforwardSignValue.UseClosedLoopSign));
    }

    public static class SmallFlyWheel{
        public static final int smallFlyWheel_ID = 2;
        public static final boolean smallFlyWheel_Inverted = false;
    }

}