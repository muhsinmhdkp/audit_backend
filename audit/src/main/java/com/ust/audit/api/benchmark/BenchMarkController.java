package com.ust.audit.api.benchmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class BenchMarkController {

    @Autowired
    BenchMarkService benchMarkService;

    @GetMapping("/benchmark/{id}")
    public ResponseEntity<BenchMarkEntity> get(@PathVariable Integer id){
        try{
            BenchMarkEntity getBenchMark = benchMarkService.getBenchMarkById(id);
            return new ResponseEntity<BenchMarkEntity>(getBenchMark, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<BenchMarkEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/benchmark")
    public ResponseEntity<List<BenchMarkEntity>> getAll(){
        try{
            List<BenchMarkEntity> getBenchMarkAll = benchMarkService.getBenchMarkAll();
            return new ResponseEntity<List<BenchMarkEntity>>(getBenchMarkAll, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<BenchMarkEntity>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/benchmark")
    public ResponseEntity<BenchMarkEntity> add(@RequestBody BenchMarkEntity benchMarkEntity){
        try{
            benchMarkService.saveBenchMark(benchMarkEntity);
            return new ResponseEntity<BenchMarkEntity>(benchMarkEntity,HttpStatus.OK);
        }
        catch (NoSuchElementException e){
             return new ResponseEntity<BenchMarkEntity>(HttpStatus.PRECONDITION_FAILED);
        }
    }
    /*
    @DeleteMapping("/benchmark{id}")
    public  void delete(@PathVariable Integer id){
        benchMarkService.delBenchMarkById(id);
    }
    */

    @PutMapping("/benchmark")
    public ResponseEntity<BenchMarkEntity> put(@RequestBody BenchMarkEntity benchMarkEntity){
        try{
            BenchMarkEntity updatedBenchMark=benchMarkService.updateBenchMark(benchMarkEntity);
            return new ResponseEntity<BenchMarkEntity>(updatedBenchMark,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<BenchMarkEntity>(HttpStatus.NOT_FOUND);
        }
    }

}
