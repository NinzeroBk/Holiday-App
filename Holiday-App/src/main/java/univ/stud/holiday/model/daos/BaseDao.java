package univ.stud.holiday.model.daos;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BaseDao<Element, Key> {

    Element readElement(@NotNull Key primaryKey);

    boolean deleteElement(@NotNull Key primaryKey);

    boolean updateElement(@NotNull Element element);

    boolean createElement(@NotNull Element element);

    List<Element> getElements();
}