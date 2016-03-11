package com.stzhangjk.working.entity;

/**
 * Created by Grady on 2016.3.6.
 */
public class Article {

    private String id;

    private String titleCN;
    private String authorCN;
    private String unitCN;
    private String abstractCN;
    private String keyWordCN;

    private String titleEN;
    private String authorEN;
    private String unitEN;
    private String abstractEN;
    private String keyWordEN;

    private int startPage;
    private int endPage;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleCN() {
        return titleCN;
    }

    public void setTitleCN(String titleCN) {
        this.titleCN = titleCN;
    }

    public String getAuthorCN() {
        return authorCN;
    }

    public void setAuthorCN(String authorCN) {
        this.authorCN = authorCN;
    }

    public String getUnitCN() {
        return unitCN;
    }

    public void setUnitCN(String unitCN) {
        this.unitCN = unitCN;
    }

    public String getAbstractCN() {
        return abstractCN;
    }

    public void setAbstractCN(String abstractCN) {
        this.abstractCN = abstractCN;
    }

    public String getKeyWordCN() {
        return keyWordCN;
    }

    public void setKeyWordCN(String keyWordCN) {
        this.keyWordCN = keyWordCN;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getAuthorEN() {
        return authorEN;
    }

    public void setAuthorEN(String authorEN) {
        this.authorEN = authorEN;
    }

    public String getUnitEN() {
        return unitEN;
    }

    public void setUnitEN(String unitEN) {
        this.unitEN = unitEN;
    }

    public String getAbstractEN() {
        return abstractEN;
    }

    public void setAbstractEN(String abstractEN) {
        this.abstractEN = abstractEN;
    }

    public String getKeyWordEN() {
        return keyWordEN;
    }

    public void setKeyWordEN(String keyWordEN) {
        this.keyWordEN = keyWordEN;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +"\n"+
                ", titleCN='" + titleCN + '\'' +"\n"+
                ", authorCN='" + authorCN + '\'' +"\n"+
                ", unitCN='" + unitCN + '\'' +"\n"+
                ", abstractCN='" + abstractCN + '\'' +"\n"+
                ", keyWordCN='" + keyWordCN + '\'' +"\n"+
                ", titleEN='" + titleEN + '\'' +"\n"+
                ", authorEN='" + authorEN + '\'' +"\n"+
                ", unitEN='" + unitEN + '\'' +"\n"+
                ", abstractEN='" + abstractEN + '\'' +"\n"+
                ", keyWordEN='" + keyWordEN + '\'' +"\n"+
                '}';
    }
}
