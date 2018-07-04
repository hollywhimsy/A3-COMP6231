
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
@WebService(name = "RecordManagerMTLImpl", targetNamespace = "http://servers")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RecordManagerMTLImpl {


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
    @WebResult(name = "createTRecordReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "createTRecord", targetNamespace = "http://servers", className = "mtlStub.CreateTRecord")
    @ResponseWrapper(localName = "createTRecordResponse", targetNamespace = "http://servers", className = "mtlStub.CreateTRecordResponse")
    public String createTRecord(
        @WebParam(name = "firstName", targetNamespace = "http://servers")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "http://servers")
        String lastName,
        @WebParam(name = "address", targetNamespace = "http://servers")
        String address,
        @WebParam(name = "phoneNumber", targetNamespace = "http://servers")
        int phoneNumber,
        @WebParam(name = "specialization", targetNamespace = "http://servers")
        String specialization,
        @WebParam(name = "location", targetNamespace = "http://servers")
        String location,
        @WebParam(name = "managerId", targetNamespace = "http://servers")
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
    @WebResult(name = "createSRecordReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "createSRecord", targetNamespace = "http://servers", className = "mtlStub.CreateSRecord")
    @ResponseWrapper(localName = "createSRecordResponse", targetNamespace = "http://servers", className = "mtlStub.CreateSRecordResponse")
    public String createSRecord(
        @WebParam(name = "firstName", targetNamespace = "http://servers")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "http://servers")
        String lastName,
        @WebParam(name = "coursesRegistred", targetNamespace = "http://servers")
        String coursesRegistred,
        @WebParam(name = "status", targetNamespace = "http://servers")
        boolean status,
        @WebParam(name = "statusDate", targetNamespace = "http://servers")
        String statusDate,
        @WebParam(name = "managerId", targetNamespace = "http://servers")
        String managerId);

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
    @WebResult(name = "editRecordReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "editRecord", targetNamespace = "http://servers", className = "mtlStub.EditRecord")
    @ResponseWrapper(localName = "editRecordResponse", targetNamespace = "http://servers", className = "mtlStub.EditRecordResponse")
    public String editRecord(
        @WebParam(name = "recordId", targetNamespace = "http://servers")
        String recordId,
        @WebParam(name = "fieldName", targetNamespace = "http://servers")
        String fieldName,
        @WebParam(name = "newValue", targetNamespace = "http://servers")
        String newValue,
        @WebParam(name = "managerId", targetNamespace = "http://servers")
        String managerId);

    /**
     * 
     * @param recordId
     * @param managerId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "recordExistReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "recordExist", targetNamespace = "http://servers", className = "mtlStub.RecordExist")
    @ResponseWrapper(localName = "recordExistResponse", targetNamespace = "http://servers", className = "mtlStub.RecordExistResponse")
    public boolean recordExist(
        @WebParam(name = "recordId", targetNamespace = "http://servers")
        String recordId,
        @WebParam(name = "managerId", targetNamespace = "http://servers")
        String managerId);

    /**
     * 
     * @param recordId
     * @param remoteCenterServerName
     * @param managerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "transferRecordReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "transferRecord", targetNamespace = "http://servers", className = "mtlStub.TransferRecord")
    @ResponseWrapper(localName = "transferRecordResponse", targetNamespace = "http://servers", className = "mtlStub.TransferRecordResponse")
    public String transferRecord(
        @WebParam(name = "managerId", targetNamespace = "http://servers")
        String managerId,
        @WebParam(name = "recordId", targetNamespace = "http://servers")
        String recordId,
        @WebParam(name = "remoteCenterServerName", targetNamespace = "http://servers")
        String remoteCenterServerName);

    /**
     * 
     * @param managerId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "getRecordsCountReturn", targetNamespace = "http://servers")
    @RequestWrapper(localName = "getRecordsCount", targetNamespace = "http://servers", className = "mtlStub.GetRecordsCount")
    @ResponseWrapper(localName = "getRecordsCountResponse", targetNamespace = "http://servers", className = "mtlStub.GetRecordsCountResponse")
    public String getRecordsCount(
        @WebParam(name = "managerId", targetNamespace = "http://servers")
        String managerId);

}
