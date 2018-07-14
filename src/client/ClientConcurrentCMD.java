package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import centerManager.CenterManager;

public class ClientConcurrentCMD
{

	public static void main(String[] args)
	{
		for (int i = 0; i < 20; i++)
		{
			// Call Create Teacher Record
			List<String> spec = new ArrayList<String>();
			spec.add("Math");
			spec.add("Computer");
			CenterManager mng = new CenterManager("CreateTRecord", "MTL0001", "Bob", "Azadi", "Garland", 123458886, spec);
			mng.start();
			CenterManager mng2 = new CenterManager("CreateTRecord", "LVL0001", "Bob", "Azadi", "Garland", 123458886, spec);
			mng2.start();
			CenterManager mng3 = new CenterManager("CreateTRecord", "DDO0001", "Bob", "Azadi", "Garland", 123458886, spec);
			mng3.start();

			// Call Create Student Record
			List<String> courses = new ArrayList<String>();
			courses.add("COEN");
			courses.add("Dist");
			Date date = new Date();
			date.getTime();
			CenterManager mng4 = new CenterManager("CreateSRecord", "MTL0002", "Alice", "Amani", courses, true, date);
			mng4.start();
			CenterManager mng5 = new CenterManager("CreateSRecord", "LVL0002", "Alice", "Amani", courses, true, date);
			mng5.start();
			CenterManager mng6 = new CenterManager("CreateSRecord", "DDO0002", "Alice", "Amani", courses, true, date);
			mng6.start();
		}	
		
		for (int i = 1; i <= 20; i++)
		{
			// You can indicate the records ID range by assigning a value to "startId", e.g.:
			// 0 => start transferring and editing from the record TR00001
			// 10 => start transferring and editing from the record TR00011
			int startId = 0; 
			
			int idIndex = i + startId;
			String id = "TR" + String.format("%05d", idIndex);
			CenterManager mng8 = new CenterManager("TransferRecord", "MTL0006", id, "LVL");		
			mng8.start(); // Start transferring the record
			
			Random rand = new Random();
			int  num = rand.nextInt(500);
			try
			{
				TimeUnit.MICROSECONDS.sleep(num); // Wait in a random manner for 0 to 500 Microsecond
			} catch (InterruptedException e)
			{			
				e.printStackTrace();
			}
			
			CenterManager mng7 = new CenterManager("EditRecord", "MTL0006", id, "address", "st. Catrine");
			mng7.start(); // Try to edit the record, if it's not transferred yet
		}
		
		for (int i = 1; i <= 20; i++)
		{
			// You can indicate the records ID range by assigning a value to "startId", e.g.:
			// 0 => start transferring and editing from the record TR00001
			// 10 => start transferring and editing from the record TR00011
			int startId = 0; 
			
			int idIndex = i + startId;
			String id = "SR" + String.format("%05d", idIndex);
			CenterManager mng9 = new CenterManager("TransferRecord", "DDO0006", id, "LVL");		
			mng9.start(); // Start transferring the record
			
			Random rand = new Random();
			int  num = rand.nextInt(500);
			try
			{
				TimeUnit.MICROSECONDS.sleep(num); // Wait in a random manner for 0 to 500 Microsecond
			} catch (InterruptedException e)
			{			
				e.printStackTrace();
			}
			
			CenterManager mng10 = new CenterManager("EditRecord", "DDO0006", id, "status", false);
			mng10.start(); // Try to edit the record, if it's not transferred yet
		}

		try
		{
			TimeUnit.MILLISECONDS.sleep(500); // Wait to make sure that all previous jobs are done
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		CenterManager mng9 = new CenterManager("MTL0001");
		System.out.println(mng9.callGetRecordsCount()); // Call Get Records Count to make sure that all records are transferred

	}
}