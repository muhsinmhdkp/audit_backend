package com.ust.audit.api.benchmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BenchMarkService {

    @Autowired
    BenchMarkRepository benchMarkRepository;

    public BenchMarkEntity updateBenchMark(BenchMarkEntity benchMarkEntity) {
        BenchMarkEntity updateBenchMark=benchMarkRepository.findById(benchMarkEntity.getAuditBenchmarkId()).
                orElseThrow(()->new NoSuchElementException());
        //updateBenchMark.setAuditBenchmarkAuditType(benchMarkEntity.getAuditBenchmarkAuditType());
        updateBenchMark.setAuditBenchmarkAuditType(benchMarkEntity.getAuditBenchmarkAuditType());
        updateBenchMark.setAuditBenchmarkStatus(benchMarkEntity.isAuditBenchmarkStatus());
        updateBenchMark.setAuditBenchmarkModifiedDate(LocalDateTime.now());
        benchMarkRepository.save(updateBenchMark);
        return updateBenchMark;
    }

    public BenchMarkEntity getBenchMarkById(Integer id) {
        return benchMarkRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public List<BenchMarkEntity> getBenchMarkAll() {
        return benchMarkRepository.findAll();
    }

    public void saveBenchMark(BenchMarkEntity benchMarkEntity) {
        benchMarkEntity.setAuditBenchmarkCreatedDate(LocalDateTime.now());
        benchMarkEntity.setAuditBenchmarkModifiedDate(benchMarkEntity.getAuditBenchmarkModifiedDate());
        benchMarkRepository.save(benchMarkEntity);
    }

    /*
    public void delBenchMarkById(Integer id) {
        benchMarkRepository.deleteById(id);

    }

     */
}
