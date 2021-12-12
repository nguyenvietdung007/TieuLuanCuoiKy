package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.text.ParseException;
import java.text.DecimalFormat;

public class HangDienMay extends HangHoa {
    private int congSuat;
    public HangDienMay(String tenHangHoa, String maHangHoa, double giaNhap, int soLuongTonKho, String ngayNhapKho , int congSuat) throws ParseException {
        super(tenHangHoa, maHangHoa + "-HDM", giaNhap, soLuongTonKho, ngayNhapKho);
        this.congSuat = congSuat;
    }
    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }
    public int getCongSuat() {
        return congSuat;
    }
    DecimalFormat decimalFormat1 = new DecimalFormat("### W");
    DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
    @Override
    public String toString() {
        String s;
        s = super.toString() + String.format("%-15s|%-15s|", decimalFormat1.format(getCongSuat()),decimalFormat2.format(tinhTien()));
        return s;
    }
}
