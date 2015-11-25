package KlasseTester;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import Klasser.Converter;
import Klasser.FilKlasse;
import Klasser.Reader;

public class FilKlasseTest {
	FilKlasse f1;
	Reader mockReader;
	String ID, b1, b2, an, or;
	Integer IDtoHex;
	
	@Before
	public void setUp() throws Exception{
		mockReader = mock( Reader.class );
		f1 = new FilKlasse( mockReader );
		ID = "a87bcd";
		IDtoHex = Converter.hexToInt(ID);
		b1 = "010011001001010111010101";
		b2 = "011001001110010010010001";
		an = "010001001000010010010001";
		or = "011011001111010111010101";
	}
	
	@Test
	public void readFile_legalInput_ShouldStoreValues() throws Exception{
		when(mockReader.readLine()).thenReturn(ID + " 1 " + b1 + " " + b2, null );
		f1.readFile();
		assertThat(f1.getDataMap().get(IDtoHex).getOperation(), is("1") );
		assertThat(f1.getDataMap().get(IDtoHex).getBinary1(), is (b1) );
		assertThat(f1.getDataMap().get(IDtoHex).getBinary2(), is (b2) );
		assertThat(f1.getDataMap().get(IDtoHex).getResults(), is (an) );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void readFile_illegalInput_ShouldThrowIllegalArgumentException() throws Exception{
		when(mockReader.readLine()).thenReturn(ID + " 2 " + b1 + null );
		f1.readFile();
		
	}
	
	@Test
	public void getReader_shouldReturnReader(){
		assertThat(f1.getReader(), is(mockReader));
	}
	
	@Test
	public void readLine_Null_ShouldReturnNoLengthMap(){
		when(mockReader.readLine()).thenReturn(null);
		assertThat(f1.getDataMap().size(), is (0) );
	}
	
	@Test
	public void readLine_Duplicate_ShouldBeAddedToList() throws Exception{
		when(mockReader.readLine()).thenReturn( ID + " 1 " + b1 + " " + b2, ID + " 2 " + b2 + " " + b2 , null);
		f1.readFile();
		assertThat(f1.getDuplicates().size(), is(1));
	}
	
	@Test
	public void readLine_InputErrors_ShouldBeAddedToList() throws Exception{
		when(mockReader.readLine()).thenReturn(ID + " i " + b1 + " " + b2, null);
		f1.readFile();
		assertThat(f1.getErrors().size(), is(1));
	}
	
	@Test
	public void getIntegerResult_ShouldReturnHexResultAsInteger() throws Exception{
		when(mockReader.readLine()).thenReturn(ID + " 2 " + b1 + " " + b2, null);
		f1.readFile();
		assertThat(f1.getDataMap().get(IDtoHex).getIntegerResult(), is(Converter.binaryToInt(or)));
	}
	
	@Test
	public void dataMap_Duplicate_ShouldBeStoredAsWholeString() throws Exception{
		when(mockReader.readLine()).thenReturn( ID + " 1 " + b1 + " " + b2,
												ID + " 2 " + b2 + " " + b2 , null);
		f1.readFile();
		assertThat(f1.getDuplicates().get(0),is(ID + " 2 " + b2 + " " +b2));
	}
	
	@Test
	public void 
	


}
