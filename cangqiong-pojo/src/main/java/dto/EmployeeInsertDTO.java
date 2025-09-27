package dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeInsertDTO implements Serializable {
    private Long id;
    private String idNumber;
    private String name;
    private String phone;
    private String sex;
    private String username;
}
