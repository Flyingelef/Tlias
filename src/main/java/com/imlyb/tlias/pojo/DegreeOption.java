package com.imlyb.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DegreeOption {
    private List<Object> degreeList;
    private List<Object> dataList;
}
