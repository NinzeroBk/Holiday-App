package univ.stud.holiday.model.daos;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
@interface SQL{
    String query() default "";
}
