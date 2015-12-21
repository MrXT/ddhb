package com.manzz.framework.core.model;

import java.io.Serializable;

/**
 * 键值对
 * @author WJK
 * @version:1.0 2014-09
 */
public class LabelValueBean implements Comparable<LabelValueBean>, Serializable {

    public LabelValueBean() {
    }

    public LabelValueBean(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    /**
     * 
     * @param o aaa
     * @return tag
     */
    public int compareTo(LabelValueBean o) {
        return getLabel().compareTo(o.getLabel());
    }

    /**
     * 
     * @param obj aaa
     * @return tag
     */
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof LabelValueBean)){
            return false;
        }
        LabelValueBean other = (LabelValueBean) obj;
        if (getValue() == null && other.getValue() == null)
            return true;
        if (getValue() == null || other.getValue() == null)
            return false;
        else
            return getValue().equals(other.getValue());
    }

    public int hashCode() {
        int result = 17;
        result += value != null ? value.hashCode() : 0;
        return result;
    }

    public String toString() {
        return "[label:"+getLabel()+",value:"+getValue()+"]";
    }

    private static final long serialVersionUID = -8510820179535739532L;

    private String label;

    private Object value;
}