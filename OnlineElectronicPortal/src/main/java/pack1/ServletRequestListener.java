package pack1;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
@WebListener
public class ServletRequestListener implements javax.servlet.ServletRequestListener,ServletRequestAttributeListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		IO.println("ServletRequestObject initializer");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		IO.println("servletRequestObject destroyed");
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae)
	{
		IO.println("attribute added to the servletRequest====>"+srae.getName());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		IO.println("Attribute removed from the servletRequest====>"+srae.getName());
	}
}
