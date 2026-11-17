// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

/** Simple auto creation */
public class AutoBuilder {
    public static class AutoPart {
        public final String kType = "";
        public double kDuration = 0.0;

        private AutoPart () {
        }
    }
    public static class AutoPartDrive extends AutoPart {
        public final String kType = "drive";
        public double kDuration = 0.0;

        public double kSpeedLeft = 0.0;
        public double kSpeedRight = 0.0;

        public AutoPartDrive (double speedLeft, double speedRight, double duration) {
            kSpeedLeft = speedLeft;
            kSpeedRight = speedRight;
            kDuration = duration;
        }
    }
    public static class AutoPartArm extends AutoPart {
        public final String kType = "arm";
        public double kDuration = 0.0;

        public double kSpeed = 0.0;

        public AutoPartArm (double speed, double duration) {
            kSpeed = speed;
            kDuration = duration;
        }
    }

    private AutoPart[] m_parts = null;
    public AutoBuilder (AutoPart... parts) { m_parts = parts; }
    public AutoPart[] getParts () { return m_parts; }
}
