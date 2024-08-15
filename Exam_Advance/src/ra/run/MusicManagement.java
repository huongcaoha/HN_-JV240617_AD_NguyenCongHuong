package ra.run;

import ra.Common.Common;
import ra.service.SearchService;
import ra.service.SingerService;
import ra.service.SongService;

public class MusicManagement {
    public static void main(String[] args) {
        while (true){
            System.out.println("**********************************MUSIC-MANAGEMENT************************************");
            System.out.println("|                                                                                                                                                                    |");
            System.out.println("|                                                              1. Quản lý ca sĩ                                                                          |");
            System.out.println("|                                                              2. Quản lý bài hát                                                                      |");
            System.out.println("|                                                              3. Tìm kiếm bài hát                                                                  |");
            System.out.println("|                                                              4. Thoát                                                                                      |");
            System.out.println("|                                                                                                                                                                    |");
            System.out.println("***********************************************************************************************");
            int choise = 0 ;
                choise = Common.getInputInt(choise,"Enter choise :");
                switch (choise){
                    case 1 : {
                        SingerService.main(args);
                        break;
                    }
                    case 2 : {
                        SongService.main(args);
                        break;
                    }
                    case 3 : {
                        SearchService.main(args);
                        break;
                    }
                    case 4 : {
                        System.out.println("Goodbye !!!");
                        return;
                    }
                    default: {
                        System.err.println("Enter try again from 1 to 4 !");
                    }
                }
        }

    }
}
