package org.tempuri;

public class MainServiceSoapProxy implements org.tempuri.MainServiceSoap {
  private String _endpoint = null;
  private org.tempuri.MainServiceSoap mainServiceSoap = null;
  
  public MainServiceSoapProxy() {
    _initMainServiceSoapProxy();
  }
  
  public MainServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMainServiceSoapProxy();
  }
  
  private void _initMainServiceSoapProxy() {
    try {
      mainServiceSoap = (new org.tempuri.MainServiceLocator()).getMainServiceSoap();
      if (mainServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mainServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mainServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mainServiceSoap != null)
      ((javax.xml.rpc.Stub)mainServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.MainServiceSoap getMainServiceSoap() {
    if (mainServiceSoap == null)
      _initMainServiceSoapProxy();
    return mainServiceSoap;
  }
  
  public void genericFunction(byte[] baseInfo, byte[] input, javax.xml.rpc.holders.IntHolder genericFunctionResult, javax.xml.rpc.holders.StringHolder output) throws java.rmi.RemoteException{
    if (mainServiceSoap == null)
      _initMainServiceSoapProxy();
    mainServiceSoap.genericFunction(baseInfo, input, genericFunctionResult, output);
  }
  
  public java.lang.String genericFuctionJSON(org.tempuri.InterfaceUser iuser, org.tempuri.WeixinQueryStruct weixin) throws java.rmi.RemoteException{
    if (mainServiceSoap == null)
      _initMainServiceSoapProxy();
    return mainServiceSoap.genericFuctionJSON(iuser, weixin);
  }
  
  
}