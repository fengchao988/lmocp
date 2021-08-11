package org.jeecg.common.system.base.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@ApiModel("分页数据返回通用类")
public class ResponsePage<T> {
    @ApiModelProperty("当前页")
    private long pageNo;
    @ApiModelProperty("获取每页显示条数")
    private long pageSize;
    @ApiModelProperty("当前满足条件总行数")
    private long total;
    private List<T> records;

    public ResponsePage(RequestPage page, List<T> records, long total) {
        this.pageNo = page.getPageNo();
        this.pageSize = page.getPageSize();
        this.total = total;
        this.records = records;
    }

    /**
     * JPA 专用Page转换
     *
     * @param page jpa page
     */
    public ResponsePage(Page<T> page) {
        this.pageNo = page.getNumber();
        this.pageSize = page.getSize();
        this.total = page.getTotalElements();
        this.records = page.getContent();
    }

    /**
     * Mybatis-plus 专用Page转换
     *
     * @param page Mybatis-plus page
     */
    public ResponsePage(IPage<T> page) {
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
        this.records = page.getRecords();
    }

    @ApiModelProperty("当前分页总页数")
    public long getPageCount() {
        if (getPageSize() == 0) {
            return 0L;
        }
        long pageCount = getTotal() / getPageSize();
        if (getTotal() % getPageSize() != 0) {
            pageCount++;
        }
        return pageCount;
    }
}
