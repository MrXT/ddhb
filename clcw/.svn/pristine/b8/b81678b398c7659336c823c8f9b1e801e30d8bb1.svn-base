package com.manzz.clcw.common.cmcc;

public class MasServiceSoapProxy implements com.manzz.clcw.common.cmcc.MasServiceSoap {
  private String _endpoint = null;
  private com.manzz.clcw.common.cmcc.MasServiceSoap masServiceSoap = null;
  
  public MasServiceSoapProxy() {
    _initMasServiceSoapProxy();
  }
  
  public MasServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMasServiceSoapProxy();
  }
  
  private void _initMasServiceSoapProxy() {
    try {
      masServiceSoap = (new com.manzz.clcw.common.cmcc.MasServiceLocator()).getMasServiceSoap();
      if (masServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)masServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)masServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (masServiceSoap != null)
      ((javax.xml.rpc.Stub)masServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.manzz.clcw.common.cmcc.MasServiceSoap getMasServiceSoap() {
    if (masServiceSoap == null)
      _initMasServiceSoapProxy();
    return masServiceSoap;
  }
  
  public com.manzz.clcw.common.cmcc.SendSmsResult sendSms(java.lang.String userName, java.lang.String password, java.lang.String[] destAddr, java.lang.String content, java.lang.String ext) throws java.rmi.RemoteException{
    if (masServiceSoap == null)
      _initMasServiceSoapProxy();
    return masServiceSoap.sendSms(userName, password, destAddr, content, ext);
  }
  
  public com.manzz.clcw.common.cmcc.SendSmsResult sendScheduleSms(java.lang.String userName, java.lang.String password, java.lang.String[] destAddr, java.lang.String content, java.lang.String ext, java.util.Calendar scheduleTime) throws java.rmi.RemoteException{
    if (masServiceSoap == null)
      _initMasServiceSoapProxy();
    return masServiceSoap.sendScheduleSms(userName, password, destAddr, content, ext, scheduleTime);
  }
  
  public com.manzz.clcw.common.cmcc.MessageDeliveryInformation[] getDeliveryStatus(java.lang.String requestIdentifier) throws java.rmi.RemoteException{
    if (masServiceSoap == null)
      _initMasServiceSoapProxy();
    return masServiceSoap.getDeliveryStatus(requestIdentifier);
  }
  
  
}