package com.wll.inspection;

import com.wll.inspection.mapper.CompanyMapper;
import com.wll.inspection.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InspectionApplicationTests {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    CompanyService companyService;

    @Test
    void contextLoads() {
    }

    @Test
    void MapperTest(){

        System.out.println(companyMapper.selectAll());
        System.out.println(companyMapper.selectByPrimaryKey(201309L));
    }

    @Test
    void ServiceTest(){
        System.out.println(companyService.selectById(201309L));
    }

}
