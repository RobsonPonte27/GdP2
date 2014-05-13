package studiplayer.audio;

import studiplayer.basic.BasicPlayer;

public abstract class SampledFile extends AudioFile {

	protected String duration = "";

	public SampledFile() {
		super();

	}

	public SampledFile(String path) throws NotPlayableException {
		super(path);

	}

	public void play() throws NotPlayableException {
		try {
			BasicPlayer.play(getPathname());
		} catch (RuntimeException e) {
			throw new NotPlayableException(pathname, e);
		}
	}

	public void togglePause() {

		BasicPlayer.togglePause();
	}

	public void stop() {

		BasicPlayer.stop();
	}

	public String getFormattedDuration() {

		return timeFormatter(Long.valueOf(duration));
	}

	public String getFormattedPosition() {

		return timeFormatter(studiplayer.basic.BasicPlayer.getPosition());
	}

	public static String timeFormatter(long microtime) {
		double m;
		double s;
		int minuten;
		int sekunden;
		String zeit;
		String hilf1;
		String hilf2;

		if (microtime < 0) {
			throw new RuntimeException("Negativ time value provided");
		}
		if (microtime >= (99 * 60 + 60) * Math.pow(10, 6)) {
			throw new RuntimeException("Time value exceeds allowed format");
		}

		microtime = (long) (microtime / Math.pow(10, 6));
		m = microtime / 60;
		s = microtime % 60;
		minuten = (int) m;
		sekunden = (int) s;
		if (minuten <= 9) {
			hilf1 = "0" + minuten;

		} else
			hilf1 = "" + minuten;
		if (sekunden <= 9) {
			hilf2 = "0" + sekunden;

		} else
			hilf2 = "" + sekunden;

		zeit = hilf1 + ":" + hilf2;
		return zeit;
	}

}
