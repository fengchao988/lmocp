
import com.snszyk.iiot.marketization.demo.DemoApplication;
import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionId;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.PositionInfRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class TestRepo {

    @Autowired
    PositionInfRepository positionInfRepository;


    @Test
    public void test() {

        System.out.println(1);

    }

}

