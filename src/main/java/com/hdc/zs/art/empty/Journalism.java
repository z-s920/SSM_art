package com.hdc.zs.art.empty;

public class Journalism {
    private Integer id;
    private String title;
    private String content;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Journalism{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Journalism(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
