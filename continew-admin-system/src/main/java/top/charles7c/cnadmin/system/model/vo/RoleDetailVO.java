/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.cnadmin.system.model.vo;

import java.util.List;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.charles7c.cnadmin.common.base.BaseDetailVO;
import top.charles7c.cnadmin.common.config.easyexcel.ExcelBaseEnumConverter;
import top.charles7c.cnadmin.common.enums.DataScopeEnum;
import top.charles7c.cnadmin.common.enums.DataTypeEnum;
import top.charles7c.cnadmin.common.enums.DisEnableStatusEnum;

/**
 * 角色详情信息
 *
 * @author Charles7c
 * @since 2023/2/1 22:19
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "角色详情信息")
public class RoleDetailVO extends BaseDetailVO {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    @ExcelProperty(value = "角色名称")
    private String name;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    @ExcelProperty(value = "角色编码")
    private String code;

    /**
     * 数据权限（1：全部数据权限，2：本部门及以下数据权限，3：本部门数据权限，4：仅本人数据权限，5：自定义数据权限）
     */
    @Schema(description = "数据权限（1：全部数据权限，2：本部门及以下数据权限，3：本部门数据权限，4：仅本人数据权限，5：自定义数据权限）")
    @ExcelProperty(value = "数据权限", converter = ExcelBaseEnumConverter.class)
    private DataScopeEnum dataScope;

    /**
     * 角色排序
     */
    @Schema(description = "角色排序")
    @ExcelProperty(value = "角色排序")
    private Integer sort;

    /**
     * 状态（1：启用，2：禁用）
     */
    @Schema(description = "状态（1：启用，2：禁用）")
    @ExcelProperty(value = "状态", converter = ExcelBaseEnumConverter.class)
    private DisEnableStatusEnum status;

    /**
     * 类型（1：系统内置，2：自定义）
     */
    @Schema(description = "类型（1：系统内置，2：自定义）")
    @ExcelProperty(value = "类型", converter = ExcelBaseEnumConverter.class)
    private DataTypeEnum type;

    /**
     * 描述
     */
    @Schema(description = "描述")
    @ExcelProperty(value = "描述")
    private String description;

    /**
     * 功能权限：菜单 ID 列表
     */
    @Schema(description = "功能权限：菜单 ID 列表")
    private List<Long> menuIds;

    /**
     * 权限范围：部门 ID 列表
     */
    @Schema(description = "权限范围：部门 ID 列表")
    private List<Long> deptIds;

    @Override
    public Boolean getDisabled() {
        return DataTypeEnum.SYSTEM.equals(type);
    }
}
