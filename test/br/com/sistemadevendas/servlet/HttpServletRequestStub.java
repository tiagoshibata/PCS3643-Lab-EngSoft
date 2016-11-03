package br.com.sistemadevendas.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HttpServletRequestStub implements HttpServletRequest {
	
	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) { throw new NotImplementedException(); }
	
	@Override
	public AsyncContext startAsync() { throw new NotImplementedException(); }
	
	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException { throw new NotImplementedException(); }
	
	@Override
	public void setAttribute(String arg0, Object arg1) { throw new NotImplementedException(); }
	
	@Override
	public void removeAttribute(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public boolean isSecure() { throw new NotImplementedException(); }
	
	@Override
	public boolean isAsyncSupported() { throw new NotImplementedException(); }
	
	@Override
	public boolean isAsyncStarted() { throw new NotImplementedException(); }
	
	@Override
	public ServletContext getServletContext() { throw new NotImplementedException(); }
	
	@Override
	public int getServerPort() { throw new NotImplementedException(); }
	
	@Override
	public String getServerName() { throw new NotImplementedException(); }
	
	@Override
	public String getScheme() { throw new NotImplementedException(); }
	
	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public int getRemotePort() { throw new NotImplementedException(); }
	
	@Override
	public String getRemoteHost() { throw new NotImplementedException(); }
	
	@Override
	public String getRemoteAddr() { throw new NotImplementedException(); }
	
	@Override
	public String getRealPath(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public BufferedReader getReader() throws IOException { throw new NotImplementedException(); }
	
	@Override
	public String getProtocol() { throw new NotImplementedException(); }
	
	@Override
	public String[] getParameterValues(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public Enumeration<String> getParameterNames() { throw new NotImplementedException(); }
	
	@Override
	public Map<String, String[]> getParameterMap() { throw new NotImplementedException(); }
	
	@Override
	public String getParameter(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public Enumeration<Locale> getLocales() { throw new NotImplementedException(); }
	
	@Override
	public Locale getLocale() { throw new NotImplementedException(); }
	
	@Override
	public int getLocalPort() { throw new NotImplementedException(); }
	
	@Override
	public String getLocalName() { throw new NotImplementedException(); }
	
	@Override
	public String getLocalAddr() { throw new NotImplementedException(); }
	
	@Override
	public ServletInputStream getInputStream() throws IOException { throw new NotImplementedException(); }
	
	@Override
	public DispatcherType getDispatcherType() { throw new NotImplementedException(); }
	
	@Override
	public String getContentType() { throw new NotImplementedException(); }
	
	@Override
	public int getContentLength() { throw new NotImplementedException(); }
	
	@Override
	public String getCharacterEncoding() { throw new NotImplementedException(); }
	
	@Override
	public Enumeration<String> getAttributeNames() { throw new NotImplementedException(); }
	
	@Override
	public Object getAttribute(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public AsyncContext getAsyncContext() { throw new NotImplementedException(); }
	
	@Override
	public void logout() throws ServletException { throw new NotImplementedException(); }
	
	@Override
	public void login(String arg0, String arg1) throws ServletException { throw new NotImplementedException(); }
	
	@Override
	public boolean isUserInRole(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public boolean isRequestedSessionIdValid() { throw new NotImplementedException(); }
	
	@Override
	public boolean isRequestedSessionIdFromUrl() { throw new NotImplementedException(); }
	
	@Override
	public boolean isRequestedSessionIdFromURL() { throw new NotImplementedException(); }
	
	@Override
	public boolean isRequestedSessionIdFromCookie() { throw new NotImplementedException(); }
	
	@Override
	public Principal getUserPrincipal() { throw new NotImplementedException(); }
	
	@Override
	public HttpSession getSession(boolean arg0) { throw new NotImplementedException(); }
	
	@Override
	public HttpSession getSession() { throw new NotImplementedException(); }
	
	@Override
	public String getServletPath() { throw new NotImplementedException(); }
	
	@Override
	public String getRequestedSessionId() { throw new NotImplementedException(); }
	
	@Override
	public StringBuffer getRequestURL() { throw new NotImplementedException(); }
	
	@Override
	public String getRequestURI() { throw new NotImplementedException(); }
	
	@Override
	public String getRemoteUser() { throw new NotImplementedException(); }
	
	@Override
	public String getQueryString() { throw new NotImplementedException(); }
	
	@Override
	public String getPathTranslated() { throw new NotImplementedException(); }
	
	@Override
	public String getPathInfo() { throw new NotImplementedException(); }
	
	@Override
	public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException { throw new NotImplementedException(); }
	
	@Override
	public Part getPart(String arg0) throws IOException, IllegalStateException, ServletException { throw new NotImplementedException(); }
	
	@Override
	public String getMethod() { throw new NotImplementedException(); }
	
	@Override
	public int getIntHeader(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public Enumeration<String> getHeaders(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public Enumeration<String> getHeaderNames() { throw new NotImplementedException(); }
	
	@Override
	public String getHeader(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public long getDateHeader(String arg0) { throw new NotImplementedException(); }
	
	@Override
	public Cookie[] getCookies() { throw new NotImplementedException(); }
	
	@Override
	public String getContextPath() { throw new NotImplementedException(); }
	
	@Override
	public String getAuthType() { throw new NotImplementedException(); }
	
	@Override
	public boolean authenticate(HttpServletResponse arg0) throws IOException, ServletException { throw new NotImplementedException(); }

}
