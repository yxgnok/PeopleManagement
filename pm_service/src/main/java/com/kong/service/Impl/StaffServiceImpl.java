package com.kong.service.Impl;

import com.kong.dao.StaffDao;
import com.kong.entity.Staff;
import com.kong.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("StaffService")
public class StaffServiceImpl implements StaffService {
    //在业务层（service）可以设置一些基本的业务规则
    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff staff) {
        staff.setPassword("123456"); //默认密码
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    @Override
    public void remove(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
