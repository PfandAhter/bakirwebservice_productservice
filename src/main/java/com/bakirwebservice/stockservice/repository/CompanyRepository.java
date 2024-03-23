package com.bakirwebservice.stockservice.repository;

import com.bakirwebservice.stockservice.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query(value = "SELECT * FROM product_service.company WHERE company_id = ?",nativeQuery = true)
    Company findCompanyByCompanyId (Long companyid);

}
