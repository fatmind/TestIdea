package velocity.render;

import org.apache.velocity.app.event.implement.IncludeNotFound;
import org.apache.velocity.runtime.RuntimeServices;

public class VelocityEventHandler extends IncludeNotFound {

	@Override
	public String includeEvent(String includeResourcePath,
			String currentResourcePath, String directiveName) {
		return includeResourcePath + " not found";
	}

	@Override
	public void setRuntimeServices(RuntimeServices rs) {
		super.setRuntimeServices(rs);
	}

}
