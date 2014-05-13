import studiplayer.basic.BasicPlayer;

abstract class SampledFile extends AudioFile {

	protected long duration;

	// constructors

	public SampledFile() {
		super();
	}

	public SampledFile(String s) {
		super(s);
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
		return TaggedFile.timeFormatter(this.duration);
	}

	public String getFormattedPosition() {
		return TaggedFile.timeFormatter(studiplayer.basic.BasicPlayer
				.getPosition());
	}

	// Zeit umformatieren
	public static String timeFormatter(long microseconds) {

		// falls zeit negatives zeitformat
		if (microseconds < 0) {
			throw new RuntimeException("Negativer Zeitwert wird angeboten");
		}
		// falls zu großes zeitformat
		if (microseconds > 5999999999L) {
			throw new RuntimeException("Zeitwert übersteigt erlaubtes Format");
		}

		int minutes = (int) ((microseconds / 1000000) / 60);
		int seconds = (int) ((microseconds / 1000000) % 60);

		return String.format("%02d:%02d", minutes, seconds);

	}

}
