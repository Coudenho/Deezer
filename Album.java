import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Album {
   private String AlbumArtist;
    private String Albumname;
    private List<String> ArtistList;
    private List<Song> songList;

    public Album(String albumArtist, String albumname, List<String> artistList, List<Song> songList) {
        AlbumArtist = albumArtist;
        Albumname = albumname;
        ArtistList = artistList;
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public List<String> getArtistList() {
        return ArtistList;
    }

    public String getAlbumArtist() {
        return AlbumArtist;
    }

    public String getAlbumname() {
        return Albumname;
    }

    public static Album readAlbum(Scanner scanner) {
        String albumArtist = "";
        String albumname = "";
        List<String> artistList = new ArrayList<>();
        List<Song> songList = new ArrayList<>();
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            Scanner scanner1 = new Scanner(temp);

            if (temp.startsWith("TRACK")) {
                scanner1 = scanner1.skip("TRACK ");
                temp = scanner1.nextLine();
                Song song;
                int trackNumber = Integer.valueOf(temp.split("; ")[0]);
                String trackName = temp.split("; ")[1];
                String trackTime = temp.split("; ")[2];
                song = new Song(trackNumber, trackName, trackTime);
                songList.add(song);
            }
            else if (temp.startsWith("ARTISTS")) {
                scanner1 = scanner1.skip("ARTISTS ");
                temp = scanner1.nextLine();
                String[] stringList = temp.split("; ");
                for (int i = 0; i < stringList.length; i++)
                    artistList.add(stringList[i]);

            }
            else {
                if ((!(temp.startsWith("ADS"))) && (!(temp.startsWith("AD")))){
                temp = scanner1.nextLine();
                albumArtist = temp.split("; ")[0];
                albumname = temp.split("; ")[1];
            }}
        }
            return new Album(albumArtist, albumname, artistList, songList);
    }
    @Override
    public String toString(){
        String temp = "";
        temp += "Album: " + this.Albumname + "\n" + "Artists: ";
        for (String artist: this.ArtistList){
            temp += artist + ", ";
        }
        temp += "\n";
        for (Song track: this.songList){

            temp += "Track: " + track.getTitle() + " (" + track.getLength() + ")" + "\n";

        }
        return temp;
    }

}
