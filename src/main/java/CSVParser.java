import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CSVParser {
    private final String filePath;

    public CSVParser(String filePath) {
        this.filePath = filePath;
    }

    public Optional<List<Investment>> parseCSV() throws FileNotFoundException {
        try {
            CsvToBeanBuilder<FidelityReportEntry> csvToBeanBuilder = new CsvToBeanBuilder<>(new FileReader(filePath));

            List<FidelityReportEntry> reportEntries = csvToBeanBuilder
                    .withType(FidelityReportEntry.class).build().parse();

            List<Investment> investments = reportEntries.stream().map(fidelityReportEntry ->
                    new Investment(fidelityReportEntry.investmentName,
                            fidelityReportEntry.quantity,
                            fidelityReportEntry.pricePerUnit,
                            fidelityReportEntry.cost))
                    .collect(Collectors.toList());

            return Optional.of(investments);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
