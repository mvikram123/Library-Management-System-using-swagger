package com.Library.Managmenet.System.Library.Management.System1.DTO;

import com.Library.Managmenet.System.Library.Management.System1.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    String name;
    String mob;
    String email;
    Department department;

}
