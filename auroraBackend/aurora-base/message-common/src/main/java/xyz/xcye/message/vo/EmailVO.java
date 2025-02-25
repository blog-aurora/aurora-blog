package xyz.xcye.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.xcye.message.po.Email;

/**
 * @author xcye <br/>
 * @description TODO <br/>
 * @date 2022-12-14 22:01:53 <br/>
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(title = "email数据表的VO")
public class EmailVO extends Email {

}