package cn.gjp0609.ems_v2.entity;

/**
 * Created by gjp06 on 17.4.12.
 */
public class Page {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalRows;
    private Integer totalPages;

    /**
     * @return 当前页第一行行数
     */
    public int getFirstRow() {
        return pageSize * (pageIndex - 1) + 1;
    }

    /**
     * @return 当前页最后一行行数
     */
    public int getLastRow() {
        return pageSize * pageIndex;
    }

    public boolean hasNextPage() {
        return pageIndex < totalPages;
    }

    public boolean hasPrePages() {
        return pageIndex > 1;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    /**
     * 查询到总行数后要计算总页面数
     *
     * @param totalRows 所查询表的总行数
     */
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
        int k = totalRows % pageSize;
        if (k == 0) totalPages = totalRows / pageSize;
        else totalPages = totalRows / pageSize + 1;
//        this.totalPages = totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
