
package fooddata.adapter.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RetrieveService", targetNamespace = "http://service.adapter.fooddata/", wsdlLocation = "https://isdemm-food-data-adapter.herokuapp.com/fooddata/adapter?wsdl")
public class RetrieveService
    extends Service
{

    private final static URL RETRIEVESERVICE_WSDL_LOCATION;
    private final static WebServiceException RETRIEVESERVICE_EXCEPTION;
    private final static QName RETRIEVESERVICE_QNAME = new QName("http://service.adapter.fooddata/", "RetrieveService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://isdemm-food-data-adapter.herokuapp.com/fooddata/adapter?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RETRIEVESERVICE_WSDL_LOCATION = url;
        RETRIEVESERVICE_EXCEPTION = e;
    }

    public RetrieveService() {
        super(__getWsdlLocation(), RETRIEVESERVICE_QNAME);
    }

    public RetrieveService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RETRIEVESERVICE_QNAME, features);
    }

    public RetrieveService(URL wsdlLocation) {
        super(wsdlLocation, RETRIEVESERVICE_QNAME);
    }

    public RetrieveService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RETRIEVESERVICE_QNAME, features);
    }

    public RetrieveService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetrieveService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RetrieveInterface
     */
    @WebEndpoint(name = "RetrievePort")
    public RetrieveInterface getRetrievePort() {
        return super.getPort(new QName("http://service.adapter.fooddata/", "RetrievePort"), RetrieveInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RetrieveInterface
     */
    @WebEndpoint(name = "RetrievePort")
    public RetrieveInterface getRetrievePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.adapter.fooddata/", "RetrievePort"), RetrieveInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RETRIEVESERVICE_EXCEPTION!= null) {
            throw RETRIEVESERVICE_EXCEPTION;
        }
        return RETRIEVESERVICE_WSDL_LOCATION;
    }

}
