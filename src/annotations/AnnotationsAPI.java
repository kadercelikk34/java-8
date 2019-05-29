package annotations;
import java.util.Arrays;

//@Single
/*@Multiple(value = {
        @Single("Merhaba"),
        @Single("Jupiter")
})*/
@Single("Merhaba")
@Single("Jupiter")
public class AnnotationsAPI {

    public static void main(String[] args) {
       Class<AnnotationsAPI> app =AnnotationsAPI.class;
       Single[] notz = app.getAnnotationsByType(Single.class);
        for (Single not : notz) {
            System.out.println(not.value());
            // Merhaba
            // Uranüs
        }
/*        Arrays.stream(notz).forEach(a-> {
            System.out.println(a.value());
        });*/

    }
}
