
package com.example.aiiti.madprice.Shopkeeper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShopkeeperDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sname")
    @Expose
    private String sname;
    @SerializedName("semail")
    @Expose
    private String semail;
    @SerializedName("spassword")
    @Expose
    private String spassword;
    @SerializedName("slocation")
    @Expose
    private String slocation;
    @SerializedName("sshopname")
    @Expose
    private String sshopname;
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public String getSshopname() {
        return sshopname;
    }

    public void setSshopname(String sshopname) {
        this.sshopname = sshopname;
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
