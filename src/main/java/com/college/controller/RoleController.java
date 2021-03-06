package com.college.controller;

import com.college.contants.AppCode;
import com.college.contants.Path;
import com.college.entity.Role;
import com.college.model.Resp;
import com.college.service.RoleService;
import com.college.utils.DateTimeUtil;
import com.github.pagehelper.Page;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author milo
 * @Title:
 * @Description
 */
@RestController
public class RoleController extends BaseController {

    private static Logger logger = LoggerFactory
            .getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * get list
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @param roleName
     * @param sign       英文标示
     * @param remark
     * @param status     0: 删除 1:正常
     * @param createTime 创建时间

     * @return
     */
    @RequestMapping(value = Path.ROLE_LIST)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(value = "pagenum", defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pagesize", defaultValue = "10") int pageSize,
                                       @RequestParam(value = "id", required = false) Integer id,
                                       @RequestParam(value = "roleName", required = false) Integer roleName,
                                       @RequestParam(value = "sign", required = false) Integer sign,
                                       @RequestParam(value = "remark", required = false) Integer remark,
                                       @RequestParam(value = "status", required = false) boolean status,
                                       @RequestParam(value = "createTime", required = false) Integer createTime,
                                       @RequestParam(value = "updateTime", required = false) Integer updateTime
    ) {
        Map<String, Object> params = Maps.newHashMap();
        Page<Role> page = roleService.searchPageList(pageNum, pageSize, params);
        Map<String, Object> resultMap = Maps.newHashMap();
        logger.info(" RoleController -->  pageResult :{}", page.getResult());
        resultMap.put("result", page.getResult());
        resultMap.put("pages", page.getPages());
        resultMap.put("startrow", page.getStartRow());
        resultMap.put("endrow", page.getEndRow());
        resultMap.put("pagesize", page.getPageSize());
        resultMap.put("pagenum", page.getPageNum());
        resultMap.put("total", page.getTotal());
        return resultMap;
    }

    /**
     * insert
     *
     * @param roleName
     * @param sign       英文标示
     * @param remark
     * @param status     0: 删除 1:正常
     * @param createTime 创建时间

     * @return
     */
    @RequestMapping(value = Path.ROLE_ADD)
    @ResponseBody
    public Resp add(
            @RequestParam(value = "roleName", required = false) String roleName,
            @RequestParam(value = "sign", required = false) String sign,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "status", required = false) boolean status,
            @RequestParam(value = "createTime", required = false) String createTime) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setSign(sign);
        role.setRemark(remark);
        role.setStatus(status);
        role.setCreateTime(DateTimeUtil.parseDateTime(createTime,"yyyy-MM-dd HH:mm:ss"));
        Integer id = roleService.insert(role);
        return null != id ? Resp.success(id) : Resp.error(AppCode._10003);
    }

    /**
     * update
     *
     * @param id
     * @param roleName
     * @param sign       英文标示
     * @param remark
     * @param status     0: 删除 1:正常
     * @param createTime 创建时间

     * @return
     */
    @RequestMapping(value = Path.ROLE_UPDATE)
    @ResponseBody
    public Resp update(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "roleName", required = false) String roleName,
            @RequestParam(value = "sign", required = false) String sign,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "status", required = false) boolean status,
            @RequestParam(value = "createTime", required = false) String createTime
    ) {
        Role role = new Role();
        role.setId(id);
        role.setRoleName(roleName);
        role.setSign(sign);
        role.setRemark(remark);
        role.setStatus(status);
        role.setCreateTime(DateTimeUtil.parseDateTime(createTime,"yyyy-MM-dd HH:mm:ss"));
        roleService.update(role);
        return Resp.success();
    }

}
