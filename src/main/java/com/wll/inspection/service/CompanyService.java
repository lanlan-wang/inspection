package com.wll.inspection.service;

import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.ResultVOUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wll
 */
@Component
public interface CompanyService {

    /**
     * 删除公司
     * @param CompanyId
     * @return
     */
    ResultVO  deleteByPrimaryKey(Long CompanyId);

    /**
     * 查找公司
     * @param id
     * @return
     */
    ResultVO selectById(Long id);

    /**
     * 添加公司
     * @param record
     * @return
     */
    ResultVO addCompany(Company record);

    /**
     * 查找所有
     * @return
     */
    ResultVO selectAll();

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 更新公司信息
     * @param company
     * @return
     */
    ResultVO update(Company company);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Company> findAllUserByPageS(int pageNum, int pageSize);

}

