package com.wll.inspection.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.dao.Company;
import com.wll.inspection.enums.ResultEnum;
import com.wll.inspection.mapper.CompanyMapper;
import com.wll.inspection.service.CompanyService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import com.wll.inspection.utils.PageUtils;
import com.wll.inspection.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public ResultVO deleteByPrimaryKey(Long CompanyId) {
        if(companyMapper.selectByPrimaryKey(CompanyId) == null){
            return ResultVOUtil.error(ResultEnum.COMPANY_HAS_NOT_EXIST);
        }
        return ResultVOUtil.success(companyMapper.deleteByPrimaryKey(CompanyId));
    }

    @Override
    public ResultVO selectById(Long id) {
        if(companyMapper.selectByPrimaryKey(id) == null){
            return ResultVOUtil.error(ResultEnum.COMPANY_HAS_NOT_EXIST);
        }
        return ResultVOUtil.success(companyMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultVO addCompany(Company record) {
        if(companyMapper.selectByPrimaryKey(record.getCompanyId()) ==null){
            return ResultVOUtil.success(companyMapper.insert(record));
        }else{
            return ResultVOUtil.error(ResultEnum.COMPANY_HAS_EXIST);
        }
    }

    @Override
    public ResultVO selectAll() {
        return ResultVOUtil.success(companyMapper.selectAll());
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }

    @Override
    public ResultVO update(Company company) {
        try{
            if(companyMapper.selectByPrimaryKey(company.getCompanyId()) !=null)
            {
                companyMapper.updateByPrimaryKey(company);
            }
        }catch(Exception e){
            return ResultVOUtil.error(ResultEnum.COMPANY_HAS_NOT_EXIST);
        }
        return ResultVOUtil.success();
    }



    @Override
    public PageInfo<Company> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Company> lists = companyMapper.pageSelect();
        PageInfo<Company> pageInfo = new PageInfo<Company>(lists);
        return pageInfo;



    }

    private PageInfo<Company> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Company> companies = companyMapper.pageSelect();
        return new PageInfo<Company>(companies);
    }


}