package social.gripp.util.data.annotaions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import social.gripp.util.QualifierNames;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Qualifier(QualifierNames.BO)
public @interface BO {
}
