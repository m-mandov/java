
package application.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the application.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudentResponse_QNAME = new QName("http://services.application/", "addStudentResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://services.application/", "deleteStudent");
    private final static QName _GetMarks_QNAME = new QName("http://services.application/", "getMarks");
    private final static QName _GetStudentByName_QNAME = new QName("http://services.application/", "getStudentByName");
    private final static QName _GetStudentByFacNumber_QNAME = new QName("http://services.application/", "getStudentByFacNumber");
    private final static QName _IsAuthorizedResponse_QNAME = new QName("http://services.application/", "isAuthorizedResponse");
    private final static QName _IsAuthorized_QNAME = new QName("http://services.application/", "isAuthorized");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://services.application/", "getAllStudentsResponse");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://services.application/", "deleteStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://services.application/", "getAllStudents");
    private final static QName _AddStudent_QNAME = new QName("http://services.application/", "addStudent");
    private final static QName _GetStudentByNameResponse_QNAME = new QName("http://services.application/", "getStudentByNameResponse");
    private final static QName _GetMarksResponse_QNAME = new QName("http://services.application/", "getMarksResponse");
    private final static QName _GetStudentByFacNumberResponse_QNAME = new QName("http://services.application/", "getStudentByFacNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: application.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link GetStudentByNameResponse }
     * 
     */
    public GetStudentByNameResponse createGetStudentByNameResponse() {
        return new GetStudentByNameResponse();
    }

    /**
     * Create an instance of {@link GetMarksResponse }
     * 
     */
    public GetMarksResponse createGetMarksResponse() {
        return new GetMarksResponse();
    }

    /**
     * Create an instance of {@link GetStudentByFacNumberResponse }
     * 
     */
    public GetStudentByFacNumberResponse createGetStudentByFacNumberResponse() {
        return new GetStudentByFacNumberResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudentByFacNumber }
     * 
     */
    public GetStudentByFacNumber createGetStudentByFacNumber() {
        return new GetStudentByFacNumber();
    }

    /**
     * Create an instance of {@link IsAuthorizedResponse }
     * 
     */
    public IsAuthorizedResponse createIsAuthorizedResponse() {
        return new IsAuthorizedResponse();
    }

    /**
     * Create an instance of {@link IsAuthorized }
     * 
     */
    public IsAuthorized createIsAuthorized() {
        return new IsAuthorized();
    }

    /**
     * Create an instance of {@link GetStudentByName }
     * 
     */
    public GetStudentByName createGetStudentByName() {
        return new GetStudentByName();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link GetMarks }
     * 
     */
    public GetMarks createGetMarks() {
        return new GetMarks();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Mark }
     * 
     */
    public Mark createMark() {
        return new Mark();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMarks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getMarks")
    public JAXBElement<GetMarks> createGetMarks(GetMarks value) {
        return new JAXBElement<GetMarks>(_GetMarks_QNAME, GetMarks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getStudentByName")
    public JAXBElement<GetStudentByName> createGetStudentByName(GetStudentByName value) {
        return new JAXBElement<GetStudentByName>(_GetStudentByName_QNAME, GetStudentByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByFacNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getStudentByFacNumber")
    public JAXBElement<GetStudentByFacNumber> createGetStudentByFacNumber(GetStudentByFacNumber value) {
        return new JAXBElement<GetStudentByFacNumber>(_GetStudentByFacNumber_QNAME, GetStudentByFacNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAuthorizedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "isAuthorizedResponse")
    public JAXBElement<IsAuthorizedResponse> createIsAuthorizedResponse(IsAuthorizedResponse value) {
        return new JAXBElement<IsAuthorizedResponse>(_IsAuthorizedResponse_QNAME, IsAuthorizedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAuthorized }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "isAuthorized")
    public JAXBElement<IsAuthorized> createIsAuthorized(IsAuthorized value) {
        return new JAXBElement<IsAuthorized>(_IsAuthorized_QNAME, IsAuthorized.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getStudentByNameResponse")
    public JAXBElement<GetStudentByNameResponse> createGetStudentByNameResponse(GetStudentByNameResponse value) {
        return new JAXBElement<GetStudentByNameResponse>(_GetStudentByNameResponse_QNAME, GetStudentByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMarksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getMarksResponse")
    public JAXBElement<GetMarksResponse> createGetMarksResponse(GetMarksResponse value) {
        return new JAXBElement<GetMarksResponse>(_GetMarksResponse_QNAME, GetMarksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByFacNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application/", name = "getStudentByFacNumberResponse")
    public JAXBElement<GetStudentByFacNumberResponse> createGetStudentByFacNumberResponse(GetStudentByFacNumberResponse value) {
        return new JAXBElement<GetStudentByFacNumberResponse>(_GetStudentByFacNumberResponse_QNAME, GetStudentByFacNumberResponse.class, null, value);
    }

}
