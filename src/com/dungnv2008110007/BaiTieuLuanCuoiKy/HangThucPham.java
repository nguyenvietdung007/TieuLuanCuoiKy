package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.util.Date;
import java.text.ParseException;
import java.text.DecimalFormat;

public class HangThucPham extends HangHoa {
    private Date ngayHetHan;
    public HangThucPham(String tenHangHoa, String maHangHoa, double giaNhap, int soLuongTonKho, String ngayNhapKho , String ngayHetHan) throws ParseException {
        super(tenHangHoa, maHangHoa + "-HTP", giaNhap, soLuongTonKho, ngayNhapKho);
        this.ngayHetHan = doiChuoiThanhNgay(ngayHetHan);
    }
    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    DecimalFormat decimalFormat = new DecimalFormat("###,### VND");
    @Override
    public String toString() {
        String s ;
        s = super.toString() + String.format( "%-15s|%-15s|", doiNgayThanhChuoi(getNgayHetHan()) , decimalFormat.format(tinhTien()));
        return s;
    }
}
