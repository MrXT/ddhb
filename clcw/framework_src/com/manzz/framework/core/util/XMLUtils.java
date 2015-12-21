/**
 * Project Name:DTDP
 * File Name:XMLUtils.java
 * Package Name:com.manzz.utils
 * Date:2015年1月26日下午7:09:35
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * ClassName: XMLUtils <br/>
 * Function: xml解析工具
 *
 * @author ZZW
 * @version 2015年1月26日 
 */
public class XMLUtils
{
    public static String getText(String xml, String node) throws DocumentException{
        String result = "";
        if(CommonUtils.allNotEmpty(xml, node)){
            Document document = DocumentHelper.parseText(xml);
            List<?> nodes = document.selectNodes(node);
            if(CollectionUtils.isNotEmpty(nodes)){
                Element selected = (Element) nodes.get(0);
                return selected.getText();
            }
        }
        return result;
        
    }
}

