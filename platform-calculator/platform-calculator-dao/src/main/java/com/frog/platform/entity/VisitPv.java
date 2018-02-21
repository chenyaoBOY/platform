package com.frog.platform.entity;

import java.io.Serializable;
import java.util.Date;

public class VisitPv implements Serializable {
    private String id;

    private Long dayVisit;

    private Date date;

    private String pageName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getDayVisit() {
        return dayVisit;
    }

    public void setDayVisit(Long dayVisit) {
        this.dayVisit = dayVisit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }
}