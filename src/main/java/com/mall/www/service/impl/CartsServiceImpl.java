package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.CartsBo;
import com.mall.www.common.dto.CartsDto;
import com.mall.www.common.vo.CartsVo;
import com.mall.www.entity.Carts;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.CartsMapper;
import com.mall.www.service.CartsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {

    @Resource
    CartsMapper cartsMapper;

    /**
     * 根据用户id查询购物车信息
     *
     * @param userId 用户id
     * @return 购物车信息集合
     */
    @Override
    public List<CartsVo> list(Long userId) {
        List<CartsVo> list = new ArrayList<>();
        try {
            //根据用户id查询购物信息
            List<CartsBo> cartsBos = cartsMapper.selectList(userId);
            //将购物车信息拷贝到Vo中
            cartsBos.forEach(cartsBo -> {
                CartsVo cartsVo = new CartsVo();
                BeanUtils.copyProperties(cartsBo, cartsVo);
                BeanUtils.copyProperties(cartsBo.getProduct(), cartsVo);
                list.add(cartsVo);
            });
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list;
        }
    }

    /**
     * 根据用户id和商品id修改购物车商品的数量
     *
     * @param cartsDto 封装了用户id和商品id
     * @return 购物车信息集合
     */
    @Transactional
    @Override
    public List<CartsVo> updateProductQuantity(CartsDto cartsDto) {
        try {
            //根据用户id和商品id查询购物车信息
            Carts carts = cartsMapper.selectByUserIdAndProductId(cartsDto.getUserId(), cartsDto.getProductId());
            //判断是购物车信息是否为空
            if (carts == null) {
                //如果购物车信息为空,表示购物车信息不存在，则添加购物信息
                //添加购物车信息
                Carts temp = new Carts();
                temp.setUserId(cartsDto.getUserId());
                temp.setProductId(cartsDto.getProductId());
                temp.setQuantity(cartsDto.getQuantity());
                int i = addCart(temp);
                if (i < 0) {
                    throw new ServiceException(StatusCode.SERVER_ERROR);
                }
            } else {
                //如果购物车信息不为空，表示购物车信息已存在该商品，则添加数量
                //计算数量
                int quantity = carts.getQuantity() + cartsDto.getQuantity();
                //如果数量小于等于0，则删除购物车信息,否则修改购物车商品数量
                if (quantity <= 0) {
                    //删除
                    List<Long> cartId = new ArrayList<>();
                    cartId.add(carts.getCartId());
                    int i = deleteCarts(cartId);
                    if (i < 0) {
                        throw new ServiceException(StatusCode.SERVER_ERROR);
                    }
                } else {
                    //修改购物车商品数量
                    int i = cartsMapper.updateQuantityByCartId(carts.getCartId(), quantity);
                    if (i < 0) {
                        throw new ServiceException(StatusCode.SERVER_ERROR);
                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list(cartsDto.getUserId());
        }
    }

    /**
     * 添加购物信息到数据库
     *
     * @param carts 购物车信息
     * @return 添加数据的条数
     */
    @Transactional
    @Override
    public int addCart(Carts carts) {
        int i = 0;
        try {
            i = cartsMapper.insert(carts);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }
        return i;
    }

    /**
     * 根据购物id删除购物信息
     *
     * @param cartIds 购物车集合
     * @return 删除数据的条数
     */
    @Transactional
    @Override
    public int deleteCarts(List<Long> cartIds) {
        int i = -1;
        try {
            i = cartsMapper.deleteByCartIds(cartIds);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return i;
        }
    }
}
