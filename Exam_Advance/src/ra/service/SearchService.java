package ra.service;

import ra.Common.Common;
import ra.Controller.SearchController;

public class SearchService {
    public static void main(String[] args) {
      while (true){
          System.out.println("*********************************SEARCH-MANAGEMENT***********************************");
          System.out.println("*                                                                                                                                                                   *");
          System.out.println("*                                     1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại                                        *");
          System.out.println("*                                     2.Tìm kiếm ca sĩ theo tên hoặc thể loại                                                      *");
          System.out.println("*                                     3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần                            *");
          System.out.println("*                                     4.Hiển thị 10 bài hát được đăng mới nhất                                                  *");
          System.out.println("*                                     5. Thoát                                                                                                               *");
          System.out.println("*                                                                                                                                                                    *");
          System.out.println("***********************************************************************************************");
          int choice = 0 ;
          choice = Common.getInputInt(choice,"Enter choice : ");
          switch (choice){
              case 1 : {
                  SearchController.searchSongBySinger();
                  break;
              }
              case 2 : {
                  SearchController.searchSingerByNameOrGenre();
                  break;
              }
              case 3 : {
                  SearchController.sortSongIncrease();
                  break;
              }
              case 4 : {
                  SearchController.get10SongNew();
                  break;
              }
              case 5 : {
                  return;
              }
              default: {
                  System.out.println("Enter try again !");
              }
          }
      }
    }
}
