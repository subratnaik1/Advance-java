package pack1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		IO.println("Servletcontext object Initialized");
		ServletContext context = sce.getServletContext();
		IO.println("App 9 is deployes in to :" + context.getServerInfo());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		IO.println("servletContext object destroyed");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		IO.println("attribute added to the servletContexe object");
		String attributeName = scae.getName();
		IO.println("Attribute name:" + attributeName);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		IO.println("Attribute removed from the servlet context");
	}
}
