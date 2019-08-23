package com.erp.mapper;

import com.erp.domain.Leaves;
import com.erp.domain.LeavesAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaveMapper {
    /**
     * 新增请假信息
     * @param leaves
     * @return
     */
    @Insert("insert into leaves(lid,aid,types,lstate,starttime,endtime,total,adminsstate," +
            " remark,lopinion,mopinion)  values(null,#{aid},#{types},#{lstate},#{starttime},#{endtime},#{total},#{adminsstate},#{remark},#{lopinion},#{mopinion})")
    public int insertleave(Leaves leaves);

    /**请假一天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为c 已审批，拒绝则将该值变为d
     * @return
     */
    @Update("update leaves set lstate=#{lstate},adminsstate=#{adminsstate},lopinion=#{lopinion}, mopinion=#{mopinion} where lid=#{lid}")
    public  int updLeave(Leaves leaves);

    /**请假多天的情况
     * 经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */
    @Update("update leaves set lstate=#{lstate},adminsstate=#{adminsstate},lopinion=#{lopinion} where lid=#{lid}")
    public  int updeLeave(Leaves leaves);


    /**请假多天的情况
     * 总经理对请假信息进行审批 修改值lstate通过则将改为b 已审批，拒绝则将该值变为d
     * @return
     */
    @Update("update leaves set lstate=#{lstate},adminsstate=#{adminsstate},lopinion=#{lopinion} where lid=#{lid}")
    public  int updeLastLeave(Leaves leaves);

    /**
     * 查询所有需要总经理批准请假信息
     * @return
     */

    @Select("SELECT a.*,l.* FROM admin a INNER JOIN LEAVES l ON a.`id`=l.`aid` where l.total>=1 AND l.remark=1")
    public List<LeavesAdmin> getGmLeave();


    /**
     * 查询所有需要经理批准请假信息
     * @return
     */

    @Select("SELECT a.*,l.* FROM admin a INNER JOIN LEAVES l ON a.`id`=l.`aid` where  l.remark=0")
    public List<LeavesAdmin> getLeave();

    /**
     * 根据请假单编号查询请假信息
     * @param lid
     * @return
     */
    @Select("SELECT a.*,l.* FROM admin a INNER JOIN LEAVES l ON a.`id`=l.`aid` where lid=#{lid}")
    public LeavesAdmin getLeaveById(@Param("lid") Integer lid);





    /**
     * 查询所有请假信息
     * @return
     */

    @Select("SELECT a.*,l.* FROM admin a INNER JOIN LEAVES l ON a.`id`=l.`aid`")
    public List<LeavesAdmin> getAllleave();

    /**
     * 查询自己的请假信息
     * @return
     */

    @Select("SELECT a.*,l.* FROM admin a INNER JOIN LEAVES l ON a.`id`=l.`aid` and a.id=#{id}")
    public List<LeavesAdmin> getMyselfleave(@Param("id") Integer id);



}
