

package com.example.thi.controller;
import com.example.thi.entity.Staff;
import com.example.thi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class valiNhanVIen implements Validator{

    @Autowired
    private StaffRepository staffRepository;



    @Override
    public boolean supports(Class<?> clazz) {
        return Staff.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Staff staff = (Staff) target;

        // Kiểm tra email fpt
        if (staff.getAccountFpt() != null && !staff.getAccountFpt().endsWith("@fpt.edu.vn")) {
            errors.rejectValue("accountFpt", "accountFpt.invalid", "Email FPT phải kết thúc với @fpt.edu.vn");
        }

        // Kiểm tra email fe
        if (staff.getAccountFe() != null && !staff.getAccountFe().endsWith("@fe.edu.vn")) {
            errors.rejectValue("accountFe", "accountFe.invalid", "Email FE phải kết thúc với @fe.edu.vn");
        }
//
        // Kiểm tra mã nhân viên
        if (staff.getStaffCode() != null && staff.getStaffCode().length() > 15) {
            errors.rejectValue("staffCode", "staffCode.length", "Mã nhân viên không được vượt quá 15 ký tự");
        }

        // Kiểm tra độ dài tên nhân viên
        if (staff.getName() != null && staff.getName().length() > 100) {
            errors.rejectValue("name", "name.length", "Tên nhân viên không được vượt quá 100 ký tự");
        }
//

//
//
//
        // Kiểm tra mã, email FPT và email FE không trùng
    }





}



