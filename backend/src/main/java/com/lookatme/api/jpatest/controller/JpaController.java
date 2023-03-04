package com.lookatme.api.jpatest.controller;

import com.lookatme.api.jpatest.entity.JpaEntity;
import com.lookatme.api.jpatest.repository.JpaTestRepositroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JpaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JpaTestRepositroy jpaRepository;

    @GetMapping("/jpaSearchAll")
    public List<JpaEntity> jpaSearchAll(){
        logger.info("전체검색!!");
        List<JpaEntity> stringObjectMap = new ArrayList<JpaEntity>();
        stringObjectMap = jpaRepository.findAll();
        return stringObjectMap;
    }

    @GetMapping("/jpaSearchOne")
    public String jpaSearchOne(){
        //logger.info("한개검색");
        return jpaRepository.findById(jpaRepository.findByJpaNumber()).toString();
    }

    @GetMapping("/jpaInsert")
    public Integer jpaInsert(){
        // 데이터를 입력하고
        JpaEntity jpaEntity = JpaEntity.builder().jpaText("랜덤 숫자 : " + ((Math.random()*10000)+1)).jpaAge((int) ((Math.random()*10)+1)).build();
        // 리턴으로 해당 입력한 idx 리턴
        jpaRepository.save(jpaEntity);

        return jpaEntity.getJpaNumber();
    }

    @GetMapping("/jpaUpdate")
    public String jpaUpdate(){
        //logger.info("업데이트");
        JpaEntity jpaEntity = jpaRepository.findById(jpaRepository.findByJpaNumber()).get();
        jpaEntity.setJpaText("업데이트");
        jpaRepository.save(jpaEntity);

        return "업데이트 내용 : " + jpaEntity.getJpaText();
    }

    @GetMapping("/jpaDelete")
    public String jpaDelete(){
        //logger.info("삭제");
        JpaEntity jpaEntity = jpaRepository.findById(jpaRepository.findByJpaNumber()).get();
        jpaRepository.delete(jpaEntity);

        return "삭제함";
    }

    @GetMapping("/hello")
    public String vueTest(){
        return "Hi";
    }

}
