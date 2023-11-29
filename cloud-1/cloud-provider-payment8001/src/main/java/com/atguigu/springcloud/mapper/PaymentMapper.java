package com.atguigu.springcloud.mapper;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: keyanbin
 * @description: ${description}
 * @create: 2023-11-26 23:19
 **/
@Mapper
public interface PaymentMapper {
    int insert(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}