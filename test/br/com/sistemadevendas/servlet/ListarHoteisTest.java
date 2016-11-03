package br.com.sistemadevendas.servlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;

import br.com.sistemadevendas.bd.HotelDAOStub;
import br.com.sistemadevendas.models.Hotel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ListarHoteisTest {

	private class ListarHoteisStubbed extends ListarHoteis {
		public ListarHoteisStubbed() {
			hotelDao = new HotelDAOStub();
		}
	}
	
	@Test
	public void testShowsHotelList() throws ServletException, IOException {
		class SuccesfulRequest extends HttpServletRequestStub {
			private boolean setAttributeCalled;
			
			@Override
			public void setAttribute(String param, Object value) {
				if (param != "hoteis")
					throw new NotImplementedException();
				// Should return all the hotels
				assertEquals(((List<Hotel>)value), new HotelDAOStub().getHoteis());
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
		
		SuccesfulRequest request = new SuccesfulRequest();
		ListarHoteisStubbed servlet = new ListarHoteisStubbed();
		servlet.doGet(request, null);
		assert(request.setAttributeCalled());
	}

}
