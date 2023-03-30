package ch.docbox.ws.cdachservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.commons.lang3.StringUtils;
import org.hl7.v3.CE;
import org.hl7.v3.ClinicalDocumentType;
import org.hl7.v3.POCDMT000040IntendedRecipient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.7-b01- Generated
 * source version: 2.1
 *
 */
@WebService(name = "CDACHServices", targetNamespace = "http://ws.docbox.ch/CDACHServices/")
@XmlSeeAlso({ org.hl7.v3.ObjectFactory.class, ch.docbox.ws.cdachservices.ObjectFactory.class })
public interface CDACHServices {

	/**
	 *
	 * @param message
	 * @param success
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/checkAccess")
	@RequestWrapper(localName = "checkAccess", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.CheckAccess")
	@ResponseWrapper(localName = "checkAccessResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.CheckAccessResponse")
	public void checkAccess(
			@WebParam(name = "success", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<Boolean> success,
			@WebParam(name = "message", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<String> message);

	/**
	 *
	 * @param message
	 * @param documentID
	 * @param document
	 * @param attachment
	 * @param success
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/addReferral")
	@RequestWrapper(localName = "addReferral", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.AddReferral")
	@ResponseWrapper(localName = "addReferralResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.AddReferralResponse")
	public void addReferral(
			@WebParam(name = "document", targetNamespace = StringUtils.EMPTY) ClinicalDocumentType document,
			@WebParam(name = "attachment", targetNamespace = StringUtils.EMPTY) byte[] attachment,
			@WebParam(name = "success", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<Boolean> success,
			@WebParam(name = "message", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<String> message,
			@WebParam(name = "documentID", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<String> documentID);

	/**
	 *
	 * @param code
	 * @return returns java.util.List<ch.docbox.ws.cdachservices.DocumentInfoType>
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/getInboxClinicalDocuments")
	@WebResult(name = "document", targetNamespace = StringUtils.EMPTY)
	@RequestWrapper(localName = "getInboxClinicalDocuments", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetInboxClinicalDocuments")
	@ResponseWrapper(localName = "getInboxClinicalDocumentsResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetInboxClinicalDocumentsResponse")
	public List<DocumentInfoType> getInboxClinicalDocuments(
			@WebParam(name = "code", targetNamespace = StringUtils.EMPTY) CE code);

	/**
	 *
	 * @param documentID
	 * @param document
	 * @param attachment
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/getClinicalDocument")
	@RequestWrapper(localName = "getClinicalDocument", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetClinicalDocument")
	@ResponseWrapper(localName = "getClinicalDocumentResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetClinicalDocumentResponse")
	public void getClinicalDocument(
			@WebParam(name = "documentID", targetNamespace = StringUtils.EMPTY) String documentID,
			@WebParam(name = "document", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<ClinicalDocumentType> document,
			@WebParam(name = "attachment", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<byte[]> attachment);

	/**
	 *
	 * @return returns java.util.List<ch.docbox.ws.cdachservices.AppointmentType>
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/getCalendar")
	@WebResult(name = "appointment", targetNamespace = StringUtils.EMPTY)
	@RequestWrapper(localName = "getCalendar", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetCalendar")
	@ResponseWrapper(localName = "getCalendarResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetCalendarResponse")
	public List<AppointmentType> getCalendar();

	/**
	 *
	 * @param id
	 * @param msgTitle
	 * @param param
	 * @param msgBody
	 * @return returns boolean
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/deleteAgendaEntry")
	@WebResult(name = "success", targetNamespace = StringUtils.EMPTY)
	@RequestWrapper(localName = "deleteAgendaEntry", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.DeleteAgendaEntry")
	@ResponseWrapper(localName = "deleteAgendaEntryResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.DeleteAgendaEntryResponse")
	public boolean deleteAgendaEntry(@WebParam(name = "id", targetNamespace = StringUtils.EMPTY) String id,
			@WebParam(name = "msgTitle", targetNamespace = StringUtils.EMPTY) String msgTitle,
			@WebParam(name = "msgBody", targetNamespace = StringUtils.EMPTY) String msgBody,
			@WebParam(name = "param", targetNamespace = StringUtils.EMPTY) String param);

	/**
	 *
	 * @param message
	 * @param documentID
	 * @param document
	 * @param attachment
	 * @param success
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/sendClinicalDocument")
	@RequestWrapper(localName = "sendClinicalDocument", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.SendClinicalDocument")
	@ResponseWrapper(localName = "sendClinicalDocumentResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.SendClinicalDocumentResponse")
	public void sendClinicalDocument(
			@WebParam(name = "document", targetNamespace = StringUtils.EMPTY) ClinicalDocumentType document,
			@WebParam(name = "attachment", targetNamespace = StringUtils.EMPTY) byte[] attachment,
			@WebParam(name = "success", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<Boolean> success,
			@WebParam(name = "message", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<String> message,
			@WebParam(name = "documentID", targetNamespace = StringUtils.EMPTY, mode = WebParam.Mode.OUT) Holder<String> documentID);

	/**
	 *
	 * @param type
	 * @return returns java.util.List<org.hl7.v3.POCDMT000040IntendedRecipient>
	 */
	@WebMethod(action = "http://ws.docbox.ch/CDACHServices/getRecipients")
	@WebResult(name = "recipient", targetNamespace = StringUtils.EMPTY)
	@RequestWrapper(localName = "getRecipients", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetRecipients")
	@ResponseWrapper(localName = "getRecipientsResponse", targetNamespace = "http://ws.docbox.ch/CDACHServices/", className = "ch.docbox.ws.cdachservices.GetRecipientsResponse")
	public List<POCDMT000040IntendedRecipient> getRecipients(
			@WebParam(name = "type", targetNamespace = StringUtils.EMPTY) String type);

}
