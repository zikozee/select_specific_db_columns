package com.nativequery.mysqlnativequery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;

}

//@SqlResultSetMapping(
//        name="employeeMapping",
//        classes={
//                @ConstructorResult(
//                        targetClass=Employee.class,
//                        columns={
//                                @ColumnResult(name="first_name"),
//                                @ColumnResult(name="last_name")
//                        }
//                )
//        }
//)
//@NamedNativeQuery(name="getEmployees", query="SELECT first_name, last_name FROM employee", resultSetMapping="employeeMapping")
//@Data
//@NoArgsConstructor @AllArgsConstructor
//public class Employee {
//
//    private String firstName;
//    private String lastName;
//
//}

