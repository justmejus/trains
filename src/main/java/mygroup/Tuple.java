package mygroup;

/**
 * Created by marimpietri on 25/02/17.
 */
public class Tuple {

    public final char a;
    public final char b;
    public final int c;

    public Tuple(char a, char b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public char getA() {
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;
        if (a!=(tuple.a)) return false;
        if (b!=(tuple.b)) return false;
        return c==(tuple.c);
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b + c;
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}