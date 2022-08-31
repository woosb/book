package com.accountBook.book.service;

import com.accountBook.book.domain.entity.FinancialPosition;
import com.accountBook.book.domain.repository.FinancialPositionRepository;
import com.accountBook.book.dto.FinancialPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FinancialPositionService {
    private final FinancialPositionRepository financialPositionRepository;

    public FinancialPositionDto findFinancialPositionCompanyId(Long companyId) {
        FinancialPosition financialPosition = financialPositionRepository.findByCompanyId(companyId);
        FinancialPositionDto financialPositionDto = FinancialPositionDto.builder().FinancialId(financialPosition.getFinancialId()).assets(financialPosition.getAssets()).liabilities(financialPosition.getLiabilities()).equityAndLiabilities(financialPosition.getEquityAndLiabilities()).cashAndCashEquivalents(financialPosition.getCashAndCashEquivalents()).retainedEarnings(financialPosition.getRetainedEarnings()).currentAssets(financialPosition.getCurrentAssets()).noncurrentAssets(financialPosition.getNoncurrentAssets()).currentLiabilities(financialPosition.getCurrentLiabilities()).noncurrentLiabilities(financialPosition.getNoncurrentLiabilities()).ymd(financialPosition.getYmd()).mm(financialPosition.getMm()).kindOfReport(financialPosition.getKindOfReport()).build();
        return financialPositionDto;
    }
}
