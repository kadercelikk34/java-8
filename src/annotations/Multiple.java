package annotations;
import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Multiple {
    Single[] value();
   /* Multiple notasyonu Single tipli diziler barındırabilen bir value alanına sahiptir. Artık
    Multiple notasyonu üzerinden birden fazla @Single notasyonu uygulanabilirdir*/
}
