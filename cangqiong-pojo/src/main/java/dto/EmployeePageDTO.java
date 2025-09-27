package dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeePageDTO implements Serializable {
    private String name;
//    页码
    private Integer page;
//    每页显示的记录数
    private Integer pageSize;
}
