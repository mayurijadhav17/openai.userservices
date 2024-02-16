package com.userservice.openai.controllers;


import com.userservice.openai.dtos.QuotaDto;
import com.userservice.openai.models.Quota;
import com.userservice.openai.services.OpenaiRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quota")
@PreAuthorize("hasRole('ADMIN')")
public class OpenaiRequestController {

    private final OpenaiRequestService openaiRequestService;

    @PutMapping("/{id}")
    public Quota updateQuota(@RequestBody @Valid QuotaDto quotaDto, @PathVariable Long id) throws Exception {
        return openaiRequestService.updateCompanyQuota(quotaDto, id);
    }


}

