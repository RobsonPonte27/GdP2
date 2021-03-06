import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UTestAudioFile {
	// pathname tests
	@Test
	public void test_AudioFile_parsePathname_01() throws Exception {
		AudioFile af = new AudioFile();
		
		af.parsePathname("");
		
		assertEquals("failed to parse empty pathname", "", af.getPathname());
		assertEquals("failed to parse empty filename", "", af.getFilename());
	}
	
	@Test
	public void test_AudioFile_parsePathname_02() throws Exception {
		AudioFile af = new AudioFile();
		String blanks = "    ";
		af.parsePathname(blanks);
		
		assertEquals("failed to parse pathname containing only blanks", blanks, af.getPathname());
		assertEquals("failed to parse filename containing only blanks", blanks, af.getFilename());
	}
	
	@Test
	public void test_AudioFile_parsePathname_03() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "file.mp3";
		
		af.parsePathname(pathName);
		
		assertEquals("failed to parse pathname for '" + pathName + "'", "file.mp3", af.getPathname());
		assertEquals("failed to parse filename for '" + pathName + "'", "file.mp3", af.getFilename());
	}
	
	@Test
	public void test_AudioFile_parsePathname_04() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/my-tmp/file.mp3";
		
		af.parsePathname(pathName);

		assertEquals("failed to parse pathname for '" + pathName + "'", pathName, af.getPathname());
		assertEquals("failed to parse filename for '" + pathName + "'", "file.mp3", af.getFilename());
	}
	
	@Test
	public void test_AudioFile_parsePathname_05() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "//my-tmp////part1//file.mp3/";
		
		af.parsePathname(pathName);

		assertEquals("failed to parse pathname for '" + pathName +"'", "/my-tmp/part1/file.mp3/", af.getPathname());
		assertEquals("failed to parse filename for '" + pathName +"'", "", af.getFilename());
	}
	
	@Test
	public void test_AudioFile_parsePathname_06() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "d:\\\\part1///file.mp3";
		
		af.parsePathname(pathName);

		assertEquals("failed to parse pathname for '" + pathName +"'", "/d/part1/file.mp3", af.getPathname());
		assertEquals("failed to parse filename for '" + pathName +"'", "file.mp3", af.getFilename());	
	}
	
	// filename tests
	@Test
	public void test_AudioFile_parseFilename_01() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = " Falco  -  Rock me    Amadeus .mp3  ";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", " Falco  -  Rock me    Amadeus .mp3  ", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Falco", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "Rock me    Amadeus", af.getTitle());
	}

	@Test
	public void test_AudioFile_parseFilename_02() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/ Falco  -  Rock me    Amadeus .mp3  ";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", " Falco  -  Rock me    Amadeus .mp3  ", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Falco", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "Rock me    Amadeus", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_03() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "Frankie Goes To Hollywood - The Power Of Love.ogg";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "Frankie Goes To Hollywood - The Power Of Love.ogg", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Frankie Goes To Hollywood", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "The Power Of Love", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_04() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/Frankie Goes To Hollywood - The Power Of Love.ogg";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "Frankie Goes To Hollywood - The Power Of Love.ogg", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Frankie Goes To Hollywood", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "The Power Of Love", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_05() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "audiofile.aux";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "audiofile.aux", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "audiofile", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_06() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/audiofile.aux";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "audiofile.aux", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "audiofile", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_07() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","A.U.T.O.R", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "T.I.T.E.L", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_08() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","A.U.T.O.R", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "T.I.T.E.L", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_09() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Hans-Georg Sonstwas", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "Blue-eyed boy-friend", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_10() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","Hans-Georg Sonstwas", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "Blue-eyed boy-friend", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_11() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "-";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "-", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "-", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_12() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/-";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", "-", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "-", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_13() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = " - ";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", " - ", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "", af.getTitle());
	}
	
	@Test
	public void test_AudioFile_parseFilename_14() throws Exception {
		AudioFile af = new AudioFile();
		String pathName = "/dir/ - ";
		
		af.parsePathname(pathName);
		af.parseFilename(af.getFilename());
		
		assertEquals("failed to save filename for '" + pathName + "'", " - ", af.getFilename());
		assertEquals("failed to parse author for '" + pathName + "'","", af.getAuthor());
		assertEquals("failed to parse title for '" + pathName + "'", "", af.getTitle());
	}
	
	// Konstruktor & toString tests
	@Test
	public void test_AudioFile_konstruktor_toString_01() throws Exception {
		AudioFile af = new AudioFile(" Falco  -  Rock me    Amadeus .mp3  ");
		
		assertEquals("failed to parse ' Falco  -  Rock me    Amadeus .mp3  '", "Falco - Rock me    Amadeus", af.toString());
	}

	@Test
	public void test_AudioFile_konstruktor_toString_02() throws Exception {
		AudioFile af = new AudioFile("/dir/ Falco  -  Rock me    Amadeus .mp3  ");
		
		assertEquals("failed to parse '/dir/ Falco  -  Rock me    Amadeus .mp3  '", "Falco - Rock me    Amadeus", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_03() throws Exception {
		AudioFile af = new AudioFile("Frankie Goes To Hollywood - The Power Of Love.ogg");
		
		assertEquals("failed to parse 'Frankie Goes To Hollywood - The Power Of Love.ogg'", "Frankie Goes To Hollywood - The Power Of Love", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_04() throws Exception {
		AudioFile af = new AudioFile("/dir/Frankie Goes To Hollywood - The Power Of Love.ogg");
		
		assertEquals("failed to parse '/dir/Frankie Goes To Hollywood - The Power Of Love.ogg'", "Frankie Goes To Hollywood - The Power Of Love", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_05() throws Exception {
		AudioFile af = new AudioFile("audiofile.aux");
		
		assertEquals("failed to parse 'audiofile.aux'", "audiofile", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_06() throws Exception {
		AudioFile af = new AudioFile("/dir/audiofile.aux");
		
		assertEquals("failed to parse '/dir/audiofile.aux'", "audiofile", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_07() throws Exception {
		AudioFile af = new AudioFile("   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION");

		
		assertEquals("failed to parse '   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION'", "A.U.T.O.R - T.I.T.E.L", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_08() throws Exception {
		AudioFile af = new AudioFile("/dir/   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION");
		
		assertEquals("failed to parse '/dir/   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION'", "A.U.T.O.R - T.I.T.E.L", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_09() throws Exception {
		AudioFile af = new AudioFile("Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3");
		
		assertEquals("failed to parse '/dir/Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3'", "Hans-Georg Sonstwas - Blue-eyed boy-friend", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_10() throws Exception {
		AudioFile af = new AudioFile("/dir/Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3");
		
		assertEquals("failed to parse '/dir/Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3'", "Hans-Georg Sonstwas - Blue-eyed boy-friend", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_11() throws Exception {
		AudioFile af = new AudioFile("-");
		
		assertEquals("failed to parse '-'", "-", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_12() throws Exception {
		AudioFile af = new AudioFile("/dir/-");
		
		assertEquals("failed to parse '/dir/-'", "-", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_13() throws Exception {
		AudioFile af = new AudioFile(" - ");
		
		assertEquals("failed to parse ' - '", "", af.toString());
	}
	
	@Test
	public void test_AudioFile_konstruktor_toString_14() throws Exception {
		AudioFile af = new AudioFile("/dir/ - ");
		
		assertEquals("failed to parse '/dir/ - '", "", af.toString());
	}
}