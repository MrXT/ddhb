/**
 * ZGSerLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ZGSerLocator extends org.apache.axis.client.Service implements org.tempuri.ZGSer {

    public ZGSerLocator() {
    }


    public ZGSerLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZGSerLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ZGSerSoap
    private java.lang.String ZGSerSoap_address = "http://10.50.50.104:8016/ZGSer.asmx";

    public java.lang.String getZGSerSoapAddress() {
        return ZGSerSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ZGSerSoapWSDDServiceName = "ZGSerSoap";

    public java.lang.String getZGSerSoapWSDDServiceName() {
        return ZGSerSoapWSDDServiceName;
    }

    public void setZGSerSoapWSDDServiceName(java.lang.String name) {
        ZGSerSoapWSDDServiceName = name;
    }

    public org.tempuri.ZGSerSoap getZGSerSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ZGSerSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getZGSerSoap(endpoint);
    }

    public org.tempuri.ZGSerSoap getZGSerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.ZGSerSoapStub _stub = new org.tempuri.ZGSerSoapStub(portAddress, this);
            _stub.setPortName(getZGSerSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setZGSerSoapEndpointAddress(java.lang.String address) {
        ZGSerSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ZGSerSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.ZGSerSoapStub _stub = new org.tempuri.ZGSerSoapStub(new java.net.URL(ZGSerSoap_address), this);
                _stub.setPortName(getZGSerSoapWSDDServiceName());
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
        if ("ZGSerSoap".equals(inputPortName)) {
            return getZGSerSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ZGSer");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ZGSerSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ZGSerSoap".equals(portName)) {
            setZGSerSoapEndpointAddress(address);
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
