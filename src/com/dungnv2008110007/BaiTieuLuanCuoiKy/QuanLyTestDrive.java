package com.dungnv2008110007.BaiTieuLuanCuoiKy;

import java.util.Scanner;
import java.text.ParseException;

public class QuanLyTestDrive {
    public static void main(String[] args) throws ParseException {
        int luaChon;
        Scanner scanner = new Scanner(System.in);
        //tạo list
        DanhSachQuanLy list = new DanhSachQuanLy();
        //tạo đối tượng hàng thực phẩm 
        HangHoa h1 = new HangThucPham("Gao nep","111",12000,720,"02/03/2018","02/04/2022");
        HangHoa h2 = new HangThucPham("Khoai lang","222",40000,845,"10/07/2018","18/03/2021");
        HangHoa h3 = new HangThucPham("Thit bo","333",180000,1030,"13/06/2020","25/09/2020");
        HangHoa h4 = new HangThucPham("Cai xanh","444",25000,690,"19/10/2020","14/06/2020");
        HangHoa h5 = new HangThucPham("Ca chua","555",17000,1100,"22/10/2020","06/02/2021");
        HangHoa h6 = new HangThucPham("Rau ma","666",26000,560,"25/10/2021","23/11/2020");
        HangHoa h7 = new HangThucPham("Mi Omachi","777",8000,3400,"30/12/2021","16/12/2022");
        //tạo đôi tượng hàng sành sứ
        HangHoa h8 = new HangSanhSu("Chen com","101",75000,530,"05/02/2015","Quang Nam");
        HangHoa h9 = new HangSanhSu("Dia com","202",40000,780,"07/04/2017","Nha Trang");
        HangHoa h10 = new HangSanhSu("Am tra","303",65000,1295,"16/07/2018","Khanh Hoa");
        HangHoa h11 = new HangSanhSu("Ly tra","404",35000,1330,"21/08/2019","Binh Đinh");
        HangHoa h12 = new HangSanhSu("Chen tra","505",100000,845,"22/10/2020","Phu Yen");
        HangHoa h13 = new HangSanhSu("Lo hoa","606",70000,990,"28/11/2021","Binh Thuan");
        HangHoa h14 = new HangSanhSu("Chau hoa","707",980000,205,"25/11/2021","Quang Ngai");
        //tạo đối tượng hàng điện máy
        HangHoa h15 = new HangDienMay("May quat","110", 170000,200,"04/05/2016",300);
        HangHoa h16 = new HangDienMay("May loc nuoc","220",900000,95,"09/04/2018",850);
        HangHoa h17 = new HangDienMay("May hut bui","330",780000,120,"11/08/2019",900);
        HangHoa h18 = new HangDienMay("May giat","440",940000,60,"15/07/2020",1200);
        HangHoa h19 = new HangDienMay("May lanh","550",690000,80,"24/10/2021",1100);
        HangHoa h20 = new HangDienMay("Tu mat","660",850000,45,"27/11/2021",500);
        HangHoa h21 = new HangDienMay("Tu dong","770",770000,350,"29/12/2022",800);
        //thêm tất cả các loại hàng hóa đã được tạo ở trên vào list 
        list.addHangHoaTrucTiep(h1);
        list.addHangHoaTrucTiep(h2);
        list.addHangHoaTrucTiep(h3);
        list.addHangHoaTrucTiep(h4);
        list.addHangHoaTrucTiep(h5);
        list.addHangHoaTrucTiep(h6);
        list.addHangHoaTrucTiep(h7);
        list.addHangHoaTrucTiep(h8);
        list.addHangHoaTrucTiep(h9);
        list.addHangHoaTrucTiep(h10);
        list.addHangHoaTrucTiep(h11);
        list.addHangHoaTrucTiep(h12);
        list.addHangHoaTrucTiep(h13);
        list.addHangHoaTrucTiep(h14);
        list.addHangHoaTrucTiep(h15);
        list.addHangHoaTrucTiep(h16);
        list.addHangHoaTrucTiep(h17);
        list.addHangHoaTrucTiep(h18);
        list.addHangHoaTrucTiep(h19);
        list.addHangHoaTrucTiep(h20);
        list.addHangHoaTrucTiep(h21);
        // Menu
        System.out.println("=========================================");
        System.out.println("|                                       |");
        System.out.println("|  TRUONG DAI HOC GIA DINH              |");
        System.out.println("|  TEN SINH VIEN: NGUYEN VIET DUNG      |");
        System.out.println("|  MSSV: 2008110007                     |");
        System.out.println("|  MON HOC: LAP TRINH HUONG DOI TUONG   |");
        System.out.println("|  GIANG VIEN: THAY LE HUYNH PHUOC      |");
        System.out.println("|                                       |");
        System.out.println("=========================================");
		do{
            System.out.println("================================MENU======================================================");
            System.out.println("| 1. Thao tac voi hang hoa: (them, sua, xoa).                                            |");
            System.out.println("| 2. Tim kiem theo: (loai, gia, ngay nhap, gia tri cao nhat, tong gia tri cao nhat).     |");
            System.out.println("| 3. Sap xep tang dan theo: (gia nhap, ngay nhap, loai va ngay nhap, loai va gia nhap).  |");
            System.out.println("| 4. Sap xep giam dan theo: (gia nhap, ngay nhap, loai va ngay nhap, loai va gia nhap).  |");
            System.out.println("| 5. Thong ke: (Thong ke theo tung loai hang hoa, thong ke tat ca hang hoa).             |");
            System.out.println("| 0. Thoat chuong trinh.                                                                 |");
            System.out.println("================================END=======================================================");
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            switch(luaChon){
                case 1: //Menu lựa chọn các chức năng: thêm, sửa, xóa hàng hóa. Dữ liệu được nhập từ bàn phím.
                    int luaChon1;
                    do{
                        System.out.println("=======MENU========");
                        System.out.println("| 1. Them hang hoa.");
                        System.out.println("| 2. Sua hang hoa.");
                        System.out.println("| 3. Xoa hang hoa.");
                        System.out.println("| 0. Thoat.");
                        System.out.println("=======END=========");
                        System.out.print("Nhap lua chon cua ban: ");
                        luaChon1 = scanner.nextInt();
                        switch(luaChon1){
                            case 1: list.addHangHoa();break;
                            case 2: list.suaHangHoa();break;
                            case 3: list.xoaHangHoa();break;
                            case 0: System.out.println("Thoat.");break;
                            default: System.out.println("Khong hop le. Vui long chon lai !!!");
                        }
                    } while(luaChon1 != 0);
                    break;               
                case 2: //Menu lựa chọn chức năng tìm kiếm hàng hóa theo loại, khoảng ngày, khoảng giá 
                    int luaChon2;
                    do{
                        System.out.println("=========MENU==========");
                        System.out.println("| 1. Tim kiem theo loai.");
                        System.out.println("| 2. Tim kiem theo ngay nhap.");
                        System.out.println("| 3. Tim kiem theo gia.");
                        System.out.println("| 4. Tim kiem hang co gia tri cao nhat.");
                        System.out.println("| 5. Tim kiem hang co tong gia tri cao nhat.");
                        System.out.println("| 0. Thoat.");
                        System.out.println("=========END===========");
                        System.out.print("Nhap lua chon cua ban: ");
                        luaChon2 = scanner.nextInt();
                        switch(luaChon2){
                            case 1: list.timKiemTheoLoai();break;
                            case 2: list.timKiemTheoNgay();break;
                            case 3: list.timKiemTheoGia();break;
                            case 4: list.timKiemHangGiaTriCao();break;
                            case 5: list.timKiemHangTongGiaTriCaoNhat();break;
                            case 0: System.out.println("Thoat.");break;
                            default: System.out.println("Khong hop le. Vui long chon lai !!!");
                        }
                    } while(luaChon2 != 0);
                    break;
                case 3: //Menu sắp xếp hàng hóa tăng dần theo giá nhập, ngày nhập, theo loại và theo ngày nhập, theo loại và theo giá nhập.
                    int luaChon3;
                    do{
                        System.out.println("==================MENU====================");
                        System.out.println("| 1. Sap xep hang hoa tang dan theo gia nhap.");
                        System.out.println("| 2. Sap xep hang hoa tang dan theo ngay nhap.");
                        System.out.println("| 3. Sap xep hang hoa tang dan theo loai va ngay nhap.");
                        System.out.println("| 4. Sap xep hang hoa tang dan theo loai va gia nhap.");
                        System.out.println("| 0. Thoat.");
                        System.out.println("==================END=====================");
                        System.out.print("Nhap lua chon cua ban: ");
                        luaChon3 = scanner.nextInt();
                        switch(luaChon3){
                            case 1: list.hangHoaTangDanTheoGia();break;
                            case 2: list.hangHoaTangDanTheoNgay();break;
                            case 3: list.sapXepTangDanTheoLoaiVaTheoNgayNhap();break;
                            case 4: list.sapXepTangDanTheoLoaiVaTheoGia();break;
                            case 0: System.out.println("Thoat.");break;
                            default: System.out.println("Khong hop le. Vui long chon lai !!!");
                        }
                    } while(luaChon3 != 0);
                    break;
                case 4: //Menu sắp xếp hàng hóa giảm dần theo giá nhập, ngày nhập, theo loại và ngày nhập, theo loại và giá nhập.
                    int luaChon4;
                    do{
                        System.out.println("==================MENU===================");
                        System.out.println("| 1. Sap xep hang hoa giam dan theo gia nhap.");
                        System.out.println("| 2. Sap xep hang hoa giam dan theo ngay nhap.");
                        System.out.println("| 3. Sap xep hang hoa giam dan theo loai va ngay nhap.");
                        System.out.println("| 4. Sap xep hang hoa giam dan theo loai va gia nhap.");
                        System.out.println("| 0. Thoat.");
                        System.out.println("==================END====================");
                        System.out.print("Nhap lua chon cua ban: ");
                        luaChon4 = scanner.nextInt();
                        switch(luaChon4){
                            case 1: list.hangHoaGiamDanTheoGia();break;
                            case 2: list.hangHoaGiamDanTheoNgay();break;
                            case 3: list.sapXepGiamDanTheoLoaiVaTheoNgayNhap();break;
                            case 4: list.sapXepGiamDanTheoLoaiVaTheoGia();break;
                            case 0: System.out.println("Thoat.");break;
                            default: System.out.println("Khong hop le. Vui long chon lai !!!");
                        }
                    } while(luaChon4 != 0);
                    break;
                case 5: //Menu thống kê hàng hóa: thống kê theo loại, thống kê tất cả.
                    int luaChon5;
                    do{
                        System.out.println("==========MENU=============");
                        System.out.println("| 1. Thong ke theo loai.");
                        System.out.println("| 2. Thong ke tat ca.");
                        System.out.println("| 0. Thoat.");
                        System.out.println("==========END==============");
                        System.out.print("Nhap lua chon cua ban: ");
                        luaChon5 = scanner.nextInt();
                        switch(luaChon5){
                            case 1: list.thongKeTheoLoaiHangHoa();break;
                            case 2: list.thongKeTongHangHoa();break;
                            case 0: System.out.println("Thoat.");break;
                            default: System.out.println("Khong hop le. Vui long chon lai !!!");
                        } 
                    }while(luaChon5 != 0);
                    break;
                case 0: System.out.println("Thoat chuong trinh.");break;
                default: System.out.println("Khong hop le. Vui long chon lai !!!");               
            }           
        } while(luaChon != 0);
    }    
}
