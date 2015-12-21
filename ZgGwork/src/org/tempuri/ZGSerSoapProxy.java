package org.tempuri;

public class ZGSerSoapProxy implements org.tempuri.ZGSerSoap {
  private String _endpoint = null;
  private org.tempuri.ZGSerSoap zGSerSoap = null;
  
  public ZGSerSoapProxy() {
    _initZGSerSoapProxy();
  }
  
  public ZGSerSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initZGSerSoapProxy();
  }
  
  private void _initZGSerSoapProxy() {
    try {
      zGSerSoap = (new org.tempuri.ZGSerLocator()).getZGSerSoap();
      if (zGSerSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)zGSerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)zGSerSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (zGSerSoap != null)
      ((javax.xml.rpc.Stub)zGSerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ZGSerSoap getZGSerSoap() {
    if (zGSerSoap == null)
      _initZGSerSoapProxy();
    return zGSerSoap;
  }
  
  public java.lang.String ZGQueryAllCount(java.lang.String refparameter) throws java.rmi.RemoteException{
    if (zGSerSoap == null)
      _initZGSerSoapProxy();
    return zGSerSoap.ZGQueryAllCount(refparameter);
  }
  
  public java.lang.String ZGQueryOrder(java.lang.String refparameter) throws java.rmi.RemoteException{
    if (zGSerSoap == null)
      _initZGSerSoapProxy();
    return zGSerSoap.ZGQueryOrder(refparameter);
  }
  
  
}