import com.opencsv.bean.CsvBindByName;

public class FidelityReportEntry {
    @CsvBindByName(column = "Investments")
    public String investmentName;

    @CsvBindByName(column = "Quantity")
    public Double quantity;

    @CsvBindByName(column = "Price per unit")
    public Double pricePerUnit;

    @CsvBindByName(column = "Amount")
    public Double cost;
}
