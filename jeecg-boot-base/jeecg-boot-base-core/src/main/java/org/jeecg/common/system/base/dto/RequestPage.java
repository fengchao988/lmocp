package org.jeecg.common.system.base.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 分页参数 数据传输对象
 *
 * @author zhaowang
 * @version 1.0.0
 * @since 2021-01-05 18:30
 */
public class RequestPage {
    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private Integer pageNo = 1;
    /**
     * 分页单位
     */
    @ApiModelProperty("分页单位")
    private Integer pageSize = 10;

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setCurrent(Integer current) {
        this.pageNo = current;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public <T> IPage<T> initPage() {
        return new Page<>(pageNo, pageSize);
    }

    public Pageable initPageable() {
        // JPA 默认第一页页码编号为“0”
        return PageRequest.of(pageNo - 1, pageSize);
    }
}
