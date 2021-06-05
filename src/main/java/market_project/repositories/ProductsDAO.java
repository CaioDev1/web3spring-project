package market_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import market_project.Products;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Integer> {}
