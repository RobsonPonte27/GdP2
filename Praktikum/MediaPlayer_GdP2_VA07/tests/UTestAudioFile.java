import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UTestAudioFile {
	// basic setup
	private  char sep = java.io.File.separatorChar;
	// private String osname = System.getProperty("os.name");
    private String root = "/";

    // This array contains the arguments we feed to method parsePathname()
    private String pathNames[] = {
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
    
    /* Array of the results expected from method getPathname() 
     * We expect normalization with respect to consecutive occurrences of / and \
     * and replacement by a single java.io.File.separatorChar
     * Spaces and tabs (white space) are not altered.
     */
    private String expectedPathNames[] =  {
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
        sep + "your-tmp" + sep + "part1" + sep + "file.mp3" + sep,
        ".." + sep + "your-tmp" + sep + ".." + sep + "part1" + sep + "file.mp3" + sep,
        sep + "file.mp3",
        sep + "part1" + sep + "file.mp3" + sep,
        sep + "part1" + sep + "file.mp3",
        sep + "MP3-Archiv" + sep + ".nox",
        sep + "MP3-Archiv" + sep + "Falco - Rock me Amadeus.",
        "-",
        " -  "
    };

    /* Array of the results expected from method getFilename() 
     * Spaces and tabs (white space) are not altered.
     */
    private String expectedFileNames[] = {
        "Falco - Rock Me Amadeus.mp3",
        "Frankie Goes To Hollywood - The Power Of Love.ogg",
        "Deep Purple - Smoke On The Water.wav",
        "file.mp3",
        "Falco - Rock Me Amadeus.mp3",
        "file.mp3",
        "audiofile.au",
        "   A.U.T.O.R   -   T.I.T.E.L   .EXTENSION",
        "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3",
        "",
        " ",
        "",
        "",
        "file.mp3",
        "",
        "file.mp3",
        ".nox",
        "Falco - Rock me Amadeus.",
        "-",
        " -  "
    };
    
    /* Array of the results expected from method getAuthor() 
     * Leading and trailing spaces and tabs (white space) are trimmed.
     */
    private String authors[] = {
        "Falco",
        "Frankie Goes To Hollywood",
        "Deep Purple",
        "",
        "Falco",
        "",
        "",
        "A.U.T.O.R",
        "Hans-Georg Sonstwas",
        "", 
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Falco",
        "",
        ""
    };
    
    /* Array of the results expected from method getTitle() 
     * Leading and trailing spaces and tabs (white space) are trimmed.
     */
    private String titles[] = {
        "Rock Me Amadeus",
        "The Power Of Love",
        "Smoke On The Water",
        "file",
        "Rock Me Amadeus",
        "file",
        "audiofile",
        "T.I.T.E.L",
        "Blue-eyed boy-friend",
        "",
        "",
        "",
        "",
        "file",
        "",
        "file",
        "",
        "Rock me Amadeus",
        "-",
        ""
    };
    
    // Array of the results expected from method toString() 
    private String toStrings[] = {
        "Falco - Rock Me Amadeus",
        "Frankie Goes To Hollywood - The Power Of Love",
        "Deep Purple - Smoke On The Water",
        "file",
        "Falco - Rock Me Amadeus",
        "file",
        "audiofile",
        "A.U.T.O.R - T.I.T.E.L",
        "Hans-Georg Sonstwas - Blue-eyed boy-friend",
        "",
        "",
        "",
        "",
        "file",
        "",
        "file",
        "",
        "Falco - Rock me Amadeus",
        "-",
        ""
    };

    /* Auxiliary methods 
     */
    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }
    
    // put unit test below here
}