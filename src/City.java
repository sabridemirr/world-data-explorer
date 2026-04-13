public class City {
    private String name;
    private String country;
    private long population;
    private boolean capital;

    public City(String name, String country, long population, boolean capital) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.capital = capital;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
    @Override
    public String toString() {
        String capitalTag = capital ? " [Capital]" : "";
        return name + capitalTag + " | Pop: " + population + "M | Country: " + getCountry();
    }

}