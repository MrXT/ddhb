/**
 * MasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manzz.clcw.common.cmcc;
@SuppressWarnings("rawtypes")
public class MasServiceLocator extends org.apache.axis.client.Service implements com.manzz.clcw.common.cmcc.MasService {

    private static final long serialVersionUID = 3964199191702966800L;

    public MasServiceLocator() {
    }


    public MasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MasServiceSoap
    private java.lang.String MasServiceSoap_address = "http://xingye.sn.jituanyun.com/MasService.asmx";

    public java.lang.String getMasServiceSoapAddress() {
        return MasServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MasServiceSoapWSDDServiceName = "MasServiceSoap";

    public java.lang.String getMasServiceSoapWSDDServiceName() {
        return MasServiceSoapWSDDServiceName;
    }

    public void setMasServiceSoapWSDDServiceName(java.lang.String name) {
        MasServiceSoapWSDDServiceName = name;
    }

    public com.manzz.clcw.common.cmcc.MasServiceSoap getMasServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MasServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMasServiceSoap(endpoint);
    }

    public com.manzz.clcw.common.cmcc.MasServiceSoap getMasServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.manzz.clcw.common.cmcc.MasServiceSoapStub _stub = new com.manzz.clcw.common.cmcc.MasServiceSoapStub(portAddress, this);
            _stub.setPortName(getMasServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMasServiceSoapEndpointAddress(java.lang.String address) {
        MasServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.manzz.clcw.common.cmcc.MasServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.manzz.clcw.common.cmcc.MasServiceSoapStub _stub = new com.manzz.clcw.common.cmcc.MasServiceSoapStub(new java.net.URL(MasServiceSoap_address), this);
                _stub.setPortName(getMasServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MasServiceSoap".equals(inputPortName)) {
            return getMasServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.jituanyun.com/", "MasService");
    }

    private java.util.HashSet ports = null;

    @SuppressWarnings("unchecked")
    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.jituanyun.com/", "MasServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MasServiceSoap".equals(portName)) {
            setMasServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
