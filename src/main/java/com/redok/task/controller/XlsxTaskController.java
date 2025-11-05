package com.redok.task.controller;

import com.redok.task.model.RequestDto;
import com.redok.task.service.XlsxTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XlsxTaskController {
    private final XlsxTaskService xlsxTaskService;

    public XlsxTaskController(XlsxTaskService xlsxTaskService) {
        this.xlsxTaskService = xlsxTaskService;
    }

    @PostMapping("/find")
    @Operation(summary = "Find N minimum number")
    public String find(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Relative or absolute path and N number", required = true,
            content = @Content(schema = @Schema(implementation = RequestDto.class))) @RequestBody RequestDto requestDto) {
        return xlsxTaskService.findMinNNumber(requestDto.getPath(), requestDto.getN());
    }
}
