/**
 * MainServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class MainServiceLocator extends org.apache.axis.client.Service implements org.tempuri.MainService {

    public MainServiceLocator() {
    }


    public MainServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MainServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MainServiceSoap12
    private java.lang.String MainServiceSoap12_address = "http://manage.scjpw.com.cn/OrderInterface/MainService.asmx";

    public java.lang.String getMainServiceSoap12Address() {
        return MainServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MainServiceSoap12WSDDServiceName = "MainServiceSoap12";

    public java.lang.String getMainServiceSoap12WSDDServiceName() {
        return MainServiceSoap12WSDDServiceName;
    }

    public void setMainServiceSoap12WSDDServiceName(java.lang.String name) {
        MainServiceSoap12WSDDServiceName = name;
    }

    public org.tempuri.MainServiceSoap getMainServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MainServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMainServiceSoap12(endpoint);
    }

    public org.tempuri.MainServiceSoap getMainServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.MainServiceSoap12Stub _stub = new org.tempuri.MainServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getMainServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMainServiceSoap12EndpointAddress(java.lang.String address) {
        MainServiceSoap12_address = address;
    }


    // Use to get a proxy class for MainServiceSoap
    private java.lang.String MainServiceSoap_address = "http://manage.scjpw.com.cn/OrderInterface/MainService.asmx";

    public java.lang.String getMainServiceSoapAddress() {
        return MainServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MainServiceSoapWSDDServiceName = "MainServiceSoap";

    public java.lang.String getMainServiceSoapWSDDServiceName() {
        return MainServiceSoapWSDDServiceName;
    }

    public void setMainServiceSoapWSDDServiceName(java.lang.String name) {
        MainServiceSoapWSDDServiceName = name;
    }

    public org.tempuri.MainServiceSoap getMainServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MainServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMainServiceSoap(endpoint);
    }

    public org.tempuri.MainServiceSoap getMainServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.MainServiceSoapStub _stub = new org.tempuri.MainServiceSoapStub(portAddress, this);
            _stub.setPortName(getMainServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMainServiceSoapEndpointAddress(java.lang.String address) {
        MainServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.MainServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.MainServiceSoap12Stub _stub = new org.tempuri.MainServiceSoap12Stub(new java.net.URL(MainServiceSoap12_address), this);
                _stub.setPortName(getMainServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (org.tempuri.MainServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.MainServiceSoapStub _stub = new org.tempuri.MainServiceSoapStub(new java.net.URL(MainServiceSoap_address), this);
                _stub.setPortName(getMainServiceSoapWSDDServiceName());
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
        if ("MainServiceSoap12".equals(inputPortName)) {
            return getMainServiceSoap12();
        }
        else if ("MainServiceSoap".equals(inputPortName)) {
            return getMainServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "MainService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "MainServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "MainServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MainServiceSoap12".equals(portName)) {
            setMainServiceSoap12EndpointAddress(address);
        }
        else 
if ("MainServiceSoap".equals(portName)) {
            setMainServiceSoapEndpointAddress(address);
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
