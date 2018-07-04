package client;

import java.util.Date;
import java.util.List;
import common.Infrastucture;
import common.Logger;
import ddoStub.RecordManagerDDOImplService;
import lvlStub.RecordManagerLVLImplService;
import mtlStub.RecordManagerMTLImplService;

public class ClientManager extends Thread
{
	private RecordManagerMTLImplService mtlCaller;
	private RecordManagerLVLImplService lvlCaller;
	private RecordManagerDDOImplService ddoCaller;
	private boolean isInitialized = true;
	private String managerId;
	private String city;
	private Logger logger;
	private Logger operationResultLogger;
	private String methodToCall;
	private String firstName;
	private String lastName;
	private String address;
	private Integer phoneNumber;
	private List<String> specilization;
	private List<String> coursesRegistred;
	private boolean status;
	private Date statusDate;
	private String recordId;
	private String fieldName;
	private Object newValue;
	private String remoteCenterServerName;

	// Constructor (default: no new thread)
	public ClientManager(String managerId)
	{
		this.managerId = managerId;
		initialize();
	}

	// Constructor1
	public ClientManager(String methodToCall, String managerId)
	{
		this.managerId = managerId;
		this.methodToCall = methodToCall;
		initialize();
	}

	// Constructor2
	public ClientManager(String methodToCall, String managerId, String firstName, String lastName, String address,
			Integer phoneNumber, List<String> specilization)
	{
		this.managerId = managerId;
		this.methodToCall = methodToCall;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.specilization = specilization;
		initialize();
	}

	// Constructor3
	public ClientManager(String methodToCall, String managerId, String firstName, String lastName,
			List<String> coursesRegistred, boolean status, Date statusDate)
	{
		this.managerId = managerId;
		this.methodToCall = methodToCall;
		this.firstName = firstName;
		this.lastName = lastName;
		this.coursesRegistred = coursesRegistred;
		this.status = status;
		this.statusDate = statusDate;
		initialize();
	}

	// Constructor4
	public ClientManager(String methodToCall, String managerId, String recordId, String fieldName, Object newValue)
	{
		this.managerId = managerId;
		this.methodToCall = methodToCall;
		this.fieldName = fieldName;
		this.newValue = newValue;
		this.recordId = recordId;
		initialize();
	}

	// Constructor5
	public ClientManager(String methodToCall, String managerId, String recordId, String remoteCenterServerName)
	{
		this.managerId = managerId;
		this.methodToCall = methodToCall;
		this.remoteCenterServerName = remoteCenterServerName;
		this.recordId = recordId;
		initialize();
	}

	// Thread Method
	public void run()
	{
		switch (methodToCall)
		{
		case "CreateTRecord":
			callCreateTRecord();
			break;
		case "CreateSRecord":
			callCreateSRecord();
			break;
		case "GetRecordsCount":
			callGetRecordsCount();
			break;
		case "EditRecord":
			callEditRecord();
			break;
		case "TransferRecord":
			callTransferRecord();
			break;
		default:
			logger.logToFile(managerId + "[ClientManager.run()] Error! Wrong Method name to call (" + methodToCall + ")");
			break;
		}
	}

	public boolean callCreateTRecord()
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callCreateTRecord()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callCreateTRecord()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return false;
		}

		String spec = "";
		String spliter = "";
		for (int i = 0; i < specilization.size(); i++)
		{
			// form the acceptable format by remote CORBA server
			spec = spec + spliter + specilization.get(i);
			spliter = ",";
		}
		String result = "";
		switch (city.toUpperCase())
		{
		case "MTL":
			result = mtlCaller.getRecordManagerMTLImpl().createTRecord(firstName, lastName, address, phoneNumber, spec, city, managerId);
			break;
		case "LVL":
			result = lvlCaller.getRecordManagerLVLImpl().createTRecord(firstName, lastName, address, phoneNumber, spec, city, managerId);
			break;
		case "DDO":
			result = ddoCaller.getRecordManagerDDOImpl().createTRecord(firstName, lastName, address, phoneNumber, spec, city, managerId);
			break;
		default:
			break;
		}

		if (result.toUpperCase().contains("SUCCESS"))
		{
			logger.logToFile(managerId + "[ClientManager.callCreateTRecord()] {Thread ID: " + this.getId()
					+ "}: Teacher record created" + " @@ Remote server report: " + result + " @@");
			operationResultLogger.logToFile(managerId + "[ClientManager.callCreateTRecord()] {Thread ID: "
					+ this.getId() + "}: Teacher record created" + " @@ Remote server report: " + result + " @@");
			return true;
		}

		logger.logToFile(managerId + "[ClientManager.callCreateTRecord()]: callCreateTRecord called on " + city
				+ " server and failed" + " @@ Remote server report: " + result + " @@");
		return false;
	}

	public boolean callCreateSRecord()
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callCreateSRecord()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callCreateSRecord()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return false;
		}

		String courses = "";
		String spliter = "";
		for (int i = 0; i < coursesRegistred.size(); i++)
		{
			// form the acceptable format by remote CORBA server
			courses = courses + spliter + coursesRegistred.get(i);
			spliter = ",";
		}

		String result = "";
		switch (city.toUpperCase())
		{
		case "MTL":
			result = mtlCaller.getRecordManagerMTLImpl().createSRecord(firstName, lastName, courses, status, statusDate.toString(), managerId);
			break;
		case "LVL":
			result = lvlCaller.getRecordManagerLVLImpl().createSRecord(firstName, lastName, courses, status, statusDate.toString(), managerId);
			break;
		case "DDO":
			result = ddoCaller.getRecordManagerDDOImpl().createSRecord(firstName, lastName, courses, status, statusDate.toString(), managerId);
			break;
		default:
			break;
		}

		if (result.toUpperCase().contains("SUCCESS"))
		{
			logger.logToFile(managerId + "[ClientManager.callCreateSRecord()]: callCreateSRecord called on " + city
					+ " server and performed successfully" + " @@ Remote server report: " + result + " @@");
			operationResultLogger.logToFile(managerId + "[ClientManager.callCreateSRecord()] {Thread ID: "
					+ this.getId() + "}: Student record created" + " @@ Remote server report: " + result + " @@");
			return true;
		}

		logger.logToFile(managerId + "[ClientManager.callCreateTRecord()]: callCreateSRecord called on " + city
				+ " server and failed" + " @@ Remote server report: " + result + " @@");
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean callEditRecord()
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callEditRecord()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callEditRecord()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return false;
		}

		String newVal;
		switch (fieldName)
		{
		case "coursesRegistred":
			newVal = "";
			String spliter = "";
			for (int i = 0; i < ((List<String>) newValue).size(); i++)
			{
				// form the acceptable format by remote CORBA server
				newVal = newVal + spliter + ((List<String>) newValue).get(i);
				spliter = ",";
			}
			break;
		case "status":
			if ((boolean) newValue)
				newVal = "true";
			else
				newVal = "false";
			break;
		case "statusDate":
			newVal = ((Date) newValue).toString();
			break;
		case "phoneNumber":
			newVal = ((Integer) newValue).toString();
			break;
		default:
			newVal = (String) newValue;
			break;
		}

		String result = "";
		switch (city.toUpperCase())
		{
		case "MTL":
			result = mtlCaller.getRecordManagerMTLImpl().editRecord(recordId, fieldName, newVal, managerId);
			break;
		case "LVL":
			result = lvlCaller.getRecordManagerLVLImpl().editRecord(recordId, fieldName, newVal, managerId);
			break;
		case "DDO":
			result = ddoCaller.getRecordManagerDDOImpl().editRecord(recordId, fieldName, newVal, managerId);
			break;
		default:
			break;
		}

		if (result.toUpperCase().contains("SUCCESS"))
		{
			logger.logToFile(managerId + "[ClientManager.callEditRecord()]: callEditRecord called on " + city
					+ " server and performed successfully" + " @@ Remote server report: " + result + " @@");
			operationResultLogger.logToFile(managerId + "[ClientManager.callEditRecord()] {Thread ID: "
					+ this.getId() + "}: Edit record performed successfully" + " @@ Remote server report: " + result + " @@");
			return true;
		}

		logger.logToFile(managerId + "[ClientManager.callEditRecord()]: callEditRecord called on " + city
				+ " server and failed" + " @@ Remote server report: " + result + " @@");
		return false;
	}

	public String callGetRecordsCount()
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callGetRecordCounts()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callGetRecordCounts()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return null;
		}

		String result = "";
		switch (city.toUpperCase())
		{
		case "MTL":
			result = mtlCaller.getRecordManagerMTLImpl().getRecordsCount(managerId);
			break;
		case "LVL":
			result = lvlCaller.getRecordManagerLVLImpl().getRecordsCount(managerId);
			break;
		case "DDO":
			result = ddoCaller.getRecordManagerDDOImpl().getRecordsCount(managerId);
			break;
		default:
			break;
		}

		if (result != null)
		{
			logger.logToFile(managerId + "[ClientManager.callGetRecordCounts()]: callGetRecordCounts called on "
					+ city + " server and performed successfully");
			operationResultLogger.logToFile(managerId + "[ClientManager.callGetRecordCounts()] {Thread ID: " + this.getId()
					+ "}: Records Count: " + result);
			return result;
		}

		logger.logToFile(managerId + "[ClientManager.callGetRecordCounts()]: callGetRecordCounts called on " + city
				+ " server and failed");
		return null;
	}

	public boolean callRecordExist(String recordId)
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callRecordExist()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callRecordExist()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return false;
		}

		switch (city.toUpperCase())
		{
		case "MTL":
			return mtlCaller.getRecordManagerMTLImpl().recordExist(recordId, managerId);
		case "LVL":
			return lvlCaller.getRecordManagerLVLImpl().recordExist(recordId, managerId);
		case "DDO":
			return ddoCaller.getRecordManagerDDOImpl().recordExist(recordId, managerId);
		default:
			return false;
		}
	}

	public boolean callTransferRecord()
	{
		if (!isInitialized)
		{
			logger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: " + this.getId()
					+ "}: Error! Initialization failed for the city: " + city);
			operationResultLogger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: "
					+ this.getId() + "}: Error! Initialization failed for the city: " + city);
			return false;
		}

		String result = "";
		switch (city.toUpperCase())
		{
		case "MTL":
			result = mtlCaller.getRecordManagerMTLImpl().transferRecord(managerId, recordId, remoteCenterServerName.toUpperCase().trim());
			break;
		case "LVL":
			result = lvlCaller.getRecordManagerLVLImpl().transferRecord(managerId, recordId, remoteCenterServerName.toUpperCase().trim());
			break;
		case "DDO":
			result = ddoCaller.getRecordManagerDDOImpl().transferRecord(managerId, recordId, remoteCenterServerName.toUpperCase().trim());
			break;
		default:
			break;
		}

		if (result.toUpperCase().contains("SUCCESS"))
		{
			logger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: " + this.getId()
					+ "}: Record is trasfered successfully" + " @@ Remote server report: " + result + " @@");
			operationResultLogger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: "
					+ this.getId() + "}: Record is trasfered successfully" + " @@ Remote server report: " + result + " @@");
			return true;
		}

		logger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: " + this.getId()
				+ "}: Record transferring failed" + " @@ Remote server report: " + result + " @@");
		operationResultLogger.logToFile(managerId + "[ClientManager.callTransferRecord()] {Thread ID: "
				+ this.getId() + "}: Record transferring failed" + " @@ Remote server report: " + result + " @@");

		return false;
	}

	private void initialize()
	{
		logger = new Logger("MNG_" + managerId.toUpperCase().trim() + ".log");
		operationResultLogger = new Logger("Result.log");

		if (isIdFormatCorrect(managerId))
		{
			city = managerId.substring(0, 3).toUpperCase();
		} else
		{
			logger.logToFile(city + "[ClientManager Constructor]: ERROR! Manager ID is not valid");
			isInitialized = false;
		}

		if (city.toUpperCase().equals("MTL"))
		{
			mtlCaller = new RecordManagerMTLImplService();
		}
		if (city.toUpperCase().equals("LVL"))
		{
			lvlCaller = new RecordManagerLVLImplService();
		}
		if (city.toUpperCase().equals("DDO"))
		{
			ddoCaller = new RecordManagerDDOImplService();
		}
	}

	private boolean isIdFormatCorrect(String id)
	{
		if (id == null)
		{
			return false;
		}

		if (id.length() != 7)
		{
			return false;
		}

		String srvName = id.substring(0, 3).toUpperCase();
		if (!Infrastucture.isSystemServerName(srvName))
		{
			return false;
		}

		if (!(id.substring(3, 4).chars().allMatch(Character::isDigit)))
		{
			return false;
		}

		return true;
	}

	public String getManagerId()
	{
		return managerId;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientManager other = (ClientManager) obj;
		if (managerId == null)
		{
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		return true;
	}
}