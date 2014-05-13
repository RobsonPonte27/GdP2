package studiplayer.audio;

import java.util.Comparator;

public class AlbumComparator implements Comparator<AudioFile> {

	public int compare(AudioFile af1, AudioFile af2) {

		if (af1 == null) {
			throw new NullPointerException();
		}

		if (af2 == null) {
			throw new NullPointerException();
		}

		if (!(af1 instanceof TaggedFile) && !(af2 instanceof TaggedFile))
			return 0;

		if ((af1 instanceof TaggedFile) && !(af2 instanceof TaggedFile))
			return 1;

		if (!(af1 instanceof TaggedFile) && (af2 instanceof TaggedFile))
			return -1;

		return ((TaggedFile) af1).getAlbum().compareTo(
				((TaggedFile) af2).getAlbum());

	}

}
