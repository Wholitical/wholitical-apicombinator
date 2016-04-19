package org.wholitical.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.wholitical.domain.District;

/**
 *
 */
public interface DistrictRepository extends PagingAndSortingRepository<District, Integer> {

    District findByZipcode(@Param("zipcode") Integer zipcode);

}
