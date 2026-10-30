package com.imlyb.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsOption {
    private List<Object> clazzNameList;
    private List<Object> dataList;
}
