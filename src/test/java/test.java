import com.jxt.eum.BlogStatus;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class test {

    @Test
    public void test(){
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));

        Integer index = BlogStatus.VALID.getIndex();
        System.out.println(index);
    }
}
