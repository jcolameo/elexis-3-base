//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.18 at 01:35:39 PM CET 
//

package ch.fd.invoice400.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for uvgLawType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uvgLawType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="employer" type="{http://www.xmlData.ch/xmlInvoice/XSD}employerAddressType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="reason" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="disease"/>
 *             &lt;enumeration value="accident"/>
 *             &lt;enumeration value="maternity"/>
 *             &lt;enumeration value="prevention"/>
 *             &lt;enumeration value="birthdefect"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="patient_id" type="{http://www.xmlData.ch/xmlInvoice/XSD}stringType1_35" />
 *       &lt;attribute name="case_id" type="{http://www.xmlData.ch/xmlInvoice/XSD}stringType1_35" />
 *       &lt;attribute name="case_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="contract_number" type="{http://www.xmlData.ch/xmlInvoice/XSD}stringType1_35" />
 *       &lt;attribute name="ssn" type="{http://www.xmlData.ch/xmlInvoice/XSD}ssnPartyType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uvgLawType", propOrder = {
	"employer"
})
public class UvgLawType {
	
	protected EmployerAddressType employer;
	@XmlAttribute(name = "reason", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String reason;
	@XmlAttribute(name = "patient_id")
	protected String patientId;
	@XmlAttribute(name = "case_id")
	protected String caseId;
	@XmlAttribute(name = "case_date")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar caseDate;
	@XmlAttribute(name = "contract_number")
	protected String contractNumber;
	@XmlAttribute(name = "ssn")
	protected String ssn;
	
	/**
	 * Gets the value of the employer property.
	 * 
	 * @return possible object is {@link EmployerAddressType }
	 * 
	 */
	public EmployerAddressType getEmployer(){
		return employer;
	}
	
	/**
	 * Sets the value of the employer property.
	 * 
	 * @param value
	 *            allowed object is {@link EmployerAddressType }
	 * 
	 */
	public void setEmployer(EmployerAddressType value){
		this.employer = value;
	}
	
	/**
	 * Gets the value of the reason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReason(){
		return reason;
	}
	
	/**
	 * Sets the value of the reason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReason(String value){
		this.reason = value;
	}
	
	/**
	 * Gets the value of the patientId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPatientId(){
		return patientId;
	}
	
	/**
	 * Sets the value of the patientId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPatientId(String value){
		this.patientId = value;
	}
	
	/**
	 * Gets the value of the caseId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCaseId(){
		return caseId;
	}
	
	/**
	 * Sets the value of the caseId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCaseId(String value){
		this.caseId = value;
	}
	
	/**
	 * Gets the value of the caseDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCaseDate(){
		return caseDate;
	}
	
	/**
	 * Sets the value of the caseDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCaseDate(XMLGregorianCalendar value){
		this.caseDate = value;
	}
	
	/**
	 * Gets the value of the contractNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContractNumber(){
		return contractNumber;
	}
	
	/**
	 * Sets the value of the contractNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContractNumber(String value){
		this.contractNumber = value;
	}
	
	/**
	 * Gets the value of the ssn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSsn(){
		return ssn;
	}
	
	/**
	 * Sets the value of the ssn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSsn(String value){
		this.ssn = value;
	}
	
}
