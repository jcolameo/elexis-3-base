//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.13 at 12:17:21 PM MEZ 
//

package ch.fd.invoice400.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for generatorType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="software" type="{http://www.xmlData.ch/xmlInvoice/XSD}softwareType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generatorType", propOrder = {
	"software"
})
public class GeneratorType {
	
	@XmlElement(namespace = "http://www.xmlData.ch/xmlInvoice/XSD", required = true)
	protected SoftwareType software;
	
	/**
	 * Gets the value of the software property.
	 * 
	 * @return possible object is {@link SoftwareType }
	 * 
	 */
	public SoftwareType getSoftware(){
		return software;
	}
	
	/**
	 * Sets the value of the software property.
	 * 
	 * @param value
	 *            allowed object is {@link SoftwareType }
	 * 
	 */
	public void setSoftware(SoftwareType value){
		this.software = value;
	}
	
}
