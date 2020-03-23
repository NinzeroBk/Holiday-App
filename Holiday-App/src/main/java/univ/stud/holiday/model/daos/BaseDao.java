package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BaseDao<Element, Key> {

    Element readElement(@NotNull Key primaryKey);

    void deleteElement(@NotNull Key primaryKey);

    void updateElement(@NotNull Element element);

    void createElement(@NotNull Element element);

    List<Element> getElements();
}