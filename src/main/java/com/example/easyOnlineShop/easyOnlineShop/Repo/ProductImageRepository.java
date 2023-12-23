package com.example.easyOnlineShop.easyOnlineShop.Repo;

import com.example.easyOnlineShop.easyOnlineShop.Entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
