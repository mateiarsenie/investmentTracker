public class Investment {
    private final String name;
    private final Double numberOfUnits;
    private final Double unitCost;
    private final Double cost;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Investment))
            return false;

        Investment o = (Investment) obj;

        return o.name.equals(this.name) && o.cost.equals(this.cost)
                && o.numberOfUnits.equals(this.numberOfUnits) && o.unitCost.equals(this.unitCost);
    }

    public Investment(String name, Double numberOfUnits, Double unitCost, Double cost) {
        this.name = name;
        this.numberOfUnits = numberOfUnits;
        this.unitCost = unitCost;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Double getNumberOfUnits() {
        return numberOfUnits;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public Double getCost() {
        return cost;
    }
}
