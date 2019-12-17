package com.hg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 888 on 2019/11/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Record implements Serializable {
    private String id;
    private String peo;
    private Date time;
    private String stuta;
    private String thing;
}
