
import cn.hutool.core.util.IdUtil;
import com.snszyk.iiot.marketization.market.MarketApplication;
import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.repo.MarketElementRepo;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.*;
import com.snszyk.iiot.marketization.market.domain.product.Product;
import com.snszyk.iiot.marketization.market.domain.product.repository.ProductRepository;
import com.snszyk.iiot.marketization.market.domain.product.valobj.*;
import com.snszyk.iiot.marketization.market.domain.settlemarket.SettleMarket;
import com.snszyk.iiot.marketization.market.domain.settlemarket.repository.SettleMarketRepository;
import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleMarketId;
import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleOrganization;
import com.snszyk.iiot.marketization.market.domain.transmarket.TransMarket;
import com.snszyk.iiot.marketization.market.domain.transmarket.repository.TransMarketRepository;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.ContainedMarketElements;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.MarketElementIdentify;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.TransMarketId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest(classes = MarketApplication.class)
@RunWith(SpringRunner.class)
public class TestRepo {

    @Autowired
    MarketElementRepo marketElementRepo;

    @Autowired
    SettleMarketRepository settleMarketRepository;

    @Autowired
    TransMarketRepository transMarketRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void test() {
        String marketElementId = IdUtil.simpleUUID();
        String productElementId = IdUtil.simpleUUID();

        MarketElement marketElement = new MarketElement();
        marketElement.setMarketElementId(MarketElementId.builder().marketElementId(marketElementId).build());
        marketElement.setMarketElementName("????????????");

        List<ProductElement> productElements = new ArrayList<>();
        productElements.add(
                ProductElement.builder()
                        .productElementId(ProductElementId.builder().productElementId(productElementId).build())
                        .marketElementId(MarketElementId.builder().marketElementId(marketElementId).build())
                        .productElementName("??????")
                        .build()
        );

        marketElement.setProductElements(productElements);

        List<TransactionScope> transactionScopes = new ArrayList<>();
        transactionScopes.add(
                TransactionScope.builder()
                        .productElementId(ProductElementId.builder().productElementId(productElementId).build())
                        .scopeName("????????????-??????")
                        .transactionFlow(TransactionFlow.builder().flowId("FLOW02").build())
                        .transactionSubject(TransactionSubject.builder()
                                .buyerType(MarketSubjectType.TEAM)
                                .sellerType(MarketSubjectType.PERSONAL)
                                .build())
                        .build());

        marketElement.setTransactionScopes(transactionScopes);

        marketElementRepo.save(marketElement);
    }

    @Test
    @Transactional
    public void testRead() {
        MarketElement one = marketElementRepo.getOne(MarketElementId.builder().marketElementId("27f36605ca4f46578ab6b0040361a424").build());
        System.out.println(one);
    }

    /**
     * ???????????????????????????
     */
    @Test
    public void settleMarketRepositoryTest(){
        SettleMarket settleMarket = new SettleMarket();
        settleMarket.setSettleMarketId(SettleMarketId.builder().settleMarketId(IdUtil.randomUUID()).build());
        settleMarket.setSettleOrganization(SettleOrganization.builder().organizationId("orgId:1").build());
        settleMarket.setName("????????????01");

        settleMarketRepository.save(settleMarket);
    }

    @Test
    public void transMarketRepositoryTest(){
       String transMarketId = IdUtil.randomUUID();

        List<MarketElementIdentify> marketElementsIdentifies = new ArrayList<>();
        //????????? ????????????????????????
        marketElementsIdentifies.add(MarketElementIdentify.builder().marketElementId(transMarketId).build());
        marketElementsIdentifies.add(MarketElementIdentify.builder().marketElementId(transMarketId).build());

        TransMarket transMarket = new TransMarket();
        transMarket.setTransMarketId(TransMarketId.builder().transMarketId(transMarketId).build());
        transMarket.setName("????????????01");
        transMarket.setContainedMarketElements(ContainedMarketElements.builder().marketElementsIdentifies(marketElementsIdentifies).build());
        transMarketRepository.save(transMarket);
    }

    @Test
    public void productRepositoryTest(){
        String randomUUID = IdUtil.simpleUUID();
        Product product = new Product();
        product.setProductId(ProductId.builder().settleMarketId(randomUUID).build());

        product.setProductDetail(ProductDetail.builder()
                .name("????????????")
                .originalIdentify(OriginalIdentify.builder().originalId("????????????ID").build())
                .specification(Specification.builder().description("????????????-??????").model("1???").build())
                .build());
        product.setYieldly(Yieldly.builder().workplaceId("????????????ID").build());

        product.setQuota(Quota.builder().quotaValue(new BigDecimal(1000000.1)).quotaUnitId("????????????id-002").build());

        List<PriceItem> priceItems = new ArrayList<>();
        priceItems.add(PriceItem.builder().name("RS8").unitId("????????????ID-TAI").price(27000000.0).build());
        priceItems.add(PriceItem.builder().name("M8").unitId("????????????ID-TAI").price(29000000.0).build());

        product.setPrice(Price.builder()
                .priceValue(new BigDecimal(1000000.2))
                .priceUnitId("????????????Id001")
                .priceItems(priceItems)
                .productPricePattern(ProductPricePattern.SINGLE)
                .build());

        product.setProductionOrganization(ProductionOrganization.builder()
                .organizationId("????????????Id")
                .build());

        product.setUnderMarket(UnderMarket.builder().transMarketId("????????????Id").build());
        product.setUnderProductElement(UnderProductElement.builder().productElementId("??????????????????Id").build());
        productRepository.save(product);
    }

    @Test
    public void queryProductRepositoryTest(){

        Product byId = productRepository.findById(ProductId.builder().settleMarketId("33fb2410536445cf8714b2978dd22e96").build()).orElse(null);
        System.out.println(byId);
    }
}

