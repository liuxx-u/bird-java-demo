package com.bird.demo.web.api.admin;

import com.alibaba.fastjson.JSON;
import com.bird.core.Check;
import com.bird.core.OperationResult;
import com.bird.service.common.service.IService;
import com.bird.service.common.service.dto.EntityDTO;
import com.bird.service.common.service.query.PagedListQueryDTO;
import com.bird.service.common.service.query.PagedListResultDTO;
import com.bird.web.sso.SsoAuthorize;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * @author liuxx
 * @date 2018/6/21
 */
public abstract class AdminCrudController<S extends IService,D extends EntityDTO> extends AdminController {

    /**
     * 获取服务操作类
     *
     * @return
     */
    protected abstract S getService();

    @PostMapping("/getPaged")
    @ApiOperation(value = "获取分页")
    @SsoAuthorize(permissions = "view")
    public OperationResult<PagedListResultDTO> getPaged(@RequestBody PagedListQueryDTO query) {

        PagedListResultDTO result = getService().queryPagedList(query, getDtoClazz());
        return OperationResult.Success("获取成功", result);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    @SsoAuthorize(permissions = {"add", "edit"})
    public OperationResult save(@RequestBody Map dto) {

        getService().save(this.transfer(dto));
        return OperationResult.Success("保存成功", null);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除")
    @SsoAuthorize(permissions = "delete")
    public OperationResult delete(Long id) {
        Check.GreaterThan(id, 0, "id");

        getService().delete(id);
        return OperationResult.Success("删除成功", null);
    }

    /**
     * 获取DTO的类型
     *
     * @return
     */
    private Class<D> getDtoClazz() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        Class<D> clazz = (Class<D>) pt.getActualTypeArguments()[1];

        return clazz;
    }

    /**
     * Map转换为DTO
     *
     * @param dto
     * @return
     */
    protected D transfer(Map dto) {
        return JSON.parseObject(JSON.toJSONString(dto), getDtoClazz());
    }

    /**
     * Map转换为指定类型的DTO
     *
     * @param dto
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T transfer(Map dto, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(dto), clazz);
    }
}
