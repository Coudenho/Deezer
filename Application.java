import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class Application {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please give a file:");
            File file = new File(scanner.nextLine());
            Scanner AlbumListscanner = new Scanner(file);
            Scanner temp = new Scanner(file);

           // System.out.println(AlbumList.readAlbum(AlbumListscanner));
           // System.out.println(AdList.readAdList(temp));
           AlbumList albumList = AlbumList.readAlbum(AlbumListscanner);
           AdList adList = AdList.readAdList(temp);
            menuPrinter(albumList, adList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void menuPrinter(AlbumList albumList, AdList adList){
        AdList mainAdList = adList;
        AlbumList mainAlbumList = albumList;
        Scanner scanner1 = new Scanner(System.in);
        List<Object> list = new ArrayList<>();
        Playlist thread1 = new Playlist(list, mainAlbumList, mainAdList);
        Tred tred1 = new Tred(thread1);
       // Playlist playlist = new Playlist(list);
        System.out.println("Please make your choice: \n" +
                "1 – Print all albums & songs\n" +
                "2 – Add a new advertisement\n" +
                "3 – Enable shuffling of songs\n" +
                "4 – Add song to front of playlist\n" +
                "5 – Write to file\n" +
                "6 – Calculate commercial value\n" +
                "7 – Stop the program");
        int Choice = scanner1.nextInt();
        switch(Choice){
            case 1: System.out.println(mainAlbumList.toString());
            System.out.println(mainAdList.toString());
            break;
            case 2: mainAdList.addAd(addAd());
                break;
            case 3:

              //  Playlist thread = new Thread(() -> { return Playlist.randomPlayList(mainAlbumList, mainAdList);})
                tred1.start();
                System.out.println(tred1.playlist.playList.size());
            break;
            case 4: //playlist = new Playlist(addToPlaylist(mainAlbumList, mainAdList, playlist));
                Scanner scanner = new Scanner(System.in);
                System.out.println("What song would you like to add?");
                String input = scanner.nextLine();
                thread1.addStuff(input);
            case 5:
            case 7: System.exit(0);
        }
        menuPrinter(mainAlbumList, mainAdList);
    }
    public static Ad addAd(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who is the advertiser?: ");
        String advertiser = scanner.nextLine();
        System.out.println("What is the length of the ad (Minutes:seconds)?: ");
        String length = scanner.nextLine();
        System.out.println("What is the price of the ad?: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Ad(advertiser, length, price);
    }

     public static List<Object> addToPlaylist(AlbumList albumList, AdList adList, Playlist playList){
        List<Object> result = new ArrayList<>();
        AdList copy = adList;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What song would you like to add?");
        String input = scanner.nextLine();
        Song songToAdd = new Song(0, null, null);
        for (Album album: albumList.getAlbumList()){
           for(Song song: album.getSongList()){
               if (song.getTitle().equals(input)){
                   songToAdd = song;
               }

           }
        }
        Collections.shuffle(adList.getAdList());
        result.add(songToAdd);
        result.add(adList.getAdList().get(0));
        result.add(playList);


        return result;
     }

}
