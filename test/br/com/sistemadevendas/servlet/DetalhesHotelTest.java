package br.com.sistemadevendas.servlet;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import br.com.sistemadevendas.bd.HotelDAOStub;
import br.com.sistemadevendas.models.Hotel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DetalhesHotelTest {
	
	private class DetalhesHotelStubbed extends DetalhesHotel {
		public DetalhesHotelStubbed() {
			hotelDao = new HotelDAOStub();
		}
	}
	
	@Test(expected=ServletException.class)
	public void testFailOnMissingIdParameter() throws ServletException, IOException {
		class InvalidRequest extends HttpServletRequestStub {
			@Override
			public String getParameter(String param) {
				if (param != "id")
					throw new NotImplementedException();
				return null;
			}
		}
		
		HttpServletRequest request = new InvalidRequest();
		DetalhesHotelStubbed servlet = new DetalhesHotelStubbed();
		try {
			servlet.doGet(request, null);
		} catch (ServletException e) {
			assertEquals("Missing ID parameter", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected=ServletException.class)
	public void testFailOnNonExistingHotel() throws ServletException, IOException {
		class MissingHotelRequest extends HttpServletRequestStub {
			@Override
			public String getParameter(String param) {
				if (param != "id")
					throw new NotImplementedException();
				return "5";
			}
		}
		
		HttpServletRequest request = new MissingHotelRequest();
		DetalhesHotelStubbed servlet = new DetalhesHotelStubbed();
		try {
			servlet.doGet(request, null);
		} catch (ServletException e) {
			assertEquals("Invalid hotel id", e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testShowsCorrectHotel() throws ServletException, IOException {
		class SuccesfulRequest extends HttpServletRequestStub {
			private int id;
			private boolean setAttributeCalled;
			
			public SuccesfulRequest(int id) {
				this.id = id;
			}
			
			@Override
			public String getParameter(String param) {
				if (param != "id")
					throw new NotImplementedException();
				return String.valueOf(id);
			}
			
			@Override
			public void setAttribute(String param, Object value) {
				if (param != "hotel")
					throw new NotImplementedException();
				// Should return the hotel with matching ID
				assertEquals(((Hotel)value).getId(), this.id);
				setAttributeCalled = true;
			}
			
			public boolean setAttributeCalled() {
				return setAttributeCalled;
			}
			
			@Override
			public RequestDispatcher getRequestDispatcher(String arg0) {
				return new RequestDispatcher() {
					@Override
					public void include(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException { throw new NotImplementedException(); }
					
					@Override
					public void forward(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {}
				};
			};
		}
		
		SuccesfulRequest request = new SuccesfulRequest(1);
		DetalhesHotelStubbed servlet = new DetalhesHotelStubbed();
		servlet.doGet(request, null);
		assert(request.setAttributeCalled());
	}

}
