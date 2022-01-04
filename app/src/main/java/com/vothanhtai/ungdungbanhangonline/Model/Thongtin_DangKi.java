package com.vothanhtai.ungdungbanhangonline.Model;

public class Thongtin_DangKi {
    String ten,hovaten, SDT, diachi, matkhau,nhaplaimatkhau,email;

    public Thongtin_DangKi() {
    }

    public Thongtin_DangKi(String ten, String hovaten, String SDT, String diachi, String matkhau, String nhaplaimatkhau, String email) {
        this.ten = ten;
        this.hovaten = hovaten;
        this.SDT = SDT;
        this.diachi = diachi;
        this.matkhau = matkhau;
        this.nhaplaimatkhau = nhaplaimatkhau;
        this.email = email;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNhaplaimatkhau() {
        return nhaplaimatkhau;
    }

    public void setNhaplaimatkhau(String nhaplaimatkhau) {
        this.nhaplaimatkhau = nhaplaimatkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Thongtin_DangKi{" +
                "ten='" + ten + '\'' +
                ", hovaten='" + hovaten + '\'' +
                ", SDT='" + SDT + '\'' +
                ", diachi='" + diachi + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", nhaplaimatkhau='" + nhaplaimatkhau + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
