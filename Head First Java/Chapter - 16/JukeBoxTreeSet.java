import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.io.*;

class Song {

	String title;
	String artist;
	int rating;
	int year;

	public Song(String title, String artist, int rating, int year) {
	
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.year = year;
	
	}

	@Override 
	public String toString() {
		return title;
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		Song song = (Song) other;
		return (this.title.equals(song.title));
	}

}

class ArtistCompare implements Comparator <Song> {
	@Override
	public int compare(Song one, Song other) {
		return one.artist.compareTo(other.artist);
	}
}

class TitleCompare implements Comparator <Song> {
	@Override
	public int compare(Song one, Song other) {
		return one.title.compareTo(other.title);
	}
}

public class JukeBoxTreeSet {

	ArrayList <Song> songList;

	public static void main(String[] args) {

		
		JukeBoxTreeSet myJukeBox = new JukeBoxTreeSet();
		myJukeBox.go();

	}

	void go() {

		songList = new ArrayList <Song> ();
		getSongs();
		TreeSet <Song> songSet = new TreeSet <Song> (new TitleCompare());
		songSet.addAll(songList);
		System.out.println(songSet);
	}

	void getSongs() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("SongsRepeated.txt"));
			String line = null;
			while((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}


	void addSong(String lineToParse) {
		String[] data = lineToParse.split("/");
		Song song = new Song(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
		songList.add(song);
	}

}

