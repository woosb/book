package com.accountBook.book.common;

import com.accountBook.book.domain.entity.Company;
import com.accountBook.book.domain.entity.FinancialPosition;
import com.accountBook.book.dto.SubjectValue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextFileReader {
    public List<Company> getFile(String location)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
        String line = null;
        Set<String> set = new HashSet<>();
        String CODE;

        HashMap<String, List<SubjectValue>> map = new HashMap<>();

        Set<String> subjects = new HashSet<>();
        subjects.add("ifrs-full_Assets");
        subjects.add("ifrs-full_Liabilities");
        subjects.add("ifrs-full_EquityAndLiabilities");
        subjects.add("ifrs-full_CashAndCashEquivalents");
        subjects.add("ifrs-full_RetainedEarnings");
        subjects.add("ifrs-full_CurrentAssets");
        subjects.add("ifrs-full_NoncurrentAssets");
        subjects.add("ifrs-full_CurrentLiabilities");
        subjects.add("ifrs-full_NoncurrentLiabilities");

        List<Company> companies = new ArrayList<>();
        br.readLine();
        while ((line = br.readLine()) != null){
            String[] splits = line.split("\t");
            String subject_eng = splits[10].trim();
            String subject = splits[11];
            String code = splits[1].replace("[", "").replace("]", "").trim();
            String name = splits[2].trim();
            String kindOfMarket = splits[3].trim();
            String sectors_code = splits[4].trim();
            String sectors_name = splits[5].trim();
            String Ymd = splits[7].trim();
            String Mm = splits[6].trim();
            String kindOfReport = splits[8].trim();

            if(map.containsKey(code)){
                if(subjects.contains(subject_eng) && splits.length > 12){
                    map.get(code).add(new SubjectValue(subject_eng, splits[12].trim(), Ymd, Mm, kindOfReport));
                }
            }else{
                companies.add(new Company(code, name, kindOfMarket, sectors_code, sectors_name));
                map.put(code, new ArrayList<>());
            }
        }

        for(Company com : companies){
            if(map.containsKey(com.getCode())){
                List<SubjectValue> subjectValues = map.get(com.getCode());
                FinancialPosition fip = new FinancialPosition();
//                fip.setCompany(com);
                for(SubjectValue sub : subjectValues){
                    switch(sub.getName()){
                        case "ifrs-full_Assets": {
                            fip.setAssets(sub.getValue());
                            fip.setYmd(sub.getYmd());
                            fip.setMm(sub.getMm());
                            fip.setKindOfReport(sub.getKindOfReport());
                        }
                        break;
                        case "ifrs-full_Liabilities": {
                            fip.setLiabilities(sub.getValue());
                        }
                        break;
                        case "ifrs-full_EquityAndLiabilities": {
                            fip.setEquityAndLiabilities(sub.getValue());
                        }
                        break;
                        case "ifrs-full_CashAndCashEquivalents": {
                            fip.setCashAndCashEquivalents(sub.getValue());
                        }
                        break;
                        case "ifrs-full_RetainedEarnings": {
                            fip.setRetainedEarnings(sub.getValue());
                        }
                        break;
                        case "ifrs-full_CurrentAssets": {
                            fip.setCurrentAssets(sub.getValue());
                        }
                        break;
                        case "ifrs-full_NoncurrentAssets": {
                            fip.setNoncurrentAssets(sub.getValue());
                        }
                        break;
                        case "ifrs-full_CurrentLiabilities": {
                            fip.setCurrentLiabilities(sub.getValue());
                        }
                        break;
                        case "ifrs-full_NoncurrentLiabilities": {
                            fip.setNoncurrentLiabilities(sub.getValue());
                        }
                        break;
                    }
                }
                com.financialPositionList.add(fip);
            }
        }
        return companies;
    }
}
