package io.ceylon.election.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="electoral_districts")
@Data
public class ElectoralDistrict {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @Column(name = "districtName", nullable = false)
    private String districtName;

    @Column(name = "province_name", nullable = false)
    private String provinceName;
}
