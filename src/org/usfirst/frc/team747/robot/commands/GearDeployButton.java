package org.usfirst.frc.team747.robot.commands;

import org.usfirst.frc.team747.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;

public class GearDeployButton extends Button{

    @Override
    public boolean get() {
        return OI.getGearDeployButton();
    }
}
