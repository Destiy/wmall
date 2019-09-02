package com.matree.wmall.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author
 * @create 2019-08-29 0:33
 */
@Data
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id;

    private String name;

    private String catalog2Id;
}
