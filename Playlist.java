import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Playlist extends Thread {
    AlbumList albumList;
    List<Object> playList;
    AdList adList;
    public Playlist(List<Object> playList, AlbumList albumList, AdList adList) {
        this.playList = playList;
        this.albumList = albumList;
        this.adList = adList;
    }
    public static List<Object> randomPlayList(AlbumList albumList, AdList adList){
        AdList copymainAdList = adList;
        AlbumList copymainAlbumList = albumList;
        AdList mainAdList = adList;
        AlbumList mainAlbumList = albumList;
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++ ){
            Collections.shuffle(copymainAdList.getAdList());
            Collections.shuffle(copymainAlbumList.getAlbumList());
            Collections.shuffle(copymainAlbumList.getAlbumList().get(0).getSongList());
            list.add(copymainAdList.getAdList().get(0));
            list.add(copymainAlbumList.getAlbumList().get(0));
            System.out.println(copymainAlbumList.getAlbumList().get(0).getSongList().get(0).toString() + "\n");
            System.out.println("AD " + copymainAdList.getAdList().get(0).getAdvertiser() + " (" + copymainAdList.getAdList().get(0).getLength() + ")" + "\n");
        }


    return list;

    }
    public void addToList(List<Object> e){
       this.playList.add(e);
    }
    public void addStuff(String input){
        List<Object> result = new ArrayList<>();
        AdList copy = adList;
       // Scanner scanner = new Scanner(System.in);
       // System.out.println("What song would you like to add?");
        //input = scanner.nextLine();
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

        playList = result;
    }
    @Override
    public void run(){
        AdList copymainAdList = this.adList;
        AlbumList copymainAlbumList = this.albumList;
        AdList mainAdList = this.adList;
        AlbumList mainAlbumList = this.albumList;
       // List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++ ){
            Collections.shuffle(copymainAdList.getAdList());
            Collections.shuffle(copymainAlbumList.getAlbumList());
            Collections.shuffle(copymainAlbumList.getAlbumList().get(0).getSongList());
            playList.add(copymainAdList.getAdList().get(0));
            playList.add(copymainAlbumList.getAlbumList().get(0));
            System.out.println(copymainAlbumList.getAlbumList().get(0).getSongList().get(0).toString() + "\n");
            System.out.println("AD " + copymainAdList.getAdList().get(0).getAdvertiser() +
                    " (" + copymainAdList.getAdList().get(0).getLength() + ")" + "\n");
        }
    }
}
