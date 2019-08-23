package com.erp.controller;

import com.erp.domain.Leaves;
import com.erp.domain.LeavesAdmin;
import com.erp.service.LeaveService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("fingMyleave")
    public ResponseEntity<?> getMyLeave(@RequestParam("id") Integer id){
    List<LeavesAdmin> leavesAdminList= leaveService.getMyselfleave(id);

        System.out.println(leavesAdminList);
            return new ResponseEntity<>(leavesAdminList,HttpStatus.OK);
    }


    @GetMapping("fingALLleave")
    public ResponseEntity<?> getALLLeave(@RequestParam("id") Integer id){
        List<LeavesAdmin> leavesAdminList= leaveService.getAllleave();

        System.out.println(leavesAdminList);
        return new ResponseEntity<>(leavesAdminList,HttpStatus.OK);
    }

    /**
     * 员工开始请假
     * @param leaves
     * @return
     */
    @PutMapping("insertLeave")
    public ResponseEntity<?> insertLeave(Leaves leaves){
     leaves.setAdminsstate("审批中");
     leaves.setRemark(0);
     leaves.setLstate("经理审批中");
        System.err.println(leaves);

        int count=leaveService.insertleave(leaves);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

//    @Update("update leaves set lstate=#{lstate},adminsstate=#{adminsstate},lopinion=#{lopinion} where lid=#{lid}")
//    public  int updLeave(Leaves leaves);

    @PostMapping("updleave")
    public ResponseEntity<?> updleave(Leaves leaves){
        System.err.println(leaves+"kkkkkkkkkkkkk");
        int count=leaveService.updLeave(leaves);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
