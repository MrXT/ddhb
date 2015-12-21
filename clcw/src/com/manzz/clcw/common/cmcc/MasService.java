/**
 * MasService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manzz.clcw.common.cmcc;

public interface MasService extends javax.xml.rpc.Service {
    public java.lang.String getMasServiceSoapAddress();

    public com.manzz.clcw.common.cmcc.MasServiceSoap getMasServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.manzz.clcw.common.cmcc.MasServiceSoap getMasServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
