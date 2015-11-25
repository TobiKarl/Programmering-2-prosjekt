package Klasser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilKlasse {
	private Reader _reader;
	private Map<Integer, FileData> _dataMap;
	private List<String> _duplicates, _errors;

	public FilKlasse(Reader reader) {
		_reader = reader;
		_duplicates = new ArrayList<String>();
		_errors = new ArrayList<String>();
		_dataMap = new HashMap<Integer, FileData>();
	}

	public void readFile() throws Exception {

		String textString, maaleID, operation, binary1, binary2, binaryResult = null;
		FileData data;

		while ((textString = _reader.readLine()) != null) {
			//

			String[] tokens = (textString.split("\\s+"));

			if (tokens.length != 4)
				throw new IllegalArgumentException();
			maaleID = tokens[0];
			operation = tokens[1];
			binary1 = tokens[2];
			binary2 = tokens[3];
	
			try {
				binaryResult = binaryOperation(operation, binary1,
						binary2);
			} catch (Exception e) {
				_errors.add(textString);
				return;
			}

			if (_dataMap.containsKey(Converter.hexToInt(maaleID) ) ) 
				_duplicates.add(textString);
			else {
				data = new FileData(operation, binaryResult, binary1, binary2, Converter.binaryToInt(binaryResult));
				_dataMap.put(Converter.hexToInt(maaleID), data);
			}
		
		}

	}

	public String binaryOperation(String operation, String b1, String b2)
			throws Exception {
		String result = "";

		if (operation.equals("1"))
			result = Converter.bitwiseAND(b1, b2);

		else if (operation.equals("2"))
			result = Converter.bitwiseOR(b1, b2);
		else
			throw new Exception();

		return result;
	}

	public Reader getReader() {
		return _reader;
	}

	public Map<Integer, FileData> getDataMap() {
		return _dataMap;

	}

	public List<String> getDuplicates() {
		return _duplicates;
	}
	
	public List<String> getErrors(){
		return _errors;
	}

	public class FileData {

		private String _operation,_results,_binary1,_binary2;
		private Integer _integerResult;

		public FileData(String operation, String results, String binary1,
				String binary2, Integer integerResult) {
			_operation = operation;
			_results = results;
			_binary1 = binary1;
			_binary2 = binary2;
			_integerResult = integerResult;
		}


		public String getOperation() {
			return _operation;
		}



		public String getResults() {
			return _results;
		}



		public String getBinary1() {
			return _binary1;
		}



		public String getBinary2() {
			return _binary2;
		}



		public Integer getIntegerResult() {
			return _integerResult;
		}



		public String toString() {
			return _operation + " " + _binary1 + " " + _binary2;
		}

	}

}
