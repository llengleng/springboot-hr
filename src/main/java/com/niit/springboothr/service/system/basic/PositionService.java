package com.niit.springboothr.service.system.basic;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.springboothr.mapper.PositionMapper;
import com.niit.springboothr.model.Position;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/26 14：00
 * @description :
 */
@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public List<Position> getAllPosition(){
        return positionMapper.selectAllPosition();
    }

    public Integer addPosition(Position position){
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position){
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id){
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositions(Integer[] ids){
        return positionMapper.deletePositions(ids);
    }

    public PageInfo<Position> getPositionByPage(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<Position> positions = positionMapper.selectAllPosition();
        return new PageInfo<>(positions,size);
    }

    public int addPositions(List<Position> positions){
        return positionMapper.batchInsert(positions);
    }

}
