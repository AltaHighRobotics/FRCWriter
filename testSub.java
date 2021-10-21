// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class testSub extends SubsystemBase { 
    /**  Creates a new testSub. */ 
    private TalonFX test0;

    public testSub() { 
        TalonFX test0 = new TalonFX(Constants.TEST0); 
        test0.setNeutralMode(NeutralMode.Coast); 
    } 

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void testOn() { 
        test0.set(ControlMode.PercentOutput, Constants.TEST_ON_SPEED); 
    } 

    public void testOff() { 
        test0.set(ControlMode.PercentOutput, Constants.TEST_OFF_SPEED); 
    } 
}