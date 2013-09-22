package velocity.macro;

import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


public class VelocityMacro {
	
	public static void main(String[] args) throws Exception {

		InputStream in = VelocityMacro.class.getClassLoader().getResourceAsStream("velocity.properties");
		Properties pros = new Properties();
		pros.load(in);
		
		Velocity.init(pros);
		
		Template t = Velocity.getTemplate("/src/main/java/com/velocity/macro2.vm");
		
		VelocityContext ctx = new VelocityContext();
		
		Writer writer = new StringWriter();
		t.merge(ctx, writer);
		
		System.out.println(writer); 
		
	}
	

}
