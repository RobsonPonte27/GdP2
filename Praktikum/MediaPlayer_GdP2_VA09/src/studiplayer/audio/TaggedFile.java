package studiplayer.audio;

import java.util.Map;

public class TaggedFile extends SampledFile {

	protected String album = "";

	public TaggedFile() {
		super();

	}

	public TaggedFile(String path) throws NotPlayableException {
		super(path);
		readAndStoreTags(getPathname());

	}

	public void readAndStoreTags(String pathname) throws NotPlayableException {
		try {

			Map<String, Object> tag_map = studiplayer.basic.TagReader
					.readTags(pathname);

			if (tag_map.containsKey("title")
					&& !tag_map.get("title").toString().isEmpty())
				title = tag_map.get("title").toString();
			title = title.trim();
			if (tag_map.containsKey("author")
					&& !tag_map.get("author").toString().isEmpty())
				author = tag_map.get("author").toString();
			author = author.trim();
			if (tag_map.containsKey("album")
					&& !tag_map.get("album").toString().isEmpty())
				album = tag_map.get("album").toString();
			album = album.trim();
			if (tag_map.containsKey("duration")
					&& !tag_map.get("duration").toString().isEmpty())
				duration = tag_map.get("duration").toString();
			duration = duration.trim();
		} catch (RuntimeException e) {
			throw new NotPlayableException(pathname, e);
		}
	}

	public String getAlbum() {

		return album;
	}

	public String toString() {
		String ret = "";
		if (author != null && author.length() > 0) {
			ret += author;
		}
		if (title != null && title.length() > 0) {
			if (ret.length() > 0)
				ret += " - ";
			ret += title;
		}
		if (album != null && album.length() > 0) {
			if (ret.length() > 0)
				ret += " - ";
			ret += album;
		}
		if (ret.length() > 0)
			ret += " - ";
		ret += getFormattedDuration();
		return ret;
	}

	public String[] fields() {

		String[] field = { author, title, album, getFormattedDuration() };
		return field;
	}

}
