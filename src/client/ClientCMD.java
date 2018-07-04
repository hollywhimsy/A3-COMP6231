package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import centerManager.CenterManager;

public class ClientCMD
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// Call Create Teacher Record
		List<String> spec = new ArrayList<String>();
		spec.add("Math");
		spec.add("Computer");
		CenterManager mng = new CenterManager("CreateTRecord", "MTL0001", "Bob", "Azadi", "Garland", 123458886, spec);
		mng.start();

		// Call Create Student Record
		List<String> courses = new ArrayList<String>();
		courses.add("COEN");
		courses.add("Dist");
		Date date = new Date();
		date.getTime();
		CenterManager mng2 = new CenterManager("CreateSRecord", "LVL0001", "Alice", "Amani", courses, true, date);
		mng2.start();

		try
		{
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// Call Edit Record
		Date date2 = new Date();
		date2.getTime();
		date2.setDate(11);
		CenterManager mng3 = new CenterManager("EditRecord", "LVL0002", "SR00001", "statusDate", date2);
		mng3.start();

		// Call Get Records Count
		CenterManager mng4 = new CenterManager("MTL0001");
		System.out.println(mng4.callGetRecordsCount()); // This can be called by "run" as a thread too

		// Test if record exists
		CenterManager mng5 = new CenterManager("MTL0002");
		String id = "TR00001";
		if (mng5.callRecordExist(id))
			System.out.println("There is a record corresponding to ID: " + id);
		else
			System.out.println("There is NO record corresponding to ID: " + id);

		try
		{
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// Call transfer Record
		CenterManager mng6 = new CenterManager("TransferRecord", "MTL0001", "TR00001", "DDO");
		mng6.run(); // Also this can be called directly

		// Call Get Records again
		CenterManager mng7 = new CenterManager("DDO0001");
		System.out.println(mng7.callGetRecordsCount()); // This can be called by "run" as a thread too
	}
}