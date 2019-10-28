package org.ct.bean;

public class Page {
    //当前页数
    private Integer pageCurrent;
    //每页数量
    private Integer pageNumber;
    //总页数
    private Integer pageTotal;
    //总条数
    private Integer totalCount;

    public Page() {
        this.pageCurrent = 0;
        this.pageNumber = 5;
    }

    private void count() {
        int i = (int) Math.ceil(1.0 * this.totalCount / this.pageNumber);
        this.pageTotal = i;
        if (this.pageCurrent <= 0) {
            this.pageCurrent = 0;
        }
        if (this.pageCurrent >= this.pageTotal && this.pageCurrent != 0) {
            this.pageCurrent = this.pageTotal - 1;
        }
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.count();
    }
}
