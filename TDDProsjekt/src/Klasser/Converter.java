package Klasser;


public final class Converter {
	private final static String hexRegexString="";
	private final static String regexBinary = "";
	private final static String hexString="0123456789ABCDEF";
	
	private Converter() {
	}

	/** Return an int representation of a binary*/
	public static Integer binaryToInt(String binary) {
		// if(checkString(binary) );

		if (binary.length() > 24) {
			System.out.println("Binary String over 24 bits");
			return  null;
		}
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
		if (decimal >= (int) Math.pow(2, 24)){
			System.out.println("Int size larger than 24 bit");
			return null;
		}
		
		if(decimal == 0) return "0";

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
		return binary;
	}
	
	/**Return an int representation of a hex value*/
	public static int hexToInt(String input){
		if(input.length() > 6) throw new IllegalArgumentException();
		String hex = input.toUpperCase();
		checkHexString(hex);
		hex.toUpperCase();
		System.out.println(hex);
		char[] chars = hex.toCharArray();
		
		int value=0;
		
		for(int i = 0; i < chars.length; i++){
			
			for(int k = 0 ; k<16 ;k++){
				
				if ( chars[i] == hexString.charAt(k) ){
					value += k*Math.pow(16, chars.length-i-1);
					break;
				}
			}
		}
		
		return value;
	}
	
	/**Return a hex representation of an int*/
	public static String intToHex(int decimal){
		
		String hex="";
		char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
							'A', 'B', 'C', 'D', 'E', 'F'
						   };
		
		String decToBinary = Converter.intToBinary(decimal);
		
		while(true){
		if(decToBinary.length()%4 != 0)
			decToBinary ="0" + decToBinary;
		else break;
		}
		
		while(decToBinary.length() > 0){
				String binary = "";
				binary = decToBinary.substring(0, 4);
				decToBinary=decToBinary.substring(4, decToBinary.length());
				hex += hexValues[Converter.binaryToInt(binary)];
		}
		
		
		return hex;
	}
	
	
	
	/**Check that the string only contains binary code*/
	private static boolean checkStringForBinary(String string) {
		if (string.matches(regexBinary))
			return true;

		return false;
	}
	
	/**Check if the string only contain hex code*/
	private static boolean checkHexString(String hex){
		if(hexRegexString.matches(hexRegexString)) return true;
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("BINARY \n__________________");
		for(int i = 0; i<=50; i++)
			System.out.println(binaryToInt(intToBinary(i))+ " = " +intToBinary(i)  );
		
		System.out.println("\nHEX \n____________________");
		for(int i = 0; i<=50; i++)
			System.out.println(hexToInt(intToHex(i)) + " = " + intToHex(i));
		
		System.out.println(hexToInt("ABEFfe"));
	}

}
