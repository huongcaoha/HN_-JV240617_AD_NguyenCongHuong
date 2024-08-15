package ra.Controller;

import ra.Database.Data;
import ra.model.Song;

import java.util.Scanner;

public class SongController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayAllSongs(Song[] songs){
        System.out.printf("| %-10s | %-30s | %-30s | %-30s | %-30s | %-20s | %-15s |\n","ID","songName","descriptions","singer","songWriter","createdDate","songStatus");
        for(Song song : songs){
            if(song != null){
                song.displayData();
            }else {
                break;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
//    public static void addSong(){
//        int number = 0 ;
//        number = Common.getInputInt(number,"Enter number song wan add : ");
//        for(int i = 1 ; i <= number ; i++){
//            System.out.println("Enter song number " + i );
//            Song song = new Song();
//            song.inputData(Data.singers,Data.currentIndexSingers,Data.songs,Data.currentIndexSongs);
//            if(song == null){
//                SingerService.main(args);
//            }else {
//                Data.currentIndexSongs++ ;
//                Data.songs[Data.currentIndexSongs] = song ;
//            }
//        }
//        System.out.println("Add successfully "+ number + " song !");
//        SongController.displayAllSongs(Data.songs);
//    }
    public static void updateSong(Song[] songs , int currentIndexSongs,int currentIndexSinger){
        System.out.println("Enter song id : ");
        String songId = scanner.nextLine().trim();
        int index = -1 ;
        for(int i = 0 ; i <= currentIndexSongs ; i++){
            if(songs[i].getSongId().equals(songId)){
                index = i ;
                break;
            }
        }
        if(index >= 0 ){
            songs[index].updateData(Data.singers,Data.currentIndexSingers,Data.songs,Data.currentIndexSongs);
            if(currentIndexSinger >= 0){
                displayAllSongs(Data.songs);
            }
        }else {
            System.err.println("Not found song id !");
        }
    }

    public static void deleteSong(){
        System.out.println("Enter song id : ");
        String songId = scanner.nextLine().trim();
        int index = -1 ;
        for(int i = 0 ; i <= Data.currentIndexSongs ; i++){
            if(Data.songs[i].getSongId().equals(songId)){
                index = i ;
                break;
            }
        }
        if(index < 0){
            System.err.println("Not found song id !");
        }else {
            for(int i = index ; i < Data.currentIndexSongs ; i++){
                Song tmp = Data.songs[i] ;
                Data.songs[i] = Data.songs[i+1];
                Data.songs[i+1] = tmp ;
            }
            Data.songs[Data.currentIndexSongs] = null ;
            Data.currentIndexSongs-- ;
            if(Data.currentIndexSingers >= 0 ){
                System.out.println("Delete successfully !");
                displayAllSongs(Data.songs);
            }
        }
    }
}
