package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.util.Date;
import java.text.ParseException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public abstract class HangHoa {
    private String tenHangHoa;
    private String maHangHoa;
    private double giaNhap;
    private int soLuongTonKho;
    private Date ngayNhapKho;
    public HangHoa(String tenHangHoa, String maHangHoa, double giaNhap, int soLuongTonKho, String ngayNhapKho) throws ParseException {
        this.tenHangHoa = tenHangHoa ;
        this.maHangHoa = maHangHoa;
        this.giaNhap = giaNhap ;
        this.soLuongTonKho = soLuongTonKho;
        this.ngayNhapKho = doiChuoiThanhNgay(ngayNhapKho);       
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    } 
    public String getTenHangHoa() {
        return tenHangHoa;
    }
    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }
    public String getMaHangHoa() {
        return maHangHoa;
    }
    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }
    public double getGiaNhap() {
        return giaNhap;
    }
    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }
    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public static Date doiChuoiThanhNgay(String chuoiNgay) throws ParseException{
        /*
        + ngày tháng năm theo giờ Việt Nam
         - dd: ngày
         - mm: tháng
         - yyyy: năm
        */
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }
	public static String doiNgayThanhChuoi(Date date){
        String chuoiNgay = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        chuoiNgay = simpleDateFormat.format(date);
        return chuoiNgay;
    }
    public double tinhTien(){
        return getGiaNhap() * getSoLuongTonKho();
    }
    DecimalFormat decimalFormat = new DecimalFormat("###,### VND");
    public String toString() {
		String s = "";
		s += String.format("|%-25s|%-8s|%-15s|%-8s|%-15s|", getTenHangHoa(),getMaHangHoa(),decimalFormat.format(getGiaNhap()),getSoLuongTonKho(),doiNgayThanhChuoi(getNgayNhapKho()));
		return s;
	}   
}

