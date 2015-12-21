/**
 * MainServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface MainServiceSoap extends java.rmi.Remote {
    public void genericFunction(byte[] baseInfo, byte[] input, javax.xml.rpc.holders.IntHolder genericFunctionResult, javax.xml.rpc.holders.StringHolder output) throws java.rmi.RemoteException;
    public java.lang.String genericFuctionJSON(org.tempuri.InterfaceUser iuser, org.tempuri.WeixinQueryStruct weixin) throws java.rmi.RemoteException;
}
