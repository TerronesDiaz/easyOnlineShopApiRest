package com.example.easyOnlineShop.easyOnlineShop.Repo;

import com.example.easyOnlineShop.easyOnlineShop.Entity.DigitalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface DigitalProductRepository extends JpaRepository<DigitalProduct, Long> {

}
