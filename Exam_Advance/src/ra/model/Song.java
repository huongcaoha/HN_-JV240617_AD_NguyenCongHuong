package ra.model;

import ra.Controller.SingerController;
import ra.Database.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Song {
    Scanner scanner = new Scanner(System.in);
    private String songId ;
    private String songName ;
    private  String descriptions ;
    private Singer singer ;
    private String songWriter ;
    private Date createdDate ;
    private Boolean songStatus ;

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, Boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(Boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Singer[] singers,int currentSinger, Song[] songs,int currentSong){
        if(currentSinger < 0){
            System.err.println("Not found singer , you should add the singer first");
            return;
        }else {
            while (true){
                System.out.println("Enter songId (There are 4 characters and start with the letter S, no duplicates) " );
                songId =  scanner.nextLine().trim();
                if(songId.matches("^S\\w{3}$")){
                    boolean checkExis = false ;
                    for(Song song : songs){
                        if(song != null){
                            if(song.getSongId().equals(songId)){
                                checkExis = true ;
                                break;
                            }
                        }
                    }
                    if(checkExis){
                        System.err.println("Song id exis !");
                    }else {
                        break;
                    }
                }else {
                    System.err.println("There are 4 characters and start with the letter S, no duplicates");
                }
            }

            while (true){
                System.out.println("Enter song name : ");
                songName = scanner.nextLine().trim();
                if(songName.length() > 0){
                    break;
                }else {
                    System.err.println("Song name cannot be left blank !");
                }
            }

            System.out.println("Enter descriptions : ");
            descriptions = scanner.nextLine().trim();

            while (true){
                SingerController.displaySingers(Data.singers);
                int singId = 0 ;
                try {
                    System.out.println("Enter singer id : ");
                     singId = Integer.parseInt(scanner.nextLine()) ;
                }catch (Exception e){
                    System.err.println("Sing id invalid !");
                }
                for(Singer sing : singers){
                    if(sing != null){
                        if(sing.getSingerId() == singId){
                            singer = sing ;
                        }
                    }else {
                        break;
                    }
                }
                if(singer != null){
                    break;
                }else {
                    System.err.println("Not found song id !");
                }
            }

            while (true){
                System.out.println("Enter song write : ");
                songWriter = scanner.nextLine().trim();
                if(songWriter.length() > 0){
                    break;
                }else {
                    System.err.println(" Song write cannot be left blank !");
                }
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                long currentMilliseconds = System.currentTimeMillis();
                createdDate = new Date(currentMilliseconds);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            while (true){
                System.out.println("Enter status song (true or false): ");
                String status = scanner.nextLine().trim().toLowerCase();
                if(status.equals("true") || status.equals("false")){
                    try {
                        songStatus = Boolean.parseBoolean(status);
                        break;
                    }catch (Exception e){
                        System.err.println("Enter true or false !");
                    }
                }else {
                    System.err.println("Enter try again !");
                }

            }

        }
    }

    public void updateData(Singer[] singers,int currentSinger, Song[] songs,int currentSong){
        if(currentSinger < 0){
            System.err.println("Not found singer , you should add the singer first");
            return;
        }else {
            while (true){
                System.out.println("Enter song name : ");
                songName = scanner.nextLine().trim();
                if(songName.length() > 0){
                    break;
                }else {
                    System.err.println("Song name cannot be left blank !");
                }
            }

            System.out.println("Enter descriptions : ");
            descriptions = scanner.nextLine().trim();

            while (true){
                SingerController.displaySingers(Data.singers);
                int singId = 0 ;
                try {
                    System.out.println("Enter singer id : ");
                    singId = Integer.parseInt(scanner.nextLine()) ;
                }catch (Exception e){
                    System.err.println("Sing id invalid !");
                }
                for(Singer sing : singers){
                    if(sing != null){
                        if(sing.getSingerId() == singId){
                            singer = sing ;
                        }
                    }else {
                        break;
                    }
                }
                if(singer != null){
                    break;
                }else {
                    System.err.println("Not found song id !");
                }
            }

            while (true){
                System.out.println("Enter song write : ");
                songWriter = scanner.nextLine().trim();
                if(songWriter.length() > 0){
                    break;
                }else {
                    System.err.println(" Song write cannot be left blank !");
                }
            }

            while (true){
                try {
                    System.out.println("Enter status song (true or false): ");
                    songStatus = Boolean.parseBoolean(scanner.nextLine().trim());
                    break;
                }catch (Exception e){
                    System.err.println("Enter true or false !");
                }
            }

        }
    }

    public void displayData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("[ %-10s | %-30s | %-30s | %-30s | %-30s | %-20s | %-15s ]\n",songId,songName,descriptions,singer.getSingerName(),songWriter,simpleDateFormat.format(createdDate),songStatus);
    }


}
