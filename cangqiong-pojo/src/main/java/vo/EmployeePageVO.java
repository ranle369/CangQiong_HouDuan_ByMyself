package vo;

import entity.Employee;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class EmployeePageVO implements Serializable {
    public Long total;
    public List<Employee> records;
}
