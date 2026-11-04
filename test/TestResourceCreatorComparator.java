
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class TestResourceCreatorComparator {

        @Test
        public void testCompareDifferentCreators() {
            // arrange
            ResourceCreatorComparator comparator = new ResourceCreatorComparator();

            Resource book1 = new Resource("111", "Bogfinkens Sang", "Arnesen, Arne") {
            };
            Resource book2 = new Resource("222", "Zebraens Liv", "Bentsen, Bent") {
            };

            // act
            int result = comparator.compare(book1, book2);

            //assertion
            assertTrue(result < 0, "Arnesen burde komme før Bentsen");
        }

        @Test
        public void testCompareSameCreators() {
            ResourceCreatorComparator comparator = new ResourceCreatorComparator();

            //arrange
            Resource book1 = new Resource("333", "Abens Hverdag", "Arnesen, Arne") {
            };
            Resource book2 = new Resource("444", "Bogfinkens Sang", "Arnesen, Arne") {
            };

            //act
            int result = comparator.compare(book1, book2);

            //assertion
            assertEquals(0, result);
        }
    }

