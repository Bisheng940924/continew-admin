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

package top.charles7c.cnadmin.system.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.charles7c.cnadmin.common.constant.RegexConsts;

/**
 * 修改邮箱信息
 *
 * @author Charles7c
 * @since 2023/1/12 20:18
 */
@Data
@Schema(description = "修改邮箱信息")
public class UpdateEmailRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新邮箱
     */
    @Schema(description = "新邮箱")
    @NotBlank(message = "新邮箱不能为空")
    @Pattern(regexp = RegexConsts.EMAIL, message = "邮箱格式错误")
    private String newEmail;

    /**
     * 验证码
     */
    @Schema(description = "验证码")
    @NotBlank(message = "验证码不能为空")
    @Length(max = 6, message = "验证码非法")
    private String captcha;

    /**
     * 当前密码（加密后）
     */
    @Schema(description = "当前密码（加密后）")
    @NotBlank(message = "当前密码不能为空")
    private String currentPassword;
}
