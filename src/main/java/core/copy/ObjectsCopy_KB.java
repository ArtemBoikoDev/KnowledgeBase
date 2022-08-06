package core.copy;

/**
 * https://www.baeldung.com/java-deep-copy
 */
public class ObjectsCopy_KB {
    public static void main(String[] args) {
        Type1 type1 = new Type1();
        type1.setF1(1);
        type1.setF2(2);
        type1.setF3("3");

        System.out.println("type1 = " + type1);

        Type2 type2 = new Type2();
        type2.setF1(type1.getF1());
        type2.setF2(type1.getF2());
        type2.setF3(type1.getF3());
        type2.setType1(type1);

        System.out.println("type2 = " + type2);

        /* copy constructor option */
//        Type2 type3 = new Type2(type2);

        /* clone overriding option */
        Type2 clone = type2.clone();

        System.out.println("---------before-----------");
        System.out.println("type1 = " + type1);
        System.out.println("type2 = " + type2);
        System.out.println("type3 = " + clone);

        type2.setF1(4);
        type2.setF2(5);
        type2.setF3("6");

        type1.setF1(7);
        type1.setF2(8);
        type1.setF3("9");
        System.out.println("---------after-----------");


        System.out.println("type1 = " + type1);
        System.out.println("type2 = " + type2);
        System.out.println("type3 = " + clone);

    }
}
