package org.usfirst.frc.team747.robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class PIDDriveRotateWithVisionP2 {
	@SuppressWarnings("deprecation")
	static NetworkTable table = NetworkTable.getTable("limelight");
	static double tv;
	static double tx;

	
	@SuppressWarnings("deprecation")
	public static void searchForCube() throws InterruptedException {
		tv = table.getNumber("tv", 0);
		tx = table.getNumber("tx", 0);
		
	
		if (tv == 0) {
			new PIDDriveRotateCommand(27);
			TimeUnit.MILLISECONDS.sleep(750);
		} else if(tv == 1) {
			if(!(tv <= 14 && tv >= -14)) {
				new PIDDriveRotateCommand(tx);
			}
			System.out.println("Done! Aligned with cube");
		}
		
		
		
	}
}