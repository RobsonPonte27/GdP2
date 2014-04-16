
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
		
		// sonderfall nur leerzeichen
		if (pathname.trim().length() == 0){
			this.pathname = pathname;
			filename = pathname;
			return;
		}
		
		// sonderfall nur datei
		if (!pathname.contains(java.io.File.separator)) {
			this.pathname = pathname;
			filename = pathname;
			return;
		}
		
		// sonderfall laufwerkname vor dateinamen
		if (pathname.contains(":")) {
			pathname = pathname.replace(':', java.io.File.separatorChar);
			pathname = java.io.File.separator + pathname;
		}
		
		// ab hier pfad und datei
		
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
		this.pathname = buffer.toString();
		filename = pathname.substring(pathname.lastIndexOf(java.io.File.separatorChar)+1);
		
		System.out.println(pathname);
	}
	
	
	
}
