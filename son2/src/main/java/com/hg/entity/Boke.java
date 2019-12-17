package com.hg.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Boke implements Serializable {
  private String id;
  private String titel;
  private String content;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date time;
}
