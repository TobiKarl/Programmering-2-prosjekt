package Klasser;


public final class Converter {
	//tillater kun hex verdier
	//tillater kun string fra 0 t.o.m 6 i lengde
	private final static String regexHexString="^[0-9A-Fa-f]{0,6}$";
	
	//tillater kun binære verdier
	//tillater kun string fra 0 t.o.m 24 i lengde
	private final static String regexBinary = "^[0-1]{0,24}$";
	private final static String hexString="0123456789ABCDEF";
	
	private Converter() {
	}

	/** Return an int representation of a binary*/
	public static Integer binaryToInt(String binary) {
		if(checkBinaryString(binary) )	throw new IllegalArgumentException();
		if(binary.length()==0) return 0;
		
		int decimal = 0;

		if (binary.charAt(binary.length() - 1) == '1')
			decimal += 1;

		for (int i = binary.length() - 1; i > 0; i--) {
			if (binary.charAt(i - 1) == '1')
				decimal += Math.pow(2, binary.length() - i);
		}
		return decimal;
	}

	/**Return a binary representation of an int*/
	public static String intToBinary(int decimal) {
		if (decimal >= (int) Math.pow(2, 24)) return null;
		if(decimal <= 0) return "0";

		int binaryDigits = 0;

		for (int i = 0; i <= 24; i++) {
			if (decimal <= Math.pow(2, i)) {
				binaryDigits = i;
				break;
			}
		} 
		
		String binary = "";
		for (; binaryDigits >= 0; binaryDigits--) {
			if (Math.pow(2, binaryDigits) <= decimal) {
				binary += "1";
				decimal -= Math.pow(2, binaryDigits);
			} else {
				if (binary.length() > 0)
					binary += "0";
			}
		}
		
		while(binary.length() < 24) 
			binary = "0" + binary;
		
		return binary;
	}
	
	/**Return an int representation of a hex value*/
	public static int hexToInt(String input){
		if(checkHexString(input)) throw new IllegalArgumentException();
		if(input.length()==0) return 0;
		
		String hex = input.toUpperCase();
		char[] chars = hex.toCharArray();
		
		int value=0;
		
		value += hexString.indexOf( chars[chars.length-1] );
		
		for(int i = 1; i < chars.length; i++){
		value += hexString.indexOf( chars[chars.length-1-i] ) * Math.pow(16, i );
		}
		
		return value;
	}
	
	/**Return a hex representation of an int*/
	public static String intToHex(int decimal){
		if(decimal < 0) throw new IllegalArgumentException();
		
		String hex = "";
		char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
							'A', 'B', 'C', 'D', 'E', 'F'
						   };
		
		String decToBinary = Converter.intToBinary(decimal);
		
		String binary;
		while(decToBinary.length() > 0){
				binary = "";
				binary = decToBinary.substring(0, 4);
				decToBinary=decToBinary.substring(4, decToBinary.length());
				hex += hexValues[Converter.binaryToInt(binary)];
		}
		
		while(hex.charAt(0)=='0')
			hex=hex.substring(1);
		
		return hex.toString();
	}
	
	
	
	/**Check that the string only contains binary code*/
	protected static boolean checkBinaryString(String string) {
		if (string.matches(regexBinary))
			return false;

		return true;
	}
	
	/**Check if the string only contain hex code*/
	protected static boolean checkHexString(String hex){
		if(hex.matches(regexHexString)) 
			return false;
		
		return true;
	}
	
	public static String bitwiseAND (String s1, String s2){
		String results="";
		Converter.checkBinaryString(s1);
		Converter.checkBinaryString(s2);
		
		for(int i = 0; i < s1.length(); i++){
			if ( s1.charAt(i) == '1' && s1.charAt(i) == s2.charAt(i) )
				results += "1";
			else
				results += "0";
 		}
		
		return results;
	}
	
	public static String bitwiseOR (String s1, String s2){
		String results="";
		
		for(int i = 0; i < s1.length(); i++){
			if( s1.charAt(i) == '1' || s2.charAt(i) == '1')
				results += "1";
			else 
				results += "0";
		}
		
		return results;
	}
	
	

}
