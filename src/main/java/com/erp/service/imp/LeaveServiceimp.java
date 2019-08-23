package com.erp.service.imp;

import com.erp.domain.Leaves;
import com.erp.domain.LeavesAdmin;
import com.erp.mapper.LeaveMapper;
import com.erp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveServiceimp implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;

    /**
     * 新增请假信息
     * @param leaves
     * @return
     */
    @Override
    public int insertleave(Leaves leaves) {
        return leaveMapper.insertleave(leaves);
    }

    /**请假一天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为c 已审批，拒绝则将该值变为d
     * @return
     */
    @Override
    public int updLeave(Leaves leaves) {
        return leaveMapper.updLeave(leaves);
    }

    /**请假多天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */
    @Override
    public int updeLeave(Leaves leaves) {
        return leaveMapper.updeLeave(leaves);
    }

    /**请假多天的情况
     * 总经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */
    @Override
    public int updeLastLeave(Leaves leaves) {
        return leaveMapper.updeLastLeave(leaves);
    }

    /**
     * 查询所有需要总经理批准请假信息
     * @return
     */
    @Override
    public List<LeavesAdmin> getGmLeave() {
        return leaveMapper.getGmLeave();
    }

    /**
     * 根据请假单编号查询请假信息
     * @param lid
     * @return
     */
    @Override
    public LeavesAdmin getLeaveById(Integer lid) {
        return leaveMapper.getLeaveById(lid);
    }

    /**
     * 查询所有请假信息
     * @return
     */
    @Override
    public List<LeavesAdmin> getAllleave() {
        return leaveMapper.getAllleave();
    }
    /**
     * 查询所有请假信息
     * @return
     */
    @Override
    public List<LeavesAdmin> getLeave() {
        return null;
    }

    /**
     * 查询自己的请假信息
     * @param id
     * @return
     */
    @Override
    public List<LeavesAdmin> getMyselfleave(Integer id) {
        return leaveMapper.getMyselfleave(id);
    }
}
