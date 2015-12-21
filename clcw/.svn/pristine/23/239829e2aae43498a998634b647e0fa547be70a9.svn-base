/**
 * ServiceErrorCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manzz.clcw.common.cmcc;
@SuppressWarnings("all")
public class ServiceErrorCode implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ServiceErrorCode(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Success = "Success";
    public static final java.lang.String _AuthenticiationFailed = "AuthenticiationFailed";
    public static final java.lang.String _BadKeywords = "BadKeywords";
    public static final java.lang.String _InsufficientBalance = "InsufficientBalance";
    public static final java.lang.String _BatchSizeTooLarge = "BatchSizeTooLarge";
    public static final java.lang.String _ArgumentError = "ArgumentError";
    public static final java.lang.String _BadRequest = "BadRequest";
    public static final java.lang.String _ServiceUnavailable = "ServiceUnavailable";
    public static final ServiceErrorCode Success = new ServiceErrorCode(_Success);
    public static final ServiceErrorCode AuthenticiationFailed = new ServiceErrorCode(_AuthenticiationFailed);
    public static final ServiceErrorCode BadKeywords = new ServiceErrorCode(_BadKeywords);
    public static final ServiceErrorCode InsufficientBalance = new ServiceErrorCode(_InsufficientBalance);
    public static final ServiceErrorCode BatchSizeTooLarge = new ServiceErrorCode(_BatchSizeTooLarge);
    public static final ServiceErrorCode ArgumentError = new ServiceErrorCode(_ArgumentError);
    public static final ServiceErrorCode BadRequest = new ServiceErrorCode(_BadRequest);
    public static final ServiceErrorCode ServiceUnavailable = new ServiceErrorCode(_ServiceUnavailable);
    public java.lang.String getValue() { return _value_;}
    public static ServiceErrorCode fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ServiceErrorCode enumeration = (ServiceErrorCode)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ServiceErrorCode fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceErrorCode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.jituanyun.com/", "ServiceErrorCode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
