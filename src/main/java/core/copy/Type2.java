package core.copy;

import java.util.StringJoiner;

public class Type2 implements Cloneable {
    private int f1;
    private Integer f2;
    private String f3;
    private Type1 type1;

    public Type2() {
    }

    /* copy constructor option */
    public Type2(Type2 type2) {
        this(type2.getF1(), type2.getF2(), type2.getF3(), new Type1(type2.getType1()));
    }

    public Type2(int f1, Integer f2, String f3, Type1 type1) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.type1 = type1;
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

    public Type1 getType1() {
        return type1;
    }

    public void setType1(Type1 type1) {
        this.type1 = type1;
    }

    /* clone overriding option */
    @Override
    public Type2 clone() {
        Type2 clone;
        try {
            clone = (Type2) super.clone();
        } catch (CloneNotSupportedException e) {
            clone = new Type2(this.getF1(), this.getF2(), this.getF3(), this.getType1());
        }
        clone.type1 = this.type1.clone();
        return clone;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Type2.class.getSimpleName() + "[", "]")
                .add("f1=" + f1)
                .add("f2=" + f2)
                .add("f3='" + f3 + "'")
                .add("type1=" + type1)
                .toString();
    }
}
