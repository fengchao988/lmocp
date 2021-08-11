package com.snszyk.iiot.marketization.market.domain.product.repository;

import com.snszyk.iiot.marketization.market.domain.product.Product;
import com.snszyk.iiot.marketization.market.domain.product.valobj.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
