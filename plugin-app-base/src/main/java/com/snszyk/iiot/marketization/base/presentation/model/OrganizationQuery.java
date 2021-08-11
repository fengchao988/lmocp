package com.snszyk.iiot.marketization.base.presentation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationQuery extends JpaRepository<Organization, String> {
}
