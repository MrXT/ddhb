/*
 *  Copyright 2006 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.api.dom.java;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.dom.OutputUtilities;

/**
 * @author Jeff Butler
 */
public class Field extends JavaElement {
    private FullyQualifiedJavaType type;
    private String name;
    private String initializationString;
    private boolean isTransient;
    private boolean isVolatile;
    /** customize system configuration */
    // add
    private FullyQualifiedJavaType idKeyType;

    /**
     *  
     */
    public Field() {
        // use a default name to avoid NPE
        this("foo", FullyQualifiedJavaType.getIntInstance()); //$NON-NLS-1$
    }
    
    public Field(String name, FullyQualifiedJavaType type) {
        super();
        this.name = name;
        this.type = type;
    }
    
    public Field(Field field) {
        super(field);
        this.type = field.type;
        this.name = field.name;
        this.initializationString = field.initializationString;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the type.
     */
    public FullyQualifiedJavaType getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(FullyQualifiedJavaType type) {
        this.type = type;
    }

    /**
     * @return Returns the initializationString.
     */
    public String getInitializationString() {
        return initializationString;
    }

    /**
     * @param initializationString
     *            The initializationString to set.
     */
    public void setInitializationString(String initializationString) {
        this.initializationString = initializationString;
    }

    public String getFormattedContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();

        addFormattedJavadoc(sb, indentLevel);
        addFormattedAnnotations(sb, indentLevel);

        OutputUtilities.javaIndent(sb, indentLevel);
        sb.append(getVisibility().getValue());

        if (isStatic()) {
            sb.append("static "); //$NON-NLS-1$
        }

        if (isFinal()) {
            sb.append("final "); //$NON-NLS-1$
        }

        if (isTransient()) {
            sb.append("transient "); //$NON-NLS-1$
        }
        
        if (isVolatile()) {
            sb.append("volatile "); //$NON-NLS-1$
        }
        
        sb.append(type.getShortName());

        sb.append(' ');
        sb.append(name);

        if (initializationString != null && initializationString.length() > 0) {
            sb.append(" = "); //$NON-NLS-1$
            sb.append(initializationString);
        }

        sb.append(';');

        return sb.toString();
    }
    
    /** customize system configuration */
    // add
    public void addDefaultIdKeyAnnotation(){
        idKeyType = new FullyQualifiedJavaType("com.manzz.framework.core.annotation.IdKey");
        addAnnotation("@" + getIdKeyType().getShortName());
    }
    // add
    public List<FullyQualifiedJavaType> getAnnotationTypeList(){
        List<FullyQualifiedJavaType> list = new ArrayList<FullyQualifiedJavaType>();
        list.add(getIdKeyType());
        return list;
    }

    public boolean isTransient() {
        return isTransient;
    }

    public void setTransient(boolean isTransient) {
        this.isTransient = isTransient;
    }

    public boolean isVolatile() {
        return isVolatile;
    }

    public void setVolatile(boolean isVolatile) {
        this.isVolatile = isVolatile;
    }

    /** customize system configuration */
    // add
    public FullyQualifiedJavaType getIdKeyType()
    {
        return idKeyType;
    }

    public void setIdKeyType(FullyQualifiedJavaType idKeyType)
    {
        this.idKeyType = idKeyType;
    }
}
