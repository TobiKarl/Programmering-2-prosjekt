package KlasseTester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import Klasser.Converter;

public class ConverterTEST {
	
	
	
	@Before
	public void setUp(){
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void dwaodwa() {
		Converter.hexToInt("8h4o3hu");
	}
	@Test
	public void hexToInt_f_ShouldReturn15() {
	assertThat( Converter.hexToInt("f"), is(15) );
	}
	
	@Test
	public void hexToInt_AB4E7_ShouldReturn701671(){
		assertThat( Converter.hexToInt("AB4E7"), is(701671) ) ;
	}
	
	@Test
	public void intToHex_14_ShouldReturnE(){
		assertThat( Converter.intToHex(14), is("E"));
	}
	
	@Test
	public void intToHex_90123_ShouldReturn1600B(){
		assertThat( Converter.intToHex(90123), is("1600B"));
	}
	
	
	@Test(expected = IllegalArgumentException.class	)
	public void binaryToInt_0202_shouldThrowException(){
		Converter.binaryToInt("0202");
	}
	
	@Test
	public void binaryToInt_11010_ShouldReturn26(){
		assertThat ( Converter.binaryToInt("11010"), is(26));
	}
	
	@Test
	public void intToBinary_27_ShouldReturn11011(){
		assertThat ( Converter.intToBinary(27), is("11011"));
	}

}
