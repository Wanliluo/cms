package com.cms.common.util;

/**
 * Created with IntelliJ IDEA.
 * Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pagination {
    private Object content;
    private int currentPage = 1;
    private int recordCount;
    private int pageCount;
    private int pageSize;
    private int currentFristPosition;
    private List<Integer> pageList;
    private int firstPage;
    private int prevPage;
    private int nextPage;
    private int lastPage;

    public Pagination(int recordCount, int pageSize, int currentPage) {
        this.recordCount = recordCount;
        this.pageSize = pageSize;
        this.pageCount = this.calculatePageCount();
        this.currentPage = this.calculateCurrentPage(currentPage);
        this.pageList = this.calculatePageList();
        this.currentFristPosition = this.calculateRecordPosition();
        this.content = new Object();
    }

    public int calculatePageCount() {
        boolean pageCount = true;
        int pageCount1;
        if(this.recordCount % this.pageSize == 0) {
            pageCount1 = this.recordCount / this.pageSize;
        } else {
            pageCount1 = this.recordCount / this.pageSize + 1;
        }

        pageCount1 = pageCount1 < 1?1:pageCount1;
        return pageCount1;
    }

    public int calculateRecordPosition() {
        return (this.currentPage - 1) * this.pageSize;
    }

    private int calculateCurrentPage(int currentPage) {
        if(currentPage < 1) {
            currentPage = 1;
        } else if(currentPage > this.pageCount) {
            currentPage = this.pageCount;
        }

        return currentPage;
    }

    private List<Integer> calculatePageList() {
        Object pageTmpList = new ArrayList();
        int i;
        if(this.pageCount < 7) {
            for(i = 0; i < this.pageCount; ++i) {
                ((List)pageTmpList).add(Integer.valueOf(i + 1));
            }
        } else if(this.currentPage < 4) {
            pageTmpList = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7)});
        } else if(this.currentPage > this.pageCount - 4) {
            for(i = this.pageCount - 6; i < this.pageCount + 1; ++i) {
                ((List)pageTmpList).add(Integer.valueOf(i));
            }
        } else {
            pageTmpList = Arrays.asList(new Integer[]{Integer.valueOf(this.currentPage - 3), Integer.valueOf(this.currentPage - 2), Integer.valueOf(this.currentPage - 1), Integer.valueOf(this.currentPage), Integer.valueOf(this.currentPage + 1), Integer.valueOf(this.currentPage + 2), Integer.valueOf(this.currentPage + 3)});
        }

        return (List)pageTmpList;
    }

    public int getFirstPage() {
        return 1;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrevPage() {
        return this.currentPage > 1?this.currentPage - 1:1;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return this.currentPage < this.pageCount?this.currentPage + 1:this.pageCount;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return this.pageCount;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<Integer> getPageList() {
        return this.pageList;
    }

    public int getRecordCount() {
        return this.recordCount;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getCurrentFristPosition() {
        return this.currentFristPosition;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public void setCurrentFristPosition(int currentFristPosition) {
        this.currentFristPosition = currentFristPosition;
    }

    public int getCurrentLastPosition() {
        int curreentLast = this.currentFristPosition + this.pageSize;
        return curreentLast > this.recordCount?this.recordCount:curreentLast;
    }
}
