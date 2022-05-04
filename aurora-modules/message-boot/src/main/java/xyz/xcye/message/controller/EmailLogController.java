package xyz.xcye.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.xcye.core.annotaion.controller.ModifyOperation;
import xyz.xcye.core.annotaion.controller.SelectOperation;
import xyz.xcye.mybatis.entity.Condition;
import xyz.xcye.mybatis.entity.PageData;
import xyz.xcye.core.valid.Insert;
import xyz.xcye.core.valid.Update;
import xyz.xcye.message.po.EmailLog;
import xyz.xcye.message.service.EmailLogService;
import xyz.xcye.message.vo.EmailLogVO;

import javax.validation.groups.Default;

/**
 * 操作au_email_log表的controller
 * @author qsyyke
 */

@Api(tags = "邮件发送日志相关操作")
@RequestMapping("/message/emailLog")
@RestController
public class EmailLogController {

    @Autowired
    private EmailLogService emailLogService;

    @ApiOperation(value = "插入邮件发送日志",notes = "插入邮件发送日志")
    @ModifyOperation
    @PostMapping("")
    public int insertEmailLog(@Validated({Insert.class, Default.class}) EmailLog emailLog) {
        return emailLogService.insertEmailLog(emailLog);
    }

    @ApiOperation(value = "根据uid更新邮件发送日志")
    @ModifyOperation
    @PutMapping("")
    public int updateEmailLog(@Validated({Update.class,Default.class}) EmailLog emailLog) throws BindException {
        return emailLogService.updateEmailLog(emailLog);
    }

    @ApiOperation(value = "删除uid对应邮件发送日志")
    @SelectOperation
    @DeleteMapping("/{uid}")
    public int deleteEmailLog(@PathVariable("uid") long uid) {
        return emailLogService.deleteEmailLog(uid);
    }

    @ApiOperation(value = "查询所有邮件发送日志")
    @SelectOperation
    @GetMapping("")
    public PageData<EmailLogVO> queryAllEmailLog(Condition<Long> condition) {
        return emailLogService.queryAll(condition);
    }
}