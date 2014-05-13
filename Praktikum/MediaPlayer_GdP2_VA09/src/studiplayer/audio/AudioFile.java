package studiplayer.audio;

import java.io.File;
import java.util.regex.Matcher;

public abstract class AudioFile {

	protected String pathname;
	protected String filename;

	protected String author;
	protected String title;

	public AudioFile() {
	}

	public AudioFile(String path) throws NotPlayableException {
		pathname = path;

		parsePathname(path);
		parseFilename(filename);

		File neu = new File(getPathname());
		if (!neu.canRead()) {

			throw new NotPlayableException(pathname,
					"Der Pfad kann nicht gelesen werden!");
		}

	}

	public abstract void play() throws NotPlayableException;

	public abstract void togglePause();

	public abstract void stop();

	public abstract String getFormattedDuration();

	public abstract String getFormattedPosition();

	public abstract String[] fields();

	public void parsePathname(String path) {
		path = path.replaceAll("/+", Matcher.quoteReplacement(File.separator));
		path = path.replaceAll("\\\\+",
				Matcher.quoteReplacement(File.separator));

		pathname = path.trim();
		if (path.isEmpty()) {
			pathname = path;
			filename = path;
		} else if (!path.contains("/") & !path.contains("\\")) {
			pathname = path;
			filename = path;
		}

		else {

			if (pathname.contains("/") & pathname.contains(":")) {
				pathname = pathname.replace(':', '/');
				pathname = "/" + pathname;

				pathname = pathname.replaceAll("/+",
						Matcher.quoteReplacement("/"));
				pathname = pathname.replaceAll("\\\\+",
						Matcher.quoteReplacement("/"));
			}

			if (pathname.endsWith("/") | pathname.endsWith("\\")) {
				filename = "";
			} else
				filename = pathname.substring(pathname
						.lastIndexOf(File.separator) + 1);

		}

		if (!pathname.endsWith("/") | pathname.length() > 3)
			filename = pathname
					.substring(pathname.lastIndexOf(File.separator) + 1);

	}

	public String getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getPathname() {
		return this.pathname;
	}

	public String getFilename() {

		return this.filename;
	}

	public void parseFilename(String file) {

		int i;

		if (file.contains(".")) {
			file = file.substring(0, file.lastIndexOf('.'));
		}

		if (file.trim() == "") {
			author = "";
			title = "";
		}
		if (!file.contains("-")) {
			author = "";
			title = file.trim();
		}

		else if (file.startsWith("-") & file.endsWith("-") & file.length() < 2) {
			author = "";
			title = "-";
		} else if (file.trim().startsWith("-") & file.trim().endsWith("-")
				& file.trim().length() < 2) {
			author = "";
			title = "";
		} else {
			file = file.trim();

			int zaehler = 0;
			for (i = 0; i < file.length(); i++) {
				if (file.charAt(i) == '-') {
					zaehler = zaehler + 1;
				}
			}
			if (zaehler >= 1) {
				String teile[] = file.split(" - ");
				author = teile[0];
				author = author.trim();
				title = teile[1];
				title = title.trim();
			}

		}
	}

	public String toString() {
		String gesamt;
		if (getAuthor().isEmpty()) {
			gesamt = getTitle();

		} else
			gesamt = getAuthor() + " - " + getTitle();

		return gesamt;
	}

}