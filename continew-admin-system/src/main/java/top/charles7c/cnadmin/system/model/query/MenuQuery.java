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

package top.charles7c.cnadmin.system.model.query;

import java.io.Serializable;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.charles7c.cnadmin.common.annotation.Query;

/**
 * 菜单查询条件
 *
 * @author Charles7c
 * @since 2023/2/15 20:21
 */
@Data
@Schema(description = "菜单查询条件")
public class MenuQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单标题
     */
    @Schema(description = "菜单标题")
    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    /**
     * 状态（1：启用，2：禁用）
     */
    @Schema(description = "状态（1：启用，2：禁用）")
    @Query
    private Integer status;
}
