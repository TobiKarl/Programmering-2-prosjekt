package KlasseTester;
 
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import Klasser.Converter;
import Klasser.FilKlasse;

public class FilKlasseTest {
	FilKlasse f1;
	
	@Before
	public void setUp() throws Exception{
		
		f1 = new FilKlasse();
		f1.readFile("sekvenser.txt");
	}
	
	@Test
	public void readFile_sekvensertxt_shouldReturnAnicipatedResults(){
		assertThat(f1.getDataMap().get("240655").getResults(), is (Converter.bitwiseAND("110101000000110111001101", 
"001000011110011101001111")) );
	}
	
	public void readFile_invalidKey_ShouldReturnNull(){
		assertThat(f1.getDataMap().get("92929"), is (nullValue()) );
	}

}
