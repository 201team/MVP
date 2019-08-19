package com.dhcc.csr.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @Author: wlsh
 * @Date: 2019/7/31 17:05
 * @Description: 来宾参观列表对象
 */
public class VisitObject implements Parcelable {
    private VisitApply visitApply;
    private ArrayList<VisitPlan> visitPlans;

    public VisitApply getVisitApply() {
        return visitApply;
    }

    public void setVisitApply(VisitApply visitApply) {
        this.visitApply = visitApply;
    }

    public ArrayList<VisitPlan> getVisitPlans() {
        return visitPlans;
    }

    public void setVisitPlans(ArrayList<VisitPlan> visitPlans) {
        this.visitPlans = visitPlans;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.visitApply, flags);
        dest.writeTypedList(this.visitPlans);
    }

    public VisitObject() {
    }

    protected VisitObject(Parcel in) {
        this.visitApply = in.readParcelable(VisitApply.class.getClassLoader());
        this.visitPlans = in.createTypedArrayList(VisitPlan.CREATOR);
    }

    public static final Parcelable.Creator<VisitObject> CREATOR = new Parcelable.Creator<VisitObject>() {
        @Override
        public VisitObject createFromParcel(Parcel source) {
            return new VisitObject(source);
        }

        @Override
        public VisitObject[] newArray(int size) {
            return new VisitObject[size];
        }
    };
}
