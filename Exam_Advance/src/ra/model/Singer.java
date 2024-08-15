package ra.model;

import java.util.Scanner;

public class Singer {
    Scanner scanner = new Scanner(System.in);
    private Integer singerId ;
    private String singerName ;
    private Integer age ;
    private String nationality ;
    private Boolean gender ;
    private String genre ;

    public Singer() {
    }

    public Singer(Integer singerId, String singerName, Integer age, String nationality, Boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Singer[] singers ,int currentIndex){
        if(currentIndex < 0){
            singerId = 1 ;
        }else {
            singerId = singers[currentIndex].getSingerId() + 1 ;
        }

        while (true){
            System.out.println("Enter name singer :");
            singerName = scanner.nextLine().trim();
            if(singerName.length() == 0){
                System.err.println("Singer name not empty !");
            }else {
                break;
            }
        }

        while (true){
            try {
                System.out.println("Enter age : ");
                age = Integer.parseInt(scanner.nextLine().trim());
                if(age > 0){
                    break;
                }else {
                    System.err.println("Age > 0 !");
                }
            }catch (Exception e){
                System.err.println("Age invalid !");
            }
        }

        while (true){
            System.out.println("Enter nationality : ");
            nationality = scanner.nextLine().trim() ;
            if(nationality.length() > 0){
                break;
            }else {
                System.err.println("Nationality has length > 0 !");
            }
        }

        while (true){
            String gender = "";
                System.out.println("Enter gender : (true or false)");
                gender = scanner.nextLine().trim().toLowerCase();
                if(gender.equals("true") || gender.equals("false")){
                    try {
                        this.gender = Boolean.parseBoolean(gender);
                            break;
                    }catch (Exception e){
                        System.err.println("Enter true or false !");
                    }
                }else {
                    System.err.println("Enter try again !");
                }


        }

        while (true){
            System.out.println("Enter genre : ");
            genre = scanner.nextLine().trim();
            if(genre.length() > 0){
                break;
            }else {
                System.err.println("Genre not empty !");
            }
        }

    }

    public void updateData(){
        while (true){
            System.out.println("Enter name singer :");
            singerName = scanner.nextLine().trim();
            if(singerName.length() < 0){
                System.err.println("Singer name not empty !");
            }else {
                break;
            }
        }

        while (true){
            try {
                System.out.println("Enter age : ");
                age = Integer.parseInt(scanner.nextLine().trim());
                if(age > 0){
                    break;
                }else {
                    System.err.println("Age > 0 !");
                }
            }catch (Exception e){
                System.err.println("Age invalid !");
            }
        }

        while (true){
            System.out.println("Enter nationality : ");
            nationality = scanner.nextLine().trim() ;
            if(nationality.length() > 0){
                break;
            }else {
                System.err.println("Nationality has length > 0 !");
            }
        }

        while (true){
            try {
                System.out.println("Enter gender : (true or false)");
                gender = Boolean.parseBoolean(scanner.nextLine().trim());
                break;
            }catch (Exception e){
                System.err.println("Enter true or false !");
            }
        }

        while (true){
            System.out.println("Enter genre : ");
            genre = scanner.nextLine().trim();
            if(genre.length() > 0){
                break;
            }else {
                System.err.println("Genre not empty !");
            }
        }
    }

    public void displayData(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("[ %-6d | %-30s | %-10d | %-30s | %-15s | %-30s ]\n",singerId,singerName,age,nationality,gender? "male":"female",genre);
    }
}
