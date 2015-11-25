package KlasseTester;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	ConverterTEST.class,
	FilKlasseTest.class,
	IntToBinaryParameterizedTest.class,
	BinaryToIntParameterizedTest.class,
	HexToIntParameterizedTest.class,
	IntToHexParameterizedTest.class}	
)

public class TestSuite {
}
