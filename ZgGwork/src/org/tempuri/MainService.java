/**
 * MainService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface MainService extends javax.xml.rpc.Service {
    public java.lang.String getMainServiceSoap12Address();

    public org.tempuri.MainServiceSoap getMainServiceSoap12() throws javax.xml.rpc.ServiceException;

    public org.tempuri.MainServiceSoap getMainServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getMainServiceSoapAddress();

    public org.tempuri.MainServiceSoap getMainServiceSoap() throws javax.xml.rpc.ServiceException;

    public org.tempuri.MainServiceSoap getMainServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
