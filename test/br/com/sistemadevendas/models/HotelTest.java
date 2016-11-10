package br.com.sistemadevendas.models;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

public class HotelTest {

	@Test
	public void testHotel() {
		Hotel hotel = new Hotel(3, "TestHotel", 80.0, 0);
		assertEquals(3, hotel.getId());
		assertEquals("TestHotel", hotel.getNome());
		assertEquals(80.0, hotel.getPrecoDiaria(), 1e-8);
		assertEquals(0, hotel.getCidade());
	}

	@Test(expected=InvalidParameterException.class)
	public void testFailOnInvalidPrice() {
		new Hotel(0, "TestHotel", -14.0, 0);
	}

}
