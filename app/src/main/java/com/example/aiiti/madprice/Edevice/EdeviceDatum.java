
package com.example.aiiti.madprice.Edevice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EdeviceDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("dname")
    @Expose
    private String dname;
    @SerializedName("dprice")
    @Expose
    private String dprice;
    @SerializedName("dtype")
    @Expose
    private String dtype;
    @SerializedName("dcondition")
    @Expose
    private String dcondition;
    @SerializedName("dstock")
    @Expose
    private String dstock;
    @SerializedName("Dusertag")
    @Expose
    private String dusertag;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDprice() {
        return dprice;
    }

    public void setDprice(String dprice) {
        this.dprice = dprice;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDcondition() {
        return dcondition;
    }

    public void setDcondition(String dcondition) {
        this.dcondition = dcondition;
    }

    public String getDstock() {
        return dstock;
    }

    public void setDstock(String dstock) {
        this.dstock = dstock;
    }

    public String getDusertag() {
        return dusertag;
    }

    public void setDusertag(String dusertag) {
        this.dusertag = dusertag;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

}
