package velocity.render;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityRender {

	public static void main(String[] args) throws Exception  {
		
		Properties properties = new Properties();
		properties.setProperty("file.resource.loader.path", "");
		
		VelocityEngine velocity = new VelocityEngine(properties);
		VelocityContext context = new VelocityContext();
		context.put("name", "czy");
		
		Template template = velocity.getTemplate("D:/workspace/TestIdea/src/main/java/velocity/render/template.vm");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		template.merge(context, writer);
		
		writer.flush();
		writer.close();
		
		System.out.println(template.toString());
	}

}
