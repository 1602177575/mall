package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.entity.ProductComments;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.ProductCommentsMapper;
import com.mall.www.service.ProductCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Resource
    ProductCommentsMapper mapper;

    @Override
    public List<ProductCommentsVo> selectProductCommentsByPro(Long pid) {
        List<ProductComments> pro=null;
        List<ProductCommentsVo> list=new ArrayList<>();
        try {
            pro = mapper.selectProductCommentsByPro(pid);
            pro.forEach(p->{
                ProductCommentsVo vo = new ProductCommentsVo();
                vo.setUid(p.getUid());
                vo.setIssue(p.getIssue());
                vo.setAnswer(p.getAnswer());
                vo.setCommentsTime(p.getCommentsTime());
                list.add(vo);
            });

        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public List<ProductCommentsVo> selectProductCommentsByUid(Integer uid) {

        List<ProductCommentsVo> list=new ArrayList<>();
        try {
            List<ProductComments> pro = mapper.selectProductCommentsByUid(uid);

            //    private Integer uid; //用户外键
            //    private String issue; //用户提问
            //    private String answer; //商家答复
            //    private Date commentsTime; //提问回答时间
            pro.forEach(p->{
                ProductCommentsVo vo = new ProductCommentsVo();
                vo.setUid(p.getUid());
                vo.setIssue(p.getIssue());
                vo.setAnswer(p.getAnswer());
                vo.setCommentsTime(p.getCommentsTime());
                list.add(vo);
            });

        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public Integer insertProductComments(ProductCommentsDto productCommentsDto) {
        Integer integer =null;
        ProductComments productComments = new ProductComments();
        try {
            BeanUtils.copyProperties(productCommentsDto,productComments);
            mapper.insertProductComments(productComments);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return integer;
        }
    }

    @Override
    public Integer updateAnswer(Integer mid, String answer) {
        Integer integer = null;
        try {
            mapper.updateAnswer(mid, answer);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return integer;
        }
    }
}
