package com.vothanhtai.ungdungbanhangonline.Model;

import java.io.Serializable;

public class LoaiSP implements Serializable {
    private int ID;
    private String TenloaiSP;
    private int HinhanhloaiSP;
    private String GiaLoaiSP;


    public LoaiSP() {
    }

    public LoaiSP(int ID, String tenloaiSP, int hinhanhloaiSP, String giaLoaiSP) {
        this.ID = ID;
        TenloaiSP = tenloaiSP;
        HinhanhloaiSP = hinhanhloaiSP;
        GiaLoaiSP = giaLoaiSP;
    }

    public String getGiaLoaiSP() {
        return GiaLoaiSP;
    }

    public void setGiaLoaiSP(String giaLoaiSP) {
        GiaLoaiSP = giaLoaiSP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenloaiSP() {
        return TenloaiSP;
    }

    public void setTenloaiSP(String tenloaiSP) {
        TenloaiSP = tenloaiSP;
    }

    public int getHinhanhloaiSP() {
        return HinhanhloaiSP;
    }

    public void setHinhanhloaiSP(int hinhanhloaiSP) {
        HinhanhloaiSP = hinhanhloaiSP;
    }

    @Override
    public String toString() {
        return "LoaiSP{" +
                "ID=" + ID +
                ", TenloaiSP='" + TenloaiSP + '\'' +
                ", HinhanhloaiSP='" + HinhanhloaiSP + '\'' +
                ", GiaLoaiSP='" + GiaLoaiSP + '\'' +
                '}';
    }
}
