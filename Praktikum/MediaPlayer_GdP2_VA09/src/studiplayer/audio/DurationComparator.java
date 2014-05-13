package studiplayer.audio;

import java.util.Comparator;

public class DurationComparator implements Comparator<AudioFile> {

	public int compare(AudioFile af1, AudioFile af2) {
		String hilf1 = "00:00";
		String hilf2 = "00:00";
		int c = 0;

		if (af1 instanceof TaggedFile) {
			hilf1 = ((TaggedFile) af1).getFormattedDuration();
		} else if (af1 instanceof WavFile) {
			hilf1 = ((WavFile) af1).getFormattedDuration();
		}
		if (af2 instanceof TaggedFile) {
			hilf2 = ((TaggedFile) af2).getFormattedDuration();
		} else if (af2 instanceof WavFile) {
			hilf2 = ((WavFile) af2).getFormattedDuration();
		}

		c = hilf1.compareTo(hilf2);
		if (c < 0)
			return -1;
		else if (c > 0)
			return 1;
		else
			return 0;
	}

}
