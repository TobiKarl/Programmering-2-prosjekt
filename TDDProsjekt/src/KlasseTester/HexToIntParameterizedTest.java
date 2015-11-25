package KlasseTester;

import static org.junit.Assert.*;

import Klasser.Converter;
import static org.hamcrest.CoreMatchers.*;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class HexToIntParameterizedTest {
	private String hex;
	private int decimal;

	public HexToIntParameterizedTest(String hex, String decimal) {
		this.decimal = Integer.parseInt(decimal);
		this.hex = hex;
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection<String[]> input(){
		return java.util.Arrays.asList( new String[][]{
			{"ab43"		, 	"43843"	    },
			{"abcd"		, 	"43981" 	},
			{"234de"	, 	"144606" 	},
			{"addd"		, 	"44509"	    },
			{"bbbe"		, 	"48062" 	},
			{"d78"		, 	"3448" 		},
			{"abce33"	, 	"11259443" 	},
			{"54"		, 	"84" 		},
			{"73e"		, 	"1854" 		},
			{"a0bb4e"	, 	"10533710" 	},
		
		});
		
	}
	
	@org.junit.Test
	public void testIntToBinaryConversion(){
		assertThat (Converter.hexToInt(hex), is(decimal));
	}
}
