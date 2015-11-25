package KlasseTester;

import static org.junit.Assert.*;

import Klasser.Converter;
import static org.hamcrest.CoreMatchers.*;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class IntToHexParameterizedTest {
	private String hex;
	private int decimal;

	public IntToHexParameterizedTest( String hex, String decimal) {
		this.decimal = Integer.parseInt(decimal);
		this.hex = hex;
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection<String[]> input(){
		return java.util.Arrays.asList( new String[][]{
			{"AB43"		, 	"43843"	    },
			{"ABCD"		, 	"43981" 	},
			{"234DE"	, 	"144606" 	},
			{"ADDD"		, 	"44509"	    },
			{"BBBE"		, 	"48062" 	},
			{"D78"		, 	"3448" 		},
			{"ABCE33"	, 	"11259443" 	},
			{"54"		, 	"84" 		},
			{"73E"		, 	"1854" 		},
			{"A0BB4E"	, 	"10533710" 	},
		
		});
		
	}
	
	@org.junit.Test
	public void testIntToBinaryConversion(){
		assertThat (Converter.intToHex(decimal), is(hex));
	}
}
