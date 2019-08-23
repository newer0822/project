package com.erp.service;

import com.erp.domain.Leaves;
import com.erp.domain.LeavesAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface LeaveService {
    /**
     * 新增请假信息
     * @param leaves
     * @return
     */
    public int insertleave(Leaves leaves);


    /**请假一天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为c 已审批，拒绝则将该值变为d
     * @return
     */

    public  int updLeave(Leaves leaves);

    /**请假多天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */

    public  int updeLeave(Leaves leaves);


    /**请假多天的情况
     * 总经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */

    public  int updeLastLeave(Leaves leaves);

    /**
     * 查询所有需要总经理批准请假信息
     * @return
     */


    public List<LeavesAdmin> getGmLeave();

    /**
     * 根据请假单编号查询请假信息
     * @param lid
     * @return
     */

    public LeavesAdmin getLeaveById(@Param("lid") Integer lid);





    /**
     * 查询所有请假信息
     * @return
     */

    public List<LeavesAdmin> getAllleave();
    /**
     * 查询所有需要经理批准请假信息
     * @return
     */
    public List<LeavesAdmin> getLeave();


    /**
     * 查询自己的请假信息
     * @return
     */

    public List<LeavesAdmin> getMyselfleave(@Param("id") Integer id);

}
