package com.example.easyOnlineShop.easyOnlineShop.Repo;

import com.example.easyOnlineShop.easyOnlineShop.Entity.PhysicalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<PhysicalProduct, Long> {

}
