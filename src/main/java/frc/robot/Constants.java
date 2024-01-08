// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int DRIVER1CONTROLLERPORT = 0;
    public static final int MOTORCONTROLPORT1 = 1;
    public static final int MOTORCONTROLPORT2 = 2;
    public static final int MOTORCONTROLPORT3 = 3;
    public static final int MOTORCONTROLPORT4 = 4;
    public static final int MOTORCONTROLPORT5 = 5;
    public static final int MOTORCONTROLPORT6 = 6;
    public static final int MOTORCONTROLPORT7 = 7;
    public static final int MOTORCONTROLPORT8 = 8;
    public static final int RIGHTFLYWHEEL = 9;
    public static final int LEFTFLYWHEEL = 10;
  }
  public static class DriveConstants {
    public static final double ACCELERATION_CONSTANT = 0.04  ;
  }
  public static class InputConstants {
    public static final int ENCODERDIO1 = 9;
    public static final int ENCODERDIO2 = 10;
  }

  public static class PCMConstants{
    public static final int LEFTINPUTPORT = 0;
    public static final int RIGHTINPUTPORT = 1;
    public static final int LEFTOUTPUTPORT = 2;
    public static final int RIGHTOUTPUTPORT= 3;
  }
}
