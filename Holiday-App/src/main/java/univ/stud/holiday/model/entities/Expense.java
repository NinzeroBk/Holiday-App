package univ.stud.holiday.model.entities;

import org.jetbrains.annotations.NotNull;

public class Expense {
    private final int expenseId;
    private final int visitedId;
    private final double price;
    private final String name;

    public Expense(int expenseId, int visitedId, double price, @NotNull String name) {
        if (price < 0) {
            throw new RuntimeException("Price cannot be negative.");
        }
        this.expenseId = expenseId;
        this.visitedId = visitedId;
        this.price = price;
        this.name = name;
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
