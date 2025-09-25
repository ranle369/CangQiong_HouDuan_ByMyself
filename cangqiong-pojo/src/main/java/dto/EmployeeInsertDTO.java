package dto;

import lombok.Data;

@Data
public class EmployeeInsertDTO {
    private Long id;
    private String idNumber;
    private String name;
    private String phone;
    private String sex;
    private String username;
}
