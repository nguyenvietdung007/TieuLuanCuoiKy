package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.text.ParseException;
import java.text.DecimalFormat;

public class HangSanhSu extends HangHoa {
    private String xuatXu;
    public HangSanhSu(String tenHangHoa, String maHangHoa, double giaNhap, int soLuongTonKho, String ngayNhapKho ,String xuatXu) throws ParseException {
        super(tenHangHoa, maHangHoa + "-HSS", giaNhap, soLuongTonKho, ngayNhapKho);
        this.xuatXu = xuatXu;
    }
    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    public String getXuatXu() {
        return xuatXu;
    }
    DecimalFormat decimalFormat = new DecimalFormat("###,### VND");
    @Override
    public String toString() {
        String s;
        s = super.toString() + String.format("%-15s|%-15s|",getXuatXu(),decimalFormat.format(tinhTien()));
        return s;
    }
}
