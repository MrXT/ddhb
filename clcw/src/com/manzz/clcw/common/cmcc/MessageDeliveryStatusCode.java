/**
 * MessageDeliveryStatusCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manzz.clcw.common.cmcc;
@SuppressWarnings("all")
public class MessageDeliveryStatusCode implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected MessageDeliveryStatusCode(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Delivered = "Delivered";
    public static final java.lang.String _DeliveryUncertain = "DeliveryUncertain";
    public static final java.lang.String _DeliveryImpossible = "DeliveryImpossible";
    public static final java.lang.String _MessageWaiting = "MessageWaiting";
    public static final java.lang.String _DeliveryToTerminal = "DeliveryToTerminal";
    public static final java.lang.String _DeliveryNotificationNotSupported = "DeliveryNotificationNotSupported";
    public static final java.lang.String _KeyWordFilterFailed = "KeyWordFilterFailed";
    public static final java.lang.String _DeliveredToNetwork = "DeliveredToNetwork";
    public static final java.lang.String _Unknown = "Unknown";
    public static final MessageDeliveryStatusCode Delivered = new MessageDeliveryStatusCode(_Delivered);
    public static final MessageDeliveryStatusCode DeliveryUncertain = new MessageDeliveryStatusCode(_DeliveryUncertain);
    public static final MessageDeliveryStatusCode DeliveryImpossible = new MessageDeliveryStatusCode(_DeliveryImpossible);
    public static final MessageDeliveryStatusCode MessageWaiting = new MessageDeliveryStatusCode(_MessageWaiting);
    public static final MessageDeliveryStatusCode DeliveryToTerminal = new MessageDeliveryStatusCode(_DeliveryToTerminal);
    public static final MessageDeliveryStatusCode DeliveryNotificationNotSupported = new MessageDeliveryStatusCode(_DeliveryNotificationNotSupported);
    public static final MessageDeliveryStatusCode KeyWordFilterFailed = new MessageDeliveryStatusCode(_KeyWordFilterFailed);
    public static final MessageDeliveryStatusCode DeliveredToNetwork = new MessageDeliveryStatusCode(_DeliveredToNetwork);
    public static final MessageDeliveryStatusCode Unknown = new MessageDeliveryStatusCode(_Unknown);
    public java.lang.String getValue() { return _value_;}
    public static MessageDeliveryStatusCode fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        MessageDeliveryStatusCode enumeration = (MessageDeliveryStatusCode)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static MessageDeliveryStatusCode fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(MessageDeliveryStatusCode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.jituanyun.com/", "MessageDeliveryStatusCode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
