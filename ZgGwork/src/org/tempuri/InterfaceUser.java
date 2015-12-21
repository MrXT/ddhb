/**
 * InterfaceUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class InterfaceUser  implements java.io.Serializable {
    private java.lang.String valStr;

    private java.lang.String valSerial;

    private java.lang.String command;

    public InterfaceUser() {
    }

    public InterfaceUser(
           java.lang.String valStr,
           java.lang.String valSerial,
           java.lang.String command) {
           this.valStr = valStr;
           this.valSerial = valSerial;
           this.command = command;
    }


    /**
     * Gets the valStr value for this InterfaceUser.
     * 
     * @return valStr
     */
    public java.lang.String getValStr() {
        return valStr;
    }


    /**
     * Sets the valStr value for this InterfaceUser.
     * 
     * @param valStr
     */
    public void setValStr(java.lang.String valStr) {
        this.valStr = valStr;
    }


    /**
     * Gets the valSerial value for this InterfaceUser.
     * 
     * @return valSerial
     */
    public java.lang.String getValSerial() {
        return valSerial;
    }


    /**
     * Sets the valSerial value for this InterfaceUser.
     * 
     * @param valSerial
     */
    public void setValSerial(java.lang.String valSerial) {
        this.valSerial = valSerial;
    }


    /**
     * Gets the command value for this InterfaceUser.
     * 
     * @return command
     */
    public java.lang.String getCommand() {
        return command;
    }


    /**
     * Sets the command value for this InterfaceUser.
     * 
     * @param command
     */
    public void setCommand(java.lang.String command) {
        this.command = command;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InterfaceUser)) return false;
        InterfaceUser other = (InterfaceUser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.valStr==null && other.getValStr()==null) || 
             (this.valStr!=null &&
              this.valStr.equals(other.getValStr()))) &&
            ((this.valSerial==null && other.getValSerial()==null) || 
             (this.valSerial!=null &&
              this.valSerial.equals(other.getValSerial()))) &&
            ((this.command==null && other.getCommand()==null) || 
             (this.command!=null &&
              this.command.equals(other.getCommand())));
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
        if (getValStr() != null) {
            _hashCode += getValStr().hashCode();
        }
        if (getValSerial() != null) {
            _hashCode += getValSerial().hashCode();
        }
        if (getCommand() != null) {
            _hashCode += getCommand().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InterfaceUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "InterfaceUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "valStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valSerial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "valSerial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("command");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "command"));
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
