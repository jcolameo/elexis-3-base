//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.18 at 03:48:09 PM CET 
//


package ch.fd.invoice440.request;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vat_rate" type="{http://www.forum-datenaustausch.ch/invoice}vatRateType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vat_number" type="{http://www.forum-datenaustausch.ch/invoice}stringType1_15" />
 *       &lt;attribute name="vat" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vatType", propOrder = {
    "vatRate"
})
public class VatType {

    @XmlElement(name = "vat_rate", required = true)
    protected List<VatRateType> vatRate;
    @XmlAttribute(name = "vat_number")
    protected String vatNumber;
    @XmlAttribute(name = "vat", required = true)
    protected double vat;

    /**
     * Gets the value of the vatRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vatRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVatRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VatRateType }
     * 
     * 
     */
    public List<VatRateType> getVatRate() {
        if (vatRate == null) {
            vatRate = new ArrayList<VatRateType>();
        }
        return this.vatRate;
    }

    /**
     * Gets the value of the vatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * Sets the value of the vatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatNumber(String value) {
        this.vatNumber = value;
    }

    /**
     * Gets the value of the vat property.
     * 
     */
    public double getVat() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     */
    public void setVat(double value) {
        this.vat = value;
    }

}
