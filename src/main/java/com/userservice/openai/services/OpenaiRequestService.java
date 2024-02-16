package com.userservice.openai.services;


import com.userservice.openai.dtos.QuotaDto;
import com.userservice.openai.models.Quota;
import com.userservice.openai.repositories.QuataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenaiRequestService {

    private final QuataRepository quataRepository;

    public Quota updateCompanyQuota(QuotaDto quotaDto, Long id) throws Exception {
        Quota quota = quataRepository.findByEntityId(id)
                .orElseThrow(() -> new RuntimeException("Data not found id :" + id));
        int remaining_quota = quota.getTotalQuota() - 1;
        quota.setTotalQuota(remaining_quota);
        return quataRepository.save(quota);
    }

}
