import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;
public class AlbumList {
    private List<Album> albumList;

    public AlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }
    public void AddAlbum(Album album){
        this.albumList.add(album);

    }
    public static AlbumList readAlbum(Scanner scanner) {
        List<Album> e = new ArrayList<>();
        AlbumList albumList;

        while (scanner.hasNextLine()){
            String temp = scanner.nextLine();
            if (temp.equals("ALBUMS")){
                scanner.useDelimiter("ALBUM ");

                while (scanner.hasNext()) {
                    e.add(Album.readAlbum(new Scanner(scanner.next())));
                }
            }

        }
        albumList = new AlbumList(e);

        return albumList;
    }
    @Override
    public String toString(){
        String temp = "";
        for (Album album: albumList){
          temp += album.toString() + "\n" + "\n";

        }
        return temp;
    }


}
