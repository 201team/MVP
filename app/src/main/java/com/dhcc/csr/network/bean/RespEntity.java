package com.dhcc.csr.network.bean;

/**
 * @Author: wlsh
 * @Date: 2019/7/30 9:47
 * @Description: 返回结果接收类
 */
public class RespEntity<T> {

    //返回状态 0 成功 1 失败
    private int status;
    //提示信息
    private String msg;
    //返回数据
    private T data;
    //分页
    private Page page;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 分页
     */
    private class Page {
        //当前页
        private int currentPageNum;
        //页长度
        private int pageSize;
        //总页数
        private int totalPageCount;
        //总记录数
        private int totalRecordCount;

        public int getCurrentPageNum() {
            return currentPageNum;
        }

        public void setCurrentPageNum(int currentPageNum) {
            this.currentPageNum = currentPageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPageCount() {
            return totalPageCount;
        }

        public void setTotalPageCount(int totalPageCount) {
            this.totalPageCount = totalPageCount;
        }

        public int getTotalRecordCount() {
            return totalRecordCount;
        }

        public void setTotalRecordCount(int totalRecordCount) {
            this.totalRecordCount = totalRecordCount;
        }
    }
}
