package part_one;

class Award {

    private final String name;
    private final int year;

    Award(String name, int year) {
        this.name = name;
        this.year = year;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + year;
    }
}
