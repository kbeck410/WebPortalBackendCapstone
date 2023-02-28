package net.adminPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.adminPortal.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
