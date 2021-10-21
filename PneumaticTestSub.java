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
import edu.wpi.first.wpilibj.Solenoid;


public class PneumaticTestSub extends SubsystemBase { 
    /**  Creates a new PneumaticTestSub. */ 
    private Final Solenoid PneumaticTest0;

    public PneumaticTestSub() { 
        PneumaticTest0 = new Solenoid(Constants.PNEUMATICTEST0); 
    } 

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void PneumaticTestOn() { 
        PneumaticTest0.set(true); 
    } 

    public void PneumaticTestOff() { 
        PneumaticTest0.set(false); 
    } 
}