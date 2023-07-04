package com.team13.WaitDoc.hospital.repository;

import com.team13.WaitDoc.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long>, HospitalDslRepository {
    public Optional<Hospital> findByHpid(String hpid);
//    @Query("SELECT h FROM Hospital h WHERE h.addr LIKE %:region% AND h.addr LIKE %:addr%")
//    public List<Hospital> search(@Param("region") String region, @Param("addr") String addr);


}
