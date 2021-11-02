import java.util.Objects;

public class Song {
    private int trackNumber;
    private String title;
    private String length;

    public Song(int trackNumber, String title, String length) {
        this.trackNumber = trackNumber;
        this.title = title;
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString(){
        String temp = "";
        temp += "Track: " + this.getTitle() + " (" + this.getLength() + ")";
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return trackNumber == song.trackNumber && Objects.equals(title, song.title) && Objects.equals(length, song.length);
    }


}
