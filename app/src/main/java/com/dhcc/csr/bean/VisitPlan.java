package com.dhcc.csr.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: wlsh
 * @Date: 2019/7/31 17:03
 * @Description: 参观安排
 */
public class VisitPlan implements Parcelable {
    private Long id;                //主键ID
    private String orderCode;        //参观申请单号
    private String startTime;        //开始时间
    private String endTime;            //结束时间
    private String lineCode;        //参观路线编码
    private String lineName;        //参观路线名称
    private String lineDetailName;    //参观路线详情
    private String lineDetailCode;    //参观路线详情编码
    private String narrator;        //解说人
    private String narratorCode;    //解说人工号
    private String createTime;        //创建时间
    private String factoryTypeName;        //厂区类型名称
    private String factoryTypeCode;        //厂区类型编码

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineDetailName() {
        return lineDetailName;
    }

    public void setLineDetailName(String lineDetailName) {
        this.lineDetailName = lineDetailName;
    }

    public String getLineDetailCode() {
        return lineDetailCode;
    }

    public void setLineDetailCode(String lineDetailCode) {
        this.lineDetailCode = lineDetailCode;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public String getNarratorCode() {
        return narratorCode;
    }

    public void setNarratorCode(String narratorCode) {
        this.narratorCode = narratorCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFactoryTypeName() {
        return factoryTypeName;
    }

    public void setFactoryTypeName(String factoryTypeName) {
        this.factoryTypeName = factoryTypeName;
    }

    public String getFactoryTypeCode() {
        return factoryTypeCode;
    }

    public void setFactoryTypeCode(String factoryTypeCode) {
        this.factoryTypeCode = factoryTypeCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.orderCode);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.lineCode);
        dest.writeString(this.lineName);
        dest.writeString(this.lineDetailName);
        dest.writeString(this.lineDetailCode);
        dest.writeString(this.narrator);
        dest.writeString(this.narratorCode);
        dest.writeString(this.createTime);
        dest.writeString(this.factoryTypeName);
        dest.writeString(this.factoryTypeCode);
    }

    public VisitPlan() {
    }

    protected VisitPlan(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.orderCode = in.readString();
        this.startTime = in.readString();
        this.endTime = in.readString();
        this.lineCode = in.readString();
        this.lineName = in.readString();
        this.lineDetailName = in.readString();
        this.lineDetailCode = in.readString();
        this.narrator = in.readString();
        this.narratorCode = in.readString();
        this.createTime = in.readString();
        this.factoryTypeName = in.readString();
        this.factoryTypeCode = in.readString();
    }

    public static final Parcelable.Creator<VisitPlan> CREATOR = new Parcelable.Creator<VisitPlan>() {
        @Override
        public VisitPlan createFromParcel(Parcel source) {
            return new VisitPlan(source);
        }

        @Override
        public VisitPlan[] newArray(int size) {
            return new VisitPlan[size];
        }
    };
}
