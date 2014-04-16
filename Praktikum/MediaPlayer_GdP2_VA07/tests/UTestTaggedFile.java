import static org.junit.Assert.*;
import org.junit.Test;
public class UTestTaggedFile {
     @Test
     public void test_play_01() throws Exception {
    	  TaggedFile tf = new TaggedFile("audiofiles/Rock 812.mp3");
    	  tf.play();
    	  // Note: cancel playback in eclipse console window
     }
	
     @Test
     public void test_timeFormatter_10() throws Exception {
    	  assertEquals("Wrong time format", "05:05",
    			   TaggedFile.timeFormatter(305862000L));
     }
     
     @Test
     public void test_timeFormatter_08() throws Exception {
    	 try {
    		  // Call method with time value that underflows our format
    		  TaggedFile.timeFormatter(-1L);
    		  // We should never get here
    		  fail("Time value underflows format; expecting exception");
    		  
    	 }catch (RuntimeException e) {
    		 // Expected
    	 }
     }
     
}
