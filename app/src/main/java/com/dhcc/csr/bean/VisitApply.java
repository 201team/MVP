package com.dhcc.csr.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: wlsh
 * @Date: 2019/7/31 17:02
 * @Description: 来宾参观
 */
public class VisitApply implements Parcelable {
    private Long id;                //主键ID
    private String orderCode;        //申请单号
    private String createTime;        //创建时间
    private String applyTime;        //申请时间
    private String applyDeptName;   //申请单位名称
    private String applyDeptCode;   //申请单位编码
    private String applyPname;      //申请人姓名
    private String applyPcode;      //申请人编码
    private String phone;           //申请人电话
    private String guest;           //来宾单位名称
    private String guestNumber;     //来宾单位人数
    private String visitTime;        //参观时间
    private String visitSite;        //参观地点
    private String escortName;        //陪同人员姓名
    private String escortCode;        //陪同人员编码
    private String escortNumber;    //陪同人员人数
    private String leader;          //批准领导姓名
    private String leaderCode;      //批准领导编码
    private String cooperateDeptName;  //配合部门名称
    private String cooperateDeptCode;   //配合部门编码
    private String secret;               //是否保密(1-保密，2-非保密)
    private String secretTime;           //勾选保密协议的时间
    private String title;                // 标题
    private String type;                 // 单据类型 23
    private String processid;            // 流程ID
    private String status;               // 状态

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getApplyDeptCode() {
        return applyDeptCode;
    }

    public void setApplyDeptCode(String applyDeptCode) {
        this.applyDeptCode = applyDeptCode;
    }

    public String getApplyPname() {
        return applyPname;
    }

    public void setApplyPname(String applyPname) {
        this.applyPname = applyPname;
    }

    public String getApplyPcode() {
        return applyPcode;
    }

    public void setApplyPcode(String applyPcode) {
        this.applyPcode = applyPcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(String guestNumber) {
        this.guestNumber = guestNumber;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitSite() {
        return visitSite;
    }

    public void setVisitSite(String visitSite) {
        this.visitSite = visitSite;
    }

    public String getEscortName() {
        return escortName;
    }

    public void setEscortName(String escortName) {
        this.escortName = escortName;
    }

    public String getEscortCode() {
        return escortCode;
    }

    public void setEscortCode(String escortCode) {
        this.escortCode = escortCode;
    }

    public String getEscortNumber() {
        return escortNumber;
    }

    public void setEscortNumber(String escortNumber) {
        this.escortNumber = escortNumber;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    public String getCooperateDeptName() {
        return cooperateDeptName;
    }

    public void setCooperateDeptName(String cooperateDeptName) {
        this.cooperateDeptName = cooperateDeptName;
    }

    public String getCooperateDeptCode() {
        return cooperateDeptCode;
    }

    public void setCooperateDeptCode(String cooperateDeptCode) {
        this.cooperateDeptCode = cooperateDeptCode;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecretTime() {
        return secretTime;
    }

    public void setSecretTime(String secretTime) {
        this.secretTime = secretTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.orderCode);
        dest.writeString(this.createTime);
        dest.writeString(this.applyTime);
        dest.writeString(this.applyDeptName);
        dest.writeString(this.applyDeptCode);
        dest.writeString(this.applyPname);
        dest.writeString(this.applyPcode);
        dest.writeString(this.phone);
        dest.writeString(this.guest);
        dest.writeString(this.guestNumber);
        dest.writeString(this.visitTime);
        dest.writeString(this.visitSite);
        dest.writeString(this.escortName);
        dest.writeString(this.escortCode);
        dest.writeString(this.escortNumber);
        dest.writeString(this.leader);
        dest.writeString(this.leaderCode);
        dest.writeString(this.cooperateDeptName);
        dest.writeString(this.cooperateDeptCode);
        dest.writeString(this.secret);
        dest.writeString(this.secretTime);
        dest.writeString(this.title);
        dest.writeString(this.type);
        dest.writeString(this.processid);
        dest.writeString(this.status);
    }

    public VisitApply() {
    }

    protected VisitApply(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.orderCode = in.readString();
        this.createTime = in.readString();
        this.applyTime = in.readString();
        this.applyDeptName = in.readString();
        this.applyDeptCode = in.readString();
        this.applyPname = in.readString();
        this.applyPcode = in.readString();
        this.phone = in.readString();
        this.guest = in.readString();
        this.guestNumber = in.readString();
        this.visitTime = in.readString();
        this.visitSite = in.readString();
        this.escortName = in.readString();
        this.escortCode = in.readString();
        this.escortNumber = in.readString();
        this.leader = in.readString();
        this.leaderCode = in.readString();
        this.cooperateDeptName = in.readString();
        this.cooperateDeptCode = in.readString();
        this.secret = in.readString();
        this.secretTime = in.readString();
        this.title = in.readString();
        this.type = in.readString();
        this.processid = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<VisitApply> CREATOR = new Parcelable.Creator<VisitApply>() {
        @Override
        public VisitApply createFromParcel(Parcel source) {
            return new VisitApply(source);
        }

        @Override
        public VisitApply[] newArray(int size) {
            return new VisitApply[size];
        }
    };
}
