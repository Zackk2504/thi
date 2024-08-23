package com.example.thi.service;

import com.example.thi.entity.DepartmentFacility;
import com.example.thi.entity.MajorFacility;
import com.example.thi.entity.Staff;
import com.example.thi.entity.StaffMajorFacility;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {
    public void exportStaffList(HttpServletResponse response, List<Staff> staffList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Staff List");

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("STT");
        headerRow.createCell(1).setCellValue("Mã Nhân Viên");
        headerRow.createCell(2).setCellValue("Tên Nhân Viên");
        headerRow.createCell(3).setCellValue("Email FPT");
        headerRow.createCell(4).setCellValue("Email Fe");
        headerRow.createCell(5).setCellValue("Trạng Thái");
        headerRow.createCell(6).setCellValue("Cơ sở");
        headerRow.createCell(7).setCellValue("Bộ môn");
        headerRow.createCell(8).setCellValue("Chuyên ngành");

        // Tạo các hàng dữ liệu
        int rowCount = 1;
        for (Staff staff : staffList) {
            for (StaffMajorFacility smf : staff.getStaffMajorFacilities()) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(rowCount - 1);
                row.createCell(1).setCellValue(staff.getStaffCode());
                row.createCell(2).setCellValue(staff.getName());
                row.createCell(3).setCellValue(staff.getAccountFpt());
                row.createCell(4).setCellValue(staff.getAccountFe());
                row.createCell(5).setCellValue(staff.getStatus() == 1 ? "Hoạt động" : "Không hoạt động");

                // Điền thông tin cơ sở, bộ môn, chuyên ngành
                MajorFacility majorFacility = smf.getIdMajorFacility();
                DepartmentFacility departmentFacility = majorFacility.getIdDepartmentFacility();

                row.createCell(6).setCellValue(departmentFacility.getIdFacility().getName());
                row.createCell(7).setCellValue(departmentFacility.getIdDepartment().getName());
                row.createCell(8).setCellValue(majorFacility.getIdMajor().getName());
            }
        }

        // Thiết lập phản hồi HTTP để tải về file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=staff_list.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

