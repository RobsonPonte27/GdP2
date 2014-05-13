package studiplayer.audio;

import java.util.Comparator;

public class AuthorComparator implements Comparator<AudioFile> {

	public int compare(AudioFile af1, AudioFile af2) {
		String hilf1;
		String hilf2;

		if (af1 == null) {
			throw new NullPointerException();
		}

		if (af2 == null) {
			throw new NullPointerException();
		}
		hilf1 = af1.getAuthor();
		hilf2 = af2.getAuthor();

		if (hilf1.compareTo(hilf2) == 0 & hilf2.compareTo(hilf1) == 0) {
			return 0;
		}

		else if (hilf1.compareTo(hilf2) < 0 & hilf2.compareTo(hilf1) > 0) {

			return -1;
		} else {
			return 1;
		}
	}

}
