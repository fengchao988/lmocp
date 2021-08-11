package com.snszyk.iiot.marketization.measure.domain.unit;

import lombok.Getter;
import me.zhyd.oauth.utils.UuidUtils;
import org.jeecg.common.exception.JeecgBootException;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 计量单位
 *
 * @author don
 */
@Getter
public class MeasureUnit implements Serializable {
    private String id;
    private String code;
    private String name;
    private String symbol;
    private String description;
    private String categoryId;
    private int sort;

    public MeasureUnit(String id, String name, String symbol, String categoryId, int sort, String description) {
        this(name, symbol, categoryId, sort, description);
        this.id = id;

    }

    public MeasureUnit(String name, String symbol, String categoryId, int sort, String description) {
        this.name = name;
        this.symbol = symbol;
        this.categoryId = categoryId;
        this.sort = sort;
        this.description = description;
    }

    public void create(MeasureUnitRepository measureUnitRepository) throws Exception {
        this.id = UuidUtils.getUUID();
        this.code = this.generateMeasureUnitCode();
        this.checkCanBeCreate(measureUnitRepository);
        measureUnitRepository.saveUnit(this);
    }

    /**
     * 获取其编码的逻辑-我们认为这种应该是能够有编码逻辑存在
     *
     * @return
     */
    private String generateMeasureUnitCode() {
        // 暂定UUID
        return UuidUtils.getUUID();
    }

    /**
     * 检查能否创建
     *
     * @param measureUnitRepository
     */
    private void checkCanBeCreate(MeasureUnitRepository measureUnitRepository) throws Exception {
        List<MeasureUnit> units = measureUnitRepository.list(this);
        if (!CollectionUtils.isEmpty(units)) {
            throw new JeecgBootException("计量单位已存在");
        }
    }

    /**
     * 移除单位
     *
     * @param measureUnitRepository
     */
    public void delete(MeasureUnitRepository measureUnitRepository) {
        this.canBeDelete();
        measureUnitRepository.deleteMeasureUnit(this);
    }

    private void canBeDelete() {
    }

    public void edit(MeasureUnitRepository measureUnitRepository) {
        measureUnitRepository.editMeasureUnit(this);
    }
}
