package KlasseTester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import Klasser.Converter;
import Klasser.FilKlasse;

public class ConverterTEST {
	
	String binary1;
	String binary2;
	String resultBinaryAND;
	String resultBinaryOR;
	

	
	@Before
	public void setUp(){
		binary1 = "010011001001010111010101";
		binary2 = "011001001110010010010001";
		resultBinaryAND = "010001001000010010010001";	
		resultBinaryOR = "011011001111010111010101";
	}
	
	
	@Test
	public void bitwiseAND_binary1ANDbinary2_ShouldBeResultBinaryAND() {
		assertThat(Converter.bitwiseAND(binary1, binary2), is(resultBinaryAND) );
	}
	
	@Test
	public void bitwiseOR_binary1ANDbinary2_ShouldBeResultBinaryOR(){
		assertThat(Converter.bitwiseOR(binary1, binary2), is(resultBinaryOR));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_StringLengthLongerThan6_ShouldThrowIllegalArgException() {
		Converter.hexToInt("8E4D3AB");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_nonHexChars_ShouldThrowIllegalArgException(){
		Converter.hexToInt("ABE8CP");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void hexToInt_tooLongInput_ShouldThrowIllegalArgException(){
		Converter.hexToInt("ABC1234");
	}
	
	public void hexToInt_emptyInput_ShouldThrowIllegalArgException(){
		assertThat(Converter.hexToInt(""), is(0) );
	}
	
	@Test
	public void hexToInt_F_ShouldReturn15() {
	assertThat( Converter.hexToInt("f"), is(15) );
	assertThat( Converter.hexToInt("F"), is(15) );
	}
	
	@Test
	public void hexToInt_AB4E7_ShouldReturn701671(){
		assertThat( Converter.hexToInt("AB4E7"), is(701671) ) ;
		assertThat( Converter.hexToInt("ab4e7"), is(701671) ) ;
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
	public void binaryToInt_nonBinaryCode_shouldThrowException(){
		Converter.binaryToInt("00000000000000000202");
	}
	
	@Test
	public void binaryToInt_EmptyString_ShouldReturn0(){
		assertThat(Converter.binaryToInt(""), is(0));
	}
	
	@Test
	public void binaryToInt_11010_ShouldReturn26(){
		assertThat ( Converter.binaryToInt("11010"), is(26));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void binaryToInt_1010101010101010101010101_ShouldThrowException(){
		Converter.binaryToInt("1010101010101010101010101"); //25 tegn
	}
	
	@Test
	public void intToBinary_27_ShouldReturn11011(){
		assertThat ( Converter.intToBinary(27), is("000000000000000000011011"));
	}
	
	@Test
	public void intToBinary_tooBigInt_ShouldReturnNull(){
		assertThat( Converter.intToBinary((int) Math.pow(2, 24)),  nullValue());
	}
	
	@Test
	public void intToBinary_negativeInt_ShouldReturn0 (){
		assertThat ( Converter.intToBinary(-5), is("0"));
	}
	

}
