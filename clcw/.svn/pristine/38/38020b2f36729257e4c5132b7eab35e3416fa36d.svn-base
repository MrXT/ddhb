package com.manzz.framework.core.model;

import java.util.ArrayList;
import java.util.List;

import com.manzz.framework.core.common.Constants;

/**
 * 物理分页封装类
 * @author WJK
 * @version 2014-09
 */
public class PaginationVO<T> {

	/** 当前页的数据集合 */
    private List<T> result = new ArrayList<T>();
	/** 总页数 */
    private int pageCount = 0;
	/** 总记录数 */
    private int recordCount = 0;
    /** 当前页 */
    private int pageIndex = 0;
    /** 每页记录数 */
    private int pageSize = 0;
	
    public PaginationVO(List<T> result, int recordCount,int pageIndex,
    		int pageSize) {
    	this.result = result;
    	this.recordCount = recordCount;
    	this.pageIndex = pageIndex;
        this.pageSize = pageSize == 0 ? Constants.DEFAULT_PAGE_SIZE : pageSize;
    	this.pageCount = recordCount%this.pageSize==0?recordCount/this.pageSize:recordCount/this.pageSize+1;
    }
    
    public List<T> getResult() {
    	return result;
    }
    
    public void setResult(List<T> result) {
    	this.result = result;
    }
    
    public int getPageIndex() {
    	return pageIndex;
    }
    
    public void setPageIndex(int pageIndex) {
    	this.pageIndex = pageIndex;
    }
    
    public int getPageCount() {
    	return pageCount;
    }
    
    public void setPageCount(int pageCount) {
    	this.pageCount = pageCount;
    }
    
    public int getRecordCount() {
    	return recordCount;
    }
    
    public void setRecordCount(int recordCount) {
    	this.recordCount = recordCount;
    }
    
    public int getPageSize() {
    	return pageSize;
    }
    
    public void setPageSize(int pageSize) {
    	this.pageSize = pageSize;
    }
}
