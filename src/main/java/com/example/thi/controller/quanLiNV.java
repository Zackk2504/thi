package com.example.thi.controller;

import com.example.thi.entity.*;
import com.example.thi.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class quanLiNV {
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    valiNhanVIen valiNhanVIen;
    @Autowired
    FacilityRepository facilityRepository;
//    co so
    @Autowired
    MajorFacilityRepository majorFacilityRepository;
//    chuyen nganh
    @Autowired
    DepartmentFacilityRepository departmentFacilityRepository;
//    bo mon
    @RequestMapping("/quan-li")
    public String quanLiSinhVien(Model model) {
        List<Staff> staff = staffRepository.findAll();
        model.addAttribute("staff", staff);
        return "index";
    }
    @RequestMapping("/qlNV/upTT/{id}")
    public String upTT(@PathVariable UUID id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if(staff.get().getStatus() == 1) {
            staff.get().setStatus((short) 3);
        }else {
            staff.get().setStatus((short) 1);
        }
        staffRepository.save(staff.get());
        return "redirect:/quan-li";
    }




    @PostMapping("/addNV")
    public String addStaff(@Valid @ModelAttribute Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Staff> staff1 = staffRepository.findAll();
            model.addAttribute("staff", staff1);
            return "index";
        }
        staff.setStatus((short) 1);
        staffRepository.save(staff);
        return "redirect:/quan-li";
    }

    @RequestMapping("/deleteNV/{id}")
    public String deleteNV(@PathVariable UUID id) {
        staffRepository.deleteById(id);
        return "redirect:/quan-li";
    }
    @RequestMapping("/detail/{id}")
    public String detail(Model model,@PathVariable UUID id) {
        Optional<Staff> staff2 = staffRepository.findById(id);

        model.addAttribute("staff1", staff2.get());

        return "updateForm";
    }

    @RequestMapping(value = "/putNV/{id}", method = RequestMethod.POST)
    public String putNV( @ModelAttribute Staff staff, @PathVariable UUID id, Model model) {


        Optional<Staff> existingStaff = staffRepository.findById(id);

            Staff staffToUpdate = existingStaff.get();
            staffToUpdate.setId(staff.getId());
            staffToUpdate.setName(staff.getName());
            staffToUpdate.setStaffCode(staff.getStaffCode());
            staffToUpdate.setAccountFpt(staff.getAccountFpt());
            staffToUpdate.setAccountFe(staff.getAccountFe());
            staffToUpdate.setStatus((short) 1);
            staffRepository.save(staffToUpdate);

        return "redirect:/quan-li";
    }
//    @RequestMapping("/chuyenNganh/{id}")
//    public String chuyenNganh(Model model,@PathVariable UUID id,@RequestParam(value = "coSoId", required = false) UUID coSoId,
//                              @RequestParam(value = "boMonId", required = false) UUID boMonId) {
//        Optional<Staff> staff2 = staffRepository.findById(id);
//        model.addAttribute("staff1", staff2.orElse(null));
//
//        // Tìm danh sách cơ sở
//        List<Facility> listCoSo = facilityRepository.findAll();
//
//
//        // Tìm danh sách bộ môn và chuyên ngành
//        List<DepartmentFacility> listBoMon = departmentFacilityRepository.findAll();
//        List<MajorFacility> listChuyenNganh = majorFacilityRepository.findAll();
//
////        if (coSoId != null) {
////            // Lọc bộ môn theo cơ sở được chọn
////            listBoMon = listBoMon.stream()
////                    .filter(bm -> bm.getIdFacility().getId().equals(coSoId))
////                    .collect(Collectors.toList());
////        }
////
////        if (boMonId != null) {
////            // Lọc chuyên ngành theo bộ môn được chọn
////            listChuyenNganh = listChuyenNganh.stream()
////                    .filter(cn -> cn.getIdDepartmentFacility().getId().equals(boMonId))
////                    .collect(Collectors.toList());
////        }
//
//
//
//
//        model.addAttribute("listBoMon", listBoMon);
//        model.addAttribute("listCoSo", listCoSo);
//        model.addAttribute("listChuyenNganh",listChuyenNganh);
//
//        return "chuyenNganh";
//    }

    @RequestMapping("/chuyenNganh/{id}")
    public String chuyenNganh(Model model,@PathVariable UUID id
                             ) {
        Optional<Staff> staff2 = staffRepository.findById(id);
        model.addAttribute("staff1", staff2.orElse(null));

        // Tìm danh sách cơ sở
        List<Facility> listCoSo = facilityRepository.findAll();
        // Tìm danh sách bộ môn và chuyên ngành
        List<DepartmentFacility> listBoMon = departmentFacilityRepository.findAll();
        List<MajorFacility> listChuyenNganh = majorFacilityRepository.findAll();


//
        model.addAttribute("listBoMon", listBoMon);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listChuyenNganh",listChuyenNganh);

        return "ChonCoSo";
    }

    @RequestMapping("/chonCoSo/{id}")
    public String chonCoSo(@RequestParam UUID coSoId, Model model,@PathVariable UUID id) {
        Optional<Staff> staff2 = staffRepository.findById(id);
        model.addAttribute("staff1", staff2.orElse(null));
        // Tìm danh sách cơ sở
        List<Facility> listCoSo = facilityRepository.findAll();
        // Tìm danh sách bộ môn và chuyên ngành
        List<DepartmentFacility> listBoMon = departmentFacilityRepository.findAll();
        List<MajorFacility> listChuyenNganh = majorFacilityRepository.findAll();
        model.addAttribute("listchuyenNganh", listChuyenNganh);
        model.addAttribute("listBoMon", listBoMon);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("coSoId", coSoId);
        return "chonBoMon";
    }

    @RequestMapping("/chonBoMon/{id}/{coSoId}")
    public String chonBoMon(@PathVariable UUID coSoId, Model model,@PathVariable UUID id,@RequestParam UUID boMonid) {
        Optional<Staff> staff2 = staffRepository.findById(id);
        model.addAttribute("staff1", staff2.orElse(null));
        // Tìm danh sách cơ sở
        List<Facility> listCoSo = facilityRepository.findAll();
        // Tìm danh sách bộ môn và chuyên ngành
        List<DepartmentFacility> listBoMon = departmentFacilityRepository.findAll();
        List<MajorFacility> listChuyenNganh = majorFacilityRepository.findAll();
        model.addAttribute("listchuyenNganh", listChuyenNganh);
        model.addAttribute("listBoMon", listBoMon);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("coSoId", coSoId);
        model.addAttribute("boMonid", boMonid);
        return "chonChuyenNganh";
    }


}
