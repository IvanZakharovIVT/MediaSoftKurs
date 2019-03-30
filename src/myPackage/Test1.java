package myPackage;

import static org.junit.Assert.*;

import org.junit.*;

public class Test1 {

	@Test
	public void testMovie() {
		Movie test = new Movie(1, "Dune", 1984, 6, "Devid Linch", 6.7);
		String S = test.getName();
		assertEquals("Movie:Dune. Directed by Devid Linch", S);
	}
	@Test
	public void testSerial() {
		Serial serial = new Serial(1, "Doctor Who", 1955, 2019, 11, "Cris Chibbnel",1);
		String S = serial.getAge();
		assertEquals("Series:Doctor Who Start 64 year ago and runing for nowday", S);
	}
}
