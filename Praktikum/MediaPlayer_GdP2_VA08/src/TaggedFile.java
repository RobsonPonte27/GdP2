import java.util.Map;

import studiplayer.basic.TagReader;

public class TaggedFile extends SampledFile {

	protected String album;

	// constructors

	public TaggedFile() {
		super();
		album = "";
	}

	public TaggedFile(String pathname) {
		super(pathname);
		album = "";
		readAndStoreTags(getPathname());
	}

	public String getAlbum() {
		return album;
	}

	// methods

	public String toString() {
		String Ausgabe = new String();

		if (this.getAlbum().isEmpty()) {
			Ausgabe = super.toString() + " - " + getFormattedDuration();
		} else {
			Ausgabe = super.toString() + " - " + album + " - "
					+ getFormattedDuration();
		}
		return Ausgabe;
	}

	public void readAndStoreTags(String pathname) {
		Map<String, Object> tag_map = TagReader.readTags(pathname);
		for (String key : tag_map.keySet()) {

			if (tag_map.get(key) == null)
				continue;

			if (key.trim().isEmpty())
				continue;

			if (tag_map.get(key).toString().trim().isEmpty())
				continue;

			if (key == "title") {
				title = tag_map.get(key).toString().trim();
			}

			else if (key == "author") {
				author = tag_map.get(key).toString().trim();
			}

			else if (key == "album") {
				album = tag_map.get(key).toString().trim();
			}

			else if (key == "duration") {
				duration = Long.parseLong(tag_map.get(key).toString());
			}
		}
	}

	// Auto-Generation

	public String[] fields() {
		String[] fields = { author, title, album, this.getFormattedDuration() };
		return fields;
	}
}