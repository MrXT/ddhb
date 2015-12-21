/**
 * SendSmsResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manzz.clcw.common.cmcc;
@SuppressWarnings("all")
public class SendSmsResult  implements java.io.Serializable {
    private com.manzz.clcw.common.cmcc.ServiceErrorCode errorCode;

    private java.lang.String errorMessage;

    private java.lang.String requestIdentifier;

    public SendSmsResult() {
    }

    public SendSmsResult(
           com.manzz.clcw.common.cmcc.ServiceErrorCode errorCode,
           java.lang.String errorMessage,
           java.lang.String requestIdentifier) {
           this.errorCode = errorCode;
           this.errorMessage = errorMessage;
           this.requestIdentifier = requestIdentifier;
    }


    /**
     * Gets the errorCode value for this SendSmsResult.
     * 
     * @return errorCode
     */
    public com.manzz.clcw.common.cmcc.ServiceErrorCode getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this SendSmsResult.
     * 
     * @param errorCode
     */
    public void setErrorCode(com.manzz.clcw.common.cmcc.ServiceErrorCode errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorMessage value for this SendSmsResult.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this SendSmsResult.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the requestIdentifier value for this SendSmsResult.
     * 
     * @return requestIdentifier
     */
    public java.lang.String getRequestIdentifier() {
        return requestIdentifier;
    }


    /**
     * Sets the requestIdentifier value for this SendSmsResult.
     * 
     * @param requestIdentifier
     */
    public void setRequestIdentifier(java.lang.String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSmsResult)) return false;
        SendSmsResult other = (SendSmsResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.requestIdentifier==null && other.getRequestIdentifier()==null) || 
             (this.requestIdentifier!=null &&
              this.requestIdentifier.equals(other.getRequestIdentifier())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getRequestIdentifier() != null) {
            _hashCode += getRequestIdentifier().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.jituanyun.com/", "SendSmsResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.jituanyun.com/", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.jituanyun.com/", "ServiceErrorCode"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.jituanyun.com/", "ErrorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestIdentifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.jituanyun.com/", "RequestIdentifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
