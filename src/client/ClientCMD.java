package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClientCMD
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// Call Create Teacher Record
		List<String> spec = new ArrayList<String>();
		spec.add("Math");
		spec.add("Computer");
		ClientManager mng = new ClientManager("CreateTRecord", "MTL0001", "Bob", "Azadi", "Garland", 123458886, spec);
		mng.start();

		// Call Create Student Record
		List<String> courses = new ArrayList<String>();
		courses.add("COEN");
		courses.add("Dist");
		Date date = new Date();
		date.getTime();
		ClientManager mng2 = new ClientManager("CreateSRecord", "LVL0001", "Alice", "Amani", courses, true, date);
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
		ClientManager mng3 = new ClientManager("EditRecord", "LVL0002", "SR00001", "statusDate", date2);
		mng3.start();

		// Call Get Records Count
		ClientManager mng4 = new ClientManager("MTL0001");
		System.out.println(mng4.callGetRecordsCount()); // This can be called by "run" as a thread too

		// Test if record exists
		ClientManager mng5 = new ClientManager("MTL0002");
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
		ClientManager mng6 = new ClientManager("TransferRecord", "MTL0001", "TR00001", "DDO");
		mng6.run(); // Also this can be called directly

		// Call Get Records again
		ClientManager mng7 = new ClientManager("DDO0001");
		System.out.println(mng7.callGetRecordsCount()); // This can be called by "run" as a thread too
	}
}