
package mtlStub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RemoteCenterServerMTLImpl", targetNamespace = "http://centerServers")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RemoteCenterServerMTLImpl {


    /**
     * 
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param specialization
     * @param location
     * @param managerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "createTRecordReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "createTRecord", targetNamespace = "http://centerServers", className = "mtlStub.CreateTRecord")
    @ResponseWrapper(localName = "createTRecordResponse", targetNamespace = "http://centerServers", className = "mtlStub.CreateTRecordResponse")
    public String createTRecord(
        @WebParam(name = "firstName", targetNamespace = "http://centerServers")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "http://centerServers")
        String lastName,
        @WebParam(name = "address", targetNamespace = "http://centerServers")
        String address,
        @WebParam(name = "phoneNumber", targetNamespace = "http://centerServers")
        int phoneNumber,
        @WebParam(name = "specialization", targetNamespace = "http://centerServers")
        String specialization,
        @WebParam(name = "location", targetNamespace = "http://centerServers")
        String location,
        @WebParam(name = "managerId", targetNamespace = "http://centerServers")
        String managerId);

    /**
     * 
     * @param coursesRegistred
     * @param statusDate
     * @param firstName
     * @param lastName
     * @param managerId
     * @param status
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "createSRecordReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "createSRecord", targetNamespace = "http://centerServers", className = "mtlStub.CreateSRecord")
    @ResponseWrapper(localName = "createSRecordResponse", targetNamespace = "http://centerServers", className = "mtlStub.CreateSRecordResponse")
    public String createSRecord(
        @WebParam(name = "firstName", targetNamespace = "http://centerServers")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "http://centerServers")
        String lastName,
        @WebParam(name = "coursesRegistred", targetNamespace = "http://centerServers")
        String coursesRegistred,
        @WebParam(name = "status", targetNamespace = "http://centerServers")
        boolean status,
        @WebParam(name = "statusDate", targetNamespace = "http://centerServers")
        String statusDate,
        @WebParam(name = "managerId", targetNamespace = "http://centerServers")
        String managerId);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "getRecordsCountReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "getRecordsCount", targetNamespace = "http://centerServers", className = "mtlStub.GetRecordsCount")
    @ResponseWrapper(localName = "getRecordsCountResponse", targetNamespace = "http://centerServers", className = "mtlStub.GetRecordsCountResponse")
    public String getRecordsCount(
        @WebParam(name = "in0", targetNamespace = "http://centerServers")
        String in0);

    /**
     * 
     * @param recordId
     * @param newValue
     * @param fieldName
     * @param managerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "editRecordReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "editRecord", targetNamespace = "http://centerServers", className = "mtlStub.EditRecord")
    @ResponseWrapper(localName = "editRecordResponse", targetNamespace = "http://centerServers", className = "mtlStub.EditRecordResponse")
    public String editRecord(
        @WebParam(name = "recordId", targetNamespace = "http://centerServers")
        String recordId,
        @WebParam(name = "fieldName", targetNamespace = "http://centerServers")
        String fieldName,
        @WebParam(name = "newValue", targetNamespace = "http://centerServers")
        String newValue,
        @WebParam(name = "managerId", targetNamespace = "http://centerServers")
        String managerId);

    /**
     * 
     * @param recordId
     * @param managerId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "recordExistReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "recordExist", targetNamespace = "http://centerServers", className = "mtlStub.RecordExist")
    @ResponseWrapper(localName = "recordExistResponse", targetNamespace = "http://centerServers", className = "mtlStub.RecordExistResponse")
    public boolean recordExist(
        @WebParam(name = "recordId", targetNamespace = "http://centerServers")
        String recordId,
        @WebParam(name = "managerId", targetNamespace = "http://centerServers")
        String managerId);

    /**
     * 
     * @param in0
     * @param in2
     * @param in1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "transferRecordReturn", targetNamespace = "http://centerServers")
    @RequestWrapper(localName = "transferRecord", targetNamespace = "http://centerServers", className = "mtlStub.TransferRecord")
    @ResponseWrapper(localName = "transferRecordResponse", targetNamespace = "http://centerServers", className = "mtlStub.TransferRecordResponse")
    public String transferRecord(
        @WebParam(name = "in0", targetNamespace = "http://centerServers")
        String in0,
        @WebParam(name = "in1", targetNamespace = "http://centerServers")
        String in1,
        @WebParam(name = "in2", targetNamespace = "http://centerServers")
        String in2);

}
