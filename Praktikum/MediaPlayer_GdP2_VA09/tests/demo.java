import java.util.Map;

import org.junit.Test;

import studiplayer.audio.TaggedFile;
import studiplayer.basic.TagReader;


public class demo {

	@Test
	public void test() {
		TaggedFile tf = new TaggedFile("audiofiles/Rock 812.mp3");
		Map<String, Object> tag_map = TagReader.readTags(tf.getPathname());
		for (String key : tag_map.keySet()) {
			System.out.printf("\n\nKey: %s", key);
			System.out.printf("\nTyp: %s", tag_map.get(key).getClass().toString());
			System.out.printf("\nWert: " + tag_map.get(key));
			
		}
			
	}

}
