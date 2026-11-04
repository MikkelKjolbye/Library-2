import org.junit.jupiter.api.Test;
import java.text.Collator;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

    public class TestLanguageCollator {

        @Test
        public void testSvenskOgDanskSortering() {
            //arrange
            String ord1 = "Økonomi";
            String ord2 = "Åbenbaringen";

            //act
            Collator svCollator = Collator.getInstance(new Locale("sv"));
            int svResultat = svCollator.compare(ord1, ord2);

            //Assertion
            assertTrue(svResultat > 0);


           //act
            Collator daCollator = Collator.getInstance(new Locale("da", "DK"));
            int daResultat = daCollator.compare(ord1, ord2);
            //assertion
            assertTrue(daResultat < 0);
        }
    }
