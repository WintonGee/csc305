public class Driver {

    public static void main(String[] args) {
        Example ex = new Example();
        // Step 4D
        boolean sameName = ex.sameName("name");
        System.out.println(sameName);

        int total = 0;

        int num = ex.getNums()[0];
        total += num;

        System.out.println(total);
    }
}
