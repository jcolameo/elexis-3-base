package org.hl7.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for POCD_MT000040.Participant2 complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Participant2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="awarenessCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="participantRole" type="{urn:hl7-org:v3}POCD_MT000040.ParticipantRole"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}ParticipationType" />
 *       &lt;attribute name="contextControlCode" type="{urn:hl7-org:v3}ContextControl" fixed="OP" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Participant2", propOrder = { "realmCode", "typeId", "templateId", "time",
		"awarenessCode", "participantRole" })
public class POCDMT000040Participant2 {

	protected List<CS> realmCode;
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected List<II> templateId;
	protected IVLTS time;
	protected CE awarenessCode;
	@XmlElement(required = true)
	protected POCDMT000040ParticipantRole participantRole;
	@XmlAttribute
	protected List<String> nullFlavor;
	@XmlAttribute(required = true)
	protected List<String> typeCode;
	@XmlAttribute
	protected String contextControlCode;

	/**
	 * Gets the value of the realmCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the realmCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getRealmCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CS }
	 *
	 *
	 */
	public List<CS> getRealmCode() {
		if (realmCode == null) {
			realmCode = new ArrayList<CS>();
		}
		return this.realmCode;
	}

	/**
	 * Gets the value of the typeId property.
	 *
	 * @return possible object is {@link POCDMT000040InfrastructureRootTypeId }
	 *
	 */
	public POCDMT000040InfrastructureRootTypeId getTypeId() {
		return typeId;
	}

	/**
	 * Sets the value of the typeId property.
	 *
	 * @param value allowed object is {@link POCDMT000040InfrastructureRootTypeId }
	 *
	 */
	public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
		this.typeId = value;
	}

	/**
	 * Gets the value of the templateId property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the templateId property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getTemplateId().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link II }
	 *
	 *
	 */
	public List<II> getTemplateId() {
		if (templateId == null) {
			templateId = new ArrayList<II>();
		}
		return this.templateId;
	}

	/**
	 * Gets the value of the time property.
	 *
	 * @return possible object is {@link IVLTS }
	 *
	 */
	public IVLTS getTime() {
		return time;
	}

	/**
	 * Sets the value of the time property.
	 *
	 * @param value allowed object is {@link IVLTS }
	 *
	 */
	public void setTime(IVLTS value) {
		this.time = value;
	}

	/**
	 * Gets the value of the awarenessCode property.
	 *
	 * @return possible object is {@link CE }
	 *
	 */
	public CE getAwarenessCode() {
		return awarenessCode;
	}

	/**
	 * Sets the value of the awarenessCode property.
	 *
	 * @param value allowed object is {@link CE }
	 *
	 */
	public void setAwarenessCode(CE value) {
		this.awarenessCode = value;
	}

	/**
	 * Gets the value of the participantRole property.
	 *
	 * @return possible object is {@link POCDMT000040ParticipantRole }
	 *
	 */
	public POCDMT000040ParticipantRole getParticipantRole() {
		return participantRole;
	}

	/**
	 * Sets the value of the participantRole property.
	 *
	 * @param value allowed object is {@link POCDMT000040ParticipantRole }
	 *
	 */
	public void setParticipantRole(POCDMT000040ParticipantRole value) {
		this.participantRole = value;
	}

	/**
	 * Gets the value of the nullFlavor property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the nullFlavor property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getNullFlavor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getNullFlavor() {
		if (nullFlavor == null) {
			nullFlavor = new ArrayList<String>();
		}
		return this.nullFlavor;
	}

	/**
	 * Gets the value of the typeCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the typeCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getTypeCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getTypeCode() {
		if (typeCode == null) {
			typeCode = new ArrayList<String>();
		}
		return this.typeCode;
	}

	/**
	 * Gets the value of the contextControlCode property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getContextControlCode() {
		if (contextControlCode == null) {
			return "OP";
		} else {
			return contextControlCode;
		}
	}

	/**
	 * Sets the value of the contextControlCode property.
	 *
	 * @param value allowed object is {@link String }
	 *
	 */
	public void setContextControlCode(String value) {
		this.contextControlCode = value;
	}

}
