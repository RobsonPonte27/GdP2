import java.util.Map;

import studiplayer.basic.BasicPlayer;
import studiplayer.basic.TagReader;

public class TaggedFile extends AudioFile {

	// constructors

	public TaggedFile() {
		super();
	}

	public TaggedFile(String pathname) {
		super(pathname);
	}

	// methods

	public void play() {
		BasicPlayer.play(getPathname());
	}

	public void togglePause() {
		BasicPlayer.togglePause();
	}

	public void stop() {
		BasicPlayer.stop();
	}

	public String getFormattedDuration() {
		return "";
	}

	public String getFormattedPosition() {
		return "";
	}
	
	public void readAndStoreTags(String pathname) {
		Map<String, Object> tag_map = TagReader.readTags(pathname);
		for (String key : tag_map.keySet()) { 
			}
	}
	
	
	// Zeit umformatieren
	public static String timeFormatter(long microseconds) {
		
		// falls zeit negatives zeitformat
		if (microseconds <0) {
			throw new RuntimeException ("Negativer Zeitwert wird angeboten");
			}
		// falls zu großes zeitformat
		if (microseconds > 5999999999L) {
			throw new RuntimeException ("Zeitwert übersteigt erlaubtes Format");
		}
		
		int minutes = (int) ((microseconds / 1000000) / 60);
		int seconds = (int) ((microseconds / 1000000) % 60);

		return String.format("%02d:%02d", minutes, seconds);
		
	}  
	
	// Auto-Generation
	
	public String[] fields() {
		// TODO Auto-generated method stub
		return null;
	}
}
