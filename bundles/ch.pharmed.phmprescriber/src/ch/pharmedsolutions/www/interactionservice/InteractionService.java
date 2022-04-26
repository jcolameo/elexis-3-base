
package ch.pharmedsolutions.www.interactionservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import ch.pharmedsolutions.www.interactionservice.InteractionPortType;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.6-1b01 Generated
 * source version: 2.2
 *
 */
@WebServiceClient(name = "InteractionService", targetNamespace = "https://www.pharmedsolutions.ch/InteractionService", wsdlLocation = "https://www.pharmedsolutions.ch/InteractionService/wsdl")
public class InteractionService extends Service {

	private final static URL INTERACTIONSERVICE_WSDL_LOCATION;
	private final static WebServiceException INTERACTIONSERVICE_EXCEPTION;
	private final static QName INTERACTIONSERVICE_QNAME = new QName(
			"https://www.pharmedsolutions.ch/InteractionService", "InteractionService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL("https://www.pharmedsolutions.ch/InteractionService/wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		INTERACTIONSERVICE_WSDL_LOCATION = url;
		INTERACTIONSERVICE_EXCEPTION = e;
	}

	public InteractionService() {
		super(__getWsdlLocation(), INTERACTIONSERVICE_QNAME);
	}

	public InteractionService(WebServiceFeature... features) {
		super(__getWsdlLocation(), INTERACTIONSERVICE_QNAME, features);
	}

	public InteractionService(URL wsdlLocation) {
		super(wsdlLocation, INTERACTIONSERVICE_QNAME);
	}

	public InteractionService(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, INTERACTIONSERVICE_QNAME, features);
	}

	public InteractionService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public InteractionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 *
	 * @return returns InteractionPortType
	 */
	@WebEndpoint(name = "InteractionPort")
	public InteractionPortType getInteractionPort() {
		return super.getPort(new QName("https://www.pharmedsolutions.ch/InteractionService", "InteractionPort"),
				InteractionPortType.class);
	}

	/**
	 *
	 * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *                 on the proxy. Supported features not in the
	 *                 <code>features</code> parameter will have their default
	 *                 values.
	 * @return returns InteractionPortType
	 */
	@WebEndpoint(name = "InteractionPort")
	public InteractionPortType getInteractionPort(WebServiceFeature... features) {
		return super.getPort(new QName("https://www.pharmedsolutions.ch/InteractionService", "InteractionPort"),
				InteractionPortType.class, features);
	}

	private static URL __getWsdlLocation() {
		if (INTERACTIONSERVICE_EXCEPTION != null) {
			throw INTERACTIONSERVICE_EXCEPTION;
		}
		return INTERACTIONSERVICE_WSDL_LOCATION;
	}

}
