package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public final class Expense {
    private final int visitedId;
    private final double price;
    private final String name;
    private int expenseId;

    public Expense(int visitedId, double price, @NotNull String name) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.visitedId = visitedId;
        this.price = price;
        this.name = name;
    }

    public Expense(int expenseId, int visitedId, double price, String name) {
        this(visitedId, price, name);
        this.expenseId = expenseId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public int getVisitedId() {
        return visitedId;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", visitedId=" + visitedId +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
