public class Realtor {

    private String name;
    private int experienceYears;

    public Realtor(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void displayInfo() {
        System.out.println("Realtor: " + name +
                ", Experience: " + experienceYears + " years");
    }
}
