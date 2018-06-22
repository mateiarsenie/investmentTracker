import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CSVParserTest {

    @Test
    public void testReadsCSVCorrectly() {
        CSVParser sut = new CSVParser("/Users/Matei/IdeaProjects/InvestmentTracker/src/test/resources/FidelityData.csv");

        try {
            Optional<List<Investment>> investmentsOptional = sut.parseCSV();
            assertThat(investmentsOptional.isPresent(), is(Boolean.TRUE));

            List<Investment> investments = investmentsOptional.get();
            Investment expectedInvestment = new Investment("Fundsmith Equity Fund I Class Income", 55.15, 3.63, 200.0);
            assertThat(investments.get(0), is(expectedInvestment));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}