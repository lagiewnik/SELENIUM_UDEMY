import java.util.ArrayList;

public class TestSAmple {
    public static void main(String[] args) {
        DataDriven dd = new DataDriven();

        ArrayList<String> arrTC = dd.getTestCase("Purchase");

        System.out.println(arrTC.toString());

    }
}
