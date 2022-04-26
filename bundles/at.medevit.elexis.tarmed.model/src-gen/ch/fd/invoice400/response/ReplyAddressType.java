//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.13 at 12:17:21 PM MEZ 
//

package ch.fd.invoice400.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for replyAddressType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="replyAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="company" type="{http://www.xmlData.ch/xmlInvoice/XSD}replyCompanyType"/>
 *         &lt;element name="contact" type="{http://www.xmlData.ch/xmlInvoice/XSD}replyContactType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ean_party" use="required" type="{http://www.xmlData.ch/xmlInvoice/XSD}xtendEanPartyType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replyAddressType", propOrder = {
	"company", "contact"
})
public class ReplyAddressType {
	
	@XmlElement(namespace = "http://www.xmlData.ch/xmlInvoice/XSD")
	protected ReplyCompanyType company;
	@XmlElement(namespace = "http://www.xmlData.ch/xmlInvoice/XSD")
	protected ReplyContactType contact;
	@XmlAttribute(name = "ean_party", required = true)
	protected String eanParty;
	
	/**
	 * Gets the value of the company property.
	 * 
	 * @return possible object is {@link ReplyCompanyType }
	 * 
	 */
	public ReplyCompanyType getCompany(){
		return company;
	}
	
	/**
	 * Sets the value of the company property.
	 * 
	 * @param value
	 *            allowed object is {@link ReplyCompanyType }
	 * 
	 */
	public void setCompany(ReplyCompanyType value){
		this.company = value;
	}
	
	/**
	 * Gets the value of the contact property.
	 * 
	 * @return possible object is {@link ReplyContactType }
	 * 
	 */
	public ReplyContactType getContact(){
		return contact;
	}
	
	/**
	 * Sets the value of the contact property.
	 * 
	 * @param value
	 *            allowed object is {@link ReplyContactType }
	 * 
	 */
	public void setContact(ReplyContactType value){
		this.contact = value;
	}
	
	/**
	 * Gets the value of the eanParty property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEanParty(){
		return eanParty;
	}
	
	/**
	 * Sets the value of the eanParty property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEanParty(String value){
		this.eanParty = value;
	}
	
}
