package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.util.Date;
import java.text.ParseException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachQuanLy {
    //private static final int Comparator = 0;
    private ArrayList<HangHoa> list;
    private Scanner scanner = new Scanner(System.in);
    DanhSachQuanLy(){
        list = new ArrayList<>();
    }
    public void setList(ArrayList<HangHoa> list) {
        this.list = list;
    }
    public ArrayList<HangHoa> getList() {
        return list;
    }
    //chức năng thêm hàng hóa trực tiếp
    public void addHangHoaTrucTiep(HangHoa h) throws ParseException{
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            HangHoa hH = list.get(i);
            if(hH.getMaHangHoa().equalsIgnoreCase(h.getMaHangHoa()) || hH.getMaHangHoa().equalsIgnoreCase("-HTP") || hH.getMaHangHoa().equalsIgnoreCase("-HSS") || hH.getMaHangHoa().equalsIgnoreCase("-HDM") ){
                System.out.println("Ma hang hoa bi trung. Vui long nhap lai !!!");
                count++ ;
                addHangHoa();
                break;
            }
        }
        if(count == 0){
            list.add(h);
        }
    }
    //chức năng thêm hàng hóa bằng dữ liệu được nhập vào từ bàn phím
    public void addHangHoa() throws ParseException {
        int luaChon;
        do{
            System.out.println("======MENU=======");
            System.out.println("1.Hang thuc pham.");
            System.out.println("2.Hang sanh su.");
            System.out.println("3.Hang dien may.");
		    System.out.println("0.Quay lai.");
            System.out.println("======END========");
            System.out.print("Nhap lua chon cua ban: ");
    	    luaChon = scanner.nextInt();
            switch(luaChon){
                case 1: //hàng thực phẩm
				        nhapHangThucPham();
                        break;         
			    case 2: //hàng sành sứ
                        nhapHangSanhSu();
                        break;
			    case 3: //hàng điện máy
                        nhapHangDienMay();
                        break;
                case 0: System.out.println("Quay lai."); break;
			    default: System.out.println("Khong hop le. Vui long nhap lai !!!");
            }
        } while (luaChon != 0);
	}
    public void nhapHangThucPham() throws ParseException{
        String tenHH, maHH, ngayNK;
        double giaNhap;
        int soLuongTonKho;
        System.out.println("\n(((NHAP THONG TIN HANG THUC PHAM)))");
        System.out.print("Nhap ten hang hoa: ");
		scanner.nextLine();
		tenHH = scanner.nextLine();
		System.out.print("Nhap ma hang hoa: ");
		maHH = scanner.nextLine();
        System.out.print("Nhap gia nhap (VND): ");
		giaNhap = scanner.nextDouble();	
		System.out.print("Nhap so luong ton kho: ");
		soLuongTonKho = scanner.nextInt();			
		System.out.print("Nhap ngay nhap kho: ");
        scanner.nextLine();
		ngayNK = scanner.nextLine();
        System.out.print("Nhap ngay het han: ");
		String ngayHH = scanner.nextLine();
		HangHoa h = new HangThucPham( tenHH, maHH, giaNhap, soLuongTonKho, ngayNK, ngayHH);
		addHangHoaTrucTiep(h);
    }
    public void nhapHangSanhSu() throws ParseException{
        String tenHH, maHH, ngayNK;
        double giaNhap;
        int soLuongTonKho;
        System.out.println("\n(((NHAP THONG TIN HANG SANH SU)))");
        System.out.print("Nhap ten hang hoa: ");
		scanner.nextLine();
		tenHH = scanner.nextLine();
		System.out.print("Nhap ma hang hoa: ");
		maHH = scanner.nextLine();
        System.out.print("Nhap gia nhap (VND): ");
		giaNhap = scanner.nextDouble();	
		System.out.print("Nhap so luong ton kho: ");
		soLuongTonKho = scanner.nextInt();			
		System.out.print("Nhap ngay nhap kho: ");
        scanner.nextLine();
		ngayNK = scanner.nextLine();
        System.out.print("Nhap xuat xu: ");
		String xuatXu = scanner.nextLine();
		HangHoa h = new HangThucPham( tenHH, maHH, giaNhap, soLuongTonKho, ngayNK, xuatXu);
		addHangHoaTrucTiep(h);
    }
    public void nhapHangDienMay() throws ParseException {
        String tenHH, maHH, ngayNK;
        double giaNhap;
        int soLuongTonKho;
        System.out.println("\n(((NHAP THONG TIN HANG DIEN MAY)))");
        System.out.print("Nhap ten hang hoa: ");
		scanner.nextLine();
		tenHH = scanner.nextLine();
		System.out.print("Nhap ma hang hoa: ");
		maHH = scanner.nextLine();
        System.out.print("Nhap gia nhap (VND): ");
		giaNhap = scanner.nextDouble();	
		System.out.print("Nhap so luong ton kho: ");
		soLuongTonKho = scanner.nextInt();			
		System.out.print("Nhap ngay nhap kho: ");
        scanner.nextLine();
		ngayNK = scanner.nextLine();
        System.out.print("Nhap cong suat cua thiet bi: ");
        int congSuat = scanner.nextInt();
		HangHoa h = new HangDienMay(tenHH, maHH, giaNhap, soLuongTonKho, ngayNK, congSuat) ;
		addHangHoaTrucTiep(h);
    }
    //chức năng sửa hàng hóa theo mã của 1 hàng hóa bất kỳ 
    public void suaHangHoa() throws ParseException{
        String tenHH, ngayNK;
        double giaNhap;
        int soLuongTonKho;
        int dem = 0;
        System.out.print("Nhap ma hang hoa cua loai hang ma ban muon sua: ");
        String maHH = scanner.nextLine();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h.getMaHangHoa().equals(maHH)){
                dem++;
                if(h instanceof HangThucPham){
                    String[] maH = maHH.split("-",2);
                    System.out.println("\n(((NHAP THONG TIN HANG THUC PHAM)))");
                    System.out.print("Nhap ten hang hoa: ");
                    tenHH = scanner.nextLine();
                    System.out.print("Nhap gia nhap (VND): ");
                    giaNhap = scanner.nextDouble();	
                    System.out.print("Nhap so luong ton kho: ");
                    soLuongTonKho = scanner.nextInt();			
                    System.out.print("Nhap ngay nhap kho: ");
                    scanner.nextLine();
                    ngayNK = scanner.nextLine();
                    System.out.print("Nhap ngay het han: ");
                    String ngayHH = scanner.nextLine();
                    HangHoa a = new HangThucPham( tenHH, maH[0], giaNhap, soLuongTonKho, ngayNK, ngayHH);
                    list.add(list.indexOf(h),a);
                    list.remove(h);
                }
                else if(h instanceof HangSanhSu){
                    String[] maH = maHH.split("-",2);
                    System.out.println("\n(((NHAP THONG TIN HANG SANH SU)))"); 
                    System.out.print("Nhap ten hang hoa: ");
                    tenHH = scanner.nextLine();
                    System.out.print("Nhap gia nhap (VND): ");
                    giaNhap = scanner.nextDouble();	
                    System.out.print("Nhap so luong ton kho: ");
                    soLuongTonKho = scanner.nextInt();			
                    System.out.print("Nhap ngay nhap kho: ");
                    scanner.nextLine();
                    ngayNK = scanner.nextLine();
                    System.out.print("Nhap xuat xu: ");
                    String xuatXu = scanner.nextLine();
                    HangHoa a = new HangSanhSu(tenHH, maH[0], giaNhap, soLuongTonKho, ngayNK, xuatXu);
                    list.add(list.indexOf(h),a);
                    list.remove(h);
                }
                else if(h instanceof HangDienMay){
                    String[] maH = maHH.split("-",2);
                    System.out.println("\n(((NHAP THONG TIN HANG DIEN MAY)))");
                    System.out.print("Nhap ten hang hoa: ");
                    tenHH = scanner.nextLine();
                    System.out.print("Nhap gia nhap (VND): ");
                    giaNhap = scanner.nextDouble();	
                    System.out.print("Nhap so luong ton kho: ");
                    soLuongTonKho = scanner.nextInt();			
                    System.out.print("Nhap ngay nhap kho: ");
                    scanner.nextLine();
                    ngayNK = scanner.nextLine();
                    System.out.print("Nhap cong suat cua thiet bi: ");
                    int congSuat = scanner.nextInt();
                    HangHoa a = new HangDienMay(tenHH, maH[0], giaNhap, soLuongTonKho, ngayNK, congSuat) ;
                    list.add(list.indexOf(h),a);
                    list.remove(h);
                }
            }
        }
        if(dem == 0)
            System.out.println("Khong tim thay hang hoa co ma nay. Vui long nhap lai !!!");
    }
    //chức năng xóa hàng hóa theo mã của 1 hàng hóa bất kỳ 
    public void xoaHangHoa(){
        int dem = 0;
        System.out.print("Nhap ma hang hoa can xoa: ");
		String ma = scanner.nextLine();
		for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h.getMaHangHoa().equals(ma)){
                dem++;
                list.remove(h);
                System.out.println("Da xoa thanh cong !!!");
            }
        }
        if(dem == 0)
            System.out.println("Khong tim thay hang hoa co ma nay. Vui long nhap lai !!!");
    }
    // xuất từng loại hàng hóa
    public void xuatHangThucPham(){
        System.out.println("(HANG THUC PHAM):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangThucPham){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatHangSanhSu(){
        System.out.println("(HANG SANH SU):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Xuat Xu","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangSanhSu){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatHangDienMay(){
        System.out.println("(HANG DIEN MAY):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Cong Suat","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangDienMay){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatMotHangThucPham(HangHoa h){
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(h);
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatMotHangSanhSu(HangHoa h){
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Xuat Xu","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(h);
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatMotHangDienMay(HangHoa h){
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Cong Suat","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(h);
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatListHangThucPham(ArrayList<HangHoa> l){
        System.out.println("(HANG THUC PHAM):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatListHangSanhSu(ArrayList<HangHoa> l){
        System.out.println("(HANG SANH SU):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Xuat Xu","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatListHangDienMay(ArrayList<HangHoa> l){
        System.out.println("(HANG DIEN MAY):");
		for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-25s|%-8s|%-15s|%-8s|%-15s|%-15s|%-15s|\n","Ten Hang Hoa","Ma hang","Gia Nhap","So Luong","Ngay Nhap Kho","Cong Suat","Tong gia tri");
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 109; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatToanBo(){
        for(int i = 0; i < list.size(); i++){
           HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                xuatMotHangThucPham(h);
            }
            else if(h instanceof HangSanhSu){
                xuatMotHangSanhSu(h);
            }
            else if(h instanceof HangDienMay){
                xuatMotHangDienMay(h);
            }
        }
    }
    //các chức năng sắp xếp hàng hóa tăng dần và giảm dần
    public void hangHoaGiamDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatToanBo();
    }
    public void hangHoaTangDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatToanBo();
    }
    public void hangHoaTangDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().after(b.getNgayNhapKho())){
                    return 1 ;
                }
                else {
                    if(a.getNgayNhapKho().equals(b.getNgayNhapKho())){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatToanBo();
    }
    public void hangHoaGiamDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatToanBo();
    }
    public void sapXepTangDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                list1.add(h);
            }
            else if(h instanceof HangSanhSu){
                list2.add(h);
            }
            else if(h instanceof HangDienMay){
                list3.add(h);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangThucPham(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangSanhSu(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangDienMay(list3);
    }
    public void sapXepGiamDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                list1.add(h);
            }
            else if(h instanceof HangSanhSu){
                list2.add(h);
            }
            else if(h instanceof HangDienMay){
                list3.add(h);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangThucPham(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangSanhSu(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(a.getNgayNhapKho().compareTo(b.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangDienMay(list3);
    }
    public void sapXepTangDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                list1.add(h);
            }
            else if(h instanceof HangSanhSu){
                list2.add(h);
            }
            else if(h instanceof HangDienMay){
                list3.add(h);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangThucPham(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangSanhSu(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatListHangDienMay(list3);
    }
    public void sapXepGiamDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                list1.add(h);
            }
            else if(h instanceof HangSanhSu){
                list2.add(h);
            }
            else if(h instanceof HangDienMay){
                list3.add(h);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangThucPham(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangSanhSu(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa a, HangHoa b) {
                if(a.getGiaNhap() < b.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(a.getGiaNhap() == b.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatListHangDienMay(list3);
    }
    // các chức năng tìm kiếm 
    public void timKiemTheoLoai(){
        int luaChon;
        do{
            System.out.println("======MENU=======");
            System.out.println("1.Hang thuc pham.");
            System.out.println("2.Hang sanh su.");
            System.out.println("3.Hang dien may.");
		    System.out.println("0.Quay lai.");
            System.out.println("======END========");
            System.out.print("Nhap lua chon cua ban: ");
		    luaChon = scanner.nextInt();
		    switch(luaChon){
			    case 1: System.out.println("Cac mat hang thuc pham la:");
					    xuatHangThucPham();
					    break;				
			    case 2: System.out.println("Cac mat hang sanh su la: ");
					    xuatHangSanhSu();
					    break;					
			    case 3: System.out.println("Cac mat hang dien may la:");
					    xuatHangDienMay();
					    break;
				case 0: System.out.println("Quay lai."); break;
                default: System.out.println("Khong hop le. Vui long nhap lai !!!");	
            }
		} while (luaChon != 0);
    }
    public void timKiemTheoNgay() throws ParseException{
        int dem = 0;
        System.out.println("Nhap khoang thoi gian can tim kiem tu ngay: ");
        //scanner.nextLine();
		String ngayDau = scanner.nextLine();
		System.out.println("den ngay:");
		String ngayCuoi = scanner.nextLine();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h.getNgayNhapKho().compareTo(doiChuoiThanhNgay(ngayDau)) >= 0 && h.getNgayNhapKho().compareTo(doiChuoiThanhNgay(ngayCuoi)) <= 0){
                System.out.println("Cac mat hang da duoc nhap kho tu ngay " + ngayDau +" den ngay " + ngayCuoi + " la:");
                dem++;
                if(h instanceof HangThucPham){
                    xuatMotHangThucPham(h);
                }
                else if(h instanceof HangSanhSu){
                    xuatMotHangSanhSu(h);
                }
                else if(h instanceof HangDienMay){
                    xuatMotHangDienMay(h);
                }
            }
        }
        if(dem == 0)
            System.out.println("Khong hop le. Vui long nhap lai !!!");
    }
    public void timKiemTheoGia(){
        int dem = 0;
        System.out.println("Nhap khoang gia can tim kiem tu: ");
		double giaDau = scanner.nextDouble();
		System.out.println("den: ");
		double giaCuoi = scanner.nextDouble();
        for(int i = 0; i < list.size(); i++){
            HangHoa h = list.get(i);
            if(h.getGiaNhap() >= giaDau && h.getGiaNhap() <= giaCuoi){
                dem++;
                if(h instanceof HangThucPham){
                    xuatMotHangThucPham(h);
                }
                else if(h instanceof HangSanhSu){
                    xuatMotHangSanhSu(h);
                }
                else if(h instanceof HangDienMay){
                    xuatMotHangDienMay(h);
                }
            }
        }
        if(dem == 0)
            System.out.println("Khong hop le. Vui long nhap lai !!!");
    }
    public void timKiemHangGiaTriCao(){
        HangHoa h = list.get(0);
        double max = h.getGiaNhap();
        for(int i = 0; i < list.size(); i++){
            HangHoa hh = list.get(i);
            if(hh.getGiaNhap() > max){
                max = hh.getGiaNhap();
            }
        }
        for(int i = 0; i < list.size(); i++){
            HangHoa hh = list.get(i);
            if(hh.getGiaNhap() == max){
                System.out.println("San pham co gia tri cao nhat la: ");
                xuatMotHangSanhSu(hh);
            }
        }
    } 
    public void timKiemHangTongGiaTriCaoNhat(){
        HangHoa h = list.get(0);
        double max = h.tinhTien();
        for(int i = 0; i < list.size(); i++){
            HangHoa hh = list.get(i);
            if(hh.tinhTien() > max){
                max = hh.tinhTien();
            }
        }
        for(int i = 0; i < list.size(); i++){
            HangHoa hh = list.get(i);
            if(hh.tinhTien() == max){
                System.out.println("San pham co tong gia tri cao nhat la: ");
                xuatMotHangSanhSu(hh);
            }
        }
    }    
    DecimalFormat decimalFormat = new DecimalFormat("###,### VND");
    public void thongKeTongHangHoa(){
        int tongSoLuong = 0;
        double tongChiPhi = 0;
        for (HangHoa hangHoa : list) {
            tongSoLuong += hangHoa.getSoLuongTonKho();
            tongChiPhi += hangHoa.tinhTien();
        }
		sapXepTangDanTheoLoaiVaTheoGia();
        System.out.println("\nBANG THONG KE:");
        for (int i = 0; i < 120; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-20s|  %d  |\n","Tong so luong",tongSoLuong);
        for (int i =0 ; i < 120; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-20s|  %-20s|\n","Tong chi phi",decimalFormat.format(tongChiPhi));
        for (int i = 0; i < 120; i++) {
			System.out.print("-");
		}
		System.out.println();
    }
    public void thongKeTheoLoaiHangHoa(){
        double tongHTP = 0, tongHSS = 0, tongHDM = 0;
        int tongSoHTP = 0, tongSoHSS = 0, tongSoHDM = 0;
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa h = list.get(i);
            if(h instanceof HangThucPham){
                tongHTP += h.tinhTien();
                tongSoHTP += h.getSoLuongTonKho();
            }
            else if(h instanceof HangSanhSu){
                tongHSS += h.tinhTien();
                tongSoHSS += h.getSoLuongTonKho();
            }
            else if(h instanceof HangDienMay){
                tongHDM += h.tinhTien();
                tongSoHDM += h.getSoLuongTonKho();
            }
        }
        int luaChon;
        do{
            System.out.println("======MENU=======");
            System.out.println("1.Hang thuc pham.");
            System.out.println("2.Hang sanh su.");
            System.out.println("3.Hang dien may.");
		    System.out.println("0.Quay lai.");
            System.out.println("======END========");
            System.out.print("Nhap lua chon cua ban: ");
		    luaChon = scanner.nextInt();
            switch(luaChon){
                case 1: xuatHangThucPham();
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %d  |\n","Tong so luong",tongSoHTP);
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %-20s|\n","Tong chi phi",decimalFormat.format(tongHTP));
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        break;           
                case 2: xuatHangSanhSu();
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %d  |\n","Tong so luong",tongSoHSS);
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %-20s|\n","Tong chi phi",decimalFormat.format(tongHSS));
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        break;          
                case 3: xuatHangDienMay();
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %d  |\n","Tong so luong",tongSoHDM);
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%-20s|  %-20s|\n","Tong chi phi",decimalFormat.format(tongHDM));
                        for (int i = 0; i < 120; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        break;
                case 0: System.out.println("Quay lại."); break;  
                default: System.out.println("Khong hop le. Vui long nhap lai !!!");
            }       
        }while(luaChon != 0);
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
}

