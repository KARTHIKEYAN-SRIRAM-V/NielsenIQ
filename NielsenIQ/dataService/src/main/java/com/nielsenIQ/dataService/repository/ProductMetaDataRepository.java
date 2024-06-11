package com.nielsenIQ.dataService.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nielsenIQ.dataService.entity.ProductMetaData;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductMetaDataRepository extends JpaRepository<ProductMetaData, Long> {

	Optional<List<ProductMetaData>> findByCategory(String category, Pageable pageable);

	Optional<List<ProductMetaData>> findByBrand(String brand, Pageable pageable);

	ProductMetaData findByProductId(String productId);

}
