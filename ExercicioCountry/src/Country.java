public class Country {
    private String name;
    private int population;
    private double area;

    public Country(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPopulation(int population){
        if(population >= 0)
            this.population = population;
    }
    public void setArea(double area) {
        if(area >= 0)
            this.area = area;
    }
    public String getName() {
        return name;
    }
    public int getPopulation() {
        return population;
    }
    public double getArea() {
        return area;
    }
    public double getPopDensity(){
        double popdens;
        popdens = population/area;
        return popdens;
    }
}
