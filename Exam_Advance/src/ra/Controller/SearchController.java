package ra.Controller;

import ra.Database.Data;
import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class SearchController {
   static Scanner scanner = new Scanner(System.in);
    public static void searchSongBySinger(){
        System.out.println("Enter singer or genre to search songs :");
        String singerName = scanner.nextLine().trim().toLowerCase();
        Song[] rs = new Song[100];
        int currentIndex = -1 ;
        for(int  i = 0 ; i <= Data.currentIndexSongs ;i++){
            if(Data.songs[i].getSinger().getSingerName().toLowerCase().contains(singerName) || Data.songs[i].getSinger().getGenre().toLowerCase().contains(singerName)){
                currentIndex++;
                rs[currentIndex] = Data.songs[i];
            }
        }
        if(currentIndex < 0){
            System.err.println("Not found song !");
        }else {
            System.out.println("Result search is :");
            SongController.displayAllSongs(rs);
        }
    }

    public static void searchSingerByNameOrGenre(){
        System.out.println("Enter singer name  or genre to search singer :");
        String search = scanner.nextLine().trim();
        Singer[] rs = new Singer[100];
        int currentIndex = -1 ;
        for(int  i = 0 ; i <= Data.currentIndexSingers ;i++){
            if(Data.singers[i].getSingerName().toLowerCase().contains(search) || Data.singers[i].getGenre().toLowerCase().contains(search)){
                currentIndex++;
                rs[currentIndex] = Data.singers[i];
            }
        }
        if(currentIndex < 0){
            System.err.println("Not found singer!");
        }else {
            System.out.println("Result search is :");
            SingerController.displaySingers(rs);
        }
    }

    public static void sortSongIncrease(){
        for(int i = 0 ; i < Data.currentIndexSongs ; ){
            if(Data.songs[i].getSongName().compareTo(Data.songs[i+1].getSongName()) > 0){
                Song tmp = Data.songs[i];
                Data.songs[i] = Data.songs[i+1];
                Data.songs[i+1] = tmp ;
                if(i > 0){
                    i-- ;
                }
            }else {
                i++ ;
            }
        }
        System.out.println("List song after sort increase is :");
        SongController.displayAllSongs(Data.songs);
    }

    public static void get10SongNew(){
       if(Data.currentIndexSongs < 0){
           System.out.println("Current list song empty !");
       }else {
           for(int i = 0 ; i < Data.currentIndexSongs ; ){
               if(Data.songs[i].getCreatedDate().compareTo(Data.songs[i+1].getCreatedDate()) < 0){
                   Song tmp = Data.songs[i];
                   Data.songs[i] = Data.songs[i+1];
                   Data.songs[i+1] = tmp ;
                   if(i > 0){
                       i-- ;
                   }
               }else {
                   i++ ;
               }
           }
           int totalSong = 0;
           if(Data.currentIndexSongs >= 10){
               totalSong = 10;
           }else {
               totalSong = Data.currentIndexSongs;
               System.out.println("List current song has " + totalSong + " song !");
           }
           System.out.printf("| %-10s | %-30s | %-30s | %-30s | %-30s | %-20s | %-15s |\n","ID","songName","descriptions","singer","songWriter","createdDate","songStatus");
           for(int i = 0 ; i < totalSong ; i++){
               Data.songs[i].displayData();
           }
           System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       }
    }
}
