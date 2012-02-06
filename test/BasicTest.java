import org.junit.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void testDocument() throws MalformedURLException {
    	Document doc = new Document();
    	String google = "http://www.google.com";
    	doc.url = new URL(google);
    	doc.save();
    	
    	doc = Document.find("byUrl", new URL(google)).first();
    	//
    	assertNotNull(doc);
    	assertEquals(doc.url, new URL(google));
    	
    	doc.delete();
    }

}
