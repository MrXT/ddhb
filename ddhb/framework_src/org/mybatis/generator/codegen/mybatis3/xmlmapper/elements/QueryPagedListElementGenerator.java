/** customize system configuration */
// add class

package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * ClassName: QueryPagedListElementGenerator <br/>
 *
 * @author ZZW
 * @version 2015年1月7日 
 */
public class QueryPagedListElementGenerator extends
        AbstractXmlElementGenerator {

//    private boolean isSimple;
    
    public QueryPagedListElementGenerator(boolean isSimple) {
        super();
//        this.isSimple = isSimple;
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select");

        answer.addAttribute(new Attribute(
                "id", introspectedTable.getQueryPagedListStatementId()));
        answer.addAttribute(new Attribute("parameterType",
                introspectedTable.getBaseRecordType()));
        answer.addAttribute(new Attribute("resultMap",
                introspectedTable.getBaseResultMapId()));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
//        sb.append("select ");
//        Iterator<IntrospectedColumn> iter;
//        if (isSimple) {
//            iter = introspectedTable.getNonPrimaryKeyColumns().iterator();
//        } else {
//            iter = introspectedTable.getAllColumns().iterator();
//        }
//        while (iter.hasNext()) {
//            
//            String columnName = MyBatis3FormattingUtilities.getEscapedColumnName(iter.next());
//            sb.append(columnName);
//
//            if (iter.hasNext()) {
//                sb.append(", ");
//            }
//            if (sb.length() > 80) {
//                answer.addElement(new TextElement(sb.toString()));
//                sb.setLength(0);
//                OutputUtilities.xmlIndent(sb, 1);
//            }
//        }
//        if(sb.length() > 0){
//            answer.addElement(new TextElement(sb.toString()));
//            sb.setLength(0);
//            OutputUtilities.xmlIndent(sb, 2);
//        }
        
        answer.addElement(new TextElement("select "));
        answer.addElement(getBaseColumnListElement());
        
        sb.append("from ");
//        answer.addElement(new TextElement(sb.toString()));
//        sb.setLength(0);
//        OutputUtilities.xmlIndent(sb, 1);
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        // include
//        answer.addElement(getCustomizeIncludeElement());
        answer.addElement(getNotFuzzyIncludeElement());
        answer.addElement(getFuzzyIncludeElement());
        // sort
        XmlElement notNullSort = new XmlElement("if");
        notNullSort.addAttribute(new Attribute("test", "sort != null"));
        notNullSort.addElement(new TextElement("ORDER BY ${sort} ${order}"));
        answer.addElement(notNullSort);
        XmlElement nullSort = new XmlElement("if");
        nullSort.addAttribute(new Attribute("test", "sort == null"));
        //nullSort.addElement(new TextElement("ORDER BY ${@needModify} ${order}"));
        nullSort.addElement(new TextElement("ORDER BY OPER_TIME DESC"));
        answer.addElement(nullSort);
        

        if (context.getPlugins()
                .sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
