import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для пометки методов обработки данных
@Target(ElementType.METHOD)  // Метод будет аннотирован
@Retention(RetentionPolicy.RUNTIME)  // Аннотация будет доступна в runtime
public @interface DataProcessor {
}
