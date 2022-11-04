package com.accountBook.company.common;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.entity.FinancialPosition;
import com.accountBook.company.dto.SubjectValue;

import java.io.*;
import java.util.*;

public class TextFileReader {
    public List<Company> getFile(File file)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

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
        String line;
        while ((line = br.readLine()) != null){
            String[] splits = line.split("\t");
            String subject_eng = splits[10].trim();
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
                    switch (sub.getName()) {
                        case "ifrs-full_Assets" -> {
                            fip.setAssets(sub.getValue());
                            fip.setYmd(sub.getYmd());
                            fip.setMm(sub.getMm());
                            fip.setKindOfReport(sub.getKindOfReport());
                        }
                        case "ifrs-full_Liabilities"            -> fip.setLiabilities(sub.getValue());
                        case "ifrs-full_EquityAndLiabilities"   -> fip.setEquityAndLiabilities(sub.getValue());
                        case "ifrs-full_CashAndCashEquivalents" -> fip.setCashAndCashEquivalents(sub.getValue());
                        case "ifrs-full_RetainedEarnings"       -> fip.setRetainedEarnings(sub.getValue());
                        case "ifrs-full_CurrentAssets"          -> fip.setCurrentAssets(sub.getValue());
                        case "ifrs-full_NoncurrentAssets"       -> fip.setNoncurrentAssets(sub.getValue());
                        case "ifrs-full_CurrentLiabilities"     -> fip.setCurrentLiabilities(sub.getValue());
                        case "ifrs-full_NoncurrentLiabilities"  -> fip.setNoncurrentLiabilities(sub.getValue());
                    }
                }
                fip.setCompany(com);
                com.financialPositionList.add(fip);
            }
        }
        return companies;
    }
}
