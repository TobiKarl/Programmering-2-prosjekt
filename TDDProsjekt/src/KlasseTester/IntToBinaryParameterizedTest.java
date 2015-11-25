package KlasseTester;

import static org.junit.Assert.*;

import Klasser.Converter;
import static org.hamcrest.CoreMatchers.*;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class IntToBinaryParameterizedTest {
	private String binary;
	private int decimal;

	public IntToBinaryParameterizedTest(String decimal, String binary) {
		this.decimal = Integer.parseInt(decimal);
		this.binary = binary;
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection<String[]> input(){
		return java.util.Arrays.asList( new String[][]{
			{"243"		, 	"000000000000000011110011" },
			{"8756"		, 	"000000000010001000110100" },
			{"7"		, 	"000000000000000000000111" },
			{"734"		, 	"000000000000001011011110" },
			{"9874"		, 	"000000000010011010010010" },
			{"654354"	, 	"000010011111110000010010" },
			{"776534"	, 	"000010111101100101010110" },
			{"4132"		, 	"000000000001000000100100" },
			{"3"		, 	"000000000000000000000011" },
			{"890234"	, 	"000011011001010101111010" },
		
		});
		
	}
	
	@org.junit.Test
	public void testIntToBinaryConversion(){
		assertThat (Converter.intToBinary(decimal), is(binary));
	}
}
