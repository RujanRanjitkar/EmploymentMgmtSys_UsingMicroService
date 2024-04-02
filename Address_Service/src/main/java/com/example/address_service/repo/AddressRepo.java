package com.example.address_service.repo;

import com.example.address_service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(value = "select a.address_id, a.lane1,a.lane2,a.state,a.zip from address as a inner join employee as e on a.employee_id=e.employee_id where a.employee_id=?1", nativeQuery = true)
    Address findAddressByEmployeeId(int employeeId);
}
