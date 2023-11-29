package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: keyanbin
 * @description: ${description}
 * @create: 2023-11-26 23:19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    /**
     * ID
     */
    private Long id;

    private String serial;

}