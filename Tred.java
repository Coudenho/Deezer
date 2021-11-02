import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tred extends Thread {
    Playlist playlist;
    Tred(Playlist playlist){
        this.playlist = playlist;
    }
    public void run(){
        AdList copymainAdList = playlist.adList;
        AlbumList copymainAlbumList = playlist.albumList;
        AdList mainAdList = playlist.adList;
        AlbumList mainAlbumList = playlist.albumList;
        List<Object> playList = playlist.playList;
        for (int i = 0; i < 10; i++ ){
            Collections.shuffle(copymainAdList.getAdList());
            Collections.shuffle(copymainAlbumList.getAlbumList());
            Collections.shuffle(copymainAlbumList.getAlbumList().get(0).getSongList());
            playList.add(copymainAdList.getAdList().get(0));
            playList.add(copymainAlbumList.getAlbumList().get(0));
            System.out.println(copymainAlbumList.getAlbumList().get(0).getSongList().get(0).toString() + "\n");
            System.out.println("AD " + copymainAdList.getAdList().get(0).getAdvertiser() + " (" + copymainAdList.getAdList().get(0).getLength() + ")" + "\n");
            this.playlist.addToList(playList);
        }

    }

}
