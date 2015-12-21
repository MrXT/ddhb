package com.manzz.framework.core.web.ztree;

/**
 * 功能：zTree简单数据类型对象
 * @author WJK
 * @version 2014-09
 */
public class SimpleZTreeData {
    private Integer id;
    private Integer pId;
    private String name;
    private boolean checked = false;
    private boolean isParent = false;

    public SimpleZTreeData() {}
    
    public SimpleZTreeData(Integer id,Integer pId,String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        if(pId == null){
            isParent = true;
        }
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getpId() {
        return pId;
    }
    
    public void setpId(Integer pId) {
        this.pId = pId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsChecked() {
        return checked;
    }

    public void setIsChecked(boolean checked) {
        this.checked = checked;
    }
    
    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

}
