package studiplayer.audio;

import studiplayer.basic.WavParamReader;

public class WavFile extends SampledFile {

	WavFile() {
		super();
	}

	public WavFile(String path) throws NotPlayableException {
		super(path);
		readAndSetDurationFromFile(pathname);
	}

	public static long computeDuration(long numberOfFrames, float frameRate) {
		long ms;
		ms = 1000000 * numberOfFrames / (long) frameRate;

		return ms;

	}

	public void readAndSetDurationFromFile(String pathname)
			throws NotPlayableException {
		try {
			WavParamReader.readParams(pathname);
			duration = ""
					+ computeDuration(
							(long) WavParamReader.getNumberOfFrames(),
							(float) WavParamReader.getFrameRate());
		} catch (RuntimeException e) {
			throw new NotPlayableException(pathname, e);
		}

	}

	public String toString() {

		return this.author + " - " + this.title + " - "
				+ this.getFormattedDuration();

	}

	public String[] fields() {
		String[] field = new String[4];
		field[0] = getAuthor();
		field[1] = getTitle();
		field[2] = "";
		field[3] = getFormattedDuration();

		return field;

	}

}
