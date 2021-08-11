
import com.snszyk.iiot.marketization.market.MarketApplication;
import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.repo.MarketElementRepo;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = MarketApplication.class)
@RunWith(SpringRunner.class)
public class TestRepo {

    @Autowired
    MarketElementRepo marketElementRepo;

    @Test
    public void test() {
        String marketElementId = UUID.randomUUID().toString();
        String productElementId = UUID.randomUUID().toString();

        MarketElement marketElement = new MarketElement();
        marketElement.setMarketElementId(MarketElementId.builder().marketElementId(marketElementId).build());

        List<ProductElement> productElements = new ArrayList<>();
        productElements.add(
                ProductElement.builder()
                        .productElementId(ProductElementId.builder().productElementId(productElementId).build())
                        .marketElementId(MarketElementId.builder().marketElementId(marketElementId).build())
                        .name("材料市场")
                        .build()
        );
        productElements.add(
                ProductElement.builder()
                        .productElementId(ProductElementId.builder().productElementId("3234").build())
                        .marketElementId(MarketElementId.builder().marketElementId(marketElementId+"1").build())
                        .name("产品要素02")
                        .build()
        );

        marketElement.setProductElements(productElements);

        List<TransactionScope> transactionScopes = new ArrayList<>();
        transactionScopes.add(
                TransactionScope.builder()
                        .productElementId(ProductElementId.builder().productElementId(productElementId).build())
                        .scopeName("材料日报")
                        .transactionFlow(TransactionFlow.builder().flowId("FLOW01").build())
                        .transactionSubject(TransactionSubject.builder()
                                .buyerTypeId(MarketSubjectId.builder().marketSubjectId("buyerTypeId01").build())
                                .sellerTypeId(MarketSubjectId.builder().marketSubjectId("sellerTypeId01").build())
                                .build())
                .build());

        transactionScopes.add(
                TransactionScope.builder()
                        .productElementId(ProductElementId.builder().productElementId("3234").build())
                        .scopeName("SCOPE-02")
                        .transactionFlow(TransactionFlow.builder().flowId("FLOW02").build())
                        .transactionSubject(TransactionSubject.builder()
                                .buyerTypeId(MarketSubjectId.builder().marketSubjectId("buyerTypeId02").build())
                                .sellerTypeId(MarketSubjectId.builder().marketSubjectId("sellerTypeId02").build())
                                .build())
                        .build());

        transactionScopes.add(
                TransactionScope.builder()
                        .productElementId(ProductElementId.builder().productElementId("4234").build())
                        .scopeName("SCOPE-03")
                        .transactionFlow(TransactionFlow.builder().flowId("FLOW03").build())
                        .transactionSubject(TransactionSubject.builder()
                                .buyerTypeId(MarketSubjectId.builder().marketSubjectId("buyerTypeId03").build())
                                .sellerTypeId(MarketSubjectId.builder().marketSubjectId("sellerTypeId03").build())
                                .build())
                        .build());

        marketElement.setTransactionScopes(transactionScopes);

        marketElementRepo.save(marketElement);
    }

    @Test
    @Transactional
    public void testRead() {
        MarketElement one = marketElementRepo.getOne(MarketElementId.builder().marketElementId("e8d5805b-63fb-4934-9d86-9c34edaa9114").build());
        System.out.println(one);
    }

}

