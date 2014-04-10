
public class AudioFile {
	
	//attributes
	
	String pathname;
	String filename;
	
	//constructors
	
	public AudioFile () {
		
		pathname = "";
		filename = "";
		
	}

    //getters
	
	public String getPathname () {
		return pathname;
	}
	
	
	public String getFilename () {
		return filename;
	}
	
	
	// public methods
	public void parsePathname (String pathname) {
		
		// slashes richten
		pathname = pathname.replace('\\', java.io.File.separatorChar);
		pathname = pathname.replace('/', java.io.File.separatorChar);
		
		// doppelte slashes sollen rausfallen
		StringBuffer buffer = new StringBuffer();
		for (int i = 0, ib = 0; i < pathname.length(); i++) {
			if (pathname.charAt(i) != java.io.File.separatorChar || ib == 0 || buffer.charAt(ib-1) != java.io.File.separatorChar) {
				buffer.append(pathname.charAt(i));
				ib++;
			}
		}
		
		// convertiere buffer
		pathname = buffer.toString();
		
		System.out.println(pathname);
		
	}
	
	
	
}
