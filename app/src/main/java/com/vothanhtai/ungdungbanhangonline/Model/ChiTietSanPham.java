package com.vothanhtai.ungdungbanhangonline.Model;

import java.io.Serializable;

public class ChiTietSanPham implements Serializable {
    private String Detail_TenSP;
    private int Detail_Hinhanh;
    private String Detail_GiaSP;
    private String Detail_Description;
    private String Detail_Size;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String detail_TenSP, int detail_Hinhanh, String detail_GiaSP, String detail_Description, String detail_Size) {
        Detail_TenSP = detail_TenSP;
        Detail_Hinhanh = detail_Hinhanh;
        Detail_GiaSP = detail_GiaSP;
        Detail_Description = detail_Description;
        Detail_Size = detail_Size;
    }

    public String getDetail_TenSP() {
        return Detail_TenSP;
    }

    public void setDetail_TenSP(String detail_TenSP) {
        Detail_TenSP = detail_TenSP;
    }

    public int getDetail_Hinhanh() {
        return Detail_Hinhanh;
    }

    public void setDetail_Hinhanh(int detail_Hinhanh) {
        Detail_Hinhanh = detail_Hinhanh;
    }

    public String getDetail_GiaSP() {
        return Detail_GiaSP;
    }

    public void setDetail_GiaSP(String detail_GiaSP) {
        Detail_GiaSP = detail_GiaSP;
    }

    public String getDetail_Description() {
        return Detail_Description;
    }

    public void setDetail_Description(String detail_Description) {
        Detail_Description = detail_Description;
    }

    public String getDetail_Size() {
        return Detail_Size;
    }

    public void setDetail_Size(String detail_Size) {
        Detail_Size = detail_Size;
    }


    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "Detail_TenSP='" + Detail_TenSP + '\'' +
                ", Detail_Hinhanh=" + Detail_Hinhanh +
                ", Detail_GiaSP='" + Detail_GiaSP + '\'' +
                ", Detail_Description='" + Detail_Description + '\'' +
                ", Detail_Size='" + Detail_Size + '\'' +
                '}';
    }
}
