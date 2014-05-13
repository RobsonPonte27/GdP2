import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import studiplayer.audio.TaggedFile;
import studiplayer.basic.TagReader;

public class UTestTaggedFile {
	// basic setup
	private  char sep = java.io.File.separatorChar;
	// private String osname = System.getProperty("os.name");
	private String root = "/";
	    
	/* This Array contains the mediafiles that are supposed to play without
	 * causing the unit tests to fail
	 */
	private String undamagedSongs[] = {
			"audiofiles" + sep + "Eisbach Deep Snow.ogg",
			"audiofiles" + sep + "kein.ogg.sondern.wav",
			"audiofiles" + sep + "kein.wav.sondern.ogg",
			"audiofiles" + sep + "MadreDFD.mp3",
			"audiofiles" + sep + "Meltdown.mp3",
			"audiofiles" + sep + "Road Movie.mp3",
			"audiofiles" + sep + "Rock 812.mp3",
			"audiofiles" + sep + "special.oGg",
			"audiofiles" + sep + "tanom p2 journey.mp3",
			"audiofiles" + sep + "wellenmeister_awakening.ogg",
			"audiofiles" + sep + "wellenmeister - fire.mp3",
			"audiofiles" + sep + "wellenmeister - tranquility.wav"
	};
	
	/* This Array contains the provided mediafiles that are supposed to cause
	 * errors when called in unit tests
	 */
	private String damagedSongs[] = {
			"audiofiles/Rock 812.cut.mp3",
			"audiofiles/wellenmeister - tranquility.cut.wav"
	};
	
	/* This Array contains the imaginary pathnames for non-existent mediafiles
	 * to cause some additional errors when parsing during unit tests
	 */
	private String imaginarySongs[] = {
	        root + "home" + sep + "meier" + sep + "Musik" + sep + "Falco - Rock Me Amadeus.mp3",
	        root + "home" + sep + "db-admin" + sep + "Frankie Goes To Hollywood - The Power Of Love.ogg",
	        root + "tmp" + sep + "Deep Purple - Smoke On The Water.wav",
	        root + "my-tmp" + sep + "file.mp3",
	        "Falco - Rock Me Amadeus.mp3",
	        "file.mp3",
	        ".." + sep + "music" + sep + "audiofile.au",
	        "   A.U.T.O.R   -   T.I.T.E.L   .EXTENSION",
	        "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3",
	        "",
	        " ",
	        "//your-tmp/part1//file.mp3/",
	        "../your-tmp/..//part1//file.mp3/",
	        "\\file.mp3",
	        "\\part1\\\\file.mp3\\",
	        "\\part1///file.mp3",
	        "/MP3-Archiv/.nox",
	        "/MP3-Archiv/Falco - Rock me Amadeus.",
	        "-",
	        " -  "
	};
	
	
	/* Functionality test
	 * 
	 */
	@Test
	@Ignore
	public void test_play_undamaged() throws Exception {
		// note: cancel playback in eclipse console window
        String current = null;
        try {
            for (int i = 3; i < undamagedSongs.length; i++) {
                String p = undamagedSongs[i];
                current = p;

                TaggedFile tf = new TaggedFile(p);
                tf.play();
/*
                assertEquals("getPathname() fuer Testfall [" + i + "]: " + p
                        + " nicht korrekt", expectedPathNames[i],
                        af.getPathname());
                assertEquals("getFilename() fuer Testfall [" + i + "]: " + p
                        + " nicht korrekt", expectedFileNames[i],
                        af.getFilename());
                assertEquals("getAuthor() fuer Testfall [" + i + "]: " + p
                        + " nicht korrekt", authors[i], af.getAuthor());
                assertEquals("getTitle() fuer Testfall [" + i + "]: " + p
                        + " nicht korrekt", titles[i], af.getTitle());
                assertEquals("toString() fuer Testfall [" + i + "]: " + p
                        + " nicht korrekt", toStrings[i], af.toString());*/
            }
        } catch (Exception e) {
            fail("Fehler fuer pathname:" + current + ":" + e);
        }
	}
	
	/* This unit test is used to check for time calculation
	 */
	@Test
	public void test_timeFormatter_01() throws Exception {
		assertEquals("Wrong time format", "05:05", TaggedFile.timeFormatter(305862000L));
	}
	
	@Test
	public void test_timeFormatter_02() throws Exception {
		assertEquals("Wrong time format", "99:59", TaggedFile.timeFormatter(5999999999L));
	}
	
	@Test
	public void test_timeFormatter_03() throws Exception {
		try {
			// Call method with time value that underflows our format
			TaggedFile.timeFormatter(-1L);
			// We should never get here
			fail("Time value underflows format; expecting exception");
		} catch (RuntimeException e) {
			// this is expected, so pass
		}
	}
	@Test
	public void test_timeFormatter_04() throws Exception {
		try {
			// Call method with time value that overflows our format
			TaggedFile.timeFormatter(6000000000L);
			// We should never get here
			fail("Time value overflows format; expecting exception");
		} catch (RuntimeException e){
			// this is expected, so pass
		}
	}
	
	/* Read all tags from a TaggedFile
	 * This test demonstrates the functionality of TagReader.readTags()
	 */
	@Test
	public void test_readTags_01() throws Exception {
		TaggedFile tf = new TaggedFile("audiofiles/Eisbach Deep Snow.ogg");
		Map<String, Object> tag_map = TagReader.readTags(tf.getPathname());
		for (String key : tag_map.keySet()) {
			System.out.printf("\nKey: %s\n", key);
			System.out.printf("Type of value: %s\n", tag_map.get(key).getClass().toString());
			System.out.println("Value: " + tag_map.get(key));
		}
	}
	
	@Test
	@Ignore
	public void test_readAndStoreTags_02() throws Exception {
		TaggedFile tf = new TaggedFile();
		tf.readAndStoreTags("audiofiles/Rock 812.mp3");
		assertEquals("Wrong author", "Eisbach", tf.getAuthor());
		assertEquals("Wrong title", "Rock 812", tf.getTitle());
		assertEquals("Wrong album", "The Sea, the Sky", tf.getAlbum());
		assertEquals("Wrong time format", "05:31", tf.getFormattedDuration());
	}
}
