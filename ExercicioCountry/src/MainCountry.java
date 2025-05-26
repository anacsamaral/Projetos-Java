public class MainCountry {
    public static void main(String[] args) {
        Country br;
        br = new Country("Brasil",220000000,54000);
        System.out.println(br.getName(),br.getPopulation(),br.getArea());
    }
}
