package core.copy;

import java.util.StringJoiner;

public class Type1 implements Cloneable {
    private int f1;
    private Integer f2;
    private String f3;

    public Type1() {
    }

    /* copy constructor option */
    public Type1(Type1 type1) {
        this(type1.getF1(), type1.getF2(), type1.getF3());
    }

    public Type1(int f1, Integer f2, String f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public Integer getF2() {
        return f2;
    }

    public void setF2(Integer f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    /* clone overriding option */
    @Override
    public Type1 clone() {
        try {
            System.out.println("before first return in Type1");
            return (Type1) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("AFTER first return in Type1");
            return new Type1(this.getF1(), this.getF2(), this.getF3());
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Type1.class.getSimpleName() + "[", "]")
                .add("f1=" + f1)
                .add("f2=" + f2)
                .add("f3='" + f3 + "'")
                .toString();
    }
}
