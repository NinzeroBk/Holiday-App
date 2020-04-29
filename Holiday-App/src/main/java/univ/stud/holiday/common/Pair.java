package univ.stud.holiday.common;

public final class Pair<FirstKey, SecondKey> {
    private FirstKey firstKey;
    private SecondKey secondKey;

    public Pair(FirstKey firstKey, SecondKey secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public FirstKey getFirstKey() {
        return firstKey;
    }

    public SecondKey getSecondKey() {
        return secondKey;
    }

    public void setFirstKey(FirstKey firstKey) {
        this.firstKey = firstKey;
    }

    public void setSecondKey(SecondKey secondKey) {
        this.secondKey = secondKey;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstKey=" + firstKey +
                ", secondKey=" + secondKey +
                '}';
    }
}
