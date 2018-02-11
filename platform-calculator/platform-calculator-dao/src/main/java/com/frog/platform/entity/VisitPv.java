package com.frog.platform.entity;

import java.io.Serializable;
import java.util.Date;

public class VisitPv implements Serializable {
    private String id;

    private Long dayVisit;

    private Date dateVisit;

    private Long totalVisit;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private String extend6;

    private String extend7;

    private String extend8;

    private String extend9;

    private String extend10;

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

    public Date getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(Date dateVisit) {
        this.dateVisit = dateVisit;
    }

    public Long getTotalVisit() {
        return totalVisit;
    }

    public void setTotalVisit(Long totalVisit) {
        this.totalVisit = totalVisit;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4 == null ? null : extend4.trim();
    }

    public String getExtend5() {
        return extend5;
    }

    public void setExtend5(String extend5) {
        this.extend5 = extend5 == null ? null : extend5.trim();
    }

    public String getExtend6() {
        return extend6;
    }

    public void setExtend6(String extend6) {
        this.extend6 = extend6 == null ? null : extend6.trim();
    }

    public String getExtend7() {
        return extend7;
    }

    public void setExtend7(String extend7) {
        this.extend7 = extend7 == null ? null : extend7.trim();
    }

    public String getExtend8() {
        return extend8;
    }

    public void setExtend8(String extend8) {
        this.extend8 = extend8 == null ? null : extend8.trim();
    }

    public String getExtend9() {
        return extend9;
    }

    public void setExtend9(String extend9) {
        this.extend9 = extend9 == null ? null : extend9.trim();
    }

    public String getExtend10() {
        return extend10;
    }

    public void setExtend10(String extend10) {


        this.extend10 = extend10 == null ? null : extend10.trim();
    }

    @Override
    public String toString() {
        return "VisitPv{" +
                "id='" + id + '\'' +
                ", dayVisit=" + dayVisit +
                ", dateVisit=" + dateVisit +
                ", totalVisit=" + totalVisit +
                ", extend1='" + extend1 + '\'' +
                ", extend2='" + extend2 + '\'' +
                ", extend3='" + extend3 + '\'' +
                ", extend4='" + extend4 + '\'' +
                ", extend5='" + extend5 + '\'' +
                ", extend6='" + extend6 + '\'' +
                ", extend7='" + extend7 + '\'' +
                ", extend8='" + extend8 + '\'' +
                ", extend9='" + extend9 + '\'' +
                ", extend10='" + extend10 + '\'' +
                '}';
    }
}