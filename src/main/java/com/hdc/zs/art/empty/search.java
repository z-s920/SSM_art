package com.hdc.zs.art.empty;

public class search {
    private int page;
    private int limit;
    private String search;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "search{" +
                "page=" + page +
                ", limit=" + limit +
                ", search='" + search + '\'' +
                '}';
    }

    public search(int page, int limit, String search) {
        this.page = page;
        this.limit = limit;
        this.search = search;
    }

    public search(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }
}
