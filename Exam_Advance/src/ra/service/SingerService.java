package ra.service;

import ra.Common.Common;
import ra.Controller.SingerController;
import ra.Database.Data;
import ra.model.Singer;

public class SingerService {
    public static void main(String[] args) {
       while (true){
           System.out.println("*********************************SINGER-MANAGEMENT************************************");
           System.out.println("|                                                                                                                                                                    |");
           System.out.println("|                 1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới                    |");
           System.out.println("|                  2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ                                                                    |");
           System.out.println("|                  3.Thay đổi thông tin ca sĩ theo mã id                                                                               |");
           System.out.println("|                  4.Xóa ca sĩ theo mã id                                                                                                         |");
           System.out.println("|                  5. Thoát                                                                                                                                   |");
           System.out.println("|                                                                                                                                                                    |");
           System.out.println("***********************************************************************************************");
           int choose = 0 ;
           choose = Common.getInputInt(choose,"Enter choose : ");
           switch (choose){
               case 1 : {
                        SingerController.addSinger();
                   break;
               }
               case 2 : {
                   SingerController.displaySingers(Data.singers);
                   break;
               }
               case 3 : {
                   int idSinger = 0 ;
                   idSinger = Common.getInputInt(idSinger,"Enter id singer : ");
                   SingerController.updateSinger(idSinger,Data.singers);
                   break;
               }
               case 4 : {
                 SingerController.deleteSinger();
                   break;
               }
               case 5 : {
                   return;
               }
               default: {
                   System.err.println("Enter try again !");
               }
           }
       }
    }
}
