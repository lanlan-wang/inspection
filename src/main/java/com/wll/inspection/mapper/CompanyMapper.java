package com.wll.inspection.mapper;

import com.wll.inspection.dao.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wll30
 */
@Repository
public interface CompanyMapper {

    /**
     * 删除公司
     * @param companyId
     * @return
     */
    int deleteByPrimaryKey(Long companyId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(Company record);

    /**
     * 通过id查找
     * @param companyId
     * @return
     */
    Company selectByPrimaryKey(Long companyId);

    /**
     * 查找所有的公司
     * @return
     */
    List<Company> selectAll();

    /**
     * 更新公司
     * @param record
     * @return
     */
    int updateByPrimaryKey(Company record);

    /**
     * 分页查询
     * @return
     */
    List<Company> pageSelect();

}