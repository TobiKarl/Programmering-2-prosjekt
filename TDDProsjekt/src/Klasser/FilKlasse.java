package Klasser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilKlasse {
	private BufferedReader _reader;
	private HashMap<String, FileData> _dataMap;
	private List<FileData> _duplicates ;
	
	
	public FilKlasse(){
		_duplicates = new ArrayList<FileData>();
		_dataMap = new HashMap<String, FileData>();
	}
		
	
	public void readFile (String path) throws Exception{
		File file = new File(path);
		_reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String textString,maaleID ,operation, binary1, binary2;
		FileData data;
		
		while( (textString = _reader.readLine()) != null){
			// 
			String[] tokens = (textString.split("\\s+"));
			maaleID = Integer.toString(Converter.hexToInt(tokens[0]) );
			operation = tokens[1];
			binary1 = tokens[2];
			binary2 = tokens[3];
			
			String binaryResult = binaryOperation(operation, binary1, binary2);
			
			
			if(!_dataMap.containsKey(maaleID)){
				data = new FileData(operation, binaryResult);
				_dataMap.put(maaleID, data);
			}
			else {
				data = new FileData(operation, binaryResult, maaleID);
				_dataMap.put(maaleID, data);
			}
		}
		
	}
	
	
	public String binaryOperation(String operation, String b1, String b2){
		String result = "";
		
			if(operation.equals("1"))
				result = Converter.bitwiseAND(b1, b2);
			
			else if(operation.equals("2"))
				result = Converter.bitwiseOR(b1, b2);
			
		return result;
	}
	
	public BufferedReader getReader(){
		return _reader;
	}
	
	
	public HashMap<String, FileData> getDataMap(){
		try{
		return _dataMap;
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return _dataMap;
	}
	
	public List<FileData> getDuplicates(){
		return _duplicates;
	}
	
	
	 public class FileData {
		 
		 private String _ID;
		 private String _operation;
		 private String _results;
		 
		 FileData(String operation, String results){
			 _operation = operation;
			 _results = results;
		 }
		 
		 FileData(String operation, String results, String ID){
			 _operation = operation;
			 _results = results;
			 _ID = ID;
		 }
		 
		 public String getID(){
			 return _ID;
		 }
		 
		 public String getOperation(){
			 return _operation;
		 }
		 
		 public String getResults(){
			 return _results;
		 }
		 
	}
	 public static void main(String[] args) {
		FilKlasse f1 = new FilKlasse();
		
		try {
			f1.readFile("sekvenser.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Converter.hexToInt("03ac0f") );
		System.out.println(f1.getDataMap().get("240655").getResults());
		f1.getDataMap().get("0394");
	}
	
}
