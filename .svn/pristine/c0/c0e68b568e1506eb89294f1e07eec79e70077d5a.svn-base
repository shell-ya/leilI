package com.linkwin.framework.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.domain.entity.SysDictData;
import com.linkwin.system.service.ISysDictDataService;
import com.linkwin.system.service.ISysDictTypeService;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictTypeService dictTypeService;

    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        return dictTypeService.selectDictDataByType(dictType);
    }

    public List<SysDictData> getType(String dictType,String language)
    {
        return dictTypeService.selectDictDataByType(dictType,language);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    public String getLabel(String dictType, String dictValue,String language)
    {
        return dictDataService.selectDictLabel(dictType, dictValue,language);
    }
}
