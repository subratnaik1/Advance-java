package pack1;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		IO.println("httpSession created");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		IO.println("HttpSession Destroyed");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		IO.println("Attribute added to the session"+hsbe.getName());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		IO.println("Attribute removed the session"+hsbe.getName());
	}
}
